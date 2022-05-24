<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id ==null || !id.equals("aaa") || pw==null || !pw.equals("111")){
		//String msg = "Check th ID and PW";
		String msg = "<b>아이디와 비밀번호를 확인하세요</b>";
		msg = URLEncoder.encode(msg,"utf-8");
		response.sendRedirect("ex5_loginFrm.jsp?msg="+msg);
	}out.println("<h2>ID는 "+id+"이고<br>비민번호는"+pw+ "입니다<br></h2>");
	%>
	<h2>
	ID는 <%=id %>이고<br>
	비민번호는 <%=pw %>입니다<br>
	</h2>
</body>
</html>