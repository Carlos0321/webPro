<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<style>
	b{color : red;}
	h2{color : blue;}
	</style>
</head>
<body>
	<form action="">
	<p>
		<input type="number" name="su1" value="<%=(int)(Math.random()*9)+1 %>">*
		<input type="number" name="su2" value="<%=(int)(Math.random()*9)+1 %>"> =
		<input type="number" name="result">
	</p>
	<p><input type="submit" value="확인"></p>
	<h2>${param.su1} * ${param.su2 } = ${param.result }
 	${param.su1 * param.su2 eq param.result ? "<b>는 true 정답</b>" :"<b>는 false</b>"} </h2>
	
	</form>
</body>
</html>