<!DOCTYPE html">	
<%@page import="ren.iming.model.Token"%>
<%@page import="ren.iming.service.TokenService"%>
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
		String user_nav = "登陆";
		String user_link = "/iMingRen/view/login/login.jsp";
		String account = null;
		if(session.getAttribute("tt") != null){
			TokenService tokenService = new TokenService();
			Token token = tokenService.getToken(session.getAttribute("tt").toString());
			account = token.getAccount();
		}
		if( account != null){
			user_nav = account;
			user_link = "UserInfo";
		}
	%>
	<div id="header">
		<div class="navbar navbar-default mynavbar">
			 <div class="container-fluid">
			 	<div class="col-sm-2">
					<img href="/iMingRen/index.jsp" src="/iMingRen/img/logo.png" id="logo_img"/>			 		
			 	</div>
			 	<div class="col-xs-12 col-sm-offset-1 col-sm-6 left-2 header-text ">
			 		<p class="text-center center-block motto">虽无飞，飞必冲天；虽无鸣，鸣必惊人</p>
			 	</div>
			 	<div class="nav-box col-xs-12 col-sm-3 col-md-3 left-2 header-text ">
			 		<ul class="nav navbar-nav navbar-right">
				        <li><a href=<%= user_link%> id="login"><%=user_nav%></a></li>
				       <!--  <li><a hidden="hidden" href="UserInfo" id="account"></a></li> -->
				        <li><a href="LogoutAction" id="logout">退出</a></li>
				    </ul>
				    
			 	</div>		    
			 </div>
		</div>
	</div>
	<script type="text/javascript">
		$("#logo_img").bind("click",function(){
			location.href="/iMingRen/index.jsp";
		});
	</script>
</body>
</html>	