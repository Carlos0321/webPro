<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function () {
			$('tr:even').css('background-color','gray'); //0번쨰
			$('tr:odd').css('backgroundColor' , '#FFFFAA');
			$('tr:nth-child(3n)').css('color','red'); //1부터 시작
			$('tr:eq(0)').css('background-color','black').css('color','white');
		});
	</script>
</head>
<body>
	<table>
		<tr><th>글번호</th><th>글제목</th><th>글쓴이</th><th>조회수</th></tr>
		<tr><th>4</th><th>제목4</th><th>홍사동</th><th>44</th></tr>
		<tr><th>3</th><th>제목3</th><th>홍삼동</th><th>20</th></tr>
		<tr><th>2</th><th>제목2</th><th>홍이동</th><th>22</th></tr>
		<tr><th>1</th><th>제목1</th><th>홍일동</th><th>2</th></tr>
	</table>
</body>
</html>