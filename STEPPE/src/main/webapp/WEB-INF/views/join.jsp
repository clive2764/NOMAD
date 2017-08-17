<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		.navbar-header {
			/*background-color: dimgrey;*/
			
		}
		
		#join {
			/* width: 300px; */
			/* background-color: lightgrey; */
			text-align: center;
		}
		
		table {
			
			margin: 0 auto;
		}
		
		td {
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
		
		.radio {
			color: black;
		}
		
		label {
			color: black;
		}
		
		#image_preview img {
			width: 250px;
			height: 250px;
		}
		#userImage{
			margin:0 auto;
			width: 250px;
		}
		ui{
			width: 150px;
			list-style: none;
			
		}
		li{
			display: inline;
			
		}
		#choseClient{
			width: 150px;
		}
		
	</style>
</head>
<body>
	<!--��� �޴���-->
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
					<li role="presentation"><a href="goProject">������Ʈ</a></li>
					<li role="presentation"><a href="goFreelancer">��������</a></li>
					<li role="presentation"><a href="goManual">�̿���</a></li>
					<li role="presentation"><a href="goPms">������Ʈ ����</a></li>
					<li role="presentation">
					<c:set var="m_id" value="${member.m_id}" /> 
						<c:if test="${empty m_id}">
							<a href="goLogin">�α���</a>
						</c:if> 
						<c:if test="${!empty m_id}">
							<a href="./logout">${m_id}�� �α׾ƿ�</a>
						</c:if>
					</li>
					<li role="presentation">
						<c:if test="${empty m_id}">
							<a href="goJoin">ȸ������</a>
						</c:if>
					</li>
					
				</ul>
			</div>
		</div>
	</div>
	</nav> </header>
	<div class="about">
		<div class="container">
			<div id="join">
				<h3 style="color: black;">ȸ�� ����</h3>
				<!-- <form name="join" action ="memberInsert" method="post" enctype="multipart/form-data"> -->
				<form action ="memberInsert" method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td>
								<ul>
									<li><input type="radio" id="choseClient" class="radio" name="m_kind" value="C" /></li>
									<li><label for="choseClient">Ŭ���̾�Ʈ</label></li>
								</ul>
							</td>
							<td>
								<ul>
									<li><input type="radio" id="choseFreelancer" class="radio" name="m_kind" value="F" /></li>
									<li><label for="choseFreelancer">��������</label></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="text" id="userId" name="userId" placeholder="���̵�" /> 
								<span id="notiId"></span>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="password" id="userPassword" name="pw" placeholder="��й�ȣ" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="password" id="passwordCheck" name="pw" onkeyup="passwordCheckk()" placeholder="��й�ȣ Ȯ��" /> 
								<span id="notiPw"></span>
							</td>
						</tr>
						<tr>
							<td colspan="2" id="passwordCheckText"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="file" id="userImage" name="userImage" onchange="fileChk(this)"/>
								<input type="hidden" id="fileCheck" name="fileCheck"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div id="image_preview">
									<img src="resources/img/user.png" />
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="text" id="userName" name="userName" placeholder="�̸�" /> 
								<span id="notiName"></span>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="text" id="userEmail" name="userEmail" placeholder="�̸���" />
							</td>
						</tr>
						<tr>
							<td colspan="2" id="notiEmail" style="color: red"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" class="btn" onClick="sendCode()" value="������ȣ �߼�" /> 
								<span id="notiCode"></span>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="text" id="userCode" name="userCode" placeholder="������ȣ" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<!-- <input type="button" class="btn" onClick="join()" value="ȸ������" /> -->
								<input type="submit" class="btn" value="ȸ������" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" class="btn" onClick="location.href='./'" value="���ư���" />
								
							</td>
						</tr>

					</table>
				</form>
			</div>
		</div>
	</div>
	<hr>

	<div class="row"></div>
	<!--Ǫ�� ���� ����-->
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
							href="#">��������</a>&nbsp;&nbsp;&nbsp; <a href="#">faq</a>&nbsp;&nbsp;&nbsp;
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

<script language="javascript">
		var checked_radio = $('input:radio[name=m_kind]:checked').val(); // ���õ� radio�� value ��������
		if(checked_radio === undefined) // ������ ���� �ʾ��� ���
		{
		    alert('�ɼ��� �������ּ���.');
		} else {
		    alert(checked_radio + "�� �����ϼ̽��ϴ�.");
		}

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
				$('#notiEmail').html("�̸����� �Է����ּ���");
			}
		}
		
		//���Ͼ��ε� 
		function fileChk(elem){ //���� ������Ʈ�� �Ķ���ͷ� �޾Ҵ�.
			//�Ķ���ͷ� �� ���� �Դ��� Ȯ��
			console.log(elem.value);
			if(elem.value==""){
				console.log("empty");
				//jquery 
				$("#fileCheck").val(0);//���� ÷�� ����
			}else{
				$("#fileCheck").val(1);//���� ÷�� ��
			}
			
		}//function end 
		
				
		$('#userImage').on('change', function() {
	        
	        ext = $(this).val().split('.').pop().toLowerCase(); //Ȯ����
	        
	        //�迭�� ������ Ȯ���ڰ� �����ϴ��� üũ
	        if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
	            resetFormElement($(this)); //�� �ʱ�ȭ
	            window.alert('�̹��� ������ �ƴմϴ�! (gif, png, jpg, jpeg �� ���ε� ����)');
	        } else {
	            file = $('#userImage').prop("files")[0];
	            blobURL = window.URL.createObjectURL(file);
	            $('#image_preview img').attr('src', blobURL);
	            $('#image_preview').slideDown(); //���ε��� �̹��� �̸����� 
	            $(this).slideUp(); //���� ��� ����
	        }
	    });

	    
	    $('#image_preview a').bind('click', function() {
	        resetFormElement($('#userImage')); //������ ��� �ʱ�ȭ
	        $('#image').slideDown(); //���� ��� ������
	        $(this).parent().slideUp(); //�̸� ���� ���� ����
	        return false; //�⺻ �̺�Ʈ ����
	    });
		
	</script>


</html>