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
	request.setCharacterEncoding("utf-8");
	String pageNum = request.getParameter("pageNum"); //pageNum 추가		
	%>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	
	<!-- 들어온 파라미터 : subject, content, email, pw, num -->
	<!-- dao의 updateBoard를 호출하기 위해서는 : subject, content,email,pw,num,ip -->
	<%  
		dto.setIp(request.getRemoteAddr());
		BoardDao dao = BoardDao.getInstance();
		int result = dao.updateBoard(dto);
		if(result == BoardDao.SUCCESS){
	%>		
	<script>
		alert('글 수정 성공');
		location.href="list.jsp?pageNum=<%=pageNum%>";
	/* location.href = 'content.jsp?num=<%=dto.getNum()%>?pageNum=<%=pageNum%>'; 상세보기페이지 */
	</script>
	<% 	}else{%>
		<script>
			alert('글 수정 실패');
			history.go(-1);
		</script>
	<%}%>
</body>
</html>