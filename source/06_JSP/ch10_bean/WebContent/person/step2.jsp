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
	<jsp:useBean class="com.lec.ex.person" id="p" scope="page"/>
	<jsp:setProperty property="name" name="p" value='<%=request.getParameter("name")%>'/>
	<jsp:setProperty property="age" name="p"
					 value="<%=Integer.parseInt(request.getParameter(\"age\"))%>"/>
	<jsp:setProperty property="gender" name="p"
						value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty property="address" name="p" value='<%=request.getParameter("address") %>'/>
	
	
	<h2>입력받은 개인정보</h2>
	<p>이름 <%=p.getName() %></p>
	<p>나이 <%=p.getAge() %></p>
	<p>성별 <%=p.getGender() %></p>
	<p>주소 <%=p.getAddress() %></p>					
</body>
</html>