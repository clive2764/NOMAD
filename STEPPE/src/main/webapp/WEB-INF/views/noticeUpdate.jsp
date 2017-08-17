<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>공지사항 상세</title>
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<!-- =======================================================
        Theme Name: Day
        Theme URL: https://bootstrapmade.com/day-multipurpose-html-template-for-free/
        Author: BootstrapMade
        Author URL: https://bootstrapmade.com
    ======================================================= -->
	<style>
		.navbar-header {
			/*background-color: dimgrey;*/
			
		}
		
		#join {
			/* width: 300px; */
			/* background-color: lightgrey; */
			text-align: center;
		}
		
		table {
			color:black;
			margin: 0 auto;
		}
		
		td {
			color:black;
			padding: 3px;
		}
		
		input {
			color: black;
			width: 250px;
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
	<!--상단 메뉴바-->
	<header id="header"> <nav
		class="navbar navbar-default navbar-static-top" role="banner">
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
					<li role="presentation">
					<c:set var="m_id" value="${member.m_id}" /> 
						<c:if test="${empty m_id}">
							<a href="goLogin">로그인</a>
						</c:if> 
						<c:if test="${!empty m_id}">
							<a href="./logout">${m_id}님 로그아웃</a>
						</c:if>
					</li>
					<li role="presentation">
						<c:if test="${empty m_id}">
							<a href="goJoin">회원가입</a>
						</c:if>
					</li>
					
				</ul>
			</div>
		</div>
	</div>
	</nav> </header>
	<div class="container" style="height: -webkit-fill-available;">
		<form action="noticeUpdate" method="post">
			<table class="table table-responsive">
					<tr>
						<td>글번호&nbsp;&nbsp;&nbsp;${ndlist.n_num}</td>
						<td>제목&nbsp;&nbsp;&nbsp;<input type="text" value="${ndlist.n_title}" name="n_title" /></td>
					</tr>
					<tr>
						<td colspan="2"><textarea rows="20" cols="100" name="n_content" style="resize: none;">${ndlist.n_content}</textarea></td>
					</tr>
					<tr>
						<td><button>수정</button></td>
					</tr>
			</table>
		</form>
	</div>
		
	<div class="row"></div>
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
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>
	
</body>
</html>






