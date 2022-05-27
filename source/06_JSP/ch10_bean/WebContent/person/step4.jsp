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
<!-- 프로세스 단 -->
	<jsp:useBean class="com.lec.ex.person" id="p" scope="request"/> <!-- 객체이름이 p -->
	<jsp:setProperty property="name" name="p" value='<%=request.getParameter("name")%>'/>
	<jsp:setProperty property="age" name="p"
					 value="<%=Integer.parseInt(request.getParameter(\"age\"))%>"/>
	<jsp:setProperty property="gender" name="p"
						value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty property="address" name="p" value='<%=request.getParameter("address") %>'/>
	<jsp:forward page="pView.jsp"></jsp:forward>
	
	
</body>
</html>