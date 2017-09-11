<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>病理远程会诊平台-上传切片</title>
  <c:set var="path" value="${pageContext.request.contextPath }"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/comc_diagnosis_wait_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/comc_head_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/comc_left_nav_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/comc_page_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/datepicker.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/public_flat.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/theme.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/WdatePicker.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/weebox.css"/>
  <link rel="stylesheet" href="${path }/assets/jqueryui/jquery-ui.min.css"/>
  <link rel="stylesheet" href="${path }/assets/plupload/jquery.ui.plupload/css/jquery.ui.plupload.css">

  <script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui.min.js"></script>
  <script type="text/javascript" src="${path }/js/jquery.form.min.js"></script>
  <script type="text/javascript" src="${path }/assets/plupload/plupload.full.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${path }/assets/plupload/jquery.ui.plupload/jquery.ui.plupload.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${path }/assets/plupload/i18n/zh_CN.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${path }/js/treeView.js"></script>
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery.fileupload.js"></script>
  <style type="text/css">
    #masking {
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      bottom: 83px;
      z-index: 10;
      display: none;
    }

    .lab {
      border: 1px solid #DCDCDC;
      color: #A5A5A5;
      line-height: 26px;
      height: 26px;
      margin: 0px 8px;
      font-size: 13px;
      padding: 4px 7px;
      font-family: "微软雅黑";
      min-width: 120px;
    }

    .ckTxt {
      font-size: 12px;
      float: right;
    }

    .aColor {
      color: #a5a5a5;
    }

    input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
      color: #a5a5a5;
    }

    input:-moz-placeholder, textarea:-moz-placeholder {
      color: #a5a5a5;
    }

    input::-moz-placeholder, textarea::-moz-placeholder {
      color: #a5a5a5;
    }

    input:-ms-input-placeholder, textarea:-ms-input-placeholder {
      color: #a5a5a5;
    }

    .information input[type="radio"] {
      -webkit-appearance: radio;
    }

    #preNotice {
      color: #5f98f6;
      text-decoration: underline;
      font-weight: bold;
      font-style: italic;
    }
    input {
      border: solid 1px;
    }
  </style>
</head>
<body>
<div class="header">
  <%@include file="/webdiagnosis/maintop.jsp" %>
</div>
<div id="whole" class="mlrAuto">
  <div class="menu_left">
    <ul id="Left1_MenuList">
      <%@include file="/webdiagnosis/mainleft.jsp" %>
    </ul>
  </div>
</div>
<div class="content_right">
  <div class="index_right" id="divAll" style="">
    <!--步骤指示条-->
    <div class="new_step">
      <ul>
        <li>
          <a href="PathologyAction!addPathology?caseId=<s:property value="pathology.caseId"/>&diagStatus=<s:property value="pathology.diagStatus"/>">
            <div class="step">
              1<span>病例信息</span></div>
          </a>
        </li>
        <li>
          <a href=""PathologyAction!uploadSlide?caseId=<s:property value="pathology.caseId"/>&diagStatus=<s:property value="pathology.diagStatus"/>"">
            <div class="step curr">
              2<span>上传切片</span></div>
          </a>
        </li>
      </ul>
    </div>
    <!--相关内容块-->
    <div class="index_diagnosis_table">
      <div class="diagnosis_table">
        <div class="clear"></div>
        <input type="hidden" id="caseId" name="caseId" value="<s:property value="pathology.caseId"/>">
        <table class="table">
          <tbody>
          <tr>
            <th>
              <div class="first">序号</div>
            </th><%--
            <th>
              <div>状态</div>
            </th>--%>
            <th>
              <div>切片名称</div>
            </th>
            <th>
              <div>上传时间</div>
            </th><%--
            <th>
              <div>物镜倍数</div>
            </th>
            <th>
              <div>切片大小</div>
            </th>
            <th>
              <div>免疫组化</div>
            </th>--%>
            <th>
              <div>操作</div>
            </th>
          </tr>
          <s:iterator value="imageList" id="image">
            <tr>
              <td>${image.idImage}</td>
              <%--<td>${image.preHandleFlag}</td>--%>
              <td>${image.fileName}</td>
              <td><fmt:formatDate value="${image.crtTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
              <td>
                <a href="javascript:void(0)" id="delBtn" onclick="delImage(${image.idImage})">删除</a>
              </td>
            </tr>
          </s:iterator>
          </tbody>
        </table>
        <!--分页块-->
        <span id="pagerSection"></span>
        <div class="clear"></div>
        <div class="um_btn_bg" style="width:100%;min-height:68px;">
          <input name="hidMID" type="hidden" id="hidMID" value="14816">
          <div class="new_step" style="background-color: white; float: right;border: none;">
            <ul>
              <li>
                <div class="step" id="btnUploadSec">
                  <span>上传数字切片</span>
                </div>
              </li>
            </ul>
          </div>
          <div>
            <div class="clear"></div>
          </div>
        </div>
      </div>
      <div class="pagination_btn">
        <div class="new_step" style="position:relative;background-color: white; float: right;border: none;">
          <ul>
            <li>
              <div class="step" id="btnComplete">
                <span>保&nbsp;&nbsp;&nbsp;存</span>
              </div>
            </li>
            <li>
              <div class="step" id="returnNewList">
                <span>返回新建列表</span>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="uploaderDialog" hidden>
  <form id="uploadForm" action="PathologyAction!saveUploadSlide?caseId=<s:property value="pathology.caseId"/>"
        method="post" enctype="multipart/form-data">
    <input name="caseId" type="hidden" value="<s:property value="pathology.caseId"/>">
    <div id="uploader" style="height: 100px; padding-top: 20px;">
      <input id="slide" type="file" name="slide">
    </div>
    <div class="new_step curr" style="background-color: white; float: left;border: none;">
      <ul>
        <li>
          <div class="step curr" id="uploadBtn">
            <span>开始上传</span>
          </div>
        </li>
      </ul>
    </div>
  </form>
</div>
<div id="uploaderDialog1" hidden>
  <form id="uploadForm1" action="PathologyAction!saveUploadSlide" enctype="multipart/form-data">
    <input id="fileupload1" type="file" name="files[]" data-url="PathologyAction!saveUploadSlide" multiple>
  </form>
</div>
<div id="myDialog" hidden>
  <div align="center">
    <label id="info"></label>
  </div>
</div>
</body>
<script>
  /**
   * 提交表单
   */
  $('#btnSave').click(function() {
    if (flag) {
      $('#infoForm').ajaxSubmit({
        dataType: 'json',
        success: function (result) {
          if (result && result.success) {
            $('#tipInfo').text(result.success);
            window.location.href = "PathologyAction!getNewPathologyList";
          } else if (result && result.failure) {
            showTips(result.failure);
          } else {
            showTips('出现其他错误');
          }
        }
      });
    }
  });
  $('#btnUploadSec').click(function() {
    var caseId = $('#caseId').val();
    if (caseId === '') {
      showTips("请先新建病例！");
      return false;
    }
    $('#uploaderDialog').dialog({
      title: '文件上传',
      modal: true,
      width: '400',
      height: '250'
    });
  });

  $('#uploadBtn').click(function () {
    if ($('#slide').val() === '') {
      showTips("请先选择图片");
    } else {
      $('#uploadForm').ajaxSubmit({
        dataType: 'json',
        success: function (result) {
          if (result && result.success) {
            showCallbackTips("图片上传成功", function () {
              window.location.reload();
            });
          } else if (result && result.failure) {
            showTips(result.failure);
          } else {
            showTips('出现其他错误');
          }
        }
      })
    }
  });

  $('#btnComplete').click(function() {
    showTips("保存成功");
  });
  function delImage(id) {
    $('#info').text('确定要删除该切图吗？');
    $('#myDialog').dialog({
      title: '删除切图',
      resizable: false,
      modal: true,
      buttons: [{
        text: "确定",
        icon: "ui-icon-heart",
        click: function () {
          $.ajax({
            url: 'PathologyAction!deleteImage?imageId=' + id,
            dataType: "json",
            success: function (result) {
              if (result && result.success) {
                showCallbackTips(result.success, function () {
                  window.location.reload();
                });
              } else if (result && result.failure) {
                showTips(result.failure);
                window.location.reload();
              }
            }
          })
        }
      }, {
        text: "取消",
        icon: "ui-icon-heart",
        click: function () {
          $(this).dialog("close");
        }
      }]
    });
  }
  $('#returnNewList').click(function() {
    window.location.href = "PathologyAction!getNewPathologyList";
  })
</script>
</html>