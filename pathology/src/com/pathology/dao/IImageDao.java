package com.pathology.dao;

import java.util.List;

import com.pathology.entity.Image;

public interface IImageDao {
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllImage(Class clazz,String hql);
	public List<Image> getImages(Class clazz,String id);
}
