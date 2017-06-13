package com.pathology.dao;
import java.util.List;

import com.pathology.entity.Leaf;
public interface ILeafDao<T,ID> extends IBaseDao<Leaf,String> {
List<Leaf> getByName(String username,int...pages);
int getByNameRowsNum(String username);
}
