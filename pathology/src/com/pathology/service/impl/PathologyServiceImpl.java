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
		String sql = " select a.pathologyno ,a.patientname,a.crt_Time,d.name as hospitalname from pathology a   "
						+" left join image  b  on a.id_case = b.case_id "
						+" left join result  c on a.id_case = c.case_id"
						+" left join hospital  d on a.hospitalcode = d.id_hospital"
						+"  where a.diag_status='2'";
		String sqlcount  = "select count(*) from pathology a "
				+" left join image  b  on a.id_case = b.case_id "
				+" left join result  c on a.id_case = c.case_id"
				+" left join hospital  d on a.hospitalcode = d.id_hospital"
				+"  where a.diag_status='2'";
		
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
		String sql = " select a.pathologyno ,a.patientname,a.crt_Time,d.name as hospitalname from pathology a   "
				+" left join image  b  on a.id_case = b.case_id "
				+" left join result  c on a.id_case = c.case_id"
				+" left join hospital  d on a.hospitalcode = d.id_hospital"
				+"  where a.diag_status='7'";
		
		String sqlcount  = "select count(*) from pathology a "
				+" left join image  b  on a.id_case = b.case_id "
				+" left join result  c on a.id_case = c.case_id"
				+" left join hospital  d on a.hospitalcode = d.id_hospital"
				+"  where a.diag_status='7'";
		
		int totalNum = jdbcTemplate.queryForInt(sqlcount);
		if(totalNum > 0){
			Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
			request.setAttribute("page", page.getPageStr());
		 
		}
		return jdbcTemplate.query(sql, new PathologyMapping());
	 
	}
	
	public List<PathologyDTO>  getListPathologyToBack(HttpServletRequest
			 request,String name){
		
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum != null?pageNum:"1";
		String title = "";
		int status = 1;
		String sql = " select a.pathologyno ,a.patientname,a.crt_Time,d.name as hospitalname from pathology a   "
				+" left join image  b  on a.id_case = b.case_id "
				+" left join result  c on a.id_case = c.case_id"
				+" left join hospital  d on a.hospitalcode = d.id_hospital"
				+"  where a.diag_status='3'";
		
		String sqlcount  = "select count(*) from pathology a "
				+" left join image  b  on a.id_case = b.case_id "
				+" left join result  c on a.id_case = c.case_id"
				+" left join hospital  d on a.hospitalcode = d.id_hospital"
				+"  where a.diag_status='3'";
		
		int totalNum = jdbcTemplate.queryForInt(sqlcount);
		if(totalNum > 0){
			Pages page = new Pages(totalNum, "listAskonlineForm", Integer.parseInt(pageNum), 10);
			request.setAttribute("page", page.getPageStr());
		 
		}
		List<PathologyDTO> ss=(List<PathologyDTO>)jdbcTemplate.query(sql, new PathologyMapping());
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
