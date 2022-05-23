<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<% String su = request.getParameter("su");%>
	<form action="">
		<fieldset>
			<legend>숫자입력</legend>
			숫자
			 <input type="number" name="su" value="<%if(su!=null) out.print(su);%>">
			 <input type="submit" 	value="누적">
		</fieldset>
	</form>
	<%
	String suStr = request.getParameter("su");
	if (suStr == null || suStr.equals("")) {
	
	}else{
		int s = Integer.parseInt(suStr);
		int sum = 0;
		for (int i = 0; i <= s; i++) {
			sum += i;
		}
		out.println("<h2>1부터"+s+"까지 누적합은 :" + sum+"</h2>");
	}
%>
</body>
</html>