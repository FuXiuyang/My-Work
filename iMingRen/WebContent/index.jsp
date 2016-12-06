<!DOCTYPE html>
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
   	pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="view/common/title.jsp" flush="true"/>
    <%@taglib prefix="s" uri="/struts-tags" %>
</head>

<body>
	<div class="container-fluid">
		<jsp:include page="view/common/header.jsp" flush="true"/>
		<jsp:include page="view/buy/buy.jsp" flush="true" />
	</div>
</body>
</html>