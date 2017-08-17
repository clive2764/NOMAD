<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<button id="showProcessAll" name="showProcessAll" onclick="location.href='./showProcessAll ' ">프로젝트 관리</button>
		<button  id="pinsert" name="pinsert" onclick="location.href='./goAddProject' ">프로젝트 등록</button>
		<button  id="updateUserInfo" name="updateUserInfo" onclick="location.href='./goUpdateUserInfo' ">회원정보 수정</button>
		<button  id="deleteMember" name="deleteMember" onclick="location.href='./deleteMember' ">회원탈퇴</button>
	<h1>프로젝트 목록</h1>
	${plist}
</body>
<script>
	function showApplyList(p_num){
		document.showList.action='./showApplyList';
		document.showList.submit();
	}
</script>
</html>