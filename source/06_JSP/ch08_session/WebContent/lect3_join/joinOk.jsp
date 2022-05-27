<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	String agree = request.getParameter("agree");
	if(agree.equals("y")){ // 약관동의한 경우 (세션속성값 받아 파일저장, 일부 세션 날림 -> 다음페이지로)
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		String name = (String)session.getAttribute("name");
		// 파일 저장(소스폴더의 WebContent/WEB-INF/id.txt)
		String filePath = "D:/Carlos/webPro/source/06_JSP/ch08_session/WebContent/WEB-INF/"+id+".txt";
		PrintWriter writer = new PrintWriter(filePath);
		writer.println("오늘은 DB에 insert대신 파일 출력");
		writer.println("아이디 : " +id);
		writer.println("비밀번호 : " +pw);
		writer.println("이름 : " + name);
		writer.close();
		session.removeAttribute("pw");
		session.removeAttribute("name");
		// 세션의 id속성은 유지
		response.sendRedirect("result.jsp?msg=success");
	}else { // 약관에 동의하지 않는 경우(세션 날림 -> 다음페이지로)
		session.invalidate(); // 유효한 세션 속성 삭제
		response.sendRedirect("result.jsp?msg=fail");
	}
%>
</body>
</html>