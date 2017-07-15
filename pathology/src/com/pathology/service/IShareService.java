package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.pathology.entity.Share;
import com.pathology.dto.ShareDTO;

public interface IShareService {
	
	public List<Share> getByPage(int index,Class clazz,String hql) throws Exception;
	public List<Share> getAllShare(Class clazz,String hql) throws Exception;
	public void deleteShare(Share em) throws Exception;
	public Share getShare(Class clazz,String id) throws Exception;
	public void updateShare(Share em) throws Exception;
	public void addShare(Share em) throws Exception;
	public List<ShareDTO>  getListShare(HttpServletRequest
			 request,String name) throws Exception;
}
