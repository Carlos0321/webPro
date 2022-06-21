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
			$('img').mousedown(function () {
				$(this).attr('src','img/but2.gif');
				$(this).attr('alt','마우스 다운');
			}); //mousedown 이벤트
			$('img').mouseup(function () {
				$(this).attr('src','img/but1.gif');
				$(this).attr('alt','마우스 다운전');
			}); //mouseup 이벤트
		});
	</script>
</head>
<body>
<body>
	<img src="img/but1.gif" alt="마우스 다운전">
</body>
</html>