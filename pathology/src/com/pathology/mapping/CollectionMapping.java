package com.pathology.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.pathology.dto.CollectionDTO;



public class CollectionMapping  implements RowMapper {
	private final Logger logger = Logger.getLogger(CollectionMapping.class);
	@Override
	public CollectionDTO mapRow(ResultSet rs, int arg1) {

		try{
			CollectionDTO bean = new CollectionDTO();
			bean.setNum(rs.getRow());
			bean.setContent(rs.getString("memo"));
		    bean.setMemo("");
		    bean.setCollectionId(rs.getString("id_collection"));
		    bean.setUsername(rs.getString("username"));
		    bean.setHospitalname(rs.getString("hospitalname"));
			bean.setPathologyNo(rs.getString("pathologyno"));
			bean.setPatientname(rs.getString("patientname"));
			bean.setCreateTime(rs.getTimestamp("crt_Time"));
			bean.setDiagtime(rs.getTimestamp("diag_Time"));
			bean.setCaseId(rs.getString("case_id"));
			/*bean.setId(rs.getInt("username"));
			bean.setCure(rs.getString("content"));
			bean.setCreate_time(rs.getString("create_time"));
			bean.setDescription(rs.getString("patientname"));
			bean.setDoctor_id(rs.getInt("doctor_id"));
			bean.setDoctor_name(rs.getString("doctor_name"));
			bean.setDoctor_reply(rs.getString("doctor_reply"));
			bean.setHelp(rs.getString("help"));
			bean.setIllness(rs.getString("illness"));
			bean.setMember_id(rs.getInt("member_id"));
			bean.setMember_name(rs.getString("member_name"));
			bean.setPatient_birthday(rs.getString("patient_birthday"));
			bean.setPatient_city(rs.getString("patient_city"));
			bean.setPatient_name(rs.getString("patient_name"));
			bean.setPatient_province(rs.getString("patient_province"));
			bean.setPatient_relation(rs.getInt("patient_relation"));
			bean.setPatient_sex(rs.getInt("patient_sex"));
			bean.setPatient_telephone(rs.getString("patient_telephone"));
			bean.setStatus(rs.getInt("status"));
			bean.setTitle(rs.getString("title"));
			bean.setUpdate_time(rs.getString("update_time"));
			bean.setIs_detail(rs.getInt("is_detail"));
			bean.setHospital_id(rs.getInt("hospital_id"));
			bean.setHospital_name(rs.getString("hospital_name"));
			bean.setDomain(rs.getString("domain"));*/
			return bean;
		}catch(Exception e){
			logger.error(e.getMessage());
			 
		}
		return null;
	}
}
