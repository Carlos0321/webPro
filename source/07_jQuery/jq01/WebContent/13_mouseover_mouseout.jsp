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
			var outImg = ["img/0out.jpg", "img/1out.jpg", "img/2out.jpg","img/3out.jpg"];
			var overImg = ["img/0over.jpg", "img/1over.jpg", "img/2over.jpg","img/3over.jpg"];
			$('img').each(function (idx,item) {
				$(this).mouseover(function () {
					$(this).attr('src', overImg[idx]);
				});
				$(this).mouseout(function () {
					$(this).attr('src',outImg[idx]);
				});
			});
			/* $('img').mouseover(function () {
				// over된 img의 src : img/?out.jpg => src을 img/?over.jpg
				var idx = $(this).attr('src').substring(4,5); //4번째부터 5번째 앞까지	
				$(this).attr('src','img/'+idx+'over.jpg');
			}); //mouseover 이벤트
			$('img').mouseout(function () {
				var idx = $(this).attr('src').substring(4,5);
				$(this).attr('src','img/'+idx+'out.jpg');
			}) */
		});
	</script>
</head>
<body>
<body>
	<img src="img/0out.jpg">
	<img src="img/1out.jpg">
	<img src="img/2out.jpg">
	<img src="img/3out.jpg">
</body>
</html>