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
	<link rel="stylesheet" type="text/css" href="../../css/my_style.css"/>
	
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    load stylesheets
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
    HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries
    WARNING: Respond.js doesn't work if you view the page via file://
        [if lt IE 9]>
        	<link rel="stylesheet" type="text/css" href="../../css/ie_style.css"/>
  			<script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>	
          <![endif] -->
    <jsp:include page="../common/title.jsp" flush="true"/>
    <%@taglib prefix="s" uri="/struts-tags" %>
</head>
<body>
	<div class="container-fluid">
		<!-- 头文件 -->
		<jsp:include page="../common/header.jsp" flush="true"/>
		
		<!-- 文件主体 -->
		<div class="container col-sm-offset-2 col-lg-7">
			<div id="home" class="tm-content-box tm-banner col-xs-offset-1 col-sm-offset-3 col-lg-9">
                <div class="tm-banner-inner col-lg-12">
                	<form class="form-horizontal col-lg-12" method="post" onsubmit="return checkInfo()" action="LoginAction"> 
						<div class="form-group"> 
						    <label for="account" class="clo-xs-12 col-sm-3 control-label">手机号：</label> 
						    <div class="clo-xs-12 col-sm-9"> 
						      	<input type="tel" class="form-control" id="account" name="account" placeholder="手机号"> 
						    </div>
	
						</div> 
						<div class="form-group"> 
						    <label for="password" class="clo-xs-12 col-sm-3 control-label">密码：</label> 
						    <div class="clo-xs-12 col-sm-9"> 
						      	<input type="password" class="form-control" id="password" name="password" placeholder="密码"> 
						    </div> 
						</div> 
						<div hidden="hidden" id="hint" class="col-xs-12 col-sm-12 text-left text-style">
						    <p>手机号或者是密码不正确</p>
						</div>
						<div class="form-group">
							<div class="clo-xs-12 col-sm-offset-8 col-sm-4 left-6">
								<a href="forget_password_first.jsp">忘记密码</a>
							</div>
						</div>
						<div class="form-group">
							<s:token></s:token>
						</div>
						<div class="form-group">
							<label></label>
						    <div class="left-1 clo-xs-12 col-sm-offset-2 col-sm-4"> 
						      	<button id="login" class="btn btn-default btn-block"> 登陆</button>
						    </div> 
						    <div class="left-1 clo-xs-12 col-sm-offset-1 col-sm-4"> 
						      	<a href="../register/register.jsp" class="btn btn-default btn-block">注册</a> 
						    </div>
						</div> 
						<div class="form-group">
							<label></label>
							<hr class="line-color"/>
						</div>
						
						<div class="form-group">
							<label></label>
							<div class="left-1 col-sm-offset-1 clo-xs-10 col-sm-10">
								<img src="../../img/qq.png">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="../../img/weixin.png"  >
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="../../img/weibo.png">
							</div>
						</div>
					</form> 
                </div>                    
            </div>
		</div>
		
	</div>
	<script type="text/javascript">
		function checkInfo(){
			if(document.getElementById("account").value.length != 11 
				|| document.getElementById("password").value.length < 8
				|| document.getElementById("password").value.length > 15
			){
				document.getElementById("hint").style.display ='block';
				}
			else{
				/* $("#login").submit(); */
				return true;
			}
			return false;
		}
	</script>
</body>
</html>