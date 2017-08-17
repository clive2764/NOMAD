<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	#tname{
		border: 1px solid white;
		font-size: x-large;
	}
</style>
<body>
	<form action="doTest" method="post">
		<input type = "text" readonly="readonly" name = "t_name" id="tname" value = "${test}"/>
		<h4 style ="color: red;">시험을 치루기에 앞서 꼭 읽어주세요</h4>
		1. 모든문제는 객관식 입니다.<br/>
		2. 모든문제는 단수 정답입니다.<br/>
		3. 문제를 풀고 다음 문제로 넘어갈시 이전 문제로 되돌아갈수 없습니다.<br/>
		4. 합격은 60%이상의 정답을 획득시에 주어지며, 점수역시 %로 표시됩니다.<br/>
		5. 문제를 단푼후 답은 공개하지 않으며 맞은 문제수만을 알려드립니다.<br/><br/><br/>
		<button>시험 시작</button>
	</form>
</body>
</html>