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
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
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
			<div id="home" class="tm-content-box tm-banner margin-b-10">
                <div class="tm-banner-inner">
                	<form class="form-horizontal col-lg-12" onsubmit="return checkInfo()"> 
                		<div class="form-group">
                			<h3>重置密码</h3>
                		</div>
						<div class="form-group"> 
						    <label for="input_password1" class="clo-xs-12 col-sm-3 control-label">密码：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="password" class="form-control" id="password1" placeholder="密码"> 
						    </div>
						    <div hidden="hidden" id="password1-err" class="col-xs-12 col-sm-4 text-left text-style">
						    	<p>密码格式不正确</p>
						    </div>
						</div>
						<div class="form-group"> 
						    <label for="input_password2" class="clo-xs-12 col-sm-3 control-label">确认密码：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="password" class="form-control" id="password2" placeholder="确认密码"> 
						    </div>
						    <div hidden="hidden" id="password2-no" class="col-xs-12 col-sm-4 text-left text-style">
						    	<p>两次密码不一致</p>
						    </div>
						</div> 
						<div class="form-group"> 
							<label></label>
						    <div class="left-3 clo-xs-12 col-sm-offset-3 col-sm-2"> 
						      	<button onclick="checkInfo()" id="sm" class="btn btn-default btn-block">完成</button> 
						    </div> 
						</div> 
					</form> 
                </div>                    
            </div>
		</div>
	</div>
	<script type="text/javascript">
		function checkInfo(){
			if(document.getElementById("password1").value.length < 8 
				&& document.getElementById("password1").value.length > 15 
			){
				document.getElementById("password1-err").style.display = "block";
			}else if(document.getElementById("password2").value != document.getElementById("password1").value){
				document.getElementById("password2-no").style.display = "block";
			}else{
				/* document.getElementById("sm").submit(); */
				/* $("#sm").submit(); */
				return true;
			}
			return false;
		}
	</script>
</body>
</html>