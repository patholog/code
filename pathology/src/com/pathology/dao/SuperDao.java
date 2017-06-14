package com.pathology.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SuperDao extends HibernateDaoSupport {

	private SessionFactory superSessionFactory;

	public SessionFactory getSuperSessionFactory() {
		return superSessionFactory;
	}

	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	// 增加操作
	public Serializable add(Object entity) {

		Serializable id = this.getHibernateTemplate().save(entity);

		return id;
	}

	// 删除操作
	public void delete(Object entity) {

		this.getHibernateTemplate().delete(entity);

	}

	// 更新操作
	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}

	// session查询操作
	public Object select(Class clazz, Serializable id) {

		Object obj = this.getHibernateTemplate().load(clazz, id);

		return obj;
	}

	@SuppressWarnings("unchecked")
	public List findByClz(Class clz, Map<String, Object> params) {
		StringBuffer hql = new StringBuffer();
		if (clz == null) {
			throw new RuntimeException("clz.can.not.null");
		} else {
			hql.append(" from ").append(clz.getSimpleName());
			hql.append(" where 1=1 ");
		}
		List rst = null;

		if (params == null || params.isEmpty()) {
			try {
				rst = (List) getHibernateTemplate().find(hql.toString());
			} catch (DataAccessException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			List<String> names = new ArrayList<String>();
			List<Object> values = new ArrayList<Object>();
			Iterator<Entry<String, Object>> it = params.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Object> kv = it.next();
				String key = kv.getKey();
				Object value = kv.getValue();
				if (org.apache.commons.lang.StringUtils.isNotBlank(key) && null != value
						&& org.apache.commons.lang.StringUtils.isNotBlank(value.toString())) {
					hql.append(" and ").append(key).append(" =:").append(key);
					names.add(key);
//					if(key.toLowerCase().indexOf("sid")>-1){
//						values.add(Long.valueOf(value.toString()));
//					}else{
						values.add(value);
//					}
				}
			}
			try {
//				logger.info("Find,HQL:[{}],Names:[{}],Values:[{}]",hql.toString(),names,values);
				rst = getHibernateTemplate().findByNamedParam(hql.toString(),
						names.toArray(new String[names.size()]),
						values.toArray());
			} catch (DataAccessException ex) {
				throw new RuntimeException(ex);
			}
		}
		return rst;
	}
	
	public Object findUniqueByClz(Class clz, Map<String, Object> params) {
		List list = this.findByClz(clz, params);
		if (list==null||list.size()==0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	public Object select(String hql) {

		Object obj = this.getHibernateTemplate().find(hql);

		return obj;
	}

	public List<Object> find(String s) {

		List<Object> list = this.getHibernateTemplate().find(s);

		return list;
	}

	// select login-user
	public Object check(String hql, Object[] condition) {

		List list = this.getHibernateTemplate().find(hql, condition);
		if (list.size() != 0)
			return list.get(0);

		else
			return null;
	}

	public List<Object> getAllObject(Class clazz, String hql) {

		List<Object> list = this.getHibernateTemplate().find(
				"from " + clazz.getName() + " s where 1=1 " + hql);

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Object> selectPage(int index, Class clazz, String bhql) {

		final int PAGETOTAL = 10;

		List<Object> list = null;

		final int page = index;

		final String hql = "from " + clazz.getName() + " as s where 1=1" + bhql;

		list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				try{
				List result = session.createQuery(hql).setFirstResult(
						(page - 1) * PAGETOTAL).setMaxResults(PAGETOTAL).list();
				return result;}
				catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		});

		return list;
	}

}

