<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h1>지원자 리스트</h1>
	${vList}
	<br/>
	<br/>

</body>
<script>
function check(obj){
	var isSelectChk=false;
	var arr_v_mid=document.getElementsByName("v_mid");
	var checked=0;
	for(var i=0;i<arr_v_mid.length;i++){
		if(arr_v_mid[i].checked==true){
			checked+=1;
			if(checked==arr_v_mid.length){
				isSelectChk=true;
				return true;
			}else{
				continue;
			}
		}
			
		}
	if(!isSelectChk){
		alert("선정을 다 체크해 주세요");
		return false;
	}
}

function back(){
	window.history.back();
}
</script>
</html>