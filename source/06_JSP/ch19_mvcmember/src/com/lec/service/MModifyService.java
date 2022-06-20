package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize =1024*1024; 
		String mPhoto = "";
		try {
			//mRequest 객체 생성한 후 파일 이름 받아오기
			MultipartRequest mRequest = new MultipartRequest(request, path,maxSize,"utf-8",new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement(); // mPhoto
			mPhoto = mRequest.getFilesystemName(param);
			String mId = mRequest.getParameter("mId");
			String mPw = mRequest.getParameter("mPw");
			String mName = mRequest.getParameter("mName");
			String mEmail = mRequest.getParameter("mEmail");
			//정보 수정시 사진파일을 첨부안하면 dbmPhoto(원래 사진파일)로
			String dbmPhoto = mRequest.getParameter("dbmPhoto");
			mPhoto = (mPhoto ==null) ? dbmPhoto : mPhoto;
			
			String mBirthStr = mRequest.getParameter("mBirth");
			Date mBirth = null;
			if(!mBirthStr.equals("")) {
				mBirth = Date.valueOf(mBirthStr);
			}
			String mAddress = mRequest.getParameter("mAddress");
			MemberDao mDao = MemberDao.getInstance();
			//수정
			
			MemberDto member = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, null);
			int result = mDao.modifyMember(member);
			if(result==MemberDao.SUCCESS) {//수정 성공시 세션도 수정
				HttpSession session= request.getSession();
				session.setAttribute("member", member);
				request.setAttribute("modifyResult", "회원정보 수정 성공");
			}else {
				//수정 실패시
				request.setAttribute("modifyResult","회원정보 수정 실패");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		// 업로드된 파일을 소스폴더로 복사
				File serverFile = new File(path+"/"+mPhoto);
				if(!mPhoto.equals("NOIMG.JPG") && serverFile.exists()) {
					InputStream is = null;
					OutputStream os = null;
					try {
						is = new FileInputStream(serverFile);
						System.out.println(1);
						os = new FileOutputStream("D:\\Carlos\\webPro\\source\\06_JSP\\ch19_mvcmember\\WebContent\\memberPhotoUp\\"+mPhoto);
						System.out.println(2);
						byte[] bs = new byte[(int)serverFile.length()];
						while(true) {
							int readbyteCnt = is.read(bs);
							if(readbyteCnt == -1) break;
							os.write(bs, 0, readbyteCnt);
						}
						System.out.println(3);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}finally {
						try {
							if(os!=null) os.close();
							if(is!=null) is.close();
						} catch (Exception e) {}
					}//try-catch-finally
				}
	}

}
