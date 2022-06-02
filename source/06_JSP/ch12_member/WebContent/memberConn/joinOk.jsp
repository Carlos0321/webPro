<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
	%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setBirth(Timestamp.valueOf(tempbirth+ " 00:00:00"));
		//dto.setBirth(Date.valuOf(tempbirth))
	}
	MemberDaoConn mDao = new MemberDaoConn(); //싱글톤 아님
	int result =mDao.confirmID(dto.getId()); //id중복체크
	if(result ==MemberDaoConn.MEMBER_NONEXISTENT){ //사용가능한 ID
		result = mDao.joinMember(dto); //회원가입
		if(result==MemberDaoConn.SUCCESS){//회원가입 성공
			session.setAttribute("id", dto.getId());
%>			
		<script>
		alert('회원가입 감사합니다. 로그인 후 서비스를 이용하세요');
		location.href='login.jsp';
		</script>
<%		}else{//회원가입 실패
%>			
		<script>
		alert('회원가입 실패되었습니다. 다시 가입해 주세요');
		location.href="join.jsp";
		</script>
<%		}
	}else{ //중복된 ID
	%>
	<script>
	alert('중복된 id입니다. 다른아이디를 사용하세요');
	history.back();
	</script>
<%  } %>
	
</body>
</html>