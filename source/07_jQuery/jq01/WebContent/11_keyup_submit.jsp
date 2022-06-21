<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	p:last-child{
		padding-left: 90px;
	}
</style>
<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function () {
			$('input[name="pwChk"],input[name="pw"]').keyup(function () {
				var pw =$('input[name="pw"]').val();
				var pwChk =$('input[name="pwChk"]').val();
				if(pw == pwChk){
					$('.result').text('비밀번호 일치');
				}else{
					$('.result').html('<b>비밀번호 불일치</b>')
				}
			}); //pw check
			$('form').submit(function () {
				var resultMsg = $('.result').text().trim();
				if(resultMsg != '비밀번호 일치'){
					alert('비밀번호를 확인하세요');
					$('input[name="pw"]').val('');
					$('input[name="pwChk"]').val('');
					$('.result').html('');
					$('input[name="pw"]').focus();
					return false;
				}
			});
		});
	</script>
</head>
<body>
<body>
	<form action="">
		<p>ID<input type="text" name="id"></p>
		<p>PW<input type="password" name="pw"></p>
		<p>PW<input type="password" name="pwChk"></p>
		<p class="result">&nbsp;&nbsp;</p>
		<p><input type="submit" value="가입하기"></p>
	</form>
</body>
</html>