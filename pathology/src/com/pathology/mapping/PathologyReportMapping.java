package com.pathology.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.pathology.dto.PathologyReportDTO;

public class PathologyReportMapping implements RowMapper {
	private final Logger logger=Logger.getLogger(PathologyReportMapping.class);
	@Override
	public PathologyReportDTO mapRow(ResultSet res, int arg1) {
		try{
			PathologyReportDTO bean=new PathologyReportDTO();
			bean.setAge(res.getInt("paitentage"));
			bean.setCaseId(res.getString("id_case"));
			bean.setDiagnosed(res.getString("diagnosed"));
			bean.setDiagnosisTime(res.getDate("diag_time"));
			bean.setGeneralSee(res.getString("generalsee"));
			bean.setInspecDate(res.getDate("inspectiondate"));
			bean.setInspecEnterprise(res.getString("hospitalname"));
			//临床资料
			bean.setMedicalInfo("");
			//todo
			bean.setMicroscopeSee("");
			//标本付数
			bean.setOrders(1);
			//标本部位
			bean.setPartBody(res.getString("specimename"));
			bean.setPathologyNo(res.getString("pathologyno"));
			bean.setPatientName(res.getString("patientname"));
			bean.setResult(res.getString("result"));
			bean.setSex(res.getString("sex"));
			return bean;
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			return null;
		}
	}

	
}
