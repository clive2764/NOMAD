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
  </head>
  <body>
  	<jsp:include page="header.jsp" />
    
	<div class="about">
			<div class="container">
			<div class="row">
				<form action="" method="post">
					<input type="hidden" name="m_id" value="${member.m_id}"/>
    				<a style="float: right;" href="#"><input type="button" value="신고하기"/></a>
    			</form>
   			</div>
				<table class="table table-striped" style="color: black; text-align: center;">
					<tr style="text-align:center;">
						<td colspan="2">
							<img style="width: 400px; height: 250px;" src="resources/upload/${member.m_image}.jpg"/>
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