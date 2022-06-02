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
	<td><input type="text" name="fname" required="required"></td>
	<th>전화</th>
	<td>
	<input type="text" name="tel" required="required">
	<input type="submit" value="추가">
	<input type="b" value="검색">
	</td>
	</tr>

	</table>
</form>
	<%-- <%
		FriendDao dao = FriendDao.getInstance();
		ArrayList<FriendDto> friend = dao.getFriend();
		out.println("<p>순번 이름  전화 </p>");
		for(FriendDto f : friend){
			out.println(f);
		}
	%> --%>
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