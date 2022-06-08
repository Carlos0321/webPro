<%@page import="java.sql.Timestamp"%>
<%@page import="com.lec.customer.Dao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/join.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.customer.Dto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>	
	<%
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setCbirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
		} 
	Dao mDao = Dao.getInstance();
	int result = mDao.confirmID(dto.getCid()); //id중복체크
	if(result == Dao.NONEXISTENT){
		result = mDao.joinCustomer(dto); //회원가입
		if(result == Dao.SUCCESS){
			session.setAttribute("id", dto.getCid());
			%>			
			<script>
			alert('회원가입 감사합니다. 로그인 후 서비스를 이용하세요');
			location.href='login.jsp';
			</script>
	<%		}else{//회원가입 실패
	%>			
			<script>
			alert('회원가입 실패되었습니다. 다시 가입해 주세요');
			location.href="join.jsp";
			</script>
	<%		}
		}else{ //중복된 ID
		%>
		<script>
		alert('중복된 id입니다. 다른아이디를 사용하세요');
		history.back();
		</script>
	<%  } %>
<jsp:include page="footer.jsp"/>	
</body>
</html>