<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>steppe 샘플페이지</title>
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet" />
<script src="resources/js/jquery-3.2.1.min.js"></script>
<!-- =======================================================
        Theme Name: Day
        Theme URL: https://bootstrapmade.com/day-multipurpose-html-template-for-free/
        Author: BootstrapMade
        Author URL: https://bootstrapmade.com
    ======================================================= -->
<style>
.container {
   color: black;
}
input{
color:black;
}
table {
color:black;
   text-align: center;
   vertical-align: middle;
}
#cTable{
   color: black;
}
#complete {
   width: 100%;
   height: 40px;
   background: cornflowerblue;
   box-sizing: border-box;
   border-radius: 5px;
   border: 1px solid white;
   color: #fff;
   font-weight: bold;
   font-size: 14px;
   outline: none;
   cursor: pointer;
}

input {
   border-radius: 5px;
}
</style>
</head>
<body>
   <!-- 헤더 영역 -->  
	<jsp:include page="header.jsp" />

   <div class="container">
      <!--style="height:-webkit-fill-available;"-->
      <form action="addCareerInfo" method="post" id="career">
         <table class="table">
			<tr>
				<th>
					<select name="language">
						<option value="">언어 선택</option>
						<option value="JAVA">JAVA</option>
						<option value="HTML">HTML</option>
						<option value="CSS">CSS</option>
					</select>
				</th>
				<th>
					<select name="grade">
						<option value="">등급 선택</option>
						<option value="초급">초급</option>
						<option value="중급">중급</option>
						<option value="상급">상급</option>
					</select>
				</th>
				<th>
					<input type="text" name="career" placeholder="경력"/>
				</th>
				<th>
					<button>추가</button>
				</th>
			</tr>
		</table>		
      </form>
      
   </div>

   <hr>
   <div class="container">
      <!--style="height:-webkit-fill-available;"-->
      <h1 style="text-align: center;"></h1>
   </div>
   <div class="row"></div>
   <!-- 푸터 영역 -->  
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
      var clist='';    
      $.ajax({
         type : 'get',
         url : 'showMyCareer',
         data : $('#career').serialize(),
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
            alert("error");
            console.log(error);
         }
      });

   $("#complete").click(function() {
            var clist='';
      $.ajax({
         type : 'get',
         url : 'addCareerInfo',
         data : $('#career').serialize(),
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
            alert("error");
            console.log(error);
         }
      });
   });
   });
   function memberDelete(num){
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
   }
   

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