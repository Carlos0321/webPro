<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('#msg').html('<b>Hello, jQuery</b>');
		//$('p#msg').text('<b>Hello, jQuery</b>');
		//var msg = $('#msg').html(); //msg = '<b>Hello, jQuery</b>'
		var msg = $('#msg').text(); //msg = 'Hello',jQuery
		$('input[name="msg"]').val('Hello, jQuery2');
		msg = $('input[name="msg"]').val();
		alert(msg);
	});
</script>
</head>
<body>
	<p id="msg"></p>
	<p>메세지<input type="text" name="msg"></p>
</body>
</html>