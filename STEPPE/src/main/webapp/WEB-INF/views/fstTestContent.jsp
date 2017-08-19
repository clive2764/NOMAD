<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="resources/css/font-awesome.min.css">
      <link rel="stylesheet" href="resources/css/animate.css">
      <link href="resources/css/animate.min.css" rel="stylesheet"> 
      <link href="resources/css/style.css" rel="stylesheet" />   
<script src="resources/js/jquery-3.2.1.min.js"></script>
</head>
<style>
	#Test{
		height: 10%;
	}
	#a_tname{
		width: 50px;
		border: 1px solid white;
	}
	#a_tnum{
		display: none;
	}
	.textFst{
		margin-top:10%;
		color:black;
		height: 50%;
	}
	.sub-footer{
	margin-top:50%;
	}
	.tableFst{
		margin-left: 10%;
		width: 80%;
	}
	.td01{
	width: 10%;
	}
	.td02{
	width: 70%;
	}
	.td03{
	width: 10%;
	}
</style>
<body>
	<div id = "Test">
	<header id="header">
        <nav class="navbar navbar-default navbar-static-top" role="banner">
            <div class="container" style="width: 100%; padding-bottom: 30px;">
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
				</div>		
            </div>
        </nav>	
    </header>
    	<div class = "textFst">
			<form action = "ajax(checkTest)" name = "checkTest" id = "checkTest" method="post">
				<table class="tableFst">
					${tlist}
				</table>
			</form>
		</div>
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
	</div>	
</body>
<script>
	function ajax(url) {
		var FormData = $('#checkTest').serialize();
		$.ajax({
			url : 'checkTest',
			type : 'post',
			data : FormData,
		success : function(data) {
			$('#Test').html(data);
			},
		error : function(error) {
			console.log(error);
			}
		});//ajax End
	}
	$("#check").click(function(){
		if ( $("input[type=radio]:checked").length < 1 ) {
		    alert('정답을 입력하시오');
		}else if ( $("input[type=radio]:checked").length = 1 ) {
			$(ajax(checkTest)).submit;
		}
	});
	$("#goFst").click(function(){
		$("goFst").submit;
	});
</script>
 <script src="resources/js/jquery-3.2.1.min.js"></script>      
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>   
   <script src="resources/js/wow.min.js"></script>
   <script>wow = new WOW({}).init();</script>
</html>