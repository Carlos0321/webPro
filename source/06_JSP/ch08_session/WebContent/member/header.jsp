<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/footer.css" rel="stylesheet" type="text/css">
	<style>
		header {width: 1000px; margin: 0 auto;}
		header #nav ul {overflow: hidden;}
		header #nav ul li{list-style: none; float: right; padding: 10px 30px;}
		header #nav ul li a{
			text-decoration: none; font-weight: bold; font-size: 1.5em;
			color: #A47160;
		}
	</style>
</head>
<body>
	<header>
		<div id ="nav">
			<%
			String name = (String)session.getAttribute("name");
		%>
		<%if(name==null){ // 로그인 전 해더 메뉴%>
			<ul>
				<li><a href="<%=conPath %>/member/login.jsp">로그인</a></li>
				<li><a href="<%=conPath %>/member/join.jsp">회원가입</a></li>
				<li><a href="<%=conPath %>/member/main.jsp">홈</a></li>
			</ul>
		<%}else{ // 로그인 후 해더 메뉴 %>
			<ul>
				<li><a href="logout.jsp">로그아웃</a></li>
				<li><a href="#">정보수정</a></li>
				<li><a href="#"><%=name %>님</a>
			</ul>
		<%} %>
		</div>
	</header>
</body>
</html>