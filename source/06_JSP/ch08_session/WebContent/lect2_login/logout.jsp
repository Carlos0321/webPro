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
	<% //로그인 상태 : id, name 세션 속성이 있음
		String name = (String)session.getAttribute("name");
	if(name!=null){
		//session.removeAttribute("id");
		//session.removeAttribute("name");
		session.invalidate(); //추가된 속성이 싹 사라짐
		out.println("<h2>성공적으로 로그아웃되었습니다.");
	}else{
		out.println("<h2>로그인 상태가 아닙니다</h2>");
	}
	%>
	<button onclick ="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='sessionTest.jsp'">세션 들여다보기</button>
</body>
</html>