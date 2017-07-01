package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.pathology.entity.Share;
import com.pathology.dto.ShareDTO;

public interface IShareService {
	
	public List<Share> getByPage(int index,Class clazz,String hql);
	public List<Share> getAllShare(Class clazz,String hql);
	public void deleteShare(Share em);
	public Share getShare(Class clazz,String id);
	public void updateShare(Share em);
	public void addShare(Share em);
	public List<ShareDTO>  getListShare(HttpServletRequest
			 request,String name);
}
