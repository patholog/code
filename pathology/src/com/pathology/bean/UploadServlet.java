package com.pathology.bean;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

public class UploadServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  // String repositoryPath;
  String uploadPath = "";
  private static final ResourceBundle bundle = ResourceBundle
      .getBundle("config");

  public UploadServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    Integer chunk = null;// 分割块数
    Integer chunks = null;// 总分割数
    String tempFileName = null;// 临时文件吿
    String fileName = "";
    BufferedOutputStream outputStream = null;
    if (ServletFileUpload.isMultipartContent(request)) {
      try {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024);
        // factory.setRepository(new File(repositoryPath));// 设置临时目录
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        // upload.setSizeMax(5 * 1024 * 1024);// 设置附件朿ħ大小，超过这个大小上传会不成势
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
          if (item.isFormField()) {// 是文本域
            if (item.getFieldName().equals("name")) {
              tempFileName = item.getString();
            } else if (item.getFieldName().equals("chunk")) {
              chunk = Integer.parseInt(item.getString());
              // System.out.println("当前文件块：" + (chunk + 1));
            } else if (item.getFieldName().equals("chunks")) {
              chunks = Integer.parseInt(item.getString());
              // System.out.println("文件总分块：" + chunks);
            }
          } else {
            // 如果是文件类垿
            if (tempFileName != null) {
              String chunkName = item.getName();
              fileName = item.getName();//真实文件名
              if (chunk != null) {
                chunkName = chunk + "_" + tempFileName;
              }
              File savedFile = new File(uploadPath, chunkName);
              item.write(savedFile);
            }
          }
        }
        if (chunk != null && chunk + 1 == chunks) {
          outputStream = new BufferedOutputStream(
              new FileOutputStream(new File(uploadPath,
                  fileName)));
          // 遍历文件合并
          for (int i = 0; i < chunks; i++) {
            File tempFile = new File(uploadPath, i + "_"
                + tempFileName);
            System.out.println("tempFileName:" + tempFileName);
            byte[] bytes = FileUtils.readFileToByteArray(tempFile);
            outputStream.write(bytes);
            outputStream.flush();
            tempFile.delete();
          }
          outputStream.flush();
        }
        Map<String, Object> m = new HashMap<String, Object>();
        System.out.println("newFileName:" + fileName);
        m.put("status", true);
        m.put("fileUrl", uploadPath + "/");
        response.getWriter().write(JSONObject.fromObject(m).toString());
      } catch (FileUploadException e) {
        e.printStackTrace();
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", false);
        response.getWriter().write(JSONObject.fromObject(m).toString());
      } catch (Exception e) {
        e.printStackTrace();
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", false);
        response.getWriter().write(JSONObject.fromObject(m).toString());
      } finally {
        try {
          if (outputStream != null)
            outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}