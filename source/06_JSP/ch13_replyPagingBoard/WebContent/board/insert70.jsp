<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
	//임의로 70개 글 insert하기
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for(int i=0; i<70 ; i++){
		dto.setWriter("홍길동"+i);
		dto.setSubject("제목"+i+"입니다");
		dto.setContent("본문입니다"+i);
		dto.setEmail("hong"+i+"@hong.com");
		dto.setPw("1");
		dto.setIp("192.168.10"+i);
		int result = dao.insertBoard(dto);
		System.out.println(result==BoardDao.SUCCESS? i+"번째 성공":i+"번째글쓰기 실패");
	}
	response.sendRedirect("list.jsp");
	%>
</body>
</html>