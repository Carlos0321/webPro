<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		  setTimeout(function go_url(){
	             location.href="<%=conPath%>/member/main.jsp"
	         },3000);  // 3초후 go_url() 함수를 호출한다.
		 
		</script>
		<style>
	#mainForm_wrap{
	width: 500px;
	height: 500px;
	margin:0 auto;
	border: 1px solid orange;
	text-align: center;
	font-weight: bold;
	line-height: 500px;
	font-size: 1.5em;
	
	}
	</style>
</head>
<body>
	<% // 로그인 상태 : id, name 세션 속성이 있음
	String name = (String)session.getAttribute("name");
	if(name!=null){
		session.invalidate();
	%>	
		<jsp:include page="/member/header.jsp"/>
	<div id = "mainForm_wrap">
		로그아웃되었습니다. 잠시후 페이지 이동이 있겠습니다. 
		<script>
		setTimeout(function(){location.href='main.jsp';}, 3000);
		</script>
	</div>
	<jsp:include page="/member/footer.jsp"/>
	
	<% }else{
		out.println("<h2>로그인 상태가 아닙니다</h2>");
	}
%>

</body>
</html>