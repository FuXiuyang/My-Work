<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>勤俭人</title>
	<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/iMingRen/css/my_style.css"/>
	
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    load stylesheets
	<link rel="stylesheet" type="text/css" href="/iMingRen/css/bootstrap.min.css"/>
    HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries
    WARNING: Respond.js doesn't work if you view the page via file://
        [if lt IE 9]>
        	<link rel="stylesheet" type="text/css" href="/iMingRen/css/ie_style.css"/>
  			<script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>	
          <![endif] -->
     <jsp:include page="/view/common/title.jsp" flush="true"/>
</head>
<body>
	<div class="container-fluid">
		<!-- 头文件 -->
		<jsp:include page="/view/common/header.jsp" flush="true"/>
		
		<!-- 文件主体 -->
		<div class="container">
			<div id="home" class="tm-content-box tm-banner  col-sm-12 col-lg-12">
                <div class="col-sm-12 tm-banner-inner col-lg-12">
                	<div class="col-sm-12">
                		<span>应付总额：</span><span class="money">0.5</span><span>元</span>
                	</div>            	
                	<img src="img/pay02.jpg"  class="img-responsive center-block">              	
                </div>                    
            </div>
		</div>
		
	</div>

</body>
</html>