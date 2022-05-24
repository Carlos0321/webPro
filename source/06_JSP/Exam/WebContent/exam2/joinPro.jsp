<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/join.css" rel="stylesheet">
</head>
<body>
	<% 
	request.setCharacterEncoding("utf-8");
	String name        = request.getParameter("name");
	String id          = request.getParameter("id");
	String pw          = request.getParameter("pw");
	String birth       = request.getParameter("birth");
	
	String ip          = request.getRemoteAddr();
	Date birth2=null;
	Timestamp birth3=null;

	if(birth!="") {
	    birth2 = Date.valueOf(request.getParameter("birth"));
    	birth3 = Timestamp.valueOf(request.getParameter("birth") + " 00:00:00");
	} 
	String[] hobby = request.getParameterValues("hobby"); // 배열 || null
	String gender  = request.getParameter("gender");
	String email   = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend"); // 배열
	
	response.setContentType("text/html; charset=utf-8");
	
	out.println("<html>");
	out.println("<head>");
	out.println("<link href='css/join.css' rel='stylesheet'>");
	out.println("</head>");
	out.println("<body>");
	out.println("<div id='joinForm_wrap'>");
	out.println("<div id='join_title'>회원가입정보</div>");
	out.println("<h2>name : " + name + "</h2>");
	out.println("<h2>id : " + id + "</h2>");
	out.println("<h2>pw : ");
	for(int i=0 ; i<=pw.length() ; i++) {
		out.println('*');
	}
	out.println("</h2>");
	out.println("<h2>birth : " + birth +"</h2>");
	out.println("<h2>birth3 : " +birth3 + "</h2>");
	out.println("<h2>취미 : ");
	if(hobby!=null) {
		for(int i=0 ; i<hobby.length ; i++) {
			if(i == hobby.length-1) {
				out.println(hobby[i]);
			}else {
				out.println(hobby[i] + ", ");
			}
		}
	}else {
		out.println("선택된 취미가 없음");
	}
	out.println("</h2>");
	out.println("<h2>gender : " + gender +"</h2>");
	out.println("<h2>email : " + email +"</h2>");
	out.println("<h2>mailSend :");
	if(mailSend!=null) {
		for(int i=0 ; i<mailSend.length ; i++) {
			if(i == mailSend.length-1) {
				out.println(hobby[i]);
			}else {
				out.println(hobby[i] + ", ");
			}
		}
	}else {
		out.println("모든 수신 거부");
	}
	out.println("</h2>");
	out.println("<h2>가입일 :2022-05-24</h2>");
	out.println("<h2>가입IP :"+ip+"</h2>");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	out.close();
	
	%>
	<%@include file="../exam2/footer.jsp" %>
</body>
</html>