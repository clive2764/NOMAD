<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.2.1.min.js"></script>
</head>
<style>
	#a_tname{
		width: 50px;
		border: 1px solid white;
	}
	#a_tnum{
		display: none;
	}
</style>
<body>
	<div id = "Test">
		<form action = "ajax(checkTest)" name = "checkTest" id = "checkTest" method="post">
			<table border = "1">
				${tlist}
			</table>
		</form>
	</div>	
</body>
</html>
<script>
	function ajax(url) {
		var FormData = $('#checkTest').serialize();
		$.ajax({
			url : 'checkTest',
			type : 'post',
			data : FormData,
		success : function(data) {
			$('#Test').html(data);
			},
		error : function(error) {
			console.log(error);
			}
		});//ajax End
	}
	$("#check").click(function(){
		if ( $("input[type=radio]:checked").length < 1 ) {
		    alert('정답을 입력하시오');
		}else if ( $("input[type=radio]:checked").length = 1 ) {
			$(ajax(checkTest)).submit;
		}
	});
	$("#goFst").click(function(){
		$("goFst").submit;
	});
</script>