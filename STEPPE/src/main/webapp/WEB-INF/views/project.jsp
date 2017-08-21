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
		<style>
		.thumbnail img {
			width: 100%;
		}
		input{
			color: black;
			border-radius: 5px;
			border:1px solid grey;
		}
		input#searchBtn {
			width:75px;
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
		input#insertBtn{
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
		
		<!--메인페이지 영역-->
		
			<div class="container">
				
				<div class="row">
					
		            <form class="pull-right">
		                <input type="text" name="search" placeholder="검색어를 입력해 주세요"/>
		                <input type="button" id="searchBtn" value="검색"/>
		            </form>    
	                
	        	</div>
	        	
					<div class="col-sm-6 col-lg-6 col-md-6">
						<div class="thumbnail">
							<a href="#"><img src="http://placehold.it/320x150" alt=""></a>
							<div class="caption">
								<h4>
									<a href="goProjectDetail">홈페이지 제작</a>
								</h4>
								<span class="pull-right">지원자 수 표기 구간입니다.</span><br /> <span>프로젝트
									공고기간.
									</h4> <span class="pull-right">예상기간 작성구간 입니다.</span>
									<p>필요언어 작성구간 입니다.</p>
							</div>
		
						</div>
					</div>
				
				<div class="col-sm-6 col-lg-6 col-md-6">
					<div class="thumbnail">
						<img src="http://placehold.it/320x150" alt="">
						<div class="caption">
							<h4>
								<a href="#">홈페이지 제작</a>
							</h4>
							<span class="pull-right">지원자 수 표기 구간입니다.</span><br /> <span>프로젝트
								공고기간.
								</h4> <span class="pull-right">예상기간 작성구간 입니다.</span>
								<p>필요언어 작성구간 입니다.</p>
						</div>
	
					</div>
				</div>
				<div class="col-sm-6 col-lg-6 col-md-6">
					<div class="thumbnail">
						<img src="http://placehold.it/320x150" alt="">
						<div class="caption">
							<h4>
								<a href="#">홈페이지 제작</a>
							</h4>
							<span class="pull-right">지원자 수 표기 구간입니다.</span><br /> <span>프로젝트
								공고기간.
								</h4> <span class="pull-right">예상기간 작성구간 입니다.</span>
								<p>필요언어 작성구간 입니다.</p>
						</div>
	
					</div>
				</div>
				<div class="col-sm-6 col-lg-6 col-md-6">
					<div class="thumbnail">
						<img src="http://placehold.it/320x150" alt="">
						<div class="caption">
							<h4>
								<a href="#">홈페이지 제작</a>
							</h4>
							<span class="pull-right">지원자 수 표기 구간입니다.</span><br /> <span>프로젝트
								공고기간.
								</h4> <span class="pull-right">예상기간 작성구간 입니다.</span>
								<p>필요언어 작성구간 입니다.</p>
						</div>
	
					</div>
				</div>
			</div>
		
		<hr>
	
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