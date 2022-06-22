package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("img"); // 서버에 저장될 디렉토리
		int maxSize = 1024 * 1024; // 사진 업로드 제한
		String mPhoto = ""; // 첨부된 파일이 저장된 파일 이름
		// MultipartRequest mRequest = null; 순서 상관없음
		try {
			// mRequest 객체 생성 후 mPhoto 파일 이름 얻어옴
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			// while(params.hasMoreElements()) {
			String param = params.nextElement();
			mPhoto = mRequest.getFilesystemName(param);
			// }
			// mRequest를 이용하여 파라미터 받아와서 DB저장 -순서 상관 없음
			String mId = mRequest.getParameter("mId");
			String mPw = mRequest.getParameter("mPw");
			String mName = mRequest.getParameter("mName");
			String mEmail = mRequest.getParameter("mEmail");
			mPhoto = mPhoto == null ? "NOIMG.JPG" : mPhoto;
			String mBirthStr = mRequest.getParameter("mBirth");
			Date mBirth = null;
			if (!mBirthStr.equals("")) {
				mBirth = Date.valueOf(mBirthStr);
			}
			String mAddress = mRequest.getParameter("mAddress");
			MemberDao mDao = MemberDao.getInstance();
			// mid중복체크
			int result = mDao.mIdConfirm(mId);
			if (result == MemberDao.NONEXISTENT) { // 가입 가능한 mID 회원가입
				MemberDto member = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, null);
				// 회원가입
				result = mDao.joinMember(member);
				if (result == MemberDao.SUCCESS) {
					HttpSession session = request.getSession(); // 세션은 request로부터
					session.setAttribute("mId", mId);
					request.setAttribute("joinResult", "회원가입이 완료되었습니다");
				} else {
					request.setAttribute("joinErrorMsg", "정보가 너무 길어서 회원가입 실패");
				}
			} else {
				request.setAttribute("joinErrorMsg", "중복된 ID는 회원가입이 불가합니다");
			}
		} catch (Exception e) {

		}
		// 서버에 업로드 된 파일을 소스폴더로 복사
		File serverFile = new File(path + "/" + mPhoto);
		if (serverFile.exists() && !mPhoto.equals("NOIMG.JPG")) {
			InputStream is = null; // 선언하는 이유는 finally에서 close해야됨
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream(
						"D:/Carlos/webPro/source/06_JSP/model2ex/WebContent/img/" + mPhoto);
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int readByteCnt = is.read(bs);
					if (readByteCnt == -1)
						break;
					os.write(bs, 0, readByteCnt);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();

				} catch (IOException e) {

				}
			}
		}
	}
}
