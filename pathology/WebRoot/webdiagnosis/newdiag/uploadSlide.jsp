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
  <link rel="stylesheet" href="${path }/css/public_flat.css"/>
  <link rel="stylesheet" href="${path }/css/theme.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_head_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_diagnosis_new_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_left_nav_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_register_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/assets/weebox/css/weebox.css"/>
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
<form id="infoForm" method="post" action="PathologyAction!saveInfo" enctype="multipart/form-data">
  <div id="whole" class="mlrAuto">
    <div class="menu_left">
      <ul id="Left1_MenuList">
        <%@include file="/webdiagnosis/mainleft.jsp" %>
      </ul>
    </div>
    <div class="content_right" style="">
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
        <div class="step2_upload_module">
          <!--上传切片-->
          <div class="upload_module">
            <div class="title left">上传切片</div>
            <div class="fill_des right"></div>
            <div class="clear"></div>
            <input type="hidden" id="caseId" name="caseId" value="<s:property value="pathology.caseId"/>">
            <table class="table">
              <colgroup>
                <col width="5%">
                <col width="8%">
                <col width="24%">
                <col width="12%">
                <%--<col width="7%">--%>
                <col width="7%">
                <col width="8%">
                <col width="14%">
              </colgroup>
              <tbody>
              <tr>
                <th>
                  <div class="first">序号</div>
                </th>
                <th>
                  <div>状态</div>
                </th>
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
                  <td>${image.preHandleFlag}</td>
                  <td>${image.fileName}</td>
                  <td><fmt:formatDate value="${image.crtTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                  <td></td>
                </tr>
              </s:iterator>
              </tbody>
            </table>
            <!--分页块-->
            <span id="pagerSection"></span>
            <div class="um_btn_bg" style="position:relative;width:100%;min-height:68px;">
              <input name="hidMID" type="hidden" id="hidMID" value="14816">
              <input name="btnUploadSec" type="button" id="btnUploadSec" class="inf_btn right inf_btn2"
                     value="上传数字切片" title="上传数字切片可以让专家更稳定浏览切片！">
              <div>
                <div class="clear"></div>
              </div>
            </div>
          </div>
          <div class="pagination_btn">
            <a href="PathologyAction!getNewPathologyList" class="inf_btn right">返回新建列表</a>
            <input type="button" name="btnComplete" value="保存" id="btnComplete" class="inf_btn right">
            <%--<a href="PathologyAction!addPathology?caseId=<s:property value="pathology.caseId"/>&amp;diagStatus=<s:property value="pathology.diagStatus"/>" class="inf_btn right">上一步</a>--%>
            <div class="clear">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>
<div id="uploaderDialog" hidden>
  <form id="uploadForm" action="PathologyAction!saveUploadSlide" enctype="multipart/form-data">
    <input name="caseId" type="hidden" value="<s:property value="pathology.caseId"/>">
    <div id="uploader">
      <p>对不起，您的浏览器不支持Flash，Silverlight或HTML5，请使用更新的浏览器！</p>
    </div>
  </form>
</div>
<div id="uploaderDialog1" hidden>
  <form id="uploadForm1" action="PathologyAction!saveUploadSlide" enctype="multipart/form-data">
    <input id="fileupload" type="file" name="files[]" data-url="PathologyAction!saveUploadSlide" multiple>
  </form>
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
      width: '600',
      height: '380'
    });
    startUploader();
  });

  /*function uploadFile() {
    console.log("1");
    $('#fileupload').fileupload({
      dataType: 'json',
      done: function (e, data) {
        $.each(data.result.files, function (index, file) {
          $('<p/>').text(file.name).appendTo(document.body);
        });
      }
    });
    console.log("2");
  }
  $("#uploader").plupload({
    // General settings
    runtimes : 'gears,flash,silverlight,browserplus,html5,html4',
    url : 'PathologyAction!saveUploadSlide',
    max_file_size : '10mb',
    unique_names : true,
    multiple_queues : true,
    chunk_size: '2mb',
    // Specify what files to browse for
    filters : [
      {title : "jpg, jpg", extensions : "jpg,jpeg"}
    ],

    // Flash settings
    flash_swf_url : 'plupload/js/plupload.flash.swf',
    // Silverlight settings
    silverlight_xap_url : 'plupload/js/plupload.silverlight.xap'
  });
  $('#uploadForm').submit(function(e) {
    var uploader = $('#uploader').pluploadQueue();
    if (uploader.files.length > 0) {
      // When all files are uploaded submit form
      uploader.bind('StateChanged', function() {
        if (uploader.files.length === (uploader.total.uploaded + uploader.total.failed)) {
          $('#uploadForm')[0].submit();
        }
      });
      uploader.start();
    } else {
      alert('请先上传数据文件.');
    }
    return false;
  });*/
  function startUploader() {
    var caseId = $("#caseId").val();
    var type = $("#hidType").val();
    var typeUrl = "PathologyAction!saveUploadSlide";
    var filtersExtensions = "xls,txt,docx,zip,pdf,gif,jpg,png,rar,dbf,pptx,ppt,doc,xlsx";
    if (type === "1") {
      typeUrl = "SectionUploadManage.ashx";
      filtersExtensions = "dmetrix,kfb,tmap,ndpi,zip,rar,tdr,svs,mds,tiff,tif";
    }
    var flag = "";
    var errorMsg = "";
    $("#uploader").plupload({
      runtimes: 'html5,flash,silverlight,html4', // 这里是说用什么技术引擎
      url: typeUrl + '?caseId=' + caseId,   // 服务端上传路径
      maltipart: true,
      max_file_size: '50000mb', // 文件上传最大限制。
      max_file_count: 20,     //指示用户可以同时上传文件的最大数量
      chunk_size: '5mb', // 上传分块每块的大小，这个值小于服务器最大上传限制的值即可。
      max_retries: 100, //上传网络错误时的重试次数，为0时表示不重试
      // 是否生成缩略图（仅对图片文件有效）
      resize: {
        crop: false
      },

      //  这个数组是选择器，就是上传文件时限制的上传文件类型
      filters: [
        {title: "Sec files", extensions: filtersExtensions}
      ],
      rename: true, // 是否重命名文件
      sortable: true, // Sort files
      dragdrop: false, //启用文件到小部件能够拖放(操作)(目前唯一HTML5支持)

      // Views to activate
      views: {
        list: true,
        thumbs: false, // Show thumbs
        active: 'list'
      },

      // plupload.flash.swf 的所在路径
      flash_swf_url: '\\${path }/assets/plupload/Moxie.swf',
      // silverlight所在路径
      silverlight_xap_url: '\\${path }/assets/plupload/Moxie.xap',

      init: {
        FilesAdded: function (up, files) {
          if (type !== "1" && files.length > 0 && files[files.length - 1].size > 50000000) {
            var fileName = files[files.length - 1].name.toLowerCase();
            if (fileName.endWith('.rar') || fileName.endWith('.zip')) {
              showTips("本次上传的是附件，不可在线浏览，如果需要上传切片，请使用切片上传的相关功能。");
            }
          }
        },
        UploadComplete: function () {
          //window.close(); window.opener.location.reload();
          if (flag === "") {
            showCallbackTips(flag + "上传成功！", function () {
              parent.window.location.href = parent.window.location.href;
              parent.dialog("close");
            });
          } else {
            flag = flag.substring(0, flag.length - 1);
            showCallbackTips(flag + "上传失败！" + errorMsg, function () {
              parent.window.location.href = parent.window.location.href;
              parent.dialog("close");
            });
          }
        },
        Error: function (up, err) {
          showTips(err.message);
        },
        FileUploaded: function (up, file, result) {
          if ($.trim(result.response) !== "success") {
            flag += file.name + "、";
            errorMsg += result.response + "、";
          }
        }
      }
    });
  }
  $('#btnComplete').click(function() {
    showTips("保存成功");
  })
</script>
</html>