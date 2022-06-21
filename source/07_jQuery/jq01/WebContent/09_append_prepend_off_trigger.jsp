<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.red{color:red;}
	.blue{color:blue}
</style>
<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function () {
			var h1HitCnt = 0;
			$('#h2').click(function () {
				$(this).prepend('<b class="red">♥</b>');
				$(this).append('<b class="blue">♥</b>');
			});
			$('#h1').click(function () {
				h1HitCnt ++;
				if(h1HitCnt < 6){
					$(this).prepend('<span class="red">♡</span>');
					$(this).append('<span class="red">♡</span>');
				}else{
					$('#h1').off(); //클릭한 횟수가 6회가 되면 이벤트 제거 
				}
			}); //#h1 이벤트
			setInterval(function () {
				$('h1').first().trigger('click'); //강제 이벤트 발생
			}, 2000);
		});
	</script>
</head>
<body>
<body>
	<h1 id="h1">start1</h1>
	<h1 id="h2">start2</h1>
</body>
</html>