<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table td{width:100px; height:100px; background-color: #AAFFAA;}
	.tdRed{background-color: red;}
</style>
<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function () {
			$('td').each(function (idx,item) {
				$(this).click(function(){
					alert(idx+'번째 선택하셨군요');
					$('td').removeClass('tdRed');
					$(this).addClass('tdRed');
				});
			});
			/* $('td').click(function () {
				$('td').removeClass('tdRed'); //모든 td들 #AAFFAA색으로 원상 복구
				$(this).addClass('tdRed');
				var no = $(this).attr('id');
				alert(no+'번째를 선택하셨군');
			}); */
		});
	</script>
</head>
<body>
<body>
	<table>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
	</table>
</body>
</html>