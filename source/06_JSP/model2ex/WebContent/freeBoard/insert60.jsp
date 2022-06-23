<%@page import="com.lec.dao.BoardDao"%>
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
	<%
		for(int i=0 ; i<60 ; i++){
			BoardDao dao = BoardDao.getInstance();
			if(i%5!=0){
				dao.writeBoard("go", "제목"+i, i+"번째 본문", null, "192.168.10."+i);			
			}else if(i%5==0){
				dao.writeBoard("gico", "제목"+i, i+"번째 본문", "a.docx", "192.168.10."+i);		
			}	
		}
		response.sendRedirect("../boardList.do");
	%>
</body>
</html>