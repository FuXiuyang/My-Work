<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="s" uri="/struts-tags" %>
</head>
<body>
	<div class="container">
		<div id="home" class="tm-content-box tm-banner">
              <div class="tm-banner-inner">
              	<form class="form-horizontal col-lg-10" action="BuyAction" method="post">
              		<div class="form-group"> 
				    <label for="webName" class="col-sm-3 control-label text-left">网站:</label> 
				    <div class="col-sm-5"> 
				      	<select class="form-control" id="webName" name="webName">
							<option value="1">爱奇艺</option>
							<option value="2">迅雷</option>
						</select>
				    </div> 
				</div>
				<div class="form-group"> 
				    <label for="timeLong" class="col-sm-3 control-label text-left">时长:</label> 
				    <div class="col-sm-5"> 
				      	<select class="form-control" id="timeLong" name="timeLong">
							<option value="1">1小时</option>
							<option value="2">2小时</option>
							<option value="3">3小时</option>
							<option value="4">4小时</option>
							<option value="5">5小时</option>
							<option value="6">6小时</option>
							<option value="7">7小时</option>
							<option value="8">8小时</option>
							<option value="9">9小时</option>
							<option value="10">10小时</option>
							<option value="11">11小时</option>
							<option value="12">12小时</option>
						</select>
				    </div>
				    <div class="col-sm-4 text-left text-style">
				    	<p>会员单价0.1元/小时</p>
				    </div>
				    
				</div>
				<div class="form-group">
					<s:token></s:token>
				</div>
				<div class="form-group">
					<label></label>
					<div class="left-4 col-sm-offset-4 col-sm-3">
						<input type="submit" class="btn btn-default btn-block" value="付款" >
					</div>
				</div>
              	<form>
              </div>                    
          </div>
	</div>
	
</body>
</html>