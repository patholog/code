package com.pathology.bean;

import org.apache.struts2.dispatcher.multipart.JakartaMultiPartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestParseWrapper extends JakartaMultiPartRequest {
  public void parse(HttpServletRequest request, String saveDir) throws IOException {

  }
}
