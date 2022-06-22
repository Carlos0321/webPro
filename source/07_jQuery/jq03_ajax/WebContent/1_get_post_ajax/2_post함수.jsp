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
			$('button').click(function () {
				var mId= $('input[name="mId"]').val();
				//$.post(요청경로,요청파라미터들,callback)
				$.post('idConfirm.jsp',
						{mId : mId},
						function (data,status) {
							if(status=='success'){
								$('#result').html(data);
							}
						}); //객체 스타일 
			});
		});
		$('input[name="mId"]').keyup(function () {
			var mId= $('input[name="mId"]').val();
			//$.post(요청경로,요청파라미터들,callback)
			$.post('idConfirm.jsp',
					{mId : mId},
					function (data,status) {
						if(status=='success'){
							$('#result').html(data);
						}
					}); //객체 스타일 
		});
	</script>
</head>
<body>
<body>
	아이디<input type="text" name="mId"><button>중복체크</button><br>
	<span id="result"></span>
</body>
</html>