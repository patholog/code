<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>病理远程会诊平台</title>
  <style type="text/css">
    body {
      margin: 0;
      padding: 0;
    }

    body {
      background: #ddd;
    }

    ul {
      list-style: none;
    }

    a {
      text-decoration: none;
    }

    .nav {
      background: #fff;
      width: 100%;
      height: 100px;
      font-size: 20px;
      line-height: 100px;
      text-align: center;
      border-bottom: 1px solid #f60;
    }

    .box {
      margin: 0 auto;
    }

    .fl_l {
      width: 200px;
      float: left;
      border: 1px solid #f4f4f4;
      background: #fff;
    }

    .fl_l li a {
      border-bottom: 1px solid #eee;
      text-align: center;
      display: inline;
      color: #333;
      font-size: 14px;
      line-height: 60px;
    }

    .fl_l li.active a {
      background: #63B8FF;
      color: #fff;
    }

    .fl_r {
      float: left;
      /*width: 960px;*/
      alignment: top;
    }

    .fl_r li {
      margin-top: 10px;
      margin-bottom: 30px;
      background: #fff;
      font-size: 16px;
    }

    .fl_r_row {
      margin-top: 10px;
      margin-bottom: 10px;
    }

    .fl_t {
      width: 800px;
      float: left;
      border: 1px solid #f4f4f4;
      background: #fff;
      white-space: nowrap;
    }

    .fl_t li {
      display: inline-block;
    }

    .fl_t li a {
      width: 200px;
      border-bottom: 1px solid #eee;
      text-align: center;
      display: inline-block;
      color: #333;
      font-size: 14px;
      line-height: 60px;
    }

    .fl_t li.active a {
      background: #63B8FF;
      color: #fff;
    }

    .banner {
      background: #fff;
      width: 100%;
      height: 600px;
      font-size: 40px;
      line-height: 600px;
      text-align: center;
      margin-bottom: 30px;
    }
  </style>
  <meta name="Copyright" content="Douco Design."/>
  <link href="css/public.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/global.js"></script>
  <c:set var="path" value="${pageContext.request.contextPath }"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/style.css"/>
  <script type="text/javascript" src="${path }/js/CKEditor/ckeditor.js"></script>
  <script type="text/javascript" src="${path }/CKFinder/ckfinder/ckfinder.js"></script>
  <script type="text/javascript" src="${path }/js/treeView.js"></script>
  <script type="text/javascript" src="${path }/js/common-cn.js"></script>
  <script type="text/javascript" src="${path }/js/forbid-refresh.js"></script>
  <style>
    .fl_r_table {
      font-size: 16px;
    }

    .fl_r_table_tr {
      margin: 15px 0;
    }

    .fl_r_table label {
      font-size: 16px;
    }

    .fl_r_table input {
      font-size: 14px;
      outline: solid thin #bbb;
      margin: 0 8px;
      padding: 0 7px;
    }

    .fl_r_table textarea {
      font-size: 14px;
      outline: solid thin #bbb;
      resize: none;
      width: 400px;
      padding: 0 7px;
    }

    .input-20 {
      width: 20px;
    }

    .input-30 {
      width: 30px;
    }

    .input-50 {
      width: 50px;
    }

    .input-120 {
      width: 120px;
    }

    .input-150 {
      width: 150px;
    }

    .main-contents {
      padding-left: 10px;
    }

    span.red-star, .half-word {
      display: inline-block;
      *display: inline;
      *zoom: 1;
      width: 0.5em;
    }

    span.red-star {
      color: #cb1d20;
    }

    .remarks {
      line-height: 25px;
      font-size: 14px;
      padding: 0 8px;
      border-radius: 3px;
      margin-top: 10px;
      background-color: #e4e4e4;
      border: 1px solid #dcdcdc;
      width: auto;
    }

    hr.split-line {
      border: 1px solid #63B8FF;
    }
  </style>
  <link rel="stylesheet" type="text/css" href="${path }/css/diag_style.css"/>
  <link rel="stylesheet" type="text/css" href="${path }/css/diag_theme.css"/>
</head>
<body>
<div id="header">
  <%@include file="/webdiagnosis/maintop.jsp" %>
</div>
<table id="main" cellpadding="0" cellspacing="0" border="0">
  <tr>
    <td id="leftmenu">
      <%@include file="/webdiagnosis/mainleft.jsp" %>
    </td>
    <td class="main-contents">
      <div class="box">
        <ul class="fl_t">
          <li class="active"><a href="#">病历信息</a></li>
          <li><a href="#">附件&切片</a></li>
          <li><a href="#">填写诊断</a></li>
          <li><a href="#">留言</a></li>
        </ul>
        <ul class="fl_r">
          <li>
            <div id="divTitle">
              <div class="title">
                <span class="left">诊断报告</span>
                <a class="history">病史备注</a>
                <a class="history">导出</a>
                <a class="history">打印</a>
                <a class="history">分享</a>
              </div>
            </div>
            <div id="divReport">
              <div class="logo-title">
                <span>病理远程会诊咨询意见书</span>
              </div>
              <div class="subtitle">
                <span>原病理号：17040601</span>
                <span>会诊号：20170406800</span>
              </div>
              <div class="hr-report">
                <hr>
              </div>
              <div class="">
                <table>
                  <tr>
                    <td>
                      <label>姓名</label>
                      <span><s:property value="pathology.patientname"/>"</span>
                    </td>
                    <td>
                      <label>性别</label>
                      <span>男</span>
                    </td>
                    <td>
                      <label>年龄</label>
                      <span>30</span>
                    </td>
                    <td>
                      <label>送检时间</label>
                      <span>2017-01-01 12:00:00</span>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2">
                      <label>送检单位</label>
                      <span>武汉千屏影像技术有限责任公司</span>
                    </td>
                    <td>
                      <label>切片&附件数：</label>
                      <span>1</span>
                    </td>
                    <td>
                      <label>诊断时间：</label>
                      <span>2017-01-01 12:00:00</span>
                    </td>
                  </tr>
                </table>
              </div>
              <div>
                <hr>
              </div>
              <div>
                <span>临床资料（手术所见、影像学、相关检验等）：</span>
                <span>我院乳腺彩超：左乳外上象限可及大小约2.0 cm×1.2 cm肿物，呈低回声，形态规则，边界不清，无包膜，后方回声增强。临床考虑恶性肿瘤可能性大。于我院行乳腺穿刺病理示：考虑纤维上皮性肿瘤，不除外恶性病变，等手术标本进一步确诊。临床遂行手术。术中冷冻：纤维上皮性肿瘤，导管上皮增生活跃，细胞中等异型，间质细胞丰富，异型明显，高度疑为恶性。行肿物切除术。</span>
              </div>
              <div><hr></div>
              <div>
                <span>材料部位：</span>
                <span>左乳肿物</span>
              </div>
              <div><hr></div>
              <div>
                <span>大体所见：</span>
              </div>
              <div><hr></div>
              <div>
                <span>免疫组化</span>
                <span>免疫组化</span>
              </div>
              <div><hr></div>
              <div>
                <span>初诊意见（或其他单位诊断意见）：</span>
              </div>
              <div><hr></div>
              <div>
                <span>病理图像：</span>
                <div>
                  <img>
                </div>
              </div>
              <div><hr></div>
              <div>
                <span>远程病理专家诊断意见：</span>
                <span></span>
                <div>
                  <span>
                    注：会诊资料局限，以上报告仅为所见切片的咨询意见，仅供原单位病理科参考。
如治疗，请结合原单位临床资料综合分析。
                  </span>
                </div>
              </div>
              <div><hr></div>
              <div>
                <span>本报告由武汉千屏影像技术有限责任公司  袁主任  专家会诊</span>
              </div>
            </div>
            <div class="fl_r_row">
              <label><span class="red-star">*</span>请选择会诊分类<span style="color: red">（费用不同）</span>： </label>
              <input title="hzlx" name="hzlx" type="radio" value="1">普通会诊
              <input title="hzlx" name="hzlx" type="radio" value="2">冰冻会诊
            </div>
            <hr class="split-line">
            <div class="fl_r_row">
              <table class="fl_r_table">
                <tr class="fl_r_table_tr">
                  <td>
                    <label>
                      <span class="red-star">*</span>病<span class="half-word"></span>理<span class="half-word"></span>号
                    </label>
                    <input class="input-120" id="blh" type="text" value="<s:property value="pathology.pathologyNo"/>">
                  </td>
                  <td>
                    <label for="age"><span class="red-star">*</span>年龄</label>
                    <input class="input-30" id="age" type="text"
                           value="<s:property value="pathology.patientAge"/>">
                  </td>
                  <td>
                    <label for="sex"><span class="red-star">*</span>性别</label>
                    <select id="sex">
                      <s:if test='%{pathology.patientSex=="男"}'>
                        <option value="男" selected>男</option>
                      </s:if>
                      <s:if test='%{pathology.patientSex=="女"}'>
                        <option value="女" selected>女</option>
                      </s:if>
                    </select>
                  </td>
                  <td colspan="2">
                    <label class="label-70" for="qcbw"><span class="red-star">*</span>取材部位</label>
                    <input class="input-150" id="qcbw" type="text" value="<s:property value="pathology.specimenName"/>">
                  </td>
                </tr>
                <tr>
                  <td>
                    <label for="sfzh"><span class="half-word"></span>身份证号</label>
                    <input class="input-150" id="sfzh" type="text" value="<s:property value="pathology.idCard"/>">
                  </td>
                  <td>
                    <label for="mobile">
                      <span class="half-word"></span>手<span class="half-word"></span>机<span class="half-word"></span>号
                    </label>
                    <input class="input-120" id="mobile" type="text" value="<s:property value="pathology.mobile"/>">
                  </td>
                  <td colspan="2">
                    <label for="mobileRel"><span class="half-word"></span>家属电话</label>
                    <input class="input-120" id="mobileRel" type="text" value="<s:property value="pathology.mobile"/>">
                  </td>
                  <td colspan="2">
                    <label for="sjDate"><span class="red-star">*</span>送检时间</label>
                    <input class="input-150" id="sjDate" type="text"
                           value="<s:property value="pathology.inspectionDate"/>">
                  </td>
                </tr>
                <tr>
                  <td>
                    <label for="category"><span class="half-word"></span>系统分类</label>
                    <input class="input-150" id="category" type="text" value="全科">
                  </td>
                  <td>
                    <label for="sendCompany"><span class="half-word"></span>送检单位</label>
                    <input class="input-120" id="sendCompany" type="text"
                           value="<s:property value="pathology.hospitalname"/>">
                  </td>
                  <td colspan="2">
                    <label for="sendKeshi"><span class="half-word"></span>送检科室</label>
                    <input class="input-120" id="sendKeshi" type="text"
                           value="<s:property value="pathology.hospitalname"/>">
                  </td>
                  <td>
                    <label for="nation"><span class="half-word"></span>民族</label>
                    <input class="input-50" id="nation" type="text" value="0">
                  </td>
                  <td>
                    <label for="urgent">加急</label>
                    <input class="input-20" id="urgent" type="text" value="0">
                  </td>
                </tr>
                <tr>
                  <td>
                    <label for="consultationNo">
                      <span class="half-word"></span>会<span class="half-word"></span>诊<span class="half-word"></span>号
                    </label>
                    <input class="input-150" id="consultationNo" type="text" value="110101199901011234">
                  </td>
                  <td>
                    <label for="admissionNo">
                      <span class="half-word"></span>住<span class="half-word"></span>院<span class="half-word"></span>号
                    </label>
                    <input class="input-120" id="admissionNo" type="text" value="18600001111">
                  </td>
                  <td colspan="2">
                    <label for="wardNo">
                      <span class="half-word"></span>病<span class="half-word"></span>区<span class="half-word"></span>号
                    </label>
                    <input class="input-120" id="wardNo" type="text" value="18600002222">
                  </td>
                  <td colspan="2">
                    <label for="roomNo">
                      <span class="half-word"></span>病<span class="half-word"></span>房<span class="half-word"></span>号
                    </label>
                    <input class="input-150" id="roomNo" type="text" value="2017-01-01 12:12:12">
                  </td>
                </tr>
                <tr>
                  <td colspan="6">
                    <hr class="split-line">
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <label for="clinicDiagnose"><span class="red-star">*</span>临床资料</label>
                  </td>
                  <td colspan="4">
                    <label for="historySummary"><span class="half-word"></span>病史</label>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <textarea id="clinicDiagnose"><s:property value="pathology.clinicDiagnose"/></textarea>
                  </td>
                  <td colspan="4">
                    <textarea id="historySummary"><s:property value="pathology.historySummary"/></textarea>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <label for="preliminaryOpinion"><span class="red-star">*</span>初诊意见</label>
                  </td>
                  <td colspan="4">
                    <label for="ihc"><span class="half-word"></span>免疫组化</label>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <textarea id="preliminaryOpinion">初诊意见内容</textarea>
                  </td>
                  <td colspan="4">
                    <textarea id="ihc">免疫组化内容</textarea>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <label for="generalSee"><span class="red-star">*</span>大体所见</label>
                  </td>
                  <td colspan="4">
                    <label for="microscopeSee">
                      <span class="half-word"></span>影像学检查</label>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <textarea id="generalSee" cols="10" rows="2" class="ckeditor">
                      <s:property value="pathology.generalSee"/>
                    </textarea>
                  </td>
                  <td colspan="4">
                    <textarea id="microscopeSee" cols="10" rows="2" class="ckeditor">
                      <s:property value="pathology.microscopeSee"/>
                    </textarea>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <label for="memo"><span class="half-word"></span>备注</label>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <textarea id="memo"><s:property value="pathology.memo"/></textarea>
                  </td>
                </tr>
              </table>
              <div class="remarks" style="width: 500px;">
                <span>注：</span>
                <span style="color: red">“*”</span>
                <span>为必填内容，病史与备注中的内容不在诊断结果中显示</span>
              </div>
            </div>
            <hr class="split-line">
          </li>
          <li>
            <div class="upload-module">
              <div class="title-left">上传切片</div>
              <table class="listtable" cellspacing="0" cellpadding="0" width="100%">
                <tbody>
                <tr>
                  <th>序号</th>
                  <th>状态</th>
                  <th>切片名称</th>
                  <th>上传时间</th>
                  <th>物镜倍数</th>
                  <th>切片大小</th>
                  <th>免疫组化</th>
                  <th>操作</th>
                </tr>
                <s:iterator value="pathologys" id="pathology" status="11">
                  <tr>
                    <td><s:property value="#pathology.pathologyNo"/></td>
                    <td><s:property value="#pathology.patientname"/></td>
                    <td><s:property value="#pathology.patientname"/></td>
                    <td><s:property value="#pathology.username"/></td>
                    <td><s:property value="#pathology.content"/></td>
                    <td><s:property value="#pathology.hospitalname"/></td>
                    <td><s:property value="#pathology.createTime"/></td>
                    <td align="center">
                      <a href="PathologyAction!null?id=<s:property value="#pathology.caseId"/> target='_blank'">查看</a>
                    </td>
                  </tr>
                </s:iterator>
                <tr class="lightrow">
                  <td colspan="8">
                    <div id="pageDir">
                      <%=request.getAttribute("page") != null ? request.getAttribute("page") : "" %>
                    </div>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
          </li>
          <li style="height: 400px;">填写诊断内容3</li>
          <li style="height: 500px;">留言内容4</li>
        </ul>
        <div style="clear: both;"></div>
      </div>
    </td>
  </tr>
</table>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
  $(function () {
    // 禁用所有input
    $('input').attr("disabled", "true");
    $('textarea').attr("disabled", "true");
    $('select').attr("disabled", "true");
    //设置标杆
    var _line = parseInt($(window).height() / 3);
    $(window).scroll(function () {
      //滚动730px，左侧导航固定定位
      if ($(window).scrollTop() > 730) {
        $('.fl_t').css({'position': 'fixed', 'top': 10})
      } else {
        $('.fl_t').css({'position': '', 'top': ''})
      }
      ;
      $('.fl_t li').eq(0).addClass('active');
      //滚动到标杆位置,左侧导航加active
      $('.fl_r li').each(function () {
        var _target = parseInt($(this).offset().top - $(window).scrollTop() - _line);
        var _i = $(this).index();
        if (_target <= 0) {
          $('.fl_t li').removeClass('active');
          $('.fl_t li').eq(_i).addClass('active');
        }
        //如果到达页面底部，给左侧导航最后一个加active
        else if ($(document).height() == $(window).scrollTop() + $(window).height()) {
          $('.fl_t li').removeClass('active');
          $('.fl_t li').eq($('.fl_r li').length - 1).addClass('active');
        }
      });
    });
    $('.fl_t li').click(function () {
      $(this).addClass('active').siblings().removeClass('active');
      var _i = $(this).index();
      $('body, html').animate({scrollTop: $('.fl_r li').eq(_i).offset().top - _line}, 500);
    });
  });
</script>
<div style="text-align:center;">
</div>
</body>
</html>