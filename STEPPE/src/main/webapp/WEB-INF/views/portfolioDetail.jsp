<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>steppe</title>
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet" />
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/jquery.form.min.js"></script>
</head>
<style>
input{
color:black;
}
</style>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<!--style="height:-webkit-fill-available;"-->
		<form method="post" id="portfolio" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<td><p>제목</p></td>
					<td colspan="2"><input style="width: 40%;" type="text"
						placeholder="포트폴리오 제목을 입력해주세요" name="pf_title" id="title"></td>
				</tr>
				<tr>
					<td><p>기간</p></td>
					<td colspan="2"><input style="width: 40%;" type="text"
						placeholder="포트폴리오 기간을 입력해주세요" name="pf_term" id="term"></td>
				</tr>
				<tr>
					<td><p>기여도</p></td>
					<td colspan="2"><input style="width: 40%;" type="text"
						placeholder="포트폴리오 기여도를 입력해주세요" name="pf_contribute"
						id="contribute"></td>
				</tr>
				<tr>
					<td><p>내용</p></td>
					<td colspan="2"><input style="width: 40%;" type="text"
						placeholder="포트폴리오 내용을 입력해주세요" name="pf_content" id="content"></td>
				</tr>
				<tr>
					<td><p>포트폴리오 첨부</p></td>
					<td><input type="file" name="pf_image[]" multiple="multiple" />
				</tr>
				<tr rowspan="3" colspan="3">
					<td colspan="3"><input type="button" id="complete"
						value="작성완료" /></td>
				</tr>
			</table>
		</form>
		<table>
			<tr align="center" height="25">
				<td width="200"></td>
				<td width="200"></td>
			</tr>
		</table>
		<table id="pfTable">
			${pflist}
			<%-- <c:forEach var="portfolio" items="${pflist}">
				<tr align="center" height="25">
					<td width="200">${portfolio.pf_mid}님의 포트폴리오 입니다.</td>
					<td width="200"><img src="resources/upload/${portfolio.pt_sysname}"/></td>
				</tr>
			</c:forEach> --%>
		</table>
	</div>

	<hr>
	<div class="container">
		<!--style="height:-webkit-fill-available;"-->
		<h1 style="text-align: center;"></h1>
	</div>
	<div class="row"></div>
	<jsp:include page="footer.jsp" />

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!--<script src="js/jquery.js"></script>-->
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/wow.min.js"></script>
	<script>
		wow = new WOW({}).init();
	</script>
</body>
<script>
	/* $("#complete").click(function(){
	    var term = $("#term").val();
	    var company = $("#company").val();
	    var rank= $("#rank").val();
	    console.log(term);
	    console.log(company);
	    if(term == "" || company == "" || rank == ""){
	      alert("빈항목이 존재합니다!");      
	    } 
	      
	    if(term != "" && company != "" && rank != ""){
	        $("#career").submit();
	    }
	}); */
	 $(document).ready(function(){
		var pflist=''; 	
		$.ajax({
			type : 'get',
			url : 'showPortfolioList',
			data : $('#portfolio').serialize(),
			//$('#rForm').serialize(), 폼 전체 데이터 전송
			dataType : 'json',
			success : function(data) { //댓글 리스트 json형태 반환
				console.log(data); //json 구조파악
				for(var i=0;i<data.length;i++){
					if(i==0){
						pflist+='<tr height="25" align="center">'
						+'<td width="200">'+data[i].pf_mid+'</td>'
						+"<td width='200'><a href='showPortfolioDetail?pfnum="+data[i].pf_num+"'><img src='resources/upload/"+data[i].pt_sysname+"'/></a></td>"
						+"<td><a href='showPortfolioDetail?pfnum="+data[i].pf_num+"'></a></td></tr>"
					}
			}
			$('#pfTable').html(pflist);
			},
			error : function(error) {
				console.log(error);
			}
		}); 

	    $("#complete").click(function() {
	    	var formdata = new FormData(document.getElementById('portfolio'));
				var pflist='';
		$('#portfolio').ajaxForm({
			type : 'post',
			url : 'addPortfolio',
			enctype: "multipart/form-data",
			//data : $('#portfolio').serialize(),
			//data: formdata,
			//$('#rForm').serialize(), 폼 전체 데이터 전송
			dataType : 'json',
			success : function(data) { //댓글 리스트 json형태 반환
				console.log(data); //json 구조파악
				for(var i=0;i<data.length;i++){
					pflist+='<tr height="25" align="center">'
					+'<td width="200">'+data[i].pf_title+'</td>'
					+'<td width="200">'+data[i].pf_term+'</td>'
					+'<td width="200">'+data[i].pf_contribute+'</td>'
					+'<td width="200">'+data[i].pf_content+'</td></tr>'
					/* +'<td width="200">'+data[i].pt_sysname+'</td></tr>' */
			}
			$('#pfTable').html(pflist);
			},
			error : function(error) {
				alert("error");
				console.log(error);
			}
		});
		$('#portfolio').submit();
	    });
	 });
	/*function memberDelete(num){
		var number = num;
		var clist='';
		$.ajax({
			type : 'get',
			url : 'deleteCareerInfo',
			data : {num:num},
			//$('#rForm').serialize(), 폼 전체 데이터 전송
			dataType : 'json',
			success : function(data) { //댓글 리스트 json형태 반환
				console.log(data); //json 구조파악
				for(var i=0;i<data.length;i++){
					clist+='<tr height="25" align="center">'
					+'<td width="200">'+data[i].ca_term+'</td>'
					+'<td width="200">'+data[i].ca_company+'</td>'
					+'<td width="200">'+data[i].ca_rank+'</td>'
					+"<td><input type='button' value='삭제' onclick='memberDelete("+data[i].ca_num+")'/></td></tr>"
			}
			$('#cTable').html(clist);
			},
			error : function(error) {
				console.log(error);
			} 
	});
		location.reload();
	} */
	

	/* function(){
		
	} */
	/*function complete(){
	    var term = $("#term").val();
	    var company = $("#company").val();
	    var rank= $("#rank").val();
	    console.log(term);
	    console.log(company);
	    if(term == "" || company == "" || rank == ""){
	      alert("빈항목이 존재합니다!");      
	    } 
	      
	    if(term != "" && company != "" && rank != ""){
	        $("#career").submit();
	    }    
	}*/
</script>
</html>