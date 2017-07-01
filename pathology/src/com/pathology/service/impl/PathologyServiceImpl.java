package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pathology.dao.IPathologyDao;
import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Pathology;
import com.pathology.mapping.PathologyMapping;
import com.pathology.service.IPathologyService;
import com.pathology.util.Pages;
 

public class PathologyServiceImpl implements IPathologyService {

	private IPathologyDao pathologydao;
	
	private JdbcTemplate  jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public IPathologyDao getPathologydao() {
		return pathologydao;
	}

	public void setPathologydao(IPathologyDao udao) {
		this.pathologydao = udao;
	}

	public List<Pathology> getByPage(int index, Class clazz, String hql) {

		List<Object> list = pathologydao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Pathology> getAllPathology(Class clazz, String hql) {
		return this.obj2Empl(pathologydao.getAllPathology(clazz, hql));
	}

	public void deletePathology(Pathology em) {
		if(em!=null)
			pathologydao.deletePathology(em);

	}
	
	
	public List<PathologyDTO>  getListPathologyToNeed(HttpServletRequest
			 request,String name){
		
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum != null?pageNum:"1";
		String title = "";
		int status = 1;
		String sql = " select b.pathology_no ,b.patientname,c.username,a.memo,a.crt_Time from share a   "
						+" left join pathology  b  on a.case_id = b.id_case "
						+" left join  users  c on a.doctorId = c.id_users";
		
		String sqlcount  = "select  count(*) from   collection  a"
				+"  left join  pathology  b  on a.case_id = b.id_case"
				+"   left join  users  c on a.collectioner_Id = c.id_users";
		
		int totalNum = jdbcTemplate.queryForInt(sqlcount);
		if(totalNum > 0){
			Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
			request.setAttribute("page", page.getPageStr());
		 
		}
		return jdbcTemplate.query(sql, new PathologyMapping());
	 
	}
	public List<PathologyDTO>  getListPathologyToHas(HttpServletRequest
			 request,String name){
		
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum != null?pageNum:"1";
		String title = "";
		int status = 1;
		String sql = " select b.pathology_no ,b.patientname,c.username,a.memo,a.crt_Time from share a   "
						+" left join pathology  b  on a.case_id = b.id_case "
						+" left join  users  c on a.doctorId = c.id_users";
		
		String sqlcount  = "select  count(*) from   collection  a"
				+"  left join  pathology  b  on a.case_id = b.id_case"
				+"   left join  users  c on a.collectioner_Id = c.id_users";
		
		int totalNum = jdbcTemplate.queryForInt(sqlcount);
		if(totalNum > 0){
			Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
			request.setAttribute("page", page.getPageStr());
		 
		}
		return jdbcTemplate.query(sql, new PathologyMapping());
	 
	}
	public Pathology getPathology(Class clazz, String id) {
		
		return pathologydao.getPathology(clazz, id);
	}

	public void updatePathology(Pathology em) {

		pathologydao.updatePathology(em);

	}

	public void addPathology(Pathology em) {

		pathologydao.addPathology(em);
	}

	public List<Pathology> obj2Empl(List<Object> list) {

		List<Pathology> elist = new ArrayList<Pathology>();
		for (Object obj : list) {

			Pathology em = (Pathology) obj;
			elist.add(em);
		}

		return elist;
	}

 
}
