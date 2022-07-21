<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script
  src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	$(document).ready(function () {
		$('form').submit(function () {
			var msg = $('span').text();
			if(!msg){
				alert('중복확인 하세요');
				return flase;
			}else if(msg !='사용가능한 사번입니다'){
				alert('사용가능한 사번으로 등록하세요');
				frm.empno.focus();
				return false;
			}
		});
	});
	function chk() {
		if(! frm.empno.value){
			alert('사번입력 후 중복확인 하세요');
			frm.empno.focus();
		}else{
			var empno = frm.empno.value;
			location.href= 'confirmNo.do?empno='+empno;
		}
	}
	</script>
</head>
<body>
		<c:if test="${not empty writeResult }">
			<script>alert('${writeResult}');</script>
		</c:if>
	<form action="write.do" method="post" name="frm">
		<table>
			<caption>사원 등록</caption>
			<tr>
				<th>사번</th>
				<td>
					<input type="number" name="empno" required="required" value="${param.empno }">
					<input type="button" value="중복확인" onclick="chk()" class="btn" ><br>
					<span><c:if test="${not empty msg }">${msg }</c:if></span>
				</td>
			</tr>
			<tr><th>이름</th><td><input type="text" name="ename"></td></tr>
			<tr><th>직책</th><td><input type="text" name="job"></td></tr>
			<tr>
				<th>관리자</th>
				<td>
					<select name="mgr">
					<c:forEach items="${managerList }" var="mgrEmp">
						<option value="${mgrEmp.empno }">${mgrEmp.empno } - ${mgrEmp.ename }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr><th>입사일</th>
				<td><input type="date" name="tempHiredate" value="<%=new Date(System.currentTimeMillis())%>"></td>
			</tr>
			<tr><th>급여</th><td><input type="number" name="sal" value="800"></td></tr>
			<tr><th>상여</th><td><input type="number" name="comm" value="0"></td></tr>
			<tr><th>부서코드</th>
				<td>
					<select name="deptno">
						<c:forEach items="${deptList }" var="dept">
							<option value="${dept.deptno }">${dept.deptno }-${dept.dname }-${dept.loc }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="등록" class="btn"></td></tr>
		</table>
	</form>
</body>
</html>