<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  action="showFstList" method="post">
		<select name = "FstList">
			<option value="java">JAVA</option>
			<option value="html">HTML</option>
			<option value="jsp">JSP</option>
			<option value="c">C</option>
			<option value="android">Android</option>
		</select>
		<input type = "submit" value="확인">
	</form>
	<br/><br/>
	
			<table border = "1">
			<tr><td id = t1>문제 번호</td><td id = t2>문제 내용</td><td id = t3>답</td><td id = t4>수정 & 삭제</td></tr>
			${tlist}
			</table>
			
	<br/><br/>
	
		<button><a href="goInsertFst">문제 추가</a></button>
</body>
</html>