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
.about {
	color: black;
}
input{
color:black;
}
table {
	color: black;
}

.category {
	width: 10%;
}

input#complete {
	width: 75px;
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
.proimg{
	width: auto;
	height: 400px;
}
</style>
</head>
  <body>
    <jsp:include page="header.jsp" />
   	<jsp:include page="mypagefrmenu.jsp" />
   	<jsp:include page="profilemenu.jsp" />
	<!--메인페이지 영역-->
	<div class="about">
         <div class="container">
            <hr/>
            <table class="table table-striped">
            	
               <tr>
                  <td class="category">
                     <span>프로필 사진
                  </span>
                     <img style="width: 250px; height: 250px;" src=""/>
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
                     <form action="insertProfile" method="post" id="introduce">
                        <textarea rows="20" style="width: 100%; resize:none;" id="content" name="pro_content"></textarea>
                        <input type="button" id="complete" value="작성완료"/>
                     </form>
                  </td>
            </table>
            <table>
			<tr align="center" height="25">
				<td width="200">이름</td>
				<td width="auto">사진</td>
				<td width="600">자기소개서</td>
			</tr>
		</table>
		<table id="prTable">
			<c:forEach var="profile" items="${prlist}">
				<tr align="center" height="25">
					<td width="200">${prlist.m_name}</td>
					<td width="auto"><img src="resources/upload/1503108730932.jpg"/></td>
					<td width="600">${prlist.pro_content}</td>
				</tr>
			</c:forEach>
		</table>
            <hr/>
         </div>
         <div class="container">
         <h1 style="color: black;">자기소개서 표출</h1>
         </div>
   </div>      
   <hr>
   
    <div class="row"></div>
      
    <!-- 푸터 영역 -->  
	<jsp:include page="footer.jsp" />
	
    <script src="resources/js/jquery-3.2.1.min.js"></script>		
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>	
    
</body>
<script>
$(document).ready(function(){
	var prlist='';
	$.ajax({
		type : 'get',
		url : 'showMyProfile',
		data : $('#introduce').serialize(),
		//$('#rForm').serialize(), 폼 전체 데이터 전송
		dataType : 'json',
		success : function(data) { //댓글 리스트 json형태 반환
			console.log(data); //json 구조파악
			for(var i=0;i<data.length;i++){
				prlist+='<tr height="25" align="center">'
				+'<td width="200">'+data[i].m_name+'</td>'
				+'<td width="auto">'+'<img class="proimg" src="resources/upload/'+data[i].mf_sysname+'"/>'+'</td>'
				+'<td width="600">'+data[i].pro_content+'</td>'
				+"<td><input type='button' value='삭제' onclick='memberDelete("+data[i].pro_num+")'/></td></tr>"
		}
		/* for(var i=0;i<data.rlist.length;i++){
			rlist+='<tr height="25" align="center">'
				+'<td width="100">'+data.rlist[i].r_id+'</td>'
				+'<td width="200">'+data.rlist[i].r_contents+'</td>'
				+'<td width="150">'+data.rlist[i].r_date+'</td></tr>'
		} */
		$('#prTable').html(prlist);
		},
		error : function(error) {
			alert("error");
			console.log(error);
		}
	});
   $("#complete").click(function(){
			var prlist='';
	$.ajax({
		type : 'get',
		url : 'insertProfile',
		data : $('#introduce').serialize(),
		//$('#rForm').serialize(), 폼 전체 데이터 전송
		dataType : 'json',
		success : function(data) { //댓글 리스트 json형태 반환
			console.log(data); //json 구조파악
			for(var i=0;i<data.length;i++){
				prlist+='<tr height="25" align="center">'
				+'<td width="200">'+data[i].m_name+'</td>'
				+'<td width="auto">'+'<img class="proimg" src="resources/upload/'+data[i].mf_sysname+'"/>'+'</td>'
				+'<td width="600">'+data[i].pro_content+'</td>'
				+"<td><input type='button' value='삭제' onclick='memberDelete("+data[i].pro_num+")'/></td></tr>"
		}
		/* for(var i=0;i<data.rlist.length;i++){
			rlist+='<tr height="25" align="center">'
				+'<td width="100">'+data.rlist[i].r_id+'</td>'
				+'<td width="200">'+data.rlist[i].r_contents+'</td>'
				+'<td width="150">'+data.rlist[i].r_date+'</td></tr>'
		} */
		$('#prTable').html(prlist);
		},
		error : function(error) {
			alert("error");
			console.log(error);
		}
	});
});
});
function memberDelete(num){
	var number = num;
	var prlist='';
	$.ajax({
		type : 'get',
		url : 'deleteProfile',
		data : {num:num},
		//$('#rForm').serialize(), 폼 전체 데이터 전송
		dataType : 'json',
		success : function(data) { //댓글 리스트 json형태 반환
			console.log(data); //json 구조파악
			for(var i=0;i<data.length;i++){
				prlist+='<tr height="25" align="center">'
				+'<td width="200">'+data[i].m_name+'</td>'
				+'<td width="auto">'+'<img class="proimg" src="resources/upload/'+data[i].mf_sysname+'"/>'+'</td>'
				+'<td width="600">'+data[i].pro_content+'</td>'
				+"<td><input type='button' value='삭제' onclick='memberDelete("+data[i].pro_num+")'/></td></tr>"
		}
		$('#prTable').html(prlist);
		},
		error : function(error) {
			console.log(error);
		} 
});
	location.reload();
}
</script>
</html>