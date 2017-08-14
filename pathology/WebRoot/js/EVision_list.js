var lang = "";
$(function () {
  if ($.cookie("choosenLanguage") && $.cookie("choosenLanguage") != "null" && $.cookie("choosenLanguage") != "") { lang = $.cookie("choosenLanguage") }
  if (lang == "en") {
//        if ($(".um_btn_bg").length > 0) {
//            var result = setEnglish2($("body").html());
//            $("body").html(result);
//        } else {
    var result = setEnglish2($(".index_right").html());
    $(".index_right").html(result);
//        }

    $(".state_six").find("li").css("width", "33%");
    $(".state_six").find("li").children().attr("style", "width:330px; text-align:right;");
    $(".state_six").find(".sex").css("float", "right");
    $(".state_six").find(".urgent").css("float", "right");
    $(".state_six").find(".urgent").css("margin-right", "8px");
    $(".state_six").find(".nation").css("margin-left", "45px");
    $(".state_six").find(".age").css("margin-left", "30px");
  }
  //            送检医院截取字符串
  hospitalNameSub();
  //            下拉框截取字符串和传值给label
  $(".styled_select").on("change", function () {
    var o;
    var opt = $(this).find('option');
    opt.each(function (i) {
      if (opt[i].selected == true) {
        o = opt[i].innerHTML;
      }
    })
    $(this).find('label').html(o);
  }).trigger('change');

});
function hospitalNameSub() {
  var res = "";
  var val = $("#ddlHospital").find("option:selected").text();
  res = val;
  if (val.length > 6)
    res = val.substr(0, 6);

  $("#lableName").text(res);
}


function setEnglish2(bodyString) {
  var result = bodyString;
  result = result.replaceCH('go_home" >首页<', 'go_home" >Home<');
  result = result.replaceCH('go_home">首页<', 'go_home">Home<');
  result = result.replaceCH('>不限医院<','>Unlimited<');
//	result = result.replaceCH('th>待诊断<','th>Applying Case<');
  result = result.replaceCH('>申请时间：从<','>Submission Time:From<');
  result = result.replaceCH('>状态：<','>Status:<');
  result = result.replaceCH('>不限<','>Unlimited<');
  result = result.replaceCH('>普通<','>Ordinary<');
  result = result.replaceCH('>加急<','>Urgent<');
  result = result.replaceCH('>系统分类：<','>System Category：<');
  result = result.replaceCH('>系统分类<','>System Category<');
  result = result.replaceCH('>全科<','>All<');
  result = result.replaceCH('>送检单位：<','>Hospital：<');
  result = result.replaceCH('>送检单位<','>Hospital<');
  result = result.replaceCH('关键字&nbsp;如：姓名','No. or Name');
  result = result.replaceCH('>病理号<','>Pathology No.<');
  result = result.replaceCH('>病人姓名<','>Name<');
  result = result.replaceCH('>材料部位<','>Specimen<');
  result = result.replaceCH('>病例状态<', '>CaseStatus<');
  result = result.replaceCH('>申请时间<', '>Application time<');
  result = result.replaceCH('>创建时间<', '>Creation time<');
  result = result.replaceCH('>操作<','>Operate<');
  result = result.replaceCH('"搜索"', '"Search"');
  result = result.replaceCH('>使用帮助<', '>Manual<');
  result = result.replaceCH('>Copyright 2006-2017 91360.com All Rights Reserved. 宁卫网审（2015）41号 苏ICP备13032250号，如有问题，请速与我们联系，电话：40004-91360<', '>Copyright 2006-2017 91360.com All rights reserved. Su ICP 13032250. If you have any problems, please contact us, 40004-91360<');
  //新建列表CaseUnfinishList
  result = result.replaceCH('>年龄<', '>Age<');
  result = result.replaceCH('>性别<', '>Gender<');
  result = result.replaceCH('>送检专家<', '>Pathology Expert<');
  result = result.replaceCH('>送检专家：<', '>Pathology Expert：<');
  result = result.replaceCH('"新建"', '"Add New Case"');
  result = result.replaceCH('>新建列表<', '>New Case<');
  result = result.replaceCH('"系统自动生成"', '"Generate automatically"');
  //待诊断列表CaseListDiagnosis
  result = result.replaceCH('>申请时间：从<', '>Submission time：From<');
//	result = result.replaceCH('th>已诊断<','th>Diagnosed Case<');
  result = result.replaceCH('>诊断时间：从<','>Diagnosed time:From<');
  result = result.replaceCH('>诊断时间<', '>Diagnosed Time<');
  result = result.replaceCH('>分享<', '>Share<');
  //已诊断列表DiagnosisCaseList
  result = result.replaceCH('>退回时间：从<','>Returned Time:From<');
  result = result.replaceCH('>退回原因<','>Returned Reason<');
  result = result.replaceCH('>退回时间<', '>Returned Time<');
  result = result.replaceCH('>取消收藏<', '>Unfavorite<');
  result = result.replaceCH('>补发专家<', '>Resubmit<');
  //退回病例列表ExportCaseList
  result = result.replaceCH('>状态<', '>Case Status<');
  result = result.replaceCH('>状态:<', '>Case Status:<');
  result = result.replaceCH('>查看<', '>View<');
  result = result.replaceCH('>再次编辑<', '>Edit Again<');
  result = result.replaceCH('>退回病例<', '>Returned<');
  //收藏病例列表CaseList
  result = result.replaceCH('>新建列表<','>New Case<');
  result = result.replaceCH('>编辑<', '>Edit<');
  result = result.replaceCH('>收藏病例<', '>Favorite<');
  //新建列表 医院端
  result = result.replaceCH('>准备事项告知<', '>Preparations<');
  result = result.replaceCH('>共<','>All<');
  result = result.replaceCH('>条记录<','>entries<');
  result = result.replaceCH('>分<','>All<');
  result = result.replaceCH('>页<span>','>Pages<span>');
  result = result.replaceCH('>每页<','><br/>Each shows<');
  result = result.replaceCH('>当前第<','>Current In Page<');
  result = result.replaceCH('>首页<','>First<');
  result = result.replaceCH('>上一页<','>Previous<');
  result = result.replaceCH('>下一页<','>Next<');
  result = result.replaceCH('>尾页<','>End<');
  result = result.replaceCH('>转到第<','>Switch To Page<');
  result = result.replaceCH('>页<input','><input');

  result = result.replaceCH('>诊断<','>Diagnose<');
  result = result.replaceCH('>取消收藏<','>Unfavorite<');
  result = result.replaceCH('>收藏<', '>Favorite<');
  result = result.replaceCH('>到<','>to<');
  result = result.replaceCH('>页<', '><');

  result = result.replaceCH('>创建时间：从<', '>Submission Time<');
  result = result.replaceCH('>序号<', '>No.<');
  result = result.replaceCH('>退回<', '>Returned<');
  result = result.replaceCH('>总数<', '>Total Quantity<');
  result = result.replaceCH('>报酬（元）<', '>Income<');
  result = result.replaceCH('>总计：<', '>Total<');
  result = result.replaceCH('>送检医生<', '>Doctor<');


  result = result.replaceCH('>已诊断病例数<', '>Diagnosed<');
  result = result.replaceCH('>待诊断病例数<', '>Applying<');
  result = result.replaceCH('>退回病例数<', '>Returned<');
  result = result.replaceCH('>平均诊断时间<', '>Average Time<');
  result = result.replaceCH('>总收入<', '>Total<');
  result = result.replaceCH('>今天<', '>Today<');
  result = result.replaceCH('>昨天<', '>Yesterday<');
  result = result.replaceCH('>今日<', '>Today<');
  result = result.replaceCH('>昨日<', '>Yesterday<');
  result = result.replaceCH('>日峰值<', '>Day Peak<');
  result = result.replaceCH('>峰值<', '>Peak<');
  result = result.replaceCH('>最近7天<', '>7 days<');
  result = result.replaceCH('>最近30天<', '>30 days<');
  result = result.replaceCH('>选择月份：从<', '>Please select month：from<');
  result = result.replaceCH('>已诊断<', '>Diagnosed<');
  result = result.replaceCH('>待诊断<', '>Applying<');
  result = result.replaceCH('>选择日期：从<', '>Please select date：from<');
  result = result.replaceCH('>病例总数<', '>Cases<');
  result = result.replaceCH('>收入/元<', '>Income(￥)<');
  result = result.replaceCH('>剩余次数<', '>Surplus Times<');
  //诊断报表DoctorReport
  result = result.replaceCH('>病例信息<', '>Case Info<');
  result = result.replaceCH('>上传切片&amp;附件<', '>Upload Slide & Document<');
  result = result.replaceCH('>选择诊断专家<', '>Choose Diagnosis Expert<');
  result = result.replaceCH('>病人姓名<', '>Name<');
  result = result.replaceCH('>年龄<', '>Age<');
  result = result.replaceCH('>性别<', '>Gender<');
  result = result.replaceCH('>病<ins class="half_words"></ins>理<ins class="half_words"></ins>号<', '>Pathology No.<');
  result = result.replaceCH('>加急<', '>Urgent<');
  result = result.replaceCH('>民族<', '>Ethnic<');
  result = result.replaceCH('>身份证号<', '>ID Card<');
  result = result.replaceCH('>手<ins class="half_words"></ins>机<ins class="half_words"></ins>号<', '>Cell-phone<');
  result = result.replaceCH('>家属电话<', '>Family Phone<');
  result = result.replaceCH('>送检时间<', '>Submission Time<');
  result = result.replaceCH('>系统分类<', '>System Category<');
  result = result.replaceCH('>全科<', '>All<');
  result = result.replaceCH('>送检单位<', '>Hospital<');
  result = result.replaceCH('>送检科室<', '>Department<');
  result = result.replaceCH('>取材部位<', '>Specimen<');
  result = result.replaceCH('>检<ins class="half_words"></ins>查<ins class="half_words"></ins>号<', '>Check No.<');
  result = result.replaceCH('>住<ins class="half_words"></ins>院<ins class="half_words"></ins>号<', '>Hospitalization No.<');
  result = result.replaceCH('>病<ins class="half_words"></ins>区<ins class="half_words"></ins>号<', '>Disease No.<');
  result = result.replaceCH('>病<ins class="half_words"></ins>房<ins class="half_words"></ins>号<', '>Ward No.<');
  result = result.replaceCH('>会<ins class="half_words"></ins>诊<ins class="half_words"></ins>号<', '>Consultation No.<');
  result = result.replaceCH('>临床资料（手术所见、影像学、相关验证等）：<', '>Clinical information：<');
  result = result.replaceCH('>已经输入<', '>You have entered<');
  result = result.replaceCH('>/250&nbsp;个字<', '>/250 words<');
  result = result.replaceCH('>病史（不在诊断结果中显示）：<', '>Medical history (Not show in report)：<');
  result = result.replaceCH('>备注（不在诊断结果中显示）：<', '>Remarks (Not show in report)：<');
  result = result.replaceCH('>注：<', '>Note: <');
  result = result.replaceCH('>为必填内容，病史与备注中的内容不在诊断结果中显示<', '>marked items cannot be empty. Medical history or remarks will not be displayed in report.<');
  result = result.replaceCH('"新建病例"', '"New Case"');
  result = result.replaceCH('"下一步"', '"Next"');
  result = result.replaceCH('"保存"', '"Save"');
  result = result.replaceCH('您确定删除吗？一旦删除将无法恢复！', 'Are you sure to delete the file?');
  result = result.replaceCH('>已选：<', '>Selected:<');
  result = result.replaceCH('>请选择会诊分类<', '>Please select classification of diagnosis<');
  result = result.replaceCH('>（费用不同）<', '>（Different cost）<');
  //新建病例AddCase
  result = result.replaceCH('"选择文件"', '"Select File"');
  result = result.replaceCH('"上&nbsp;传"', '"Upload"');
  result = result.replaceCH('"为确保诊断结果的准确，请如实填写初诊意见，冰冻切片请务必填写初诊考虑，或基本病变描写、疑问等。"', '"In order to ensure the accuracy of the diagnostic results, please fill in the initial diagnosis, or the basic lesion description, questions, etc."');
  result = result.replaceCH('>上一步<', '>Previous<');
  result = result.replaceCH('>上传切片<', '>Upload Slide<');
  result = result.replaceCH('>上传附件<', '>Upload Document<');
  result = result.replaceCH('"上传附件"', '"Upload Document"');
  result = result.replaceCH('"上传切片"', '"Upload Slide"');
  result = result.replaceCH('"上传普通切片"', '"Upload Slide"');
  result = result.replaceCH('>序号<', '>No.<');
  result = result.replaceCH('>状态<', '>Upload Status<');
  result = result.replaceCH('>切片名称<', '>Slide Name<');
  result = result.replaceCH('>上传时间<', '>Upload Time<');
  result = result.replaceCH('>物镜倍数<', '>Multiple Of Lense<');
  result = result.replaceCH('>切片大小<', '>Size Of Slide<');
  result = result.replaceCH('>倍<', '>times<');
  result = result.replaceCH('>免疫组化<', '>IHC<');
  result = result.replaceCH('>是&nbsp;&nbsp;&nbsp;&nbsp;<', '>Yes&nbsp;&nbsp;&nbsp;&nbsp;<');
  result = result.replaceCH('>否<', '>No<');
  result = result.replaceCH('>操作<', '>Operate<');
  result = result.replaceCH('>查看<', '>View<');
  result = result.replaceCH('>删除<', '>Delete<');
  result = result.replaceCH('"删除"', '"Delete"');
  result = result.replaceCH('>附件名称<', '>Document Name<');
  result = result.replaceCH('>附件大小<', '>Size Of Document<');
  result = result.replaceCH('>大体所见：<', '>Gross Description：<');
  result = result.replaceCH('>免疫组化：<', '>IHC：<');
  result = result.replaceCH('>影像学检查：<', '>Imaging examination：<');
  result = result.replaceCH('>初诊意见（请如实填写）：<', '>First Diagnosis：<');
  result = result.replaceCH('>请选择会诊分类：<', '>Please select classification：<');
  result = result.replaceCH('>普通会诊<', '>Routine diagnosis<');
  result = result.replaceCH('>冰冻会诊<', '>Frozen diagnosis<');
  result = result.replaceCH('>注：请在提交冰冻病例前，务必与会诊专家联系好，确保能够及时诊断。冰冻切片添加后24小时内请勿关机，确保网络访问正常。<', '>Note:please contact the expert before submitting the frozen case.Do not shut down your computer in next 24 hours for frozen-slide uploading!<');
  result = result.replaceCH('"快速免上传"', '"Add slide"');
  result = result.replaceCH('"上传数字切片"', '"Upload slide"');
  result = result.replaceCH('>专家分类：<', '>Expert classifier:<');
  result = result.replaceCH('>全部<', '>All<');
  result = result.replaceCH('>国内<', '>Domestic<');
  result = result.replaceCH('>国外<', '>Foreign<');
  result = result.replaceCH('排名不分先后，按姓氏拼音排序（本省专家优先排在前面）。', 'Ranking is not divided, sorted by the name(the provincial experts first row in front).');
  result = result.replaceCH('您是试用用户，免费专家试用次数有限，如有问题，请联系40004-91360。', 'You are a test user and free expert trial times is limited. If there is a problem, please contact 40004-91360.');
  result = result.replaceCH('>上传附件（影像资料、病例信息等）<', '>Image data, case info, etc.<');
  //上传附件和切片UploadSectionList
  result = result.replaceCH('"提交"', '"Submit"');
  result = result.replaceCH('>省份：<', '>Province：<');
  result = result.replaceCH('>城市：<', '>City：<');
  result = result.replaceCH('>医院：<', '>Hospital：<');
  result = result.replaceCH('>姓名：<', '>Name：<');
  result = result.replaceCH('>选择<', '>Select<');
  result = result.replaceCH('>专家姓名<', '>Expert Name<');
  result = result.replaceCH('>医院<', '>Hospital<');
  result = result.replaceCH('>专家手机<', '>Expert Mobile Phone<');
  result = result.replaceCH('>特长<', '>Speciality<');
  result = result.replaceCH('>出报时间<', '>Report Time<');
  result = result.replaceCH('>状态：无法诊断<', '>Status: Busy<');
  result = result.replaceCH('>时间：<', '>Time：<');
  result = result.replaceCH('>至<', '>To<');
  result = result.replaceCH('>备注：<', '>Remarks：<');
  result = result.replaceCH('>下载<', '>Download<');
  result = result.replaceCH('"未完成"', '"Uploading"');
  result = result.replaceCH('"完成"', '"Upload complete"');
  result = result.replaceCH('>请选择<', '>Select<');
  result = result.replaceCH('>留言人<', '>Name<');
  result = result.replaceCH('>留言内容<', '>Message<');
  result = result.replaceCH('>留言状态<', '>Status<');
  result = result.replaceCH('>留言时间<', '>Time<');
  result = result.replaceCH('"输入文字信息留言"', '"Please enter message"');
  result = result.replaceCH('>留言<', '>Message<');
  result = result.replaceCH('"发送留言"', '"Send Msg"');
  result = result.replaceCH('>所有专家可见<', '>To all experts<');
  result = result.replaceCH('>部分专家可见<', '>To part experts<');
  result = result.replaceCH('留言设置：', 'Message settings:');
  result = result.replaceCH('"标记为已读"', '"Mark as read"');
  result = result.replaceCH('全选<', 'All<');
//    视频会议列表
  result = result.replaceCH('>历史会议<', '>History Meetings<');
  result = result.replaceCH('>当前会议<', '>Current Meetings<');
  result = result.replaceCH('"创建视频会议"', '"Create a Meeting"');
  result = result.replaceCH('>视频会议<', '>Meetings<');
  result = result.replaceCH('>会议主题：<', '>Theme:<');
  result = result.replaceCH('>开始时间：<', '>Start Time:<');
  result = result.replaceCH('"进入"', '"Enter"');
  result = result.replaceCH('"详情"', '"Details"');
  result = result.replaceCH('"结束"', '"Cancel"');
  result = result.replaceCH('"取消"', '"Cancel"');
  result = result.replaceCH('>已结束<', '>Ended<');
//    会议详情
  result = result.replaceCH('>视频会议详情<', '>Details of Meeting<');
  result = result.replaceCH('>会议主题<', '>Theme<');
  result = result.replaceCH('>参会人员<', '>Participants<');
  result = result.replaceCH('>会议日期<', '>Date<');
  result = result.replaceCH('>会议时间<', '>Time<');
  result = result.replaceCH('>至<', '>To<');
  result = result.replaceCH('>会议说明<', '>Description<');
  result = result.replaceCH('>缺席情况：<', '>Absence:<');
  result = result.replaceCH('缺席,原因：', 'was unable to attend the meeting due to ');
  result = result.replaceCH('"无法参加"', '"Unable to Attend"');
  result = result.replaceCH('"复制"', '"Copy"');
// 添加会议
  result = result.replaceCH('>创建视频会议<', '>Create a Meeting<');
  result = result.replaceCH('添加<', 'Add<');
  result = result.replaceCH('>&nbsp;向参会人员发送邀请短信<', '>&nbsp;Send messages to the participants<');
  result = result.replaceCH('"请输入文字信息"', '"Please enter the description"');
  result = result.replaceCH('>确定<', '>Confirm<');
  result = result.replaceCH('>姓名<', '>Name<');
  result = result.replaceCH('>&nbsp;生成邀请链接<', '>&nbsp;Create invitation link<');
  result = result.replaceCH('>&nbsp;&nbsp;&nbsp;&nbsp;邀请系统外人数：<', '>&nbsp;&nbsp;&nbsp;&nbsp;The number of invitations：<');
  result = result.replaceCH(">◀&nbsp;总人数请不要超过5人&nbsp;<", ">◀&nbsp;Total number don't exceed 5 <");
  result = result.replaceCH(">◀&nbsp;会议时长请不要超过4小时&nbsp;<", ">◀&nbsp;Please don't exceed 4 hours <");
  result = result.replaceCH('>申请更多<', '>Apply for more<');
  result = result.replaceCH('"保存会议"', '"Save"');
  result = result.replaceCH('参会总人数：<', 'Total number of participants：<');
  result = result.replaceCH('>相关病例<', '>Related case<');
  result = result.replaceCH('请选择病例<', 'Choose<');
  result = result.replaceCH('>系统外人员<', '>Other people<');
  result = result.replaceCH('>邀请链接<', '>Invitation link<');
  result = result.replaceCH('>会议密码<', '>Meeting password<');
  result = result.replaceCH('>邀请系统外人员<', '>Invitation<');
  //    批量上传
  result = result.replaceCH('>切片数<', '>Slide No.<');
  result = result.replaceCH('>批量新建<', '>Batch Add<');
  result = result.replaceCH('>批量上传病例<', '>Upload Cases<');
  result = result.replaceCH('>批量上传切片<', '>Upload Slides<');
  result = result.replaceCH('"导入模板下载"', '"Download template"');
  result = result.replaceCH('"导入Excel"', '"Import Excel"');
  result = result.replaceCH('"批量提交"', '"Submit"');
  result = result.replaceCH('"匹配切片"', '"Match Slides"');
  result = result.replaceCH('"匹配病例"', '"Match Cases"');
  result = result.replaceCH('"请输入切片名称"', '"Slide Name"');
  result = result.replaceCH('"请输入病理号"', '"Pathology No."');
  result = result.replaceCH('"请输入姓名"', '"Name"');
  result = result.replaceCH('>切片名称：<', '>Slide Name<');
  result = result.replaceCH('>病理号：<', '>Pathology No.<');
  result = result.replaceCH('>病人姓名：<', '>Name<');
  result = result.replaceCH('>全部<', '>All<');
  result = result.replaceCH('>已匹配<', '>Matched<');
  result = result.replaceCH('>未匹配<', '>unmatched<');
  result = result.replaceCH('>全部<', '>All<');
  result = result.replaceCH('>保存<', '>Save<');
  result = result.replaceCH('>取消<', '>Cancel<');
  result = result.replaceCH('>切片&amp;附件数<', '>Slide&File Quantity<');
  //诊断报表
  result = result.replaceCH('"导出"', '"Export"');
  result = result.replaceCH('"冰冻切片可以让专家立刻浏览，无需上传！"', '"Frozen-slide can be viewed immediately, no need to upload!"');
  result = result.replaceCH('>余额<', '>Balance<');
  //质控中心
  result = result.replaceCH('>会诊号<', '>Consultation No. <');
  result = result.replaceCH('>初诊意见<', '>First Diagnosis<');
  result = result.replaceCH('>病理分类<', '>classification<');
  result = result.replaceCH('>病理分类：<', '>classification<');
  result = result.replaceCH('>病例状态：<', '>CaseStatus<');
  result = result.replaceCH('>请选择病理分类：<', '>Please select the pathologic classification<');
  result = result.replaceCH('>选择质控专家<', '>Choose Expert<');
  result = result.replaceCH('>为必填内容<', '>content is required<');
  result = result.replaceCH('查看<', 'View<');
  result = result.replaceCH('>已评价', '>Evaluated');
  result = result.replaceCH('>待评价', '>Pending');
  result = result.replaceCH('>病理专业医疗质量控制指标<', '>Medical quality control index<');
  result = result.replaceCH('>月份<', '>Month<');
  result = result.replaceCH('>统计项目：<', '>Statistical item:<');
  result = result.replaceCH('>月份：从<', '>Month:from<');
  result = result.replaceCH('>时间：从<', '>Time:from<');
  result = result.replaceCH('>下拉勾选<', '>Drop-down to select<');
  result = result.replaceCH('"查询"', '"Search"');
  result = result.replaceCH('>评价序号<', '>Evaluation No.<');
  result = result.replaceCH('评价<', 'Evaluation<');
  result = result.replaceCH('>送评单位<', '>Hospital<');

// 会议邀请
  //冰冻切片
  result = result.replaceCH('"添加冰冻切片"', '"Add frozen-slide"');
  result = result.replaceCH('>请先填写病例信息<', '> Please fill in the case information first<');
  //病例分享
  result = result.replaceCH('>创建分享时间<', '>Create Time<');
  result = result.replaceCH('>类型<', '>Type<');
  result = result.replaceCH('>有效期<', '>Valid Period<');
  result = result.replaceCH('>分享链接<', '>Share Link<');
  result = result.replaceCH('>密码<', '>Password<');
  //撤回病例
  result = result.replaceCH('>撤回<', '>Retract<');

  return result;
}

