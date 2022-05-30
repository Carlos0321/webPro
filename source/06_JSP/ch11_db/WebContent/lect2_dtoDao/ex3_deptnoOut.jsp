
<%@page import="com.lec.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	EmpDAO dao = EmpDAO.getInstance();	
	ArrayList<EmpDTO> dtos = dao.selectDeptno(deptno);
	out.println("<table>");
	if(!dtos.isEmpty()){ //dtos에 데이터가 있는 경우
		for(EmpDTO dto : dtos){
			out.println("<tr><td>"+dto.getEmpno()+"</td><td>"+dto.getEname()+
					"</td><td>"+dto.getHiredate()+"</td><td>"+dto.getDeptno()+"</td></tr>");
		}
	}else{ //dtos에 데이터가 없는 경우
		out.println("<tr><td>사원이 없습니다</td></tr>");
	}	
	
	%>
	<button onclick="location.href='ex3_deptnoIn.html'">다시 검색</button>
</body>
</html>