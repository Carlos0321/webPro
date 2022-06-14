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
	<h2>표현식 태그 이용</h2>
	<p>산술연산 : 10+1 = <%=10+1 %></p>
	<p>산술연산 : 10/0.0 = <%=10/0.0 %></p> <!-- 0으로 나누면 에러, 0.0으로 나누면 무한대 -->
	<p>관계연산 : 1==2 => <%=1==2 %></p>
	<p>관계연산 : 1!=2 => <%=1!=2 %></p>
	<p>관계연산 : 1 &lt;2 => <%=1<2 %></p> <!-- <라는 태그라고 인식할 수도 있음 -->
	<p>조건연산 : <%=(1>2)? "1이 2보다 큽니다" : "1이 2보다 크지 않습니다" %></p>
	<p>논리연산 : (1>2)||(1<2)=<%=(1>2)||(1<2)%></p>
	<p>로그인 여부 <%=session.getAttribute("customer")==null?"로그인전":"로그인후" %></p>
	<p>로그인 여부 <%=session.getAttribute("customer")!=null?"로그인후":"로그인전" %></p>
	<p>pageNum 파라미터 여부 <%=request.getParameter("pageNum")==null? "pagenNum 안 옴":"pageNum옴" %></p>
	<p>name 파라미터 : <%=request.getParameter("name")%></p>
	<hr>
	<h2>EL표기법을 이용(표현식 안에 쓸 수 있는 연산자는 다 사용 가능)</h2>
	<p>산술연산 : 10+1 = ${10+1 }</p>
	<p>산술연산 : 10/0.0 = ${10/0.0 }</p> <!-- 0으로 나누면 에러, 0.0으로 나누면 무한대 -->
	<p>관계연산 : 1==2 => ${1 eq 2 }></p>
	<p>관계연산 : 1!=2 => ${1!=2 }</p>
	<p>관계연산 : 1 &lt;2 => ${1<2 }</p> <!-- <라는 태그라고 인식할 수도 있음 -->
	<p>조건연산 : ${(1>2)? "1이 2보다 큽니다" : "1이 2보다 크지 않습니다" }</p>
	<p>논리연산 : (1>2)||(1<2)=${(1>2)||(1<2) }</p>
	<p>로그인 여부 ${customer ==null ? "로그인전":"로그인후" }</p>
	<p>로그인 여부 ${customer eq null ? "로그인전":"로그인후" }</p>
	<p>로그인 여부 ${empty customer ? "로그인전":"로그인후" }</p>
	<p>로그인 여부 ${not empty customer ? "로그인후":"로그인전" }</p>
	<p>pageNum 파라미터 여부 ${ empty param.pageNum ? "pagenNum 안 옴":"pageNum옴" }</p>
	<p>name 파라미터 : ${param.name }</p>
	<p>name 파라미터를 대문자로  : ${param.name.toUpperCase() }</p><!-- 해당 파라미터가 없어도 예외 발생 안 함 -->
</body>
</html>