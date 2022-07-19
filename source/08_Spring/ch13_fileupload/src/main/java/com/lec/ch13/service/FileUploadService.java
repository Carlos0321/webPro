package com.lec.ch13.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUploadService {
	public boolean fileUp(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		boolean isUpload = false;
		// 파일 업로드된 파일명 받아, 서버에 업로드, 프로젝트 폴더에 복사
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:\\Carlos\\webPro\\source\\08_Spring\\ch13_fileupload\\src\\main\\webapp\\upload/";
		String[] filenames= new String[3];
		int i = 0;
		Iterator<String> params = mRequest.getFileNames(); // file1,file2,file3
		while(params.hasNext()) {
			String param = params.next();
			
			MultipartFile mFile = mRequest.getFile(param);
			filenames[i] = mFile.getOriginalFilename(); //param으로 첨부한 파일의 오리지널 파일명
			System.out.println(i+"번째 파라미터 이름 : "+param + "파일명 : " + filenames[i]);
			if(filenames[i] !=null && !filenames[i].equals("")) { //첨부한 파일이 있을 경우 
				if(new File(uploadPath+filenames[i]).exists()) {
					filenames[i] = System.currentTimeMillis()+filenames[i];
				}// if - 중복된 파일명일 경우 변경 
				try {
					mFile.transferTo(new File(uploadPath+filenames[i])); //서버에 파일 저장
					System.out.println("서버에 저장된 파일 : "+uploadPath+ filenames[i]);
					System.out.println("백업 복사 파일 : " +backupPath+ filenames[i]);
					isUpload = filecopy(uploadPath+ filenames[i],backupPath+ filenames[i]);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}//if - 첨부여부
			i++;
		}//while 
		mav.addObject("filenames",filenames);
		
		return isUpload;
	}
	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		//복사
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int)file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;
				os.write(buff, 0 , nReadByte);
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return isCopy;
	}
}
