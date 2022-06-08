<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
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
	String path = request.getRealPath("fileUpFolder");
	int maxSize = 1024*1024*10 ; //최대 업로드 용량을 10mb
	String[] filename = {"","",""};
	String[] originFilename={"","",""};
	try{
		MultipartRequest mRequest = new MultipartRequest(request,path,maxSize,"utf-8",
									new DefaultFileRenamePolicy());
		Enumeration<String> paramNames = mRequest.getFileNames();//파라미터 이름들 file1, file2, file3
		int idx = 0;
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement(); //파라미터 이름들 순차대로 받아오기
			filename[idx] = mRequest.getFilesystemName(param); //해당 파라미터 이름으로 저장된 파일 이름
			originFilename[idx] = mRequest.getOriginalFileName(param);
			System.out.println(idx+"번쨰 파라미터 :"+param+",저장파일 :"+filename[idx]+",원파일명 :"+originFilename[idx]);
		idx++;
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}//try
	//서버에 저장된 파일을 소스폴더로 복사
	for(String f : filename){
		if(f!=null){
			//파일 복사 
			InputStream is = null; //서버에서 input받기 위해 
			OutputStream os = null; //소스 폴더로 복사하기 위해 output
			try{
				File serverfile = new File(path+"/"+f);
				if(serverfile.exists()){ //첨부한 파일이 있는지  첨부하지 않았으면 file copy 안함
					is = new FileInputStream(serverfile); //원본 파일
					os = new FileOutputStream("D:/Carlos/webPro/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/"+f); //복사될 파일 
				byte[] bs = new byte[(int)serverfile.length()]; //서버파일 크기 만큼 바이트로 읽기 
				while(true){
					int nReadCnt = is.read(bs); //서버파일을 읽기 통채로 한번 읽음  파일의 끝이 아닐경우 읽어들인 byte수 : nReadCnt
					if(nReadCnt == -1) break; //파일의 끝인가 ? 물음 
					os.write(bs,0,nReadCnt); // 바이트의 처음배열(indext)부터 끝까지  		
				}//while
					System.out.println("서버 첨부&복사 완료");
				}//if
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}
	}
	%>
	<%=Arrays.toString(filename) %>
	<%=Arrays.toString(originFilename) %>
	<h2>파일1 첨부내용</h2>
	<h5><%=path %>/<%=filename[2] %></h5>
	<img src="../fileUpFolder/<%=filename[2] %>" alt="첫번째 첨부파일">
	
	<h2>파일2 첨부 파일</h2>
	<h5><%=path %>/<%=filename[1] %></h5>
	<img src="../fileUpFolder/<%=filename[1] %>" alt="두번째 첨부파일">

	<h2>파일3 첨부 파일</h2>
	<h5><%=path %>/<%=filename[0] %></h5>
	<img src="../fileUpFolder/<%=filename[0] %>" alt="세번째 첨부파일">
</body>
</html>