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
	int btn = Integer.parseInt(request.getParameter("btn"));
	int coinbtn = (int)(Math.random() * 3);
	
	if(coinbtn ==btn){
		out.println("<h2>정답입니다</h2><br>");
		out.println("동전이 있는곳 ="+btn);
	}else if(coinbtn == btn){
		out.println("<h2>정답입니다</h2><br>");
		out.println("동전이 있는곳 ="+btn);
	}else if(coinbtn == btn){
		out.println("<h2>정답입니다</h2><br>");
		out.println("동전이 있는곳 ="+btn);
	}else{
		String msg ="<h2>Wrong! try Again</h2>";
		response.sendRedirect("ex.jsp");
	} 
	
	%>
</body>
</html>