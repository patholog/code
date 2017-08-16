package com.pathology.dao.impl;

import com.pathology.dao.IResultDao;
import com.pathology.dao.SuperDao;
import com.pathology.entity.Result;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDaoImpl extends SuperDao implements IResultDao {

  private JdbcTemplate jdbcTemplate;

  @Override
  public void insert(Result result) {
    super.add(result);
  }

  @Override
  public void updateResult(Result result) {
    super.update(result);
  }

  @Override
  public Result selectByCaseId(String caseId) {
    String sql = "select id_Result idResult, case_id caseId, doctorId doctorId, reportTime reportTime,"
        + "reportOrder reportOrder, generalSee generalSee, microscopeSee microscopeSee "
        + " from result "
        + " where case_id = '"
        + caseId + "'";
    return (Result) jdbcTemplate.query(sql, new RowMapper() {
      public Result mapRow(ResultSet arg0, int arg1) throws SQLException {
        Result t = new Result();
        t.setIdResult(arg0.getString("idResult"));
        t.setCaseId(arg0.getString("caseId"));
        t.setDoctorId(arg0.getString("doctorId"));
        t.setReportTime(arg0.getTimestamp("reportTime"));
        t.setGeneralSee(arg0.getString("generalSee"));
        t.setMicroscopeSee(arg0.getString("microscopeSee"));
        return t;
      }
    }).get(0);
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
