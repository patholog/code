package com.pathology.mapping;

import com.pathology.dto.PathologyDTO;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;


public class PathologyMapping implements RowMapper {
  private final Logger logger = Logger.getLogger(PathologyMapping.class);

  @Override
  public PathologyDTO mapRow(ResultSet rs, int arg1) {
    try {
      SimpleDateFormat myFmt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      PathologyDTO bean = new PathologyDTO();
      bean.setNum(rs.getRow());
      bean.setPathologyNo(rs.getString("pathologyno"));
      bean.setPatientname(rs.getString("patientname"));
      bean.setHospitalCode(rs.getString("hospitalcode"));
      bean.setHospitalname(rs.getString("hospitalname"));
      if(rs.getTimestamp("crt_Time")!=null){
    	  bean.setCreateTime(myFmt1.format(rs.getTimestamp("crt_Time"))); 
      }
      bean.setPatientBirthday(rs.getDate("patientBirthday"));
      bean.setPatientSex(rs.getString("patientSex"));
      bean.setPatientAge(rs.getString("patientAge"));
      bean.setAgeUnit(rs.getString("ageunit"));
      bean.setSpecimenName(rs.getString("specimenname"));
      bean.setIdCard(rs.getString("idCard"));
      bean.setCaseId(rs.getString("caseId"));
      bean.setMobile(rs.getString("mobile"));
      if(rs.getTimestamp("diag_time")!=null){
    	  bean.setDiagTime(myFmt1.format(rs.getTimestamp("diag_time")));
      }
      bean.setHistorySummary(rs.getString("historysummary"));
      bean.setClinicDiagnose(rs.getString("clinicdiagnose"));
      bean.setInspectionDate(rs.getDate("inspectionDate"));
      bean.setGeneralSee(rs.getString("generalSee"));
      bean.setMicroscopeSee(rs.getString("microscopeSee"));
      bean.setMemo(rs.getString("memo"));
      bean.setContent("tt");
      bean.setCollectionId(rs.getString("id_collection"));
      bean.setDiagnosed(rs.getString("diagnosed"));
      bean.setResult(rs.getString("result"));
      bean.setRetreatReason(rs.getString("retreat_reason"));
      bean.setDiagStatus(rs.getString("diag_status"));
      bean.setDiagStatusName(rs.getString("diagStatusName"));
      bean.setSpecimenType(rs.getString("specimentype"));
      bean.setSpecimenTypeName(rs.getString("specimenTypeName"));
      bean.setDoctorId(rs.getString("id_doctor"));
      if(rs.getTimestamp("last_upd_time")!=null){
    	  bean.setLastUpdTime(myFmt1.format(rs.getTimestamp("last_upd_time"))); 
      }
      
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
    } catch (Exception e) {
      logger.error(e.getMessage());

    }
    return null;
  }
}
