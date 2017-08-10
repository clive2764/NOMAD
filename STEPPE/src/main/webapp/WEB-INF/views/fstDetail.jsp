<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
		<tr><td>${test.t_num}</td><td>${test.t_content}</td></tr>
		<tr><td>1번</td><td>${test.t_no1}</td></tr>
		<tr><td>2번</td><td>${test.t_no2}</td></tr>
		<tr><td>3번</td><td>${test.t_no3}</td></tr>
		<tr><td>4번</td><td>${test.t_no4}</td></tr>
		<tr><td>정답</td><td>${test.t_answer}</td></tr>
	</table>
</body>
</html>