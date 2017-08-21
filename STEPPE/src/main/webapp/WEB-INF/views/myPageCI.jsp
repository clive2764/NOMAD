<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<title>steppe</title>
		<!-- Bootstrap -->
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="resources/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/css/animate.css">
		<link href="resources/css/animate.min.css" rel="stylesheet"> 
		<link href="resources/css/style.css" rel="stylesheet" />   
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<!--메인페이지 영역-->
		<div class="about">
			<form name="pinsert" action="goAddProject" method="get">
			<button>프로젝트 등록</button>
			</form>
		</div>
		<hr>
		<div class="row"></div>
		 
		<!-- 푸터 영역 -->  
		<jsp:include page="footer.jsp" />
</body>
</html>