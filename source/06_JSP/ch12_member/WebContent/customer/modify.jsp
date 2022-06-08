<%@page import="java.sql.Timestamp"%>
<%@page import="com.lec.customer.Dto"%>
<%@page import="java.sql.Date"%>
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
	<%! String id, name, tel, gender, email,address;Timestamp birth;  %>
	<%
	Dto customer = (Dto)session.getAttribute("customer");
	if(customer==null){
		response.sendRedirect("login.jsp");
	}else{
		id = customer.getCid();
		name = customer.getCname();
		tel = customer.getCtel();
		gender = customer.getCgender();
		email=customer.getCemail();
		address=customer.getCaddress();
		birth = customer.getCbirth();
	}
	%>
	<form action="modifyOk.jsp" method="post" name="modify_frm" onsubmit ="return infoConfrim()">
		<table>
			<caption>정보수정</caption>
			<tr>
			<th>아이디</th><td><input type="text" name="cid" value="<%=id%>" readonly="readonly"></td>
			</tr>
			<tr><th>현재 비밀번호</th>
			<td><input type="password" name="oldPw" required="required"></td>
			</tr>
			<tr>
			<tr><th>새비밀번호</th>
				<td><input type="password" name="pwChk"></td>
			</tr>
			<tr><th>이름</th>
				<td><input type="text" name="name" value="<%=name%>" required="required"></td>
			</tr>
			<tr><th>전화번호</th>
				<td><input type="text" name="tel" value="<%=tel %>" required="required"></td>
			</tr>
			<tr><th>성별</th>
				<td>
					<%if("m".equals(gender)) {%>
						<input type="radio" name="gender" value="m" checked="checked">남
						<input type="radio" name="gender" value="f">여
					<%}else if("f".equals(gender)){ %>
					<input type="radio" name="gender" value="m" >남
						<input type="radio" name="gender" value="f" checked="checked">여
					<%}else {%>
					<input type="radio" name="gender" value="m" >남
					<input type="radio" name="gender" value="f" >여
					<%} %>
				</td>
			</tr>
			<tr><th>이메일</th>	
				<td><input type="email" name="email" value='<%=email ==null ? "" : email%>'></td>
			</tr>
			<tr><th>생일</th>	
				<td><input type="date" name="birth" value='<%=birth==null ? "" : birth.toString().substring(0,10) %>'></td>
			</tr>
			<tr><th>주소</th>
				<td><input type="text" name="address" value='<%=address==null ? "" : address%>'></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="정보수정">
				<input type="reset" value="취소" onclick="history.back()">
				<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
				</td>
			</tr>
		</table>		
	</form>
</body>
</html>