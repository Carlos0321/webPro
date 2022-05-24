<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style >
		form{
		border : 1px solid cyan;
		width : 200px;
		}
		button{
		text-align: :center;
		background-color: lightgreen;
		padding-left : 20px;
		}
		
	</style>
</head>
<body>
	<form>
	<h2>동전이 있는 곳을 맞춰봐</h2>
	<hr>
	<button name="btn" value="1" onclick="location.href='exPro.jsp'">1번</button>
	<button name="btn" value="2" onclick="location.href='exPro.jsp'">2번</button>
	<button name="btn" value="3" onclick="location.href='exPro.jsp'">3번</button>
	</form>
	<%
	String msg = request.getParameter("msg");
	if(msg != null){
		out.println(msg);
	}
	%>
</body>
</html>