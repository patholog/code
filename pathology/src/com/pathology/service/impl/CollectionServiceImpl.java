package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import com.pathology.util.Pages;
import com.pathology.dao.ICollectionDao;
import com.pathology.entity.Collection;
import com.pathology.dto.CollectionDTO;
import com.pathology.mapping.CollectionMapping;
import com.pathology.service.ICollectionService;
 

public class CollectionServiceImpl implements ICollectionService {

	private ICollectionDao collectiondao;
	
	private JdbcTemplate  jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public ICollectionDao getCollectiondao() {
		return collectiondao;
	}

	public void setCollectiondao(ICollectionDao udao) {
		this.collectiondao = udao;
	}

	public List<Collection> getByPage(int index, Class clazz, String hql) {

		List<Object> list = collectiondao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Collection> getAllCollection(Class clazz, String hql) {
		return this.obj2Empl(collectiondao.getAllCollection(clazz, hql));
	}

	public void deleteCollection(Collection em) {
//		Message Message = Messagedao.getMessage(Message.class, em.getIdMessage());
		if(em!=null)
			collectiondao.deleteCollection(em);

	}
	
	
	public List<CollectionDTO>  getListCollection(HttpServletRequest
			 request,String name){
		
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum != null?pageNum:"1";
		String title = "";
		int status = 1;
		String sql = " select b.pathologyno ,b.patientname,c.username,a.memo,a.crt_Time,a.id_collection from collection a   "
						+" left join pathology  b  on a.case_id = b.id_case "
						+" left join  users  c on a.collectioner_Id = c.id_users";
		
		String sqlcount  = "select  count(*) from   collection  a"
				+"  left join  pathology  b  on a.case_id = b.id_case"
				+"   left join  users  c on a.collectioner_Id = c.id_users";
		
		int totalNum = jdbcTemplate.queryForInt(sqlcount);
		if(totalNum > 0){
			Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
			request.setAttribute("page", page.getPageStr());
		 
		}
		
		return jdbcTemplate.query(sql, new CollectionMapping());
	 
	}

	public Collection getCollection(Class clazz, String id) {
		
		return collectiondao.getCollection(clazz, id);
	}

	public void updateCollection(Collection em) {

		collectiondao.updateCollection(em);

	}

	public void addCollection(Collection em) {

		collectiondao.addCollection(em);
	}

	public List<Collection> obj2Empl(List<Object> list) {

		List<Collection> elist = new ArrayList<Collection>();
		for (Object obj : list) {

			Collection em = (Collection) obj;
			elist.add(em);
		}

		return elist;
	}

 
}
