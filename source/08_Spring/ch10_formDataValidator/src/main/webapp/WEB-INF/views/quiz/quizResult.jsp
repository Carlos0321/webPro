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
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
<h3>${cnt }</h3>
<h2>결과는 다음과 같습니다</h2>
	<h4>이름 : ${quiz.name }</h4>
	<h4>국어 : ${quiz.kor }</h4>
	<h4>영어 : ${quiz.eng }</h4>
	<h4>수학 : ${quiz.mat }</h4>
	<h4>총점 : ${quiz.kor+quiz.eng+quiz.mat}</h4>
	<h4>평균 : <fmt:formatNumber value="${(quiz.kor+quiz.eng+quiz.mat)/3.0 }" pattern="#,###.##"/></h4>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}/quizInput.do'">다시 입력</button>	
</body>
</html>