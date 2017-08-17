<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	.container{
		color: black;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="about" style="height: -webkit-fill-available;">
		<div class="container">
			<form  action="insertFst" method="post">
				<select name = "t_name">
					<option value="java">JAVA</option>
					<option value="html">HTML</option>
					<option value="jsp">JSP</option>
					<option value="c">C</option>
					<option value="android">Android</option>
				</select>
				<table class="table table-striped">		
					<tr>
						<td width="100">문제내용</td>
						<td><input type="text" name="t_content"/></td>
					</tr>
					<tr>
						<td width="100">1번</td>
						<td><input type="text" name="t_no1"/></td>
					</tr>
					<tr>
						<td width="100">2번</td>
						<td><input type="text" name="t_no2"/></td>
					</tr>
					<tr>
						<td width="100">3번</td>
						<td><input type="text" name="t_no3"/></td>
					</tr>
					<tr>
						<td width="100">4번</td>
						<td><input type="text" name="t_no4"/></td>
					</tr>
					<tr>
						<td width="100">정답번호</td>
						<td>
							<select name = "t_answer">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</td>
					</tr>
				</table>
				<input type = "submit" value="확인">
			</form>
		</div>
	</div><div class="row"></div>
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
</body>
	<script src="resources/js/jquery-3.2.1.min.js"></script>		
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>
</html>