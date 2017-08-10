<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="resources/js/jquery-3.2.1.min.js"></script>
		<title>NOMAD</title>
	</head>
	<body>
		<a href="javascript:Ajax('progress?code=0&prog=0','#printP')">전체</a>
		<a href="javascript:Ajax('progress?code=1&prog=1','#printP')">대기</a>
		<a href="javascript:Ajax('progress?code=2&prog=2','#printP')">작업중</a>
		<a href="javascript:Ajax('progress?code=3&prog=3','#printP')">완료</a>
		<br/>
		<div id="printP">
			${makeList}
		</div>
		<form action="progress" method="get">
			<select name="prog">
				<option value="0">전체</option>
				<option value="1">대기</option>
				<option value="2">작업중</option>
				<option value="3">완료</option>
			</select>
			<input type="submit" value="전송" />
		</form>
		<script>
			function Ajax(url, position){
				$.ajax({
					type: 'get',
					url: url,
					success: function(html){
						alert('확인');
						$(position).html(html);
					},
					error: function(error){
						console.log(error);
					}
				});
			}
		</script>
	</body>
</html>