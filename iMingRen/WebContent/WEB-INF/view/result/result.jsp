<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="ren.iming.model.VIP"%>
<%@page import="ren.iming.service.IQiYiVIPQueue"%>
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="/view/common/title.jsp" flush="true"/>
    <%@taglib prefix="s" uri="/struts-tags" %>
</head>
<body>
	<div class="container-fluid">
		<!-- 头文件 -->
		<jsp:include page="/view/common/header.jsp" flush="true"/>
		
		<!-- 文件主体 -->
		<%
		
		%>
		<div class="container">
			<div id="home" class="tm-content-box tm-banner  col-sm-12 col-lg-12">
                <div class="col-sm-12 tm-banner-inner col-lg-12">
                	<h3 class="text-style">支付成功</h3>
                	<div class="col-sm-12">
                		<p>恭喜您获得<span>5</span>个小时的VIP会员时长</p>
                		<p>账号:<span><s:property value="#vip_account"/></span></p>
                		<p>密码:<span><s:property value="#vip_password"/></span></p>
                	</div>
                </div>                    
            </div>
		</div>
	</div>

</body>
</html>