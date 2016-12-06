<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                	<form class="form-horizontal col-lg-12" method="post" onsubmit="return checkInfo()" action="SetPassword"> 
                		<div class="form-group">
                			<h3>修改密码</h3>
                		</div>
                		<div class="form-group"> 
						    <label for="password" class="clo-xs-12 col-sm-3 control-label">旧密码：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="password" class="form-control" id="password"  name="password" placeholder="旧密码"> 
						    </div>
						    <div hidden="hidden" id="old_password-err" class="col-xs-12 col-sm-4 text-left text-style" >
						    	<p>密码格式不正确</p>
						    </div>
						</div>
						<div class="form-group"> 
						    <label for="password1" class="clo-xs-12 col-sm-3 control-label">新密码：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="password" class="form-control" id="password1" name="password1" placeholder="新密码"> 
						    </div>
						    <div hidden="hidden" id="new_password-err" class="col-xs-12 col-sm-4 text-left text-style" >
						    	<p>密码格式不正确</p>
						    </div>
						</div>
						<div class="form-group"> 
						    <label for="password2" class="clo-xs-12 col-sm-3 control-label">确认密码：</label> 
						    <div class="clo-xs-12 col-sm-5"> 
						      	<input type="password" id="new_password-no" class="form-control" id="password2" name="password2" placeholder="确认密码"> 
						    </div>
						    <div hidden="hidden" class="col-xs-12 col-sm-4 text-left text-style">
						    	<p>两次密码不一致</p>
						    </div>
						</div> 
						<div class="form-group"> 
							<label></label>
						    <div class="left-3 clo-xs-12 col-sm-offset-3 col-sm-2"> 
						      	<button id="modifyPassword" class="btn btn-default btn-block" onclick="checkInfo()">更改</button> 
						    </div> 
						</div> 
					</form> 
                </div>                    
            </div>
		</div>
	</div>
	<script type="text/javascript">
		function checkInfo(){
			if(document.getElementById("password").value.length < 8
				|| document.getElementById("password").value.length > 15
			){
				document.getElementById("old_password-err").style.display = "block";
			}
			if(document.getElementById("password1").value.length < 8
				|| document.getElementById("password1").value.length > 15
			){
				document.getElementById("new_password-err").style.display = "block";
			}else if(document.getElementById("password2").value != document.getElementById("password1").value){
				document.getElementById("new_password-no").style.display = "block";
			}else{
				if(document.getElementById("password").value.length >= 8
				&& document.getElementById("password").value.length <= 15){
					console.log("modifyPassword");
					/* $("#modifyPassword").submit(); */
					return true;
				}
			}
			return false;
		}
		
	</script>

</body>
</html>