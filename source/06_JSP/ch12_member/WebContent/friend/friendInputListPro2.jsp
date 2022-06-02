<%@page import="com.lec.friend.FriendDto"%>
<%@page import="com.lec.friend.FriendDao"%>
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
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
<jsp:setProperty property="*" name="dto"/>
	<%
	FriendDao dao = FriendDao.getInstance();
	int result = dao.join(dto);
	response.sendRedirect("friendInputList.jsp");
	%>
</body>
</html>