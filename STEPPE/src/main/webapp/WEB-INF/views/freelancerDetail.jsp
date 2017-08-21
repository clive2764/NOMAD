<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>steppe 샘플페이지</title>
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/css/animate.css">
	<link href="resources/css/animate.min.css" rel="stylesheet"> 
	<link href="resources/css/style.css" rel="stylesheet" />	
	<style>
		input#report{
			background: #0f1c34;
		   	box-sizing: border-box;
		   	border-radius: 5px;
		   	border: 1px solid white;
		   	color: #fff;
		   	font-weight: bold;
		   	font-size: 14px;
		   	outline: none;
		   	cursor: pointer;
		}
		input#estimate{
			background: #0f1c34;
		   	box-sizing: border-box;
		   	border-radius: 5px;
		   	border: 1px solid white;
		   	color: #fff;
		   	font-weight: bold;
		   	font-size: 14px;
		   	outline: none;
		   	cursor: pointer;
		}
	</style>
  </head>
  <body>
  	<jsp:include page="header.jsp" />
    
	<div class="about">
			<div class="container">
			<div class="row">
				<form action="goReportWrite" method="get">
					<input type="hidden" name="m_id" value="${member.m_id}"/>
					<c:set var="m_id" value="${m_id}"/>
					
					<c:if test="${!empty m_id}">
    					<input id="report" type="submit" value="신고하기"/>
    				</c:if>
    			</form>
    			<c:set var="m_kind" value="${m_kind}"/>
    			<c:if test="${m_kind eq 'C'}">
    				<a href="goInsertEstimate"><input id="estimate" type="button" value="견적 요청"/></a>
    			</c:if>
   			</div>
				<table class="table table-striped" style="color: black; text-align: center;">
					<tr style="text-align:center;">
						<td colspan="2">
							<img style="width: 400px; height: 250px;;" src="resources/upload/${member.m_image}.jpg"/>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${member.m_name}</td>
					</tr>
					<tr>
						<td>이메일 주소</td>
						<td>${member.m_email}</td>
					</tr>
					
					
				</table>
				<hr/>
				${career}
			</div>
	</div>			
	<hr>
    <div class="row"></div>
      
    <jsp:include page="footer.jsp" />
    
    <script src="resources/js/jquery-3.2.1.min.js"></script>		
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>	
    
</body>
</html>