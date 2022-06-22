<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/login.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<form action="${conPath }/login.do" method="post">
		<table id="loginForm_wrap">
			<tr><th>ID</th><td><input type ="text" name="mId" value="${mId }" required="required"></td></tr>
			<tr><th>PW</th><td><input type ="password" name="mPw" value="${mPw }" required="required"></td></tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="location='${conPath}/joinView.do'">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>