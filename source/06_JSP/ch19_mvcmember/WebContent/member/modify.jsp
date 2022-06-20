<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty member }"> <!-- 로그인 전이면 로그인 페이지로 가기 -->
		<script>location.href="loginView.do";</script>
	</c:if>
	<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="dbmPhoto" value="${member.mPhoto }">
	<table>
	<caption>정보수정</caption>
	<tr><th>아이디</th>
	<td><input type="text" name="mId" value=${member.mId } readonly="readonly"></td>
	<td rowspan="6"><img src="${conPath }/memberPhotoUp/${member.mPhoto }"></td></tr>
	
	<tr><th>비밀번호</th><td><input type="password" name="mPw" value=${member.mPw }></td></tr>
	<tr><th>이름</th><td><input type="text" name="mName" value=${member.mName }></td></tr>
	<tr><th>메일</th><td><input type="email" name="mEmail" value=${member.mEmail }></td></tr>
	<tr>
		<th>사진</th>
		<td colspan="2"><input type="file" name="mPhoto"></td>
	</tr>
	<tr><th>생년월일</th><td><input type="date" name="mBirth" value=${member.mBirth }></td></tr>
	<tr><th>주소</th><td><input type="text" name="mAddress" value=${member.mAddress }></td></tr>
	<tr><td colspan="3">
		<input type="submit" value="정보수정">
		<input type="reset" value="초기화">
		<input type="reset" value="이전" onclick="history.back()">
	</td></tr>
	</table>
	</form>
</body>
</html>