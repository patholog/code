package com.pathology.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDao<T extends Serializable,ID extends Serializable> {
List<T> getByExample(T t,int ...pages);
int getByExampleRowsNum(T t);
List<T> getByDetachedCriteria(DetachedCriteria dc,int ...pages);
int getByDetachedCriteriaRowsNum(DetachedCriteria dc);
T save(T t);
T edit(T t);
T delt(T t);
T getOne(ID id);
List getAll(String hql);
}
