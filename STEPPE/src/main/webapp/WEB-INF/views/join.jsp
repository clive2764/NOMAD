<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        
        #join{
        	/* width: 300px; */
        	/* background-color: lightgrey; */
        	text-align: center;
        }
        table{
        	width: 300px;
        	/* text-align: center; */
        	margin:0 auto;
        	
        }
        td{
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
    <jsp:include page="header.jsp" />
    <div class="about">
		<div class="container">
           	<div id="join">
           		<h3 style="color:black;">회원 가입</h3>
				<form name="joinForm" method="post">
					<table>
						<tr>
							<td>
								<input type="text" id="userId" name="userId" placeholder="아이디" />
								<span id="notiId"></span>
							</td>
						</tr>
						<tr>
							<td>
								<input type="password" id="userPw" name="userPw" placeholder="비밀번호"  />
							</td>
						</tr>
						<tr>
							<td>
								<input type="password" id="confirmPw" name="confirmPw" placeholder="비밀번호 확인" />
								<span id="notiPw"></span>
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="userName" name="userName" placeholder="이름" />
								<span id="notiName"></span>
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="userPhone" name="userPhone" placeholder="핸드폰 번호 ex)010-0000-0000" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="userEmail" name="userEmail" placeholder="�̸���" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="userEmail" name="userEmail" placeholder="이메일" />
								<span id="notiEmail"></span>
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" class="btn" onClick="sendCode()" value="인증번호 발송" />
								<span id="notiCode"></span>
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="userCode" name="userCode" placeholder="인증번호" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" class="btn" onClick="join()" value="회원가입" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" class="btn" onClick="toIndex()" value="돌아가기" />
							</td>
						</tr>
						
					</table>
				</form>
			</div>   
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
      
      
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>	
    
</body>
	<!-- <script>
		$(function() {
			var msg = '${joinMsg}';
			if(msg == "실패")
				alert("회원가입에 실패했습니다. 다시 시도해주세요.");
		});

	
	<script language="javascript">
		/* ��й�ȣ �ߺ� �˻� */
		function passwordCheckk(){
			var password = document.getElementById("userPassword").value;
			var passwordCheck = document.getElementById("passwordCheck").value;
	
			if (passwordCheck == "") {
				document.getElementById("passwordCheckText").innerHTML = ""
			} else if (password != passwordCheck) {
				document.getElementById("passwordCheckText").innerHTML = "<span><font color=red size=2pt>��� ��ȣ�� Ʋ���ϴ�.</font></span>"
			} else {
				document.getElementById("passwordCheckText").innerHTML = "<span><font color=red size=2pt>��� ��ȣ�� ��ġ �մϴ�.</font></span>"
			}
		}
		
		/* �̸��� ���� */
		function sendCode(){
			var flag = 1;
			var email = $('#userEmail').val();
			
			if(email!=''){
				$.ajax({
					type: 'POST',
					url: './sendCode',
					data: {flag:flag, userEmail:email},
					
					success:function(data){
						var msg = data.split(",");
						console.log(data);
						$('#notiEmail').html(msg[0]);
						$('#notiCode').html(msg[1]);
						console.log('flag');
					},
					
					error:function(error){
						console.log(error);
					}
				}); 	
			}
			else
			{
				$('#notiEmail').html("이메일을 입력해주세요");
			}
		}
		
		/* ȸ�� ���� */
		/* function join()
		{	
				var id = $('#userId').val();
				var pw = $('#userPw').val();				
				var conPw = $('#confirmPw').val();			
				var name = $('#userName').val();				
				var phone = $('#userPhone').val();
				var email = $('#userEmail').val();			
				var code = $('#userCode').val();	
				
				$.ajax({
					type: 'POST',
					url: './checkJoinForm',
					data: {userId:id, userPw:pw, confirmPw:conPw, userName:name, 
						userPhone:phone, userEmail:email, userCode:code},
						
					success:function(data)
					{
						var msg = data.split(",");
						
						console.log(msg);
	
						$('#notiId').html(msg[0]);
						$('#notiPw').html(msg[1]);
						$('#notiName').html(msg[2]);
						$('#notiPhone').html(msg[3])
						$('#notiEmail').html(msg[4]);
						$('#notiCode').html(msg[5]);
						
						if(msg[9] == '0')
						{
							join.action = "./insertMember";
							join.submit();
						}
					},
					
					error:function(error)
					{
						console.log(error);
					}
				}
		}  */
		/* ���ư��� */
		/* function toHome()
		{
			join.action = "./home";
			join.submit();
		} */
		
		
	</script>
	
	
<!-- <script>
		$(function() {
			var msg = '${joinMsg}';
			if(msg == "����")
				alert("ȸ�����Կ� �����߽��ϴ�. �ٽ� �õ����ּ���.");
		});
	
		
		
		
		
		
		
	</script> -->
</html>