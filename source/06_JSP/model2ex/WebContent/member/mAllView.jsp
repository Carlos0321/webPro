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
	<style>
	#content_form {
		width: 800px; height:370px;
		margin: 130px auto 0px;
	}
</style>
</head>
<body>
	<c:if test="${not empty adminLoginResult }">
		<script type="text/javascript">
			alert('${adminLoginResult}');
		</script>
	</c:if>
	<c:if test="${not empty adminLoginError }">
		history.back();
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id = "content_form">
		<table>
			<caption>전체회원보기</caption>
			<tr>
				<c:forEach var="dto" items="${mAllView }">
					<td>
					<img src="${conPath }/memberPhotoUp/${dto.mPhoto}" alt="${dto.mName }등록사진" width="150"><br>
					${dto.mName }<br>
					(${dto.mId })
					</td>
				</c:forEach>
			</tr>
		</table>
		<div class="paging">
		<a href="${conPath }/allView.do?pageNum=1">&lt;&lt;</a>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${startPage>BLOCKSIZE }">
			<a href="${conPath }/allView.do?pageNum=${startPage-1}">&lt;</a>
		</c:if>
		<c:if test="${startPage<=BLOCKSIZE }">
			&lt;
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i == pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/allView.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/allView.do?pageNum=${endPage+1}">&gt;</a>
		</c:if>
		<c:if test="${endPage == pageCnt }">
			&gt;
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<a href="${conPath }/allView.do?pageNum=${pageCnt}">&gt;&gt;</a>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
	</div>
</body>
</html>