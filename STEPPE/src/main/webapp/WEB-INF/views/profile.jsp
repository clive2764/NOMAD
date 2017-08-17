<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
    		color: black;
    	}
    	table{
    		color: black;
    	}
    	.category{
    		width: 10%;
    	}
    	input#complete {
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
    </style>
  </head>
  <body>
    <jsp:include page="header.jsp" />
	<!--메인페이지 영역-->
	<div class="about">
			<div class="container">
				<hr/>
				<table class="table table-striped">
					<tr>
						<td class="category">
							<span>프로필 사진</h1>
						</span>
						<td style="text-align: center;">
							<img style="width: 250px; height: 250px;" src="reseources/img/#"/>
						</td>
					</tr>
					<tr>
						<td class="category">이름</td>
						<td>이름표출 구간</td>
					</tr>
					<tr>
						<td class="category">
							자기 소개서
						</td>
						<td>
							<form action="" method="get" id="introduce">
								<textarea rows="20" style="width: 100%; resize:none;" id="content" name="content"></textarea>
								<input type="button" id="complete" value="작성완료"/>
							</form>
						</td>
				</table>
				
				<hr/>
			</div>
			<div class="container">
			<h1 style="color: black;">자기소개서 표출</h1>
			</div>
	</div>		
	<hr>
	
    <div class="row"></div>
      
    <!--푸터 영역 시작-->
	<div class="sub-footer">
		<div class="container">
			<div class="social-icon">
				<div class="col-md-4">
						
				</div>
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
                        <a href="https://bootstrapmade.com/">BootstrapMade</a>
                        <br/>
                        <a href="#">공지사항</a>&nbsp;&nbsp;&nbsp;
                        <a href="#">faq</a>&nbsp;&nbsp;&nbsp;
                        <a href="#">이용약관</a>
                    </div>
				</div>
			</div>						
		</div>				
	</div>
	<!--푸터 영역 끝-->
    <script src="resources/js/jquery-3.2.1.min.js"></script>		
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>	
    
</body>
<script>
	$("#complete").click(function(){
		var content=$("#content").val();
		
		if(content==""||content==null){
			alert("자기소개사항을 입력하세요");
		}
		if(content!=""||content!=null){
			$("#introduce").submit;
		}
	});

</script>
</html>