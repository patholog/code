package com.pathology.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pathology.dao.IShareDao;
import com.pathology.dto.ShareDTO;
import com.pathology.entity.Share;
import com.pathology.mapping.ShareMapping;
import com.pathology.service.IShareService;
import com.pathology.util.Pages;
 

public class ShareServiceImpl implements IShareService {

	private IShareDao sharedao;
	
	private JdbcTemplate  jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public IShareDao getSharedao() {
		return sharedao;
	}

	public void setSharedao(IShareDao udao) {
		this.sharedao = udao;
	}

	public List<Share> getByPage(int index, Class clazz, String hql) throws Exception {

		List<Object> list = sharedao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Share> getAllShare(Class clazz, String hql) throws Exception {
		return this.obj2Empl(sharedao.getAllShare(clazz, hql));
	}

	public void deleteShare(Share em) throws Exception {
		if(em!=null)
			sharedao.deleteShare(em);

	}
	
	
	public List<ShareDTO>  getListShare(HttpServletRequest
			 request,String name) throws Exception{
		
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum != null?pageNum:"1";
		String title = "";
		int status = 1;
		String sql = " select b.pathologyno ,b.patientname,c.username,a.memo,a.crt_Time,a.id_share,a.case_id,a.shareUrl,a.sharePsd,a.shareTerm from share a   "
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
		List<ShareDTO> ss= (List<ShareDTO>)jdbcTemplate.query(sql, new ShareMapping());
		return jdbcTemplate.query(sql, new ShareMapping());
	 
	}

	public Share getShare(Class clazz, String id) throws Exception {
		
		return sharedao.getShare(clazz, id);
	}

	public void updateShare(Share em) throws Exception {

		sharedao.updateShare(em);

	}

	public void addShare(Share em) throws Exception {

		sharedao.addShare(em);
	}

	public List<Share> obj2Empl(List<Object> list) {

		List<Share> elist = new ArrayList<Share>();
		for (Object obj : list) {

			Share em = (Share) obj;
			elist.add(em);
		}

		return elist;
	}

 
}
