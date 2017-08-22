<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			.about{
				color:black;
				height: -webkit-fill-available;
			}
			table{
				text-align: center;
			}
		</style>	
	    <!-- =======================================================
	        Theme Name: Day
	        Theme URL: https://bootstrapmade.com/day-multipurpose-html-template-for-free/
	        Author: BootstrapMade
	        Author URL: https://bootstrapmade.com
	    ======================================================= -->
  </head>
<body>
	<jsp:include page="header.jsp" />
    <div class="about">
    	<div class="container">
		<form  action="showFstList" method="post">
			<select name = "FstList">
				<option value="java">JAVA</option>
				<option value="html">HTML</option>
				<option value="jsp">JSP</option>
				<option value="c">C</option>
				<option value="android">Android</option>
			</select>
			<input type = "submit" value="확인">
		</form>
		<br/><br/>
		
				<table class="table table-striped">
				<tr><td id = t1>문제 번호</td><td id = t2>문제 내용</td><td id = t3>답</td><td id = t4>수정 & 삭제</td></tr>
				${tlist}
				</table>
				
		<br/><br/>
		
			<button><a href="goInsertFst">문제 추가</a></button>
		</div>
	</div>
	<div class="row"></div>
	<!-- 푸터 영역 -->  
		<jsp:include page="footer.jsp" />
</body>
	<script src="resources/js/jquery-3.2.1.min.js"></script>		
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>
</html>