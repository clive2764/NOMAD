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
		<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
		<style>
			table {
				text-align: center;
				color: black;
				margin: 0 auto;
			}
			
			td,th {
				text-align: center;
				padding: 3px;
			}
			
			.btn {
				color: white;
				margin-top: 0px;
			}
			
			.btn:hover {
				background-color: skyblue;
				color: white;
				margin-top: 0px;
			}
		</style>   
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<!--메인페이지 영역-->
		<div class="about">
			<div class="container" style="height: -webkit-fill-available;" align="center">
				<table class="table table-responsive" >
					<h3>블랙 리스트</h3><br/>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>회원종류</th>
						<th>회원상태</th>
						<th>블랙리스트 풀기</th>
					</tr>
					${blist}
					<tr>
						<td colspan="6"><input type="button" class="btn" onclick="location.href='goMemberMM'" value="돌아가기"/></td>
					</tr>	
				</table>
			</div>
		
		</div>
		<hr>
		<div class="row"></div>
		 
		<!-- 푸터 영역 -->  
		<jsp:include page="footer.jsp" />
		
		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="resources/js/jquery-3.2.1.min.js"></script>		
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="resources/js/bootstrap.min.js"></script>	
		<script src="resources/js/wow.min.js"></script>
		<script>wow = new WOW({}).init();</script>	
	</body>
</html>