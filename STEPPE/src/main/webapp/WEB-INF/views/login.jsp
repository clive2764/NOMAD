<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>steppe 회원가입</title>
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
        .navbar-header{
            /*background-color: dimgrey;*/
        }  
        
        
        table{
        	width: 300px;
        	/* text-align: center; */
        	margin:0 auto;
        	color: black;
        	
        }
        td{
        	text-align: center;
        	padding: 3px;
        }
        input{
        	color: black;
        	width: 250px; 
        }
        .btn{
        	color: white;
        	margin-top: 0px;
        	width: 125px;
        }
        .btn:hover{
        	background-color:skyblue;
        	color: white;
        	margin-top: 0px;
        }
    </style>
  </head>
  <body>
    <jsp:include page="header.jsp" />
    <div class="about">
		<div class="container">
			<form action="access" method="post">
				<table>
					<tr>
						<td align="center">로그인</td>
					</tr>
					<tr>
						<td><input type="text" name="m_id" placeholder="아이디"/></td>
					</tr>
					<tr>
						<td><input type="password" name="m_pw" placeholder="비밀번호"/></td>
					</tr>
					<tr>
						
						<td>
							<input type="button" name="findInfo" onClick="location.href='./goFindInfo'"  class="btn" value="내정보 찾기"/>
						
							<input type="submit" class="btn" value="로그인"/>
						</td>
					</tr>
									
				</table>
			</form>
        </div>
    </div>
	<hr>
    
    <div class="row"></div>
    
    <jsp:include page="footer.jsp" />
      
      
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>	
    
</body>
<script>
var message = '${msg}';
if(message!=""){
	alert(message); 
}
</script>
</html>