<%@page import="java.util.Enumeration"%>
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
	<% //특정 세션 속성값 가져오기
	String sessionName = (String)session.getAttribute("sessionName");
	Integer myNum = (Integer)session.getAttribute("myNum");
	//session.setAttribute("myNum", 123);
	out.println("sessionName : "+sessionName+"<br>");
	out.println("myNum : "+myNum+"<br>");
	out.println("id : "+session.getAttribute("id")+"<br>"); //추가한 속성이 없을 경우 null
	
	// 모든 세션 속성 리스트 출력
	out.println("<h4>모든 세션 속성들 list </h4>");
	Enumeration<String> sAttrNames = session.getAttributeNames();
	//세션 리스트 출력 로직 
	int cnt = 0; //속성이 몇개인지 확인하기 위해 
	while(sAttrNames.hasMoreElements()){
		String sname = sAttrNames.nextElement(); //세션 (속성)이름
		String svalue= session.getAttribute(sname).toString(); //세션(속성)값
		out.println(sname+"(세션이름)/"+svalue+"(세션값)<br>");
		cnt++;
	}
	if(cnt==0){
		out.println("추가된 세션 속성이 없습니다.");
	}
	//특정 세션 삭제하기(로그아웃시 사용)
		session.removeAttribute("myNum"); //myNum 세션 속성 삭제
		out.println("<h4>myNum 세션 삭제 후 list </h4>");
		sAttrNames = session.getAttributeNames();
		//세션 리스트 출력 로직 
		 cnt = 0; //속성이 몇개인지 확인하기 위해 
		while(sAttrNames.hasMoreElements()){
			String sname = sAttrNames.nextElement(); //세션 (속성)이름
			String svalue= session.getAttribute(sname).toString(); //세션(속성)값
			out.println(sname+"(세션이름)/"+svalue+"(세션값)<br>");
			cnt++;
		}
		if(cnt==0){
			out.println("추가된 세션 속성이 없습니다.");
		}
		//모든 세션 삭제하기(로그아웃시 사용)
		session.invalidate(); //setAttribute했던 모든 세션 속성값 다 삭제
		if(request.isRequestedSessionIdValid()){//유효한 세션속성이 있는지 여부
			out.println("session valid<br>");
		}else{
			out.println("session invalid<br>");
		}
		out.println("<h4>세션ID :"+session.getId()+"</h4>");
		out.println("<h4>세션의 유효시간 : "+session.getMaxInactiveInterval()+"<br>");
		
	%>
</body>
</html>