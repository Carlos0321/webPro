<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>게시판</caption>
		<tr>
			<td><a href="<%=conPath%>/board/writeForm.jsp">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>메일</th>
			<th>조회수</th>
		</tr>
		<%
			/******************************************************/
		//list.jsp 또는 list.jsp?pageNum=11 또는 list.jsp?pageNum=1
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1"; //전달받은 pageNum파라미터가 없으면 1페이지로 
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		/******************************************************/
		BoardDao dao = BoardDao.getInstance();
		int totalCnt = dao.getBoardTotalCnt(); //DB에 등록된 글 개수 
		if (totalCnt == 0) {
			out.println("<tr><tr colspan='5'>등록된 글이 없습니다.</td></tr>");
		} else {
			ArrayList<BoardDto> dtos = dao.listBoard(startRow, endRow);
			/*****/
			for (BoardDto dto : dtos) {
				//글번호 작성자 글제목 메일 조회수
				out.println("<tr><td>" + dto.getNum() + "</td><td>" + dto.getWriter() + "</td>");
				//글 제목 <td class='left'><img src='../img/hot.gif'>
				//<a href='/ch13_board/board/content.jsp'>글제목</a></td>
				out.println("<td class='left'>");
				//답변글 들여쓰기 - re.gif출력 
				if(dto.getRe_indent() > 0){
					int width = (dto.getRe_indent()-1) * 10;
					//<img src='../img/level.gif' width= width, height='10'>들여쓰기 공간 확보 
					//<img src='../img/re.gif' width=width, height='10'>
					out.println("<img src = '../img/level.gif' width='"+width+"' height='10'>");
					out.println("<img src = '../img/re.gif'>");
				}
				
				// 조회수가 10 초과시 hot.gif 이미지 출력
				if (dto.getReadcount() > 10) {
			out.println("<img src='" + conPath + "/img/hot.gif'>");
				}
				// <a href ="content.jsp?num=글번호&pageNum=현페이지수">글 제목</a>
				out.println("<a href='" + conPath + "/board/content.jsp?num=" + dto.getNum() +
				"&pageNum="+pageNum + "'>" + dto.getSubject() + "</a></td>");
				//메일, 조회수
				out.println("<td>" + (dto.getEmail() != null ? dto.getEmail() : "") + "</td><td>" + dto.getReadcount()
				+ "</td></tr>");
			}
		}
		%>
	</table>
	<div class="paging">
		<%
			int pageCnt = (int) Math.ceil((double) totalCnt / PAGESIZE); //페이지 개수(다음 블록 여부)	
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		if (startPage > BLOCKSIZE) {//이전 블록이 있는지 여부 <a href="list.jsp?pageNum=10">이전</a>
			out.println("[ <a href='list.jsp?pageNum=" + (startPage - 1) + "'>이전블럭</a> ]");
		}
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) { //페이지 수만 출력(빨간색) <b>2</b>
				out.println("<b>" + i + "</b>");
			} else {// a 태그를 포함한 페이지 수 출력 <a href='list.jsp?pageNum=10'>10</a>
				out.println("[ <a href='list.jsp?pageNum=" + i + "'>" + i + "</a> ]");
			}
		}
		if (endPage < pageCnt) {//다음 블록이 있는지 여부 <a href='list.jsp?pageNum=다음블록 첫 페이지'>다음</a>
			out.println("[ <a href='list.jsp?pageNum=" + (endPage + 1) + "'>다음</a> ]");
		}
		%>
	</div>
</body>
</html>