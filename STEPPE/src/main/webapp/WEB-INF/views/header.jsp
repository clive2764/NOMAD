<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--상단 메뉴바-->
	<header id="header">
        <nav class="navbar navbar-default navbar-static-top" role="banner">
            <div class="container" style="width: 100%;">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                   <div class="navbar-brand">
						<a href="main"><h1>steppe</h1></a>
					</div>
                </div>				
                <div class="navbar-collapse collapse">							
					<div class="menu">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a href="goIntro">steppe?</a></li>
							<li role="presentation"><a href="goProject">프로젝트</a></li>
							<li role="presentation"><a href="goFreelancer">프리랜서</a></li>
							<li role="presentation"><a href="goManual">이용방법</a></li>
							<li role="presentation"><a href="goNotice">공지사항</a></li>
                            <li role="presentation"><a href="goPms">프로젝트 관리</a></li>
                            <li role="presentation">
                            	<c:set var="m_kind" value="${m_kind}" />
								<c:if test="${m_kind eq 'C'}">
									<a href="goAddProject">
										프로젝트 등록하기
									</a>
								</c:if>
							</li>
                            <li role="presentation">
                            	<%-- <c:set var="m_id" value="${member.m_id}"/> --%>
                            	<c:if test="${!empty m_id}">
									<a href="goMyProfile">프로필</a>
								</c:if>
							</li>
                            <li role="presentation">
                            	<c:if test="${null eq m_id }">
	            					<a href="goLogin">로그인</a>
								</c:if>
						 
								<c:if test="${null ne m_id}">
									<a href="logout">${m_id}님 로그아웃</a>
								</c:if>
							</li>
                            <li role="presentation">
                            <c:if test="${null eq m_id}">
                            	<a href="goJoin">회원가입</a>
                            </c:if>
                            </li>
						</ul>
					</div>
				</div>		
            </div>
        </nav>	
    </header>
	<!--상단 메뉴바 영역 끝-->
</body>
</html>