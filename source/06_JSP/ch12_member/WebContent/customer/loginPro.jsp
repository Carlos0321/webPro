<%@page import="com.lec.customer.Dto"%>
<%@page import="com.lec.customer.Dao"%>
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
	String id = request.getParameter("cid");
	String pw = request.getParameter("cpw");
	Dao mDao = Dao.getInstance();
	int result = mDao.login(id, pw);
	if(result==Dao.LOGIN_SUCCESS){
		Dto customer = mDao.getCustomer(id);
		session.setAttribute("customer", customer);
		response.sendRedirect("main.jsp");
	}else if(result==Dao.LOGIN_FAIL){
		%>
		<script>
			alert('비밀번호를 확인하세요');
			history.back();
		</script>		
	<%	}else{//아이디 오류 %>
			<script>
				alert('존재하지 않는 아이디입니다.');
				history.go(-1);
			</script>
<%		}
	%>
</body>
</html>