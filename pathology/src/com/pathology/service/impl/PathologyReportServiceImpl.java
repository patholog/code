package com.pathology.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pathology.dto.PathologyReportDTO;
import com.pathology.mapping.CollectionMapping;
import com.pathology.mapping.PathologyReportMapping;
import com.pathology.service.IPathologyReportService;

public class PathologyReportServiceImpl implements IPathologyReportService {

	private JdbcTemplate  jdbcTemplate;
	@Override
	public PathologyReportDTO getPatholgyReportDto(String strIdCase) {
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT A.PATIENTNAME,A.PATIENTSEX,A.PATIENTAGE,A.INSPECTIONDATE,A.ID_CASE,");
		sb.append(" C.NAME AS HOSPITALNAME,A.DIAG_TIME,A.SPECIMENNAME,B.GENERALSEE,B.DIAGNOSED,B.RESULT,");
		sb.append(" A.PATHOLOGYNO");
		sb.append(" FROM PATHOLOGY A");
		sb.append(" INNER JOIN RESULT B ON A.ID_CASE=B.CASE_ID");
		sb.append(" INNER JOIN HOSPITAL C ON A.HOSPITALCODE=C.ID_HOSPITAL");
		sb.append(" WHERE A.ID_CASE=").append(strIdCase);
		return (PathologyReportDTO)jdbcTemplate.queryForObject(sb.toString(), new PathologyReportMapping());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
