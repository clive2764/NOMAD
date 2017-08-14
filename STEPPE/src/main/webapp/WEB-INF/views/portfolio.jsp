<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
<!-- =======================================================
        Theme Name: Day
        Theme URL: https://bootstrapmade.com/day-multipurpose-html-template-for-free/
        Author: BootstrapMade
        Author URL: https://bootstrapmade.com
    ======================================================= -->
</head>
<style>
tr{
color:black;
}
</style>
<body>
	<!--상단 메뉴바-->
	<header id="header">
		<nav class="navbar navbar-default navbar-static-top" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="navbar-brand">
						<a href="main"><h1>steppe</h1></a>
					</div>
				</div>
				<div class="navbar-collapse collapse">
					<div class="menu">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a href="goIntro">steppe?</a></li>
							<li role="presentation"><a href="goProject">프로젝트</a></li>
							<li role="presentation"><a href="goFreelancer">프리랜서</a></li>
							<li role="presentation"><a href="goManual">이용방법</a></li>
							<li role="presentation"><a href="goPms">프로젝트 관리</a></li>
							<li role="presentation"><a href="goLogin">로그인</a></li>
							<li role="presentation"><a href="goJoin">회원가입</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</header>
	<div>
		<form action="portFoiloInsert" method="post" enctype="multipart/form-data">
			<table class="table">
				<tr colsapn="2">
					<td>정보 입력</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="pf_title" /></td>
				</tr>
				<tr>
					<td>진행 기간</td>
					<td><input type="text" name="pf_term" /></td>
				</tr>
				<tr>
					<td>참여율</td>
					<td><input type="text" name="pf_contribute"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="pf_content"/></td>
				</tr>
				<tr>
					<td>이미지 첨부</td>
					<td><input type="file" name="pf_image" onchange="fileChk(this)" />
						<input type="hidden" name="fileCheck" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록" /></td>
				</tr>
			</table>
		</form>
	</div>
	<!--푸터 영역 시작-->
	<div class="sub-footer">
		<div class="container">
			<div class="social-icon">
				<div class="col-md-4"></div>
			</div>

			<div class="col-md-4 col-md-offset-4">
				<div class="copyright">
					&copy; Day Theme. All Rights Reserved.
					<div class="credits">
						<!-- 
                            All the links in the footer should remain intact. 
                            You can delete the links only if you purchased the pro version.
                            Licensing information: https://bootstrapmade.com/license/
                            Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Day
                        -->
						<a href="https://bootstrapmade.com/">Free Bootstrap Themes</a> by
						<a href="https://bootstrapmade.com/">BootstrapMade</a> <br /> <a
							href="#">공지사항</a>&nbsp;&nbsp;&nbsp; <a href="#">faq</a>&nbsp;&nbsp;&nbsp;
						<a href="#">이용약관</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--푸터 영역 끝-->


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>

</body>
</html>