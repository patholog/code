<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head id="Head1">
  <title></title>
  <c:set var="path" value="${pageContext.request.contextPath }"/>

  <link type="text/css" rel="stylesheet" href="${path }/assets/jqueryui/jquery-ui.min.css" media="screen">
  <link type="text/css" rel="stylesheet" href="${path }/assets/plupload/jquery.ui.plupload/css/jquery.ui.plupload.css" media="screen">
</head>

<body>
<form method="post" action="./Plupload.aspx?MedicalCaseInfoID=14815&amp;type=1" id="form1">
  <div class="aspNetHidden">
    <input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
           value="/wEPDwUKMTM0ODE0NDUxOWRkYsUckXhnXKl0ATbSf3GSbi11i8cg9bvfVw3aMoear+8=">
  </div>
  <div class="aspNetHidden">
    <input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="E91E0DD0">
    <input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION"
           value="/wEdAAO79LH6TMNeb3nLlPwSjdGZh7rYbBKEAiAufsIH78E2gbMu/XaMNgajGwW2tPFSd59Q4RmE2798CkOcTqgT0n/xAxK+RvsegplZOzkPty2F5Q==">
  </div>
  <input name="hidMedicalCaseInfoID" type="hidden" id="hidMedicalCaseInfoID" value="14815">
  <input name="hidType" type="hidden" id="hidType" value="1">
  <div id="uploader">
    <div class="plupload_wrapper">
      <div class="ui-widget-content plupload_container ui-resizable plupload_view_list" id="uploader_container">
        <div class="ui-state-default ui-widget-header plupload_header">
          <div class="plupload_header_content">
            <div class="plupload_logo"></div>
            <div class="plupload_header_text">将文件添加到上传队列，然后点击“开始上传”按钮。</div>
            <div class="plupload_view_switch" style="display: none;"><input type="radio" id="uploader_view_list"
                                                                            name="view_mode_uploader" checked="checked"
                                                                            class="ui-helper-hidden-accessible">
              <label
                  class="plupload_button ui-state-active ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only"
                  for="uploader_view_list"
                  data-view="list" role="button" aria-disabled="false" title="List"><span
                  class="ui-button-text">List</span><span
                  class="ui-button-icon-secondary ui-icon ui-icon-grip-dotted-horizontal"></span></label>
            </div>
          </div>
        </div>
        <table class="plupload_filelist plupload_filelist_header ui-widget-header">
          <tbody>
          <tr>
            <td class="plupload_cell plupload_file_name">文件名</td>
            <td class="plupload_cell plupload_file_status">进度</td>
            <td class="plupload_cell plupload_file_size">大小</td>
            <td class="plupload_cell plupload_file_action">&nbsp;</td>
          </tr>
          </tbody>
        </table>
        <div class="plupload_content plupload_dropbox" id="uploader_dropbox">
          <div class="plupload_droptext">把文件拖到这里。</div>
          <ul class="plupload_filelist_content" id="uploader_filelist" unselectable="on"></ul>
          <div class="plupload_clearer">&nbsp;</div>
        </div>
        <table class="plupload_filelist plupload_filelist_footer ui-widget-header">
          <tbody>
          <tr>
            <td class="plupload_cell plupload_file_name">
              <div class="plupload_buttons" id="uploader_buttons">
                <!-- Visible --><a
                  class="plupload_button plupload_add ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-primary"
                  id="uploader_browse" role="button" aria-disabled="false" style="z-index: 1;"><span
                  class="ui-button-icon-primary ui-icon ui-icon-circle-plus"></span><span
                  class="ui-button-text">增加文件</span></a>&nbsp;
                <a class="plupload_button plupload_start ui-button ui-widget ui-state-default ui-corner-all ui-button-disabled ui-state-disabled ui-button-text-icon-primary"
                   id="uploader_start" role="button" aria-disabled="true"><span
                    class="ui-button-icon-primary ui-icon ui-icon-circle-arrow-e"></span><span class="ui-button-text">开始上传</span></a>&nbsp;
                <a class="plupload_button plupload_stop plupload_hidden ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-primary"
                   id="uploader_stop" role="button" aria-disabled="false"><span
                    class="ui-button-icon-primary ui-icon ui-icon-circle-close"></span><span
                    class="ui-button-text">停止上传</span></a>&nbsp;
                <div id="html5_1bpac5jjk1pmi2mk12v3157k19gr3_container" class="moxie-shim moxie-shim-html5"
                     style="position: absolute; top: 0px; left: 0px; width: 88px; height: 28px; overflow: hidden; z-index: 0;">
                  <input id="html5_1bpac5jjk1pmi2mk12v3157k19gr3" type="file"
                         style="font-size: 999px; opacity: 0; position: absolute; top: 0px; left: 0px; width: 100%; height: 100%;"
                         multiple="" accept=".dmetrix,.kfb,.tmap,.ndpi,application/zip,.rar,.tdr,.svs,.mds,image/tiff">
                </div>
              </div>
              <div class="plupload_started plupload_hidden">
                <!-- Hidden -->
                <div class="plupload_progress plupload_right">
                  <div class="plupload_progress_container ui-progressbar ui-widget ui-widget-content ui-corner-all"
                       role="progressbar" aria-valuemin="0"
                       aria-valuemax="100" aria-valuenow="0">
                    <div class="ui-progressbar-value ui-widget-header ui-corner-left"
                         style="display: none; width: 0%;"></div>
                  </div>
                </div>
                <div class="plupload_cell plupload_upload_status"></div>
                <div class="plupload_clearer">&nbsp;</div>
              </div>
            </td>
            <td class="plupload_file_status"><span class="plupload_total_status">0%</span></td>
            <td class="plupload_file_status"><span class="plupload_speed_status">0m/s</span></td>
            <td class="plupload_file_size"><span class="plupload_total_file_size">0 kb</span></td>
            <td class="plupload_file_action"></td>
          </tr>
          </tbody>
        </table>
        <div class="ui-resizable-handle ui-resizable-s" style="z-index: 90;"></div>
      </div>
      <input class="plupload_count" value="0" type="hidden" id="uploader_count" name="uploader_count"></div>
  </div>

  <script type="text/javascript" src="${path }/js/jquery-1.9.0.min.js"></script>
  <script type="text/javascript" src="${path }/assets/jqueryui/jquery-ui.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${path }/assets/plupload/plupload.full.min.js" charset="UTF-8"></script>
  <script type="text/javascript" src="${path }/assets/plupload/jquery.ui.plupload/jquery.ui.plupload.min.js" charset="UTF-8"></script>
  <script type="text/javascript">
    // 初始化
    String.prototype.endWith = function (str) {
      var reg = new RegExp(str + "$");
      return reg.test(this);
    }

    function startUploader() {
      var medID = $("#hidMedicalCaseInfoID").val();
      var type = $("#hidType").val();
      var typeUrl = "AppendUploadManage.ashx";
      var filtersExtensions = "xls,txt,docx,zip,pdf,gif,jpg,png,rar,dbf,pptx,ppt,doc,xlsx";
      if (type == "1") {
        typeUrl = "SectionUploadManage.ashx";
        filtersExtensions = "dmetrix,kfb,tmap,ndpi,zip,rar,tdr,svs,mds,tiff,tif";
      }
      var flag = "";
      var errorMsg = "";
      $("#uploader").plupload({
        runtimes: 'html5,flash,silverlight,html4', // 这里是说用什么技术引擎
        url: typeUrl + '?medID=' + medID,   // 服务端上传路径
        max_file_size: '50000mb', // 文件上传最大限制。
        max_file_count: 20,     //指示用户可以同时上传文件的最大数量
        chunk_size: '5mb', // 上传分块每块的大小，这个值小于服务器最大上传限制的值即可。
        max_retries: 100, //上传网络错误时的重试次数，为0时表示不重试
        // 是否生成缩略图（仅对图片文件有效）
        resize: {
          //                   width: 200,
          //                   height: 200,
          //                   quality: 90,
          crop: false // crop to exact dimensions
        },

        //  这个数组是选择器，就是上传文件时限制的上传文件类型
        filters: [
          {title: "Sec files", extensions: filtersExtensions}
        ],
        rename: true, // 是否重命名文件
        sortable: true, // Sort files
        dragdrop: true, //启用文件到小部件能够拖放(操作)(目前唯一HTML5支持)

        // Views to activate
        views: {
          list: true,
          thumbs: false, // Show thumbs
          active: 'list'
        },

        // plupload.flash.swf 的所在路径
        flash_swf_url: '../js/Component/plupload_2_1_2/Moxie.swf',

        // silverlight所在路径
        silverlight_xap_url: '../js/Component/plupload_2_1_2/Moxie.xap',

        init: {
          //                                      BeforeUpload: function (up, file) {
          ////                                          var ts = file.size;
          ////                                          var cs = up.settings.chunk_size;
          ////                                          var chunks= Math.ceil(ts/cs);
          //                                          alert(file.size);
          //                   //                       $.ajax({
          //                   //                           type: "POST",
          //                   //                           async: false,
          //                   //                           data: "{filename:'" + file.name + "',chunks:"+chunks+"}",
          //                   //                           dataType: "json",
          //                   //                           contentType: "application/json",
          //                   //                           url: "Plupload.aspx/check",
          //                   //                           success: function (data) {


          //                   //                           }
          //                   //                       });


          ////                                          $('#' + file.id + ' div.plupload_file_status').html(50 + '%');
          ////                                          $('span.plupload_total_status').html(50 + '%');
          ////                                          $('div.plupload_progress_bar').css('width', 60 + '%');
          ////                                          $('span.plupload_upload_status').html(
          ////                   						o.sprintf(_('Uploaded %d/%d files'), 60, 1)
          ////                   					);
          //                                      },
          FilesAdded: function (up, files) {
            if (type != "1" && files.length > 0 && files[files.length - 1].size > 50000000) {
              var fileName = files[files.length - 1].name.toLowerCase();
              if (fileName.endWith('.rar') || fileName.endWith('.zip')) {
                $.PopBox.Alert("", "本次上传的是附件，不可在线浏览，如果需要上传切片，请使用切片上传的相关功能。");
              }
            }
          },
          UploadComplete: function () {
            //window.close(); window.opener.location.reload();
            if (flag == "") {
              parent.window.location.href = parent.window.location.href;
              parent.closeWeebox();
            }
            else {
              flag = flag.substring(0, flag.length - 1);
              $.PopBox.Alert2("", flag + "上传失败！" + errorMsg, function () {
                parent.window.location.href = parent.window.location.href;
                parent.closeWeebox();
              });
            }
          },
          Error: function (up, err) {
            $.PopBox.Alert("", err.message);
          },
          FileUploaded: function (up, file, result) {
            if ($.trim(result.response) != "sucess") {
              flag += file.name + "、";
              errorMsg += result.response + "、";
            }

          }

        }
      });
    }

    $.ajaxSetup({
      cache: true
    });  //js文件缓存
    var lang = "";
    if ($.cookie("choosenLanguage") && $.cookie("choosenLanguage") != "null" && $.cookie("choosenLanguage") != "") {
      lang = $.cookie("choosenLanguage")
    }
    if (lang == "") {
      $.getScript("../js/Component/plupload_2_1_2/zh_CN.js")
          .done(function () {
            startUploader();
          });
    } else {
      startUploader();
    }
  </script>
</form>
</body>

</html>