<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="ex02_scope.jsp">
		<p>이름 : <input type="text" name="name"></p>
		<p>ID : <input type="text" name="id"></p>
		<p><input type="submit"></p>
	</form>
	<%
	//이 페이지를 벗어나면 없어지는 속성
	pageContext.setAttribute("pageName", "pageValue");
	//새로운 request객체를 생성하기 전까지 유효
	request.setAttribute("requestName", "requestValue");
	//브라우저 닫으면 사라짐
	session.setAttribute("sessionName", "sessionValue");
	//페이지내에서 어플리케이션이 사라지기 전까지 유효 
	application.setAttribute("applicationName", "applicationName");
	// foward 할 객체 (dispathcer)
	RequestDispatcher dispathcer =  request.getRequestDispatcher("ex02_scope.jsp?name=kim&id=aaa");
	dispathcer.forward(request, response);
	%>
<%-- 	<jsp:forward page="ex02_scope.jsp"/> --%>
	<h3>페이지내 속성변수 값 : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request 속성변수 값 : <%=request.getAttribute("requestName") %></h3>
	<h3>session 속성변수 값 : <%=session.getAttribute("sessionName") %></h3>
	<h3>application 속성변수 값 : <%=application.getAttribute("applicationName") %></h3>
	<hr>
	<h3>페이지내 속성변수 값 : ${pageScope.pageName }</h3>
	<h3>request 속성변수 값 : ${requestScope.requestName }</h3>
	<h3>session 속성변수 값 : ${sessionScope.sessionName }</h3>
	<h3>application 속성변수 값 : ${ applicationScope.applicationName }</h3>
	<hr>
	<!-- scope객체일 경우 생략 가능 -->
	<h3>페이지내 속성변수 값 : ${pageName }</h3>
	<h3>request 속성변수 값 : ${requestName }</h3>
	<h3>session 속성변수 값 : ${sessionName }</h3>
	<h3>application 속성변수 값 : ${applicationName }</h3>
</body>
</html>