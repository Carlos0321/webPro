<%@page import="com.lec.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/header.css" rel="stylesheet">
</head>
<body><!-- .gnb(로그인전/로그인후) - .logo - .lnb(도서보기/도서등록(로그인후)) -->
	<header>
		<div class='gnb'>
		<%if(session.getAttribute("member")==null){ %>
		<!-- 로그인 전 메뉴 (우측 부터) -->
		<ul>
			<li><a href="<%=conPath%>/fileboard/fboardList.jsp">고객센터</a></li>
			<li><a href="<%=conPath%>/member/join.jsp">회원가입</a></li>
			<li><a href="<%=conPath%>/member/login.jsp">로그인</a></li>
		</ul>
		
		<%}else{ %>
		<!-- 로그인 후 메뉴(우측부터): 고객 센터, 로그아웃, 정보 수정 ,고객 이름 -->
		<ul>
			<li><a href="<%=conPath%>/fileboard/fboardList.jsp">고객센터</a></li>
			<li><a href="<%=conPath%>/member/logout.jsp">로그아웃</a></li>
			<li><a href="<%=conPath%>/member/modifyForm.jsp">정보수정</a></li>
			<li><a href="#"><%=((MemberDto)session.getAttribute("member")).getmName() %></a></li>
		</ul>
		<%} %>
		</div>
		<div class = "logo" onclick = "location.href='<%=conPath%>/main/main.jsp'">
			<img src="https://www.coca-cola.co.kr/content/dam/journey/kr/ko/private/logos/CC_South_Korea_Lockup_Horizontal_B.svg">
		</div>
		<div class = "lnb">
			<ul>
				<li><a href="">로그인전메뉴1</a></li>
				<li><a href="">로그인전메뉴2</a></li>
				<li><a href="">로그인전메뉴3</a></li>
				<li><a href="">로그인전메뉴4</a></li>
			</ul>
		</div>
	</header>
</body>
</html>