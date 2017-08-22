<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<title>steppe</title>
		<!-- Bootstrap -->
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="resources/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/css/animate.css">
		<link href="resources/css/animate.min.css" rel="stylesheet"> 
		<link href="resources/css/style.css" rel="stylesheet" />   
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<!--메인페이지 영역-->
		<div class="about">

			<form name="pinsert" action="goAddProject" method="get">
			<button>프로젝트 등록</button>
			</form>

		<button id="showProcessAll" name="showProcessAll" onclick="location.href='./showProcessAll ' ">프로젝트 관리</button>
		<button  id="pinsert" name="pinsert" onclick="location.href='./goAddProject' ">프로젝트 등록</button>
		<button  id="updateUserInfo" name="updateUserInfo" onclick="location.href='./goUpdateUserInfo' ">회원정보 수정</button>
		<button  id="deleteMember" name="deleteMember" onclick="location.href='./deleteMember' ">회원탈퇴</button>
		<h2>프로젝트 목록</h2>
		${plist}

		</div>
		<hr>
		<div class="row"></div>
		 
		<!-- 푸터 영역 -->  
		<jsp:include page="footer.jsp" />
	<script>
	function P_teamCheck(p_status2){
		alert(p_status2);
	}
	</script>

</body>
</html>