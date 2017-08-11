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
		<tr colespan = "2" ><h2>합격한 시험</h2></tr>
		<tr>
			<td>과목</td>
			<td>퍼센트</td>
		</tr>
	</table>
	
	<table border = "1">
		<tr colespan = "2" ><h2>자격시험 목록</h2></tr>
		<tr>
			<td>JAVA</td><td><a href = "selectTest?t_name=java">보러가기</a></td>
		</tr>
		<tr>
			<td>HTML</td><td><a href = "selectTest?t_name=html">보러가기</a></td>
		</tr>
		<tr>
			<td>JSP</td><td><a href = "selectTest?t_name=jsp">보러가기</a></td>
		</tr>
		<tr>
			<td>C</td><td><a href = "selectTest?t_name=c">보러가기</a></td>
		</tr>
		<tr>
			<td>Android</td><td><a href = "selectTest?t_name=android">보러가기</a></td>
		</tr>
	</table>
</body>
</html>