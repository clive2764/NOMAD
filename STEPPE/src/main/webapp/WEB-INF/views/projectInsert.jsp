<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>steppe ����������</title>
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/css/animate.css">
	<link href="resources/css/animate.min.css" rel="stylesheet"> 
	<link href="resources/css/style.css" rel="stylesheet" />
    <script src="http://code.jquery.com/jquery-3.2.1.js"></script>
    <script>
    
    </script>
<style>
select {
	color: black;
}
table{
	color: black;
}
span{
	color:black;
}
input#complete {
	height:80px;
	width: 50%;
	background: #0f1c34;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid white;
	color: #fff;
	font-weight: bold;
	font-size: 14px;
	outline: none;
	cursor: pointer;
	text-align: center;
}
input#p_term{
	float:right;
	border-radius: 5px;
}
textarea{
	width: 100%;
	resize: none;
}
td.category{
	text-align: center;
    width: 5%;
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
					<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a href="goIntro">steppe?</a></li>
							<li role="presentation"><a href="goProject">������Ʈ</a></li>
							<li role="presentation"><a href="goFreelancer">��������</a></li>
							<li role="presentation"><a href="goManual">�̿���</a></li>
                            <li role="presentation"><a href="goPms">������Ʈ ����</a></li>
					</ul>
				</ul>
			</div>
		</div>
	</div>
	</nav> 
	</header>
	<div class="row"></div>
	<div class="container">
		<form action="" method="post" id="insertForm" name="form1">
			
			<div class="container">
				<table class="table table-responsive">
					<tr>
						<td style="vertical-align: bottom;">
							<select name="pc1_name" id="pc1_name" onchange="firstChange();">
									${cList1}
							</select> 
							<select name="pc2_name" id="pc2_name">
									<option value="2�� ī�װ�">2��ī�װ�</option>
							</select>
							<td>
							<span style="float: right;">�Ⱓ(��)</span><br/>
							<input type="text" name="p_term" id="p_term" placeholder="�Ⱓ�� �Է��Ͻÿ�" 
							onkeydown="inputOnlyNumber(this);" onkeyup="typing()" value=0 />
							</td>
					</tr>
					<tr>
						<td class="category">
							<span>����</span>
						</td>
						<td>
							<input type="text" style="width:100%;" placeholder="������ �Է��Ͽ� �ּ���" />
						</td>
					</tr>
					<tr>
						<td class="category" style="vertical-align: middle;">
							<span>����</span>
						</td>
						<td><textarea name="p_content"
								id="p_content" rows="30"></textarea></td>
					</tr>
					<tr>
						<td class="category">
							<span>���� ÷��</span>
						</td>
						<td>
							<input type="file" name="p_filename" onChange="fileChk(this)" style="width: 100%;"/>
							<input id="p_filename" type="hidden" name="fileCheck"/>
						</td>
					</tr>
					<tr>
						<td class="category">
							<span>���� ����</span>
						</td>
						<td>
							<input type="date" name="p_deadline" id="p_deadline" />
						</td>
					</tr>
					<tr>
                  		<td class="category">
                     	<span>������</span>
                  		</td>
                  		<td>
                     		<input type="text" name="p_budget" id="p_budget" 
                     		onkeydown="inputBudget(this)" onkeyup="typing2()" value=0 /><span>        ����</span>
                  		</td>
               		</tr>
					<tr style="text-align: center;">
						<td colspan="2">
							<input type="button" id="complete" value="������Ʈ ���" style="height: 80px;"/>
						</td>
					</tr>
				</table>
			</div>		
		</form>
	</div>
		
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



	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>
</body>
<script>
	/*
    function firstChange(){
    	var x = document.form1.pc1_name.options.selectedIndex;
    	var groups=document.form1.pc1_name.options.length;
    	var group=new Array(groups);
    	
    	 for (i=0; i<groups; i++) {
    		  group[i]=new Array();
    		 }//for
    	 // �ɼ�(<option>) ����
    	  group[0][0]=new Option("2�� ī�װ�");
 		  group[1][0]=new Option("���� ����");
 		  group[1][1]=new Option("Android��");//��� <option value="ss">�Ｚ</option>
 		  group[1][2]=new Option("�÷�������");
 		  group[1][3]=new Option("����");
 		  group[1][4]=new Option("�Ӻ����");
 		  group[1][5]=new Option("����Ͼ�");
 		  group[1][6]=new Option("IOS��");
 		  group[1][7]=new Option("ERP");
 		  group[1][8]=new Option("�ۺ���");
 		  group[1][9]=new Option("��Ÿ");
 		  group[2][0]=new Option("������ ����");
 		  group[2][1]=new Option("��");
 		  group[2][2]=new Option("���ø����̼�");
 		  group[2][3]=new Option("�Ϸ���Ʈ");
 		  group[2][4]=new Option("����");
 		  group[2][5]=new Option("�ΰ�");
 		  group[2][6]=new Option("�μ⹰");
 		  group[2][7]=new Option("�׷���");
 		  group[2][8]=new Option("3P");
 		  group[2][9]=new Option("PPT���ø�");
 		  group[2][10]=new Option("����,���");
 		  
 		 temp = document.form1.pc2catagory;
 		 for (m = temp.options.length-1 ; m > 0 ; m--) {//���� �� �����
 		  temp.options[m]=null
 		 }
 		 for (i=0;i<group[x].length;i++){//�� ����
 		  //��) <option value="ss">�Ｚ</option>
 		  temp.options[i]=new Option(group[x][i].text,group[x][i].value);
 		 }
 		 temp.options[0].selected=true//�ε��� 0��°, ��, ù��° ����
 		}//firstChange
 			*/
 			
 		function firstChange(){
 				var selectBox = document.getElementById("pc1_name");
 			    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
 			    //alert(selectedValue + '��  �����ϼ̽��ϴ�.');
 			   $.ajax({
 				 	 type:'get',
 			         url : './secondCatagory',
 			         data : {
 			            selectedValue : selectedValue
 			         },

 			         success : function(data) {
 			            $('#pc2_name').html(data);
 			            console.log(data);
 			         },
 			         error : function(error) {
 			            console.log(error);
 			         }
 			      });
 		}
    	function inputOnlyNumber(obj){
 			e=window.event;
 			
 			if((e.keyCode>=46 && e.keyCode<=57)||//���ڿ�
 			(e.keyCode>=96 && e.keyCode<=105) ||//Ű�е�
 			e.keyCode==8||//BackSpace
 			e.keyCode==46||//Delete
 			//e.keyCode==110||//�Ҽ���: ����Ű�迭
 			//e.keyCode==190||//�Ҽ���: Ű�к�
 			e.keyCode==37||//�� ȭ��ǥ
 			e.keyCode==39||//�� ȭ��ǥ
 			e.keyCode==35||//endŰ
 			e.keyCode==36||//homeŰ
 			e.keyCode==9//tabŰ
 			){
 			if(e.keyCode==48 || e.keyCode==96){//0�� ������ ���
 				if(obj.value=="" || obj.value=='0')//�ƹ��͵� ���ų� ���簪�� 0�� ��쿡�� 0�� ������ ���
 					e.returnValue=false;//�Է� �ȵ�
 				else//�ٸ� ���ڵڿ� ���� 0��
 					return;//�Է�
 			}
 			else//0�� �ƴ� ����
 				return;//�Է�
 			}
 			else//���ڰ� �ƴϸ� ������ ����
 				{
 				alert('���ڸ� �Է°����մϴ�');
 				e.returnValue=false;
 				
 				
 				}
 		}
 		
 		function fileChk(elem){
 			console.log(elem.value);
 			if(elem.value==""){
 				console.log("empty");
 				$("#p_filename").val(0);//����÷�� ����
 			}else{
 				$("#p_filename").val(1);//����÷�� ��
 			}
 		}
 		
 		function typing(){
 			  var val=document.getElementById("p_term").value;
 			  var value=document.getElementById("p_term");
 			  if(val>=184)
 				  alert("183�� ������ �����մϴ�");
 		}
 		
 		function inputBudget(obj){
			e=window.event;
 			
 			if((e.keyCode>=46 && e.keyCode<=57)||//���ڿ�
 			(e.keyCode>=96 && e.keyCode<=105) ||//Ű�е�
 			e.keyCode==8||//BackSpace
 			e.keyCode==46||//Delete
 			//e.keyCode==110||//�Ҽ���: ����Ű�迭
 			//e.keyCode==190||//�Ҽ���: Ű�к�
 			e.keyCode==37||//�� ȭ��ǥ
 			e.keyCode==39||//�� ȭ��ǥ
 			e.keyCode==35||//endŰ
 			e.keyCode==36||//homeŰ
 			e.keyCode==9//tabŰ
 			){
 			if(e.keyCode==48 || e.keyCode==96){//0�� ������ ���
 				if(obj.value=="" || obj.value=='0')//�ƹ��͵� ���ų� ���簪�� 0�� ��쿡�� 0�� ������ ���
 					e.returnValue=false;//�Է� �ȵ�
 				else//�ٸ� ���ڵڿ� ���� 0��
 					return;//�Է�
 			}
 			else//0�� �ƴ� ����
 				return;//�Է�
 			}
 			else//���ڰ� �ƴϸ� ������ ����
 				{
 				alert('���ڸ� �Է°����մϴ�');
 				e.returnValue=false;
 				
 				
 				}
 			
 		}
 		function typing2(){
 			  var val=document.getElementById("p_budget").value;
 			 if(val>=20001)
				  alert("2��� ������ �Է� ���� �մϴ�.");
 		}
 		

    //$("#complete").click(function(){
    	//	$("#replyForm").submit();
  //  });
</script>
</html>