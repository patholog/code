<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf8"%>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>病理远程会诊平台-病理图片查看</title>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
  	<link href="dist/cropper.css" rel="stylesheet">
  	<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<div class="htmleaf-container">
		<!-- Content -->
		<!--<div style="text-align:center;clear:both">
		<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
		<script src="/follow.js" type="text/javascript"></script>
		</div>-->
  <div class="container">
    <div class="row">
      <div class="col-md-9">
        <!-- <h3 class="page-header">Demo:</h3> -->
        <div class="img-container">
          <img src="${pageContext.request.contextPath }/webdiagnosis/picture.jpg" alt="Picture">         
        </div>
      </div> 
      </div>
      </div>
      </div>
      
	  <script src="js/jquery.min.js"></script>
	  <script src="assets/js/bootstrap.min.js"></script>
	  <script src="dist/cropper.js"></script>
	  <script src="js/main.js"></script>
</body>
</html>