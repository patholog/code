package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import com.pathology.util.Pages;
import com.pathology.util.StringUtil;
import com.pathology.dao.ICollectionDao;
import com.pathology.entity.Collection;
import com.pathology.dto.CollectionDTO;
import com.pathology.dto.ShareDTO;
import com.pathology.mapping.CollectionMapping;
import com.pathology.mapping.ShareMapping;
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

	public List<Collection> getByPage(int index, Class clazz, String hql)  throws Exception{

		List<Object> list = collectiondao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Collection> getAllCollection(Class clazz, String hql)  throws Exception{
		return this.obj2Empl(collectiondao.getAllCollection(clazz, hql));
	}

	public void deleteCollection(Collection em)  throws Exception{
//		Message Message = Messagedao.getMessage(Message.class, em.getIdMessage());
		if(em!=null)
			collectiondao.deleteCollection(em);

	}

	/**
	 * 查看收藏病理列表
   *
	 * @param request 请求
	 * @param name 当前登录用户id
	 * @return 收藏病理列表
	 * @throws Exception 查询异常
	 */
	public List<CollectionDTO>  getListCollection(HttpServletRequest request,String name)  throws Exception{
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum != null?pageNum:"1";
		String title = "";
		int status = 1;

		String whereStr=" where 1=1 ";
	    String colpat=request.getParameter("colpat");
	    String colhospital=request.getParameter("colhospital");
	    String colfromdate=request.getParameter("colfromdate");
	    String coltodate=request.getParameter("coltodate");
	    if(StringUtil.isNotBlank(colpat)){
	  	  whereStr+=" and b.patientname like'%"+colpat+"%' ";
	  	request.setAttribute("colpat",colpat);
	    }
	    if(StringUtil.isNotBlank(colhospital)){
	  	  whereStr+=" and d.name like'%"+colhospital+"%' ";
	  	request.setAttribute("colhospital",colhospital);
	    }
	    if(StringUtil.isNotBlank(colfromdate)&&StringUtil.isNotBlank(coltodate)){
		  	request.setAttribute("colfromdate",colfromdate);
		  	request.setAttribute("coltodate",coltodate);
	    	colfromdate=colfromdate+" 00:00:01";
	    	coltodate=coltodate+" 23:59:59";
	    	whereStr+=" and b.crt_Time between'"+colfromdate+"' and '"+coltodate+"'";

	    }
	    
		
		String sqlcount  = " select count(1) from collection a"
				+" inner join pathology b on a.case_id = b.id_case"
				+" left join users c on a.collectioner_Id = c.id_users"
				+" left join hospital d on b.hospitalcode = d.id_hospital"+whereStr;

		int totalNum = jdbcTemplate.queryForInt(sqlcount);

		if(totalNum > 0){
			Pages page = new Pages(totalNum, "CollectionAction!getCollectionList", Integer.parseInt(pageNum), 10);
      String sql = " select b.pathologyno, b.patientname, c.username, a.memo, b.crt_Time, b.diag_time, a.id_collection,"
          + " d.name hospitalname, a.case_id"
          + " from collection a "
          + " inner join pathology b on a.case_id = b.id_case"
          + " left join users c on a.collectioner_Id = c.id_users"
          + " left join hospital d on b.hospitalcode = d.id_hospital"+whereStr
          + page.getPageLimit();
			request.setAttribute("page", page.getPageStr());
      return jdbcTemplate.query(sql, new CollectionMapping());
    } else {
      request.setAttribute("page", "暂无数据");
      return null;
    }
	}

	public Collection getCollection(Class clazz, String id)  throws Exception{
		
		return collectiondao.getCollection(clazz, id);
	}

	public void updateCollection(Collection em)  throws Exception{

		collectiondao.updateCollection(em);

	}

	public void addCollection(Collection em)  throws Exception{

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
