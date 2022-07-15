<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
<h3>${cnt }</h3>
	<form action="${conPath }/quizInput.do" method="post">
		<h3>개인 정보 입력</h3>
		<p>이름 : <input type="text" name="name" value="${quiz.name }">
		<p>국어  : <input type="number" name="kor" placeholder="점수는 0~100점 사이"
					value='<c:if test="${quiz.kor!=0 }">${quiz.kor }</c:if>'></p>
		<p>영어  : <input type="number" name="eng" placeholder="점수는 0~100점 사이"
					value='<c:if test="${quiz.eng!=0 }">${quiz.eng }</c:if>'></p>
		<p>수학  : <input type="number" name="mat" placeholder="점수는 0~100점 사이"
					value='<c:if test="${quiz.mat!=0 }">${quiz.mat }</c:if>'></p>
		<input type="submit" value="입력">			
	</form>
</body>
</html>