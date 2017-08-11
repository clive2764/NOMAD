<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/css/animate.css">
	<link href="resources/css/animate.min.css" rel="stylesheet"> 
	<link href="resources/css/style.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		color: black;
	}
	.tcontent{
		text-align: right;
	}
</style>
</head>
<body>
	<!--상단 메뉴바-->
	<header id="header">
        <nav class="navbar navbar-default navbar-static-top" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
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
                            <li><a href="logout">로그아웃</a></li>
						</ul>
					</div>
				</div>		
            </div>
        </nav>	
    </header>
	<!--상단 메뉴바 영역 끝-->
	<div class="about">
		<div class="container">
			<table class="table table-responsive">
				<tr><td>${test.t_num}</td><td>${test.t_content}</td></tr>
				<tr><td>1번</td><td class="tcontent">${test.t_no1}</td></tr>
				<tr><td>2번</td><td class="tcontent">${test.t_no2}</td></tr>
				<tr><td>3번</td><td class="tcontent">${test.t_no3}</td></tr>
				<tr><td>4번</td><td class="tcontent">${test.t_no4}</td></tr>
				<tr><td>정답</td><td class="tcontent">${test.t_answer}</td></tr>
			</table>
		</div>
	</div>
</body>
</html>