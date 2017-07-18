package com.pathology.mapping;

import java.sql.ResultSet;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import com.pathology.entity.Function;

public class FunctionMapping implements RowMapper {
	  private final Logger logger = Logger.getLogger(PathologyMapping.class);

	  @Override
	  public Function mapRow(ResultSet rs, int arg1) {
	    try {
		      Function bean = new Function();
		      bean.setName(rs.getString("name"));
		      bean.setUrl(rs.getString("url"));
		      bean.setIdFunction(rs.getString("id_function"));
		      return bean;
	    } catch (Exception e) {
	      logger.error(e.getMessage());

	    }
	    return null;
	  }
}
