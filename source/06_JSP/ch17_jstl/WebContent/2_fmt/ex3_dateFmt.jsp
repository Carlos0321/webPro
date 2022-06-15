<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
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
	<c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
	<c:set var="nowDateUtil" value="<%=new java.util.Date() %>"/>
	${nowDate } <br>
	${nowTimes } <br>
	${nowDateUtil } <br>
	<hr>
	<h3>날짜만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/><br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/><br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/><br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/><br>
	<h5>시간만 출력</h5>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="short"/><br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="medium"/><br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="long"/><br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="full"/><br>
	<h5>날짜와 시간 모두 출력</h5>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="short"/><br>
	<fmt:formatDate value="${nowDate }" pattern="yyyy년MM월dd일(E요일) hh:mm:ss:SS(a)"/><br>
	<fmt:formatDate value="${nowDate }" pattern="yy-MM-dd(E) HH:mm:ss:SS"/><br>
	
	
</body>
</html>