package com.pathology.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pathology.dao.IBaseDao;

public class BaseDaoImpl<T extends Serializable, ID extends Serializable>
		extends HibernateDaoSupport implements IBaseDao<T, ID> {
	@SuppressWarnings("unused")
	private Class<T> presistClass = null;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.presistClass = (Class<T>) (((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public T delt(T t) {
		this.getHibernateTemplate().delete(t);
		return t;
	}

	public T edit(T t) {
		this.getHibernateTemplate().update(t);
		return t;
	}
     //�ʺϵ����ѯ
	@SuppressWarnings("unchecked")
	public List<T> getByDetachedCriteria(final DetachedCriteria dc,
			final int... pages) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				Criteria c = dc.getExecutableCriteria(s);
				c.setProjection(null);
				if (pages.length > 0)
					c.setFirstResult(pages[0]);
				if (pages.length > 1)
					c.setMaxResults(pages[1]);
				return c.list();
			}
		});
	}
	public int getByDetachedCriteriaRowsNum(final DetachedCriteria dc) {
		return ((Number) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session s)
							throws HibernateException, SQLException {
						Criteria c = dc.getExecutableCriteria(s);
						c.setProjection(Projections.rowCount());
						return c.uniqueResult();
					}
				})).intValue();
	}
	@SuppressWarnings("unchecked")
	public List<T> getByExample(final T t, final int... pages) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				Criteria c = s.createCriteria(presistClass);
				if(t!=null)
					c.add(Example.create(t));
				if (pages.length > 0)
					c.setFirstResult(pages[0]);
				if (pages.length > 1)
					c.setMaxResults(pages[1]);
				return c.list();
			}
		});
	}
	public int getByExampleRowsNum(final T t) {
		return ((Number) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session s)
							throws HibernateException, SQLException {
						Criteria c = s.createCriteria(presistClass);
						if(t!=null)
							c.add(Example.create(t));
						c.setProjection(Projections.rowCount());
						return c.uniqueResult();
					}
				})).intValue();
	}
	public List getAll(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	public T getOne(ID id) {
		return (T)this.getHibernateTemplate().get(presistClass, id);
	}
	public T save(T t) {
		this.getHibernateTemplate().save(t);
		return t;
	}
}
