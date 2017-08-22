<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <script src="http://code.jquery.com/jquery-3.2.1.js"></script>
	<style>

        table{
            color: black;
        }
       	textarea{
       		resize: none;
       		white-space: pre-line;
       	}
       	#priceForm{
       		margin-bottom:50px;
       	}
       	input{
       		color:black;
       	}
       	input#check{
       		background: #0f1c34;
		   	box-sizing: border-box;
		   	border-radius: 5px;
		   	border: 1px solid white;
		   	color: #fff;
		   	font-weight: bold;
		   	font-size: 14px;
		   	outline: none;
		   	cursor: pointer;
       	}
       	input#replyInsert,input#list{
       		background: #0f1c34;
		   	box-sizing: border-box;
		   	border-radius: 5px;
		   	border: 1px solid white;
		   	color: #fff;
		   	font-weight: bold;
		   	font-size: 14px;
		   	outline: none;
		   	cursor: pointer;
		   	float: right;
       	}
       	#r_content{
       		color:black;
       		width: 100%;
       	}
    </style>
  </head>
  <body>
    <jsp:include page="header.jsp" />
    	<div class="about">
		<div class="container">
            <table class="table table-responsive">
                <tr>
                    <td>제목</td>
                    <td colspan="3" style="text-align: center;">${project.p_title}</td>
                </tr>
                <tr>
                    <td>프로젝트 기간</td>
                    <td colspan="2" style="text-align: center;">지원자</td>
                    <td style="text-align: right;">마감일</td>
                </tr>
                <tr>
                    <td>${project.p_term}일</td>
                    <td colspan="2" style="text-align: center;">${project.p_vol}명</td>
                    <td colspan="2" style="text-align: right;">${project.p_deadline}</td>
                </tr>
                <tr>
                    <td>필요언어</td>
                    <td>${project.p_plnum0},${project.p_plnum1},${project.p_plnum2}</td>
                    <td colspan="2" style="text-align: center;">
                        <form action="" method="post" id="priceForm">
                            <input type="text" placeholder="입찰가 (만원단위 ex)200)" id="price" name="price">
                            <input type="button" value="결정" id="check"/>
                            <a href="goProject"><input type="button" value="목록보기" id="list"></a>
                        </form>
                        
                    </td>
                    
                </tr>
            
            </table>
        </div>
    
	<hr>
    <div class="container">
            <h1 style="text-align:center; color:black;">프로젝트 설명</h1>
            <p>
                ${project.p_content}
            </p>    
           
    </div>
    </div>
    <hr/>
    <div class="container">
        <h1 style="color:black; text-align:center;">댓글</h1>
        <div class="row"></div>
        <table class="table table-responsive">
            <tr>
                <td>작성자</td>
                <td colspan="5">작성 내용</td>
            </tr>
            <tr>
                <td><p>핫산</p></td>
                <td colspan="5"><p>싸잔님 월급 주쎄오 쩨발</p></td>
            </tr>
            <tr>
                <td><p>핫산</p></td>
                <td colspan="5"><p>3달째 밀렸어오 싸잔님</p></td>
            </tr>
            <tr>
                <td><p>핫산</p></td>
                <td colspan="5"><p>가족들 굶어요 싸잔님</p></td>
            </tr>
        </table>
        <form action="insertComment" method="post" id="replyForm">
        	<textarea name="r_content" id="r_content"></textarea><br/>
        	<input type="button" id="replyInsert" value="댓글작성"/>
        </form>
    </div>
    <div class="row"></div>
    <!-- 푸터 영역 -->  
	<jsp:include page="footer.jsp" />
      
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!--<script src="js/jquery.js"></script>-->		
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>	
</body>
<script>
    $("#check").click(function(){
        var price = $("#price").val();
        
        
        if(price == "" ){
          alert("입찰가를 입력하세요!");      
        } 
          
        if(price != ""){
            $("#priceForm").submit();
        }    
    });
    $("#replyInsert").click(function(){
    	var r_content  = $("#r_content").val();
    	
    	if(r_content == ""){
    		alert("댓글을 입력하세요!");
    	}
    	if(r_content != ""){
    		$("#replyForm").submit();
    	}
    });
</script>
</html>