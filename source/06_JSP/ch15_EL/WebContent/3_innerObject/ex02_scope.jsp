<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>ex02_scope.jsp페이지입니다</h2>
	<!-- scope객체일 경우 객체이름 생략 가능 -->
	<h3>페이지내 속성변수 값 : ${pageName }</h3>
	<h3>request 속성변수 값 : ${requestName }</h3>
	<h3>session 속성변수 값 : ${sessionName }</h3>
	<h3>application 속성변수 값 : ${applicationName }</h3>
	<hr>
	<h3>이름 :${param.name } <%=request.getParameter("name") %></h3>
	<h3>ID : ${param.id }</h3>
</body>
</html>