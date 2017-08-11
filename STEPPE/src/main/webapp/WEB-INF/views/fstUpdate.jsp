<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  action="updateFst" method="post">
		<select name = "t_name">
			<option value="java">JAVA</option>
			<option value="html">HTML</option>
			<option value="jsp">JSP</option>
			<option value="c">C</option>
			<option value="android">Android</option>
		</select>
		<br/><br/>
		<table border = "1">		
			<tr>
				<td width="100"><input type="text" style="width: 25px;" readonly="readonly" name="t_num" value="${test.t_num}"/><span>번 문제</span></td>
				<td><input type="text" name="t_content" value="${test.t_content}"/></td>
			</tr>
			<tr>
				<td width="100">1번</td>
				<td><input type="text" name="t_no1" value="${test.t_no1}"/></td>
			</tr>
			<tr>
				<td width="100">2번</td>
				<td><input type="text" name="t_no2" value="${test.t_no2}"/></td>
			</tr>
			<tr>
				<td width="100">3번</td>
				<td><input type="text" name="t_no3" value="${test.t_no3}"/></td>
			</tr>
			<tr>
				<td width="100">4번</td>
				<td><input type="text" name="t_no4" value="${test.t_no4}"/></td>
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
		<br/>
		<input type = "submit" value="수정 확인">
	</form>
		<button><a href="deleteFst?t_num=${test.t_num}">삭제</a></button>
</body>
</html>