package com.flp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.flp.hib.Leaf;

public class LeafDaoImpl<T,ID> extends BaseDaoImpl<Leaf,String> implements ILeafDao<Leaf,String> {
	@SuppressWarnings("unchecked")
	public List<Leaf> getByName(final String username,final  int... pages) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				Criteria c = arg0.createCriteria(Leaf.class);
				c.add(Expression.or(Expression.eq("sendfor",username), Expression.eq("sendfor","所有人")));
				c.addOrder(Order.desc("pdate"));
				if(pages.length>0)
					c.setFirstResult(pages[0]);
				if(pages.length>1)
					c.setMaxResults(pages[1]);
				return c.list();
			}
		});
	}
	public int getByNameRowsNum(final String username) {
		return ((Number)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				Criteria c = arg0.createCriteria(Leaf.class);
				c.add(Expression.or(Expression.eq("sendfor",username), Expression.eq("sendfor","所有人")));
				c.setProjection(Projections.rowCount());
				return c.uniqueResult();
			}
		})).intValue();
	}

}
