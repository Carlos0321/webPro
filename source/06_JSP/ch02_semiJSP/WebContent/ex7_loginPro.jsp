<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결과 화면</title>
	<style >
	form{border:1px solid blue;
		width:300px;
		height:600px;
		text-align: :center;
	}
	</style>
</head>
<body>
	<%!String name, id, pw; %>
	<%
	request.setCharacterEncoding("utf-8"); //post 방식으로 파라미터 전송시만
	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	%>
	<h2>아이디는 <%=id %>이고</h2>
	<h2>패스워드는<%=pw %>이고</h2>
	<br>
	<h2><%=name %>님 반갑습니다</h2>
</body>
</html>