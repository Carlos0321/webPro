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
			var array = 
				[{name:'가메출판사',link:'http://www.kame.co.kr'},
				{name:'네이버',link:'http://www.naver.com'},
				{name:'다음',link:'http://www.daum.net'},
				{name:'구글',link:'http://www.google.com'},];
			var out = '';
			$.each(array, function (idx, item){
				out += '<h1><a href="'+item.link+'">'+item.name+'</a></h1>';
				//$('body').html($('body').html()+'<h1>TEST</h1>');
			});
			$('body').html(out);
		});
	</script>
</head>
<body>
<body>

</body>
</html>