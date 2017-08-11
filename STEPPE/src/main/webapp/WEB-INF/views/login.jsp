<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>steppe ȸ������</title>
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
        }
        .btn:hover{
        	background-color:skyblue;
        	color: white;
        	margin-top: 0px;
        }
    </style>
  </head>
  <body>
    <!--��� �޴���-->
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
							<li role="presentation"><a href="goProject">������Ʈ</a></li>
							<li role="presentation"><a href="goFreelancer">��������</a></li>
							<li role="presentation"><a href="goManual">�̿���</a></li>
                            <li role="presentation"><a href="goPms">������Ʈ ����</a></li>
                            <li role="presentation"><a href="goLogin">�α���</a></li>
                            <li role="presentation"><a href="goJoin">ȸ������</a></li>
						</ul>
					</div>
				</div>		
            </div>
        </nav>	
    </header>
    <div class="about">
		<div class="container">
			<form action="access" method="post">
				<table>
					<tr>
						<td align="center">�α���</td>
					</tr>
					<tr>
						<td><input type="text" name="m_id" placeholder="���̵�"/></td>
					</tr>
					<tr>
						<td><input type="password" name="m_pw" placeholder="��й�ȣ"/></td>
					</tr>
					<tr>
						<td>
							<input type="submit" class="btn" value="�α���"/>
						</td>
					</tr>
									
				</table>
			</form>
        </div>
    </div>
	<hr>
    
    <div class="row"></div>
    <!--Ǫ�� ���� ����-->
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
		                  <a href="#">��������</a>&nbsp;&nbsp;&nbsp;
		                  <a href="#">faq</a>&nbsp;&nbsp;&nbsp;
		                  <a href="#">�̿���</a>
		              </div>
				</div>
			</div>			
		</div>
	</div>	
				
	
	<!--Ǫ�� ���� ��-->
      
      
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>	
    
</body>

</html>