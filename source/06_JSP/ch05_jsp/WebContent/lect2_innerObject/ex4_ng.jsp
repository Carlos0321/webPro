<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- age.html ->age.jsp -> pass.jsp -->
<%
	int age = Integer.parseInt(request.getParameter("age"));
%>	
	<h2><%=age %>살 민짜 컷</h2>
	<button onclick="history.go(-1);">뒤로가기</button>
</body>
</html>