<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>病理远程会诊平台-待诊断初步</title>
  <c:set var="path" value="${pageContext.request.contextPath }"/>
  <%--<link rel="stylesheet" href="${path }/css/comc_diagnosis_wait_style.css"/>
  <link rel="stylesheet" href="${path }/css/comc_head_style.css"/>
  <link rel="stylesheet" href="${path }/css/comc_left_nav_style.css"/>
  <link rel="stylesheet" href="${path }/css/comc_page_style.css"/>--%>
  <link rel="stylesheet" href="${path }/css/public_flat.css"/>
  <link rel="stylesheet" href="${path }/css/theme.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_head_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_diagnosis_new_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_left_nav_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/comc_register_style.css?Version=5.5.1.1"/>
  <link rel="stylesheet" href="${path }/css/datepicker.css"/>
  <link rel="stylesheet" href="${path }/css/theme.css"/>
  <link rel="stylesheet" href="${path }/css/WdatePicker.css"/>
  <link rel="stylesheet" href="${path }/css/weebox.css"/>

  <script type="text/javascript" src="${path }/js/jquery.min.js"></script>
  <script type="text/javascript" src="${path }/js/jquery.form.min.js"></script>
  <script type="text/javascript" src="${path }/js/treeView.js"></script>
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
  <script type="text/javascript" src="${path }/js/CKEditor/ckeditor.js"></script>
  <script type="text/javascript">
    function ShowAddedItem() {
      var MedicalCaseInfoID = $("#hidMedcialCaseId").val();
      var wetitle = '预览';
      if ($.cookie("choosenLanguage") && $.cookie("choosenLanguage") != "null" && $.cookie("choosenLanguage") != "") {
        wetitle = 'Preview';
      }
      $.weeboxs.open("../AddedItem/AddedItemList.aspx?MedicalCaseInfoID=" + MedicalCaseInfoID, {
        title: wetitle, contentType: 'iframe', width: 920, height: 480,
        showButton: false, //不显示按钮栏
        showOk: false, //不显示确定按钮
        showCancel: false
      });  //不显示取消按钮});
    }

    //cd 待诊断禁止编辑
    $(document).ready(function masking() {
      var sta = $("#sta").val();
      if (sta === "2") {
        $("#masking").css("display", "block");

        var vHeight = $("#divAll").outerHeight() - $("#divCenter").outerHeight() - $("#divFoot").outerHeight();
        var vHeight = vHeight + "px";

        $("#masking").height(vHeight);

        /*$("#txtClinicalData").attr("disabled", "disabled");
        $("#txtFirstVisit").attr("disabled", "disabled");
        $("#txtGeneralObservation").attr("disabled", "disabled");
        $("#txtHistoryOfDisease").attr("disabled", "disabled");
        $("#txtImmuneOrgan").attr("disabled", "disabled");
        $("#txtRemark").attr("disabled", "disabled");*/
      } else {
        $("#masking").css("display", "none");
      }

      $("#txtHospitalOfDelivery").attr("title", $("#hosNaHidd").val()); //设置title属性的值

      //检测此类长文本编辑框的加载字数 by flyer
      CheckWords(document.getElementById("txtClinicalData"));
      CheckWords(document.getElementById("txtFirstVisit"));
      //CheckWords(document.getElementById("txtGeneralObservation"));
      CheckWords(document.getElementById("txtHistoryOfDisease"));
      CheckWords(document.getElementById("txtImmuneOrgan"));
      CheckWords(document.getElementById("txtRemark"));

    });

    //检测手机号码和身份证号码 by flyer
    function CheckValue(type) {
      var re = "";
      var value = "";
      if (type == "1") {
        value = $("#txtMobilePhone").val();
        re = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (value != "") {
          if (!re.test(value)) {
            $("#txtMobilePhone").css("color", "red");
            //                        $("#imgMobileS").hide();
            //                        $("#imgMobileE").show();
          }
          else {
            $("#txtMobilePhone").css("color", "#a5a5a5");
            //                        $("#imgMobileS").show();
            //                        $("#imgMobileE").hide();
          }
        }
        else {
          $("#txtMobilePhone").css("color", "#a5a5a5");
        }

      }
      if (type == "2") {
        re = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/
        value = $("#txtIdentityNumber").val();
        if (value != "") {
          if (!re.test(value)) {
            $("#txtIdentityNumber").css("color", "red");
          } else {
            $("#txtIdentityNumber").css("color", "#a5a5a5");
          }
        } else {
          $("#txtIdentityNumber").css("color", "#a5a5a5");
        }
      }
      if (type == "3") {
        value = $("#txtAge").val();
        if (value != "") {
          if (value > 150 || value == 0) {
            $("#txtAge").css("color", "red");
          } else {
            $("#txtAge").css("color", "#a5a5a5");
          }
        } else {
          $("#txtAge").css("color", "#a5a5a5");
        }
      }
    }

    //检测长文本编辑框的字数，是否超过，超过限定字数，则前景色改为红色  by flyer
    function CheckWords(txt) {
      var len = 0;
      var str = txt.value;
      $("#a" + txt.name).html(str.length);
      if (str.length > 250) {
        $("#a" + txt.name).css("color", "red");
      } else {
        $("#a" + txt.name).css("color", "#a5a5a5");
      }
    }

    $(function () {
      $('#infoForm').ajaxForm({
        dataType: 'json',
        success: function (result) {
          if (result && result !== "") {
            $('#caseIdHidden').val(result);
          } else {
            alert("新建病理失败");
          }
        }
      });
      $('#hospitalCode').change(function () {
        $('#hospitalCodeHidden').val($(this).children('option:selected').val());
      })
    });
  </script>
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
              <a href="">
                <div class="step curr">
                  1<span>病例信息</span></div>
              </a>
            </li>
            <%--<li>
              <a href="">
                <div class="step">
                  2<span>上传切片&amp;附件</span></div>
              </a>
            </li>
            <li>
              <a href="">
                <div class="step">
                  3<span>选择诊断专家</span></div>
              </a>
            </li>
            <li>
              <a href="">
                <div class="step">
                  4<span>留言</span></div>
              </a>
            </li>--%>
          </ul>
          <div class="clear">
          </div>
        </div>
        <!--相关内容块-->
        <div class="step1_information" style="position: relative;">
          <div class="information">
            <span class="red_star">*</span>请选择会诊分类<span style="color:Red">（费用不同）</span>：
            <span id="rblDiagnosisType">
              <input id="rblDiagnosisType_0" type="radio" name="rblDiagnosisType" value="1" checked="checked">
              <label for="rblDiagnosisType_0">普通会诊</label>
              <input id="rblDiagnosisType_1" type="radio" name="rblDiagnosisType" value="2">
              <label for="rblDiagnosisType_1">冰冻会诊</label>
            </span>
            <p id="DiagnosisTypeTips" style="color:red;font-size:13px;display:none;">
              注：请在提交冰冻病例前，务必与会诊专家联系好，确保能够及时诊断。冰冻切片添加后24小时内请勿关机，确保网络访问正常。
              <a href="javascript:void(0)" id="preNotice" style="display:none">准备事项告知</a>
            </p>
          </div>
          <div class="information" id="divHead">
            <div id="masking" style="display: block; height: 375px;"></div>
            <ul class="state_six">
              <li>
                <div>
                  <span class="red_star">*</span>病人姓名
                  <input name="patientName" id="patientName" class="patient_name" maxlength="8">
                </div>
              </li>
              <li>
                <div>
                  <span class="red_star">*</span>病<ins class="half_words"></ins>理<ins class="half_words"></ins>号
                  <input name="pathologyNo" id="pathologyNo" class="patient_name">
                </div>
              </li>
              <li>
                <div>
                  <div class="age"><span class="red_star">*</span>年龄
                    <input name="patientAge" id="patientAge" class="inf_age" maxlength="3" onblur="CheckValue('3')"
                           onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
                           value="">
                  </div>
                  <div class="sex">
                    <span class="red_star">*</span>性别
                    <span style="width: 70px;">
                      <select name="patientSex" id="patientSex" style="width: 70px;">
                        <option value="男">男</option>
	                      <option value="女">女</option>
                      </select>
                    </span>
                  </div>
                </div>
              </li>
              <li>
                <div>
                  <span class="red_star">*</span>取材部位
                  <input name="specimenName" id="specimenName">
                </div>
              </li>
              <li>
                <div>
                  <div class="pos_r">
                    <ins class="half_words"></ins>身份证号
                    <input name="idCard" id="idCard" class="identity" maxlength="18" onblur="CheckValue('2')">
                    <div class="clear"></div>
                    <img src="../../img/sbm_success.png" class="success" id="imgIdentityS" style="display: none;
	                                        right: 3px;">
                    <img src="../../img/sbm_error.png" class="error" id="imgIdentityE" style="display: none;
	                                        right: 3px;">
                  </div>
                </div>
              </li>
              <li>
                <div class="pos_r">
                  <ins class="half_words"></ins>手<ins class="half_words"></ins>机<ins class="half_words"></ins>号
                  <input name="mobile" id="mobile" maxlength="11"
                          onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
                          onblur="CheckValue('1')">
                  <div class="clear"></div>
                  <img src="../../img/sbm_success.png" class="success" id="imgMobileS" style="display: none;
                                        right: 25px;">
                  <img src="../../img/sbm_error.png" class="error" id="imgMobileE" style="display: none;
                                        right: 25px;">
                </div>
              </li>
              <li>
                <div>
                  <ins class="half_words"></ins>家属电话
                  <input name="txtRelativePhone" type="text" id="txtRelativePhone"
                             onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
                </div>
              </li>
              <li>
                <div>
                  <span class="red_star">*</span>送检时间
                  <input name="txtDateOfDelivery" id="txtDateOfDelivery" class="calendar"
                         onfocus="WdatePicker({isShowClear:false,dateFmt:'yyyy/MM/dd HH:mm',readOnly:false,dorisSet:'mm'})"
                         readonly="" value="">
                </div>
              </li>
              <li>
                <div>
                  <ins class="half_words"></ins>系统分类
                  <span class="select_box">
                    <select name="dListClassification" id="dListClassification">
                    </select>
                  </span>
                </div>
              </li>
              <li>
                <div>
                  <ins class="half_words"></ins>送检单位
                  <select id="hospitalCode" name="hospitalCode">
                    <option value="">请选择</option>
                    <c:forEach items="${hospitalList}" var="list" varStatus="status">
                      <option value='${list.hospitalcode}'>${list.name}</option>
                    </c:forEach>
                  </select>
                  <input type="hidden" id="hospitalCodeHidden" name="hospitalCodeHidden">
                </div>
              </li>
              <li>
                <div>
                  <ins class="half_words"></ins>送检科室
                  <input name="tbDepartmentOfDelivery" id="tbDepartmentOfDelivery"></div>
              </li>
              <li>
                <div>
                  <div class="nation">
                    <ins class="half_words"></ins>民族
                    <input name="nation" id="nation" class="nationalist">
                  </div>
                  <div class="urgent">加急<span class="tick">
                    <input name="tick_box" type="hidden" id="tick_box" value="0"></span>
                  </div>
                </div>
              </li>
              <li>
                <div>
                  <span class="red_star">*</span>会<ins class="half_words"></ins>诊<ins class="half_words"></ins>号
                  <input name="caseId" id="caseId" value="">
                  <input name="caseIdHidden" id="caseIdHidden" value="">
                </div>
              </li>
              <li>
                <div>
                  <ins class="half_words"></ins>住<ins class="half_words"></ins>院<ins class="half_words"></ins>号
                  <input name="txtInHospitalNumber" id="txtInHospitalNumber"
                          onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
                </div>
              </li>
              <li>
                <div>
                  <ins class="half_words"></ins>病<ins class="half_words"></ins>区<ins class="half_words"></ins>号
                  <input name="txtBlockNumber" id="txtBlockNumber"
                          onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
                </div>
              </li>
              <li>
                <div>
                  <ins class="half_words"></ins>病<ins class="half_words"></ins>房<ins class="half_words"></ins>号
                  <input name="txtBedNumber" id="txtBedNumber"
                          onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
                </div>
              </li>
            </ul>
            <div class="clear">
            </div>
          </div>
          <div class="information2" id="divCenter" style="">
            <ul class="left" style="width: 47%;">
              <li>
                <div style="float: left"><span class="red_star">*</span>临床资料（手术所见、影像学、相关验证等）：</div>
                <div class="ckTxt">
                  <a class="aColor">已经输入</a>&nbsp;<a id="atxtClinicalData" style="color: rgb(165, 165, 165);">75</a>
                  <a class="aColor">/250&nbsp;个字</a>
                </div>
                <div class=" clear">
                </div>
                <textarea name="txtClinicalData" id="txtClinicalData" rows="3" cols="20" class="row2"
                          onkeyup="CheckWords(this)"></textarea>
              </li>
              <li>
                <div style="float: left"><span class="red_star">*</span>初诊意见（请如实填写）：</div>
                <div class="ckTxt">
                  <a class="aColor">已经输入</a>&nbsp;<a id="atxtFirstVisit" style="color: rgb(165, 165, 165);">16</a>
                  <a class="aColor">/250&nbsp;个字</a>
                </div>
                <div class=" clear">
                </div>
                <textarea name="txtFirstVisit" id="txtFirstVisit" rows="2" cols="20" class="row2"
                          onkeyup="CheckWords(this)"
                          placeholder="为确保诊断结果的准确，请如实填写初诊意见，冰冻切片请务必填写初诊考虑，或基本病变描写、疑问等。"></textarea>
              </li>
              <li style="">
                <div style="float: left"><span class="red_star">*</span>大体所见：</div>
                <div class="ckTxt">
                  <textarea id="generalSee" name="generalSee" cols="10" rows="2" class="ckeditor"></textarea>
                </div>
              </li>
              <li>
                <div style="float: left">
                  <ins class="half_words"></ins>备注（不在诊断结果中显示）：
                </div>
                <div class="ckTxt">
                  <a class="aColor">已经输入</a>&nbsp;<a id="atxtRemark" style="color: rgb(165, 165, 165);">0</a>
                  <a class="aColor">/250&nbsp;个字</a>
                </div>
                <textarea name="txtRemark" id="txtRemark" rows="1" cols="20" class="row2" onkeyup="CheckWords(this)"></textarea>
              </li>
              <li class="remarks" style="margin-top:20px;">注：<span class="red">“*”</span>为必填内容，病史与备注中的内容不在诊断结果中显示</li>
            </ul>
            <ul class="right" style="width: 47%;">
              <li>
                <div style="float: left">
                  <ins class="half_words"></ins>病史（不在诊断结果中显示）：
                </div>
                <div class="ckTxt">
                  <a class="aColor">已经输入</a>&nbsp;<a id="atxtHistoryOfDisease" style="color: rgb(165, 165, 165);">0</a>
                  <a class="aColor">/250&nbsp;个字</a>
                </div>
                <div class=" clear">
                </div>
                <textarea name="txtHistoryOfDisease" id="txtHistoryOfDisease" rows="2" cols="20" class="row2"
                          onkeyup="CheckWords(this)"></textarea>
              </li>
              <li>
                <div style="float: left">
                  <ins class="half_words"></ins>免疫组化：
                </div>
                <div class="ckTxt">
                  <a class="aColor">已经输入</a>&nbsp;<a id="atxtImmuneOrgan" style="color: rgb(165, 165, 165);">0</a>
                  <a class="aColor">/250&nbsp;个字</a>
                </div>
                <div class=" clear">
                </div>
                <textarea name="txtImmuneOrgan" id="txtImmuneOrgan" rows="2" cols="20" class="row2"
                          onkeyup="CheckWords(this)"></textarea>
              </li>
              <li style="">
                <div style="float: left">
                  <ins class="half_words"></ins>影像学检查：
                </div>
                <div class="ckTxt">
                  <textarea id="microscopeSee" cols="10" rows="2" class="ckeditor"></textarea>
                </div>
                <div class=" clear">
                </div>
              </li>
            </ul>
            <div class="clear">
            </div>
          </div>
          <div class="information2">
            <div style="float: left">
              <ins class="half_words"></ins>上传切片：
            </div>
            <input type="file" name="slide" id="slide">
          </div>
          <div class="information_btn" id="divFoot">
            <input type="submit" name="saveInfo" value="保存" id="btnSaveInfo" class="inf_btn right">
            <div class="clear">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>
</body>
</html>