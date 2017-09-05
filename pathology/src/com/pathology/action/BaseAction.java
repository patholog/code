package com.pathology.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BaseAction extends ActionSupport {

  private Logger logger = Logger.getLogger(BaseAction.class);

  /**
   * 返回json字符串
   *
   * @param response   response
   * @param jsonString json字符串
   */
  void printJson(HttpServletResponse response, String jsonString) {
    try {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out;
      out = response.getWriter();
      out.println(jsonString);
      out.flush();
      out.close();
    } catch (Exception e) {
      logger.error(e);
    }
  }
}
