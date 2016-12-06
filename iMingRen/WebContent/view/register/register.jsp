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
</head>
<body>
	<div class="container-fluid">
		<!-- 头文件 -->
		<jsp:include page="../common/header.jsp" flush="true"/>
		<div class="container">
			<div id="home" class="tm-content-box tm-banner margin-b-10">
                <div class="tm-banner-inner">
                	<form class="form-horizontal col-lg-12" method="post" onsubmit="return checkInfo()" action="RegisterAction"> 
                		<div class="form-group">
                			<h3>用户注册</h3>
                		</div>
						<div class="form-group"> 
						    <label for="account" class="clo-xs-12 col-sm-3 control-label">手机号：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="tel" class="form-control" id="account" name="account" placeholder="手机号"> 
						    </div>
						    <div hidden="hidden" id="account-err" class="col-xs-12 col-sm-4 text-left text-style">
						    	<p>手机号不正确</p>
						    </div>
						    <div hidden="hidden" id="account-has"  class="col-xs-12 col-sm-4 text-left text-style">
						    	<p>手机号已被注册</p>
						    </div>
						</div> 
						<div class="form-group"> 
						    <label for="input_password1" class="clo-xs-12 col-sm-3 control-label">密码：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="password" class="form-control" id="input_password1" name="password1" placeholder="密码"> 
						    </div>
						    <div hidden="hidden" id="password-err" class="col-xs-12 col-sm-4 text-left text-style">
						    	<p>密码格式不正确</p>
						    </div>
						</div>
						<div class="form-group"> 
						    <label for="input_password2" class="clo-xs-12 col-sm-3 control-label">确认密码：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="password" class="form-control" id="input_password2" name="password2" placeholder="确认密码"> 
						    </div>
						    <div hidden="hidden" id="password-no" class="col-xs-12 col-sm-4 text-left text-style">
						    	<p>两次密码不一致</p>
						    </div>
						</div> 
						<div class="form-group">
							 <label for="identifying_code" class="clo-xs-12 col-sm-3 control-label">验证码：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="text" class="form-control" id="identifying_code" placeholder="验证码"> 
						    </div>
						    <div hidden="hidden" id="identifying_code-err" class="col-xs-12 col-sm-4 text-left text-style">
						    	<p>验证码不正确</p>
						    </div>
						</div>
						<div class="form-group"> 
							<label></label>
						    <div class="left-3 clo-xs-12 col-sm-offset-3 col-sm-2"> 
						      	<button type="reset" class="btn btn-default btn-block">重置</button> 
						    </div> 
						    <div class="left-3 clo-xs-12 col-sm-offset-1 col-sm-2"> 
						      	<button id="register" onclick="checkInfo()" class="btn btn-default btn-block">注册</button>
						    </div>
						</div> 
						<div class="form-group">
						</div>
					</form> 
                </div>                    
            </div>
		</div>
	</div>
	<script type="text/javascript">
		function checkInfo(){
			console.log(document.getElementById("identifying_code").value);
			if(document.getElementById("account").value.length != 11){
				document.getElementById("account-err").style.display = "block";
			}
			if(document.getElementById("input_password1").value.length < 8 
				|| document.getElementById("input_password1").length > 15
			){
				document.getElementById("password-err").style.display = "block";
			}else if(document.getElementById("input_password2").value != document.getElementById("input_password1").value){
				document.getElementById("password-no").style.display = "block";
			}
			if(document.getElementById("identifying_code").value == ""){
				document.getElementById("identifying_code-err").style.display = "block";
			}
			if(
				document.getElementById("account").value.length == 11
				&& document.getElementById("input_password1").value.length >= 8
				&& document.getElementById("input_password1").value.length <= 15
				&& document.getElementById("input_password2").value == document.getElementById("input_password1").value
				&& document.getElementById("identifying_code").value != ""
			){
				/* document.getElementById("register").submit(); */
				console.log("I want to register");
				/* $("#register").submit();  */
				return true;
			}
			return false;
		}
		
	</script>
</body>
</html>