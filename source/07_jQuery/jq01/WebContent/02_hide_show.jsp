<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
	<script type="text/javascript">
		$(document).ready(function(){
			$('p').click(function(){
				$(this).hide();
			});
			$('button#hideP1').click(function(){
				$('#p1').hide();
			});
			$('button#hidePtag').click(function(){
				$('p').hide();
			});
			$('button#showPtag').click(function(){
				$('p').show();
			});
		});
	</script>
<body>
	<h1>이곳은 head</h1>
	<p>이 p태그를 클릭하면 숨겨져요</p>
	<p>이 p태그를 클릭하면 숨겨져요</p>
	<p id="p1">요거 p1 숨겨져요</p>
	
	<button id ="hideP1">p1 하나만 숨겨요</button>
	<button id="hidePtag">p태그를 다 숨겨요</button>
	<button id= "showPtag">p태그를 다 나타내요</button>
</body>
</html>