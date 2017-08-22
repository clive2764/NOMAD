<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="purchase" method="post" id="purchase" name="purchase" onsubmit="return check()">
			<div class="container">
				<table class="table table-responsive">
					<tr>
						<td>
							<span>입찰 가의 합</span>${sumbid}<span>만 원</span>
						</td>
						<td>
							<input type="hidden" value='${sumbid}' name="sumbid" id="sumbid"/>
						</td>
					</tr>
					<tr>
						<td>
							<span>수수료</span>${com}<span>만 원</span>
						</td>
						<td>
							<input type="hidden" value='${com}' name="com" id="com"/>
						</td>
					</tr>
					<tr>
						<td>
						+-----------------------------------------------------
						</td>
					</tr>
					<tr>
						<td>
						<span>결제액:</span>${sum}<span>만 원</span>
						</td>
						<td>
						<input type="hidden" value='${sum}' name="sum" id="sum"/>
						<input type="hidden" value='${v_pnum}' name="v_pnum" id="v_pnum"/>
						</td>
					</tr>
					<tr>
						<td>
						<input type="submit" value='결제' id="submit"/>
						</td>
					</tr>
				</table>
			</div>		
		</form>
</body>
<script>
	function check(){
		var con=confirm("정말 결제 하시겠습니까?");
		if(con==true){
			document.purchase.action='./purchase';
			document.purchase.submit();
		}else{
			history.back();
		}
	}
</script>
</html>