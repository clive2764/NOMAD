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
    <!--상단 메뉴바-->
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
                     <li role="presentation"><a href="goProject">프로젝트</a></li>
                     <li role="presentation"><a href="goFreelancer">프리랜서</a></li>
                     <li role="presentation"><a href="goManual">이용방법</a></li>
                            <li role="presentation"><a href="goPms">프로젝트 관리</a></li>
                            <li role="presentation">
                               <c:set var="m_id" value="${member.m_id}" />
                               <c:if test="${empty m_id}">
                              <a href="goLogin">로그인</a>
                        </c:if>
                        <c:if test="${!empty m_id}">
                           <a href="goMyProfile">프로필</a>
                        </c:if>
                        <c:if test="${!empty m_id}">
                           <a href="./logout">${m_id}님 로그아웃</a>
                        </c:if>
                     </li>
                            <li role="presentation">
                            <c:if test="${empty m_id}">
                               <a href="goJoin">회원가입</a>
                            </c:if>
                            </li>
                  </ul>
               </div>
            </div>      
            </div>
        </nav>   
    </header>
   <!--상단 메뉴바 영역 끝-->
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
                     <form action="insertProfile" method="post" id="introduce">
                        <textarea rows="20" style="width: 100%; resize:none;" id="content" name="pro_content"></textarea>
                        <input type="button" id="complete" value="작성완료"/>
                     </form>
                  </td>
            </table>
            <table>
			<tr align="center" height="25">
				<td width="200">이름</td>
				<td width="200">사진</td>
				<td width="200">자기소개서</td>
			</tr>
		</table>
		<table id="prTable">
			<c:forEach var="profile" items="${prlist}">
				<tr align="center" height="25">
					<td width="200">${data[i].m_name}</td>
					<td width="200"><img src=C:\Users\KJW\Documents\NOMAD\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\STEPPE\resources\upload\1502953212965.jpg></td>
					<td width="200">${data[i].pro_content}</td>
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
				+'<td width="200">'+'<img src=C:\Users\KJW\Documents\NOMAD\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\STEPPE\resources\upload\"1502953212965.jpg">'+'</td>'
				+'<td width="200">'+data[i].pro_content+'</td>'
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
				+'<td width="200">'+'<img src=C:\Users\KJW\Documents\NOMAD\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\STEPPE\resources\upload\"1502953212965.jpg">'+'</td>'
				+'<td width="200">'+data[i].pro_content+'</td>'
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
				+'<td width="200">'+'<img src=C:\Users\KJW\Documents\NOMAD\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\STEPPE\resources\upload\"1502953212965.jpg">'+'</td>'
				+'<td width="200">'+data[i].pro_content+'</td>'
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