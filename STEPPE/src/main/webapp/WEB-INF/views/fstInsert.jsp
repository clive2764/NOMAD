<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form  action="insertFst" method="post">
		<select name = "t_name">
			<option value="java">JAVA</option>
			<option value="html">HTML</option>
			<option value="jsp">JSP</option>
			<option value="c">C</option>
			<option value="android">Android</option>
		</select>
		<table border = "1">		
			<tr>
				<td width="100">문제내용</td>
				<td><input type="text" name="t_content"/></td>
			</tr>
			<tr>
				<td width="100">1번</td>
				<td><input type="text" name="t_no1"/></td>
			</tr>
			<tr>
				<td width="100">2번</td>
				<td><input type="text" name="t_no2"/></td>
			</tr>
			<tr>
				<td width="100">3번</td>
				<td><input type="text" name="t_no3"/></td>
			</tr>
			<tr>
				<td width="100">4번</td>
				<td><input type="text" name="t_no4"/></td>
			</tr>
			<tr>
				<td width="100">정답번호</td>
				<td>
					<select name = "t_answer">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</td>
			</tr>
		</table>
		<input type = "submit" value="확인">
	</form>
</body>
</html>