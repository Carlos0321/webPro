<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style >
	form{border:1px solid blue;
		width:300px;
		height:600px;
		text-align: :center;
	}
	</style>
</head>
<body>
	<form action="ex7_loginPro.jsp" method = "post">
		<h2>로그인 화면</h2>
			<hr/>
		<table>
			<tr><td>이름</td>
			<td><input type="text" name="name" /></td></tr>
			<tr><td>아이디</td>
			<td><input type="text" name="id" /></td></tr>
			<tr><td>패스워드</td>
			<td><input type="password" name="pw" /></td></tr>
			<tr><td colspan="2"><input type="submit" value="로그인"/></td></tr>
		</table>
		
	</form>
</body>
</html>