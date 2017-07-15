package com.pathology.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.pathology.entity.Hospital;
import com.pathology.service.IHospitalService;
import com.pathology.util.Constant;
import com.pathology.util.SessionAgentManager;

public class HospitalAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(HospitalAction.class);
	private Hospital hos = new Hospital();
	private IHospitalService hospitalservice;
	private String idHospital;
	private HttpServletRequest request;

	private Hospital hospital;
	private List<Hospital> hospitallist;
	private int index;

	public String addHospital() throws Exception {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			hospital.setIdHospital(getEandomId(16));
			hospital.setCode(getEandomId(16));
			hospitalservice.addHospital(hospital);

			return "updatesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String hospitalList() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			String hql = "";
			if (hospital != null) {
				String hospitalname = null;
				try {
					hospitalname = new String(
							(hospital.getName().getBytes("ISO8859-1")), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				if (hospitalname != null && !("".equals(hospitalname)))
					hql += " and name like '%" + hospitalname + "%'";
				if (hospital.getCode() != null
						&& !("".equals(hospital.getCode())))
					hql += " and code like '%" + hospital.getCode() + "%'";

			}

			List<Hospital> list = index != 0 ? hospitalservice.getByPage(index,
					Hospital.class, hql) : hospitalservice.getByPage(1,
					Hospital.class, hql);

			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("hoslist", list);
			session.setAttribute("thisindex", index == 0 ? 1 : index);

			session.setAttribute("count",
					hospitalservice.getAllHospital(Hospital.class, hql).size());
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String updateHospital() throws IOException {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Hospital hospitalT = hospitalservice.getHospital(Hospital.class,
					hospital.getIdHospital());
			session.setAttribute("hospital", hospitalT);
			return "edit";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}

	}

	public String saveHospital() throws IOException {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;
			Hospital hospitalT =hospitalservice.getHospital(Hospital.class, hospital.getIdHospital());
			hospitalT.setName(hospital.getName());
			hospitalT.setHospitalcode(hospital.getHospitalcode());
			hospitalT.setMemo(hospital.getMemo());
			hospitalT.setTel(hospital.getTel());
			hospitalT.setAddress(hospital.getAddress());
			hospitalservice.updateHospital(hospitalT);
			return "updatesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public String deleteHospital() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;

			Hospital hos = hospitalservice.getHospital(Hospital.class,
					hospital.getIdHospital());
			hospitalservice.deleteHospital(hos);
			return "deletesuccess";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}

	}

	public String allHostpital() {
		try {

			if (!SessionAgentManager.islogin())
				return Constant.ERR;

			List<Hospital> list = hospitalservice.getAllHospital(
					Hospital.class, "");
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("hoslist", list);
			return "regist";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Constant.ERR;
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Hospital getHos() {
		return hos;
	}

	public void setHos(Hospital hos) {
		this.hos = hos;
	}

	public IHospitalService getHospitalservice() {
		return hospitalservice;
	}

	public void setHospitalservice(IHospitalService hospitalservice) {
		this.hospitalservice = hospitalservice;
	}

	public String getIdHospital() {
		return idHospital;
	}

	public void setIdHospital(String idHospital) {
		this.idHospital = idHospital;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Hospital> getHospitallist() {
		return hospitallist;
	}

	public void setHospitallist(List<Hospital> hospitallist) {
		this.hospitallist = hospitallist;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
