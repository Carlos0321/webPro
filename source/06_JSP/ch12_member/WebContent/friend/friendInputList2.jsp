<%@page import="com.lec.friend.FriendDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDto"%>
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
<form action="friendInputListPro.jsp" method="post" name="frm">
	<table>
	<tr>
	<th>친구이름</th>
	<td><input type="text" name="fname" required="required" 
	value="<%String fname=request.getParameter("fname");
			if(fname!=null) out.println(fname);%>														"></td>
	<th>전화</th>
	<td>
	<input type="text" name="tel" required="required"
		value="<%String tel = request.getParameter(tel);
				if(tel!=null) out.println(tel);%>">
	<input type="submit" value="추가">
	<input type="button" value="검색" onclick="search()">
	</td>
	</tr>

	</table>
</form>
	<table>
		<caption>이곳에 DB 출력</caption>
	
	<% 
	FriendDao fDao = FriendDao.getInstance();
      ArrayList<FriendDto> fdto = fDao.getFriend();
         out.println("<tr><th>순번</th><th>이름</th><th>전화</th></tr>");
            if(!fdto.isEmpty()){
               for(FriendDto fdtos: fdto){
                  out.println("<tr><td>" +fdtos.getN() +"</td><td>"+ fdtos.getFname()+"</td><td>" +
                  fdtos.getTel() + "</td></tr>");            
               }
               
            }else{
               out.println("<tr><td colspan='3'>해당 친구가 존재하지 않습니다</td></tr>");
            }
	%>
	</table>
</body>
</html>