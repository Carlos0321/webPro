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
			$('button').click(function () { // IdConfirm.jsp?mId=aaa
				var mId = $('#mId').val();
			/*
				$.get(요청경로,callback(data,status)){
				data : 요청경로 수행 결과 
				status : success / fail
			})
			*/
				$.get('idConfirm.jsp?mId='+mId, function(data,status){
					if(status =='success'){
						$('#result').html(data);
					}
				});
			}); //버튼의 click이벤트
			$('#mId').keyup(function () {
				var mId = $('#mId').val();
				if(mId.length<2){
					$('#result').html('id는 2글자 이상입니다');
				}else{
					$.get('idConfirm.jsp?mId='+mId, function(data,status){
						if(status =='success'){
							$('#result').html(data);
						}
					});
				}
			});
		});
	</script>
</head>
<body>
<body>
	<p>아이디<input type="text" name="mId" id="mId"> <button>중복체크</button></p>
	<span id="result"></span>
</body>
</html>