<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
	String path = request.getRealPath("fileboardUpload");
	int maxSize = 1024*1024*5 ; //업로드 제한 용량 : 5MB
	String ffilename = null ; //첨부파일이 서버에 저장된 이름 
	MultipartRequest mRequest = null;
	try{
		mRequest = new MultipartRequest(request,path,maxSize,"utf-8", new DefaultFileRenamePolicy());
		Enumeration<String> params = mRequest.getFileNames();
		String param = params.nextElement(); //파라미터 
		ffilename = mRequest.getFilesystemName(param);
		
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
	if(ffilename!=null){ //서버에서 소스 폴더로 파일 복사
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path+"/"+ffilename);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream("D:/Carlos/webPro/source/06_JSP/model1ex/WebContent/fileboardUpload/"+ffilename);
			byte[] bs = new byte[(int)serverFile.length()];
			int readByteCnt;
			while((readByteCnt = is.read(bs))!=-1){
				os.write(bs,0,readByteCnt);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(os!=null) os.close();
			if(is!=null) is.close();
		}//try - finally
	}//if
	//파라미터 정보 받아오기 
	String pageNum = mRequest.getParameter("pageNum");
	String dbfilename = mRequest.getParameter("dbfilename");
	int fnum = Integer.parseInt(mRequest.getParameter("fnum"));
	String fsubject = mRequest.getParameter("fsubject");
	ffilename = (ffilename==null)? dbfilename : ffilename;	
	String fcontent = mRequest.getParameter("fcontent");
	String fpw = mRequest.getParameter("fpw");
	String fip = request.getRemoteAddr();	
	FileboardDto fDto = new FileboardDto(fnum,null,fsubject,fcontent,ffilename,fpw,0,0,0,0,fip,null);
	FileboardDao fDao = FileboardDao.getInstance();
	int result = fDao.updateBoard(fDto);
	if(result ==FileboardDao.SUCCESS){
	%>
	<script>
	alert('글 수정 완료');
	location.href='fboardList.jsp?pageNum=<%=pageNum%>';
	</script>
	<%}else{ %>
	<script>
	alert('글 수정 실패');
	history.back();
	</script>
	<%} %>
	
</body>
</html>