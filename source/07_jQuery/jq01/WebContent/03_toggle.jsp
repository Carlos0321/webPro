<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div#show{width:100px; height:100px; background-color:red;}
</style>
<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function () {
		$('#goShow').click(function() {
			$('#show').show();
		});
		$('#goHide').click(function() {
			$('#show').hide();
		});
		$('button').click(function () {
			$('#show').toggle();
		})
	});
</script>
</head>
<body>
	<button>토글링</button>
	<h1 id="goShow">보이게</h1>
	<h1 id="goHide">사라져</h1>
	<div id="show"></div>
</body>
</html>