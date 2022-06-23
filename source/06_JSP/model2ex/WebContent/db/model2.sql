-- dao에 들어갈 query
----------------------------------------------------------------------
--                          MVC_MEMBER                              --
----------------------------------------------------------------------
-- (1) 로그인
SELECT * FROM MVC_MEMBER WHERE mID='aaa' and mPW='1';
-- (2) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
SELECT * FROM MVC_MEMBER WHERE MID='aaa';
-- (3) 회원id 중복체크
SELECT * FROM MVC_MEMBER WHERE MID='aaa';
-- (4) 회원가입
SELECT * FROM MVC_MEMBER WHERE MID='aaaa';
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('aaa','1','홍길동','hong@naver.com','NOIMG.JPG','1998/12/12','강남');
-- (5) 회원정보 수정
UPDATE MVC_MEMBER SET MPW = '1',
                    MNAME = 'HONG',
                    MEMAIL = 'yi@naver.com',
                    MPHOTO = 'NOIMG.JPG',
                    MBIRTH = '1991/12/12',
                    MADDRESS = '서울'
        WHERE mId='aaa';
-- (6) 회원리스트(top-N구문)
SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
                        (SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC) A)
        WHERE RN BETWEEN 3 AND 5;
-- (7) 회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
COMMIT;
-- (8) 회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID = 'bbb';
ROLLBACK;
-- (9) 이메일 중복체크
SELECT * FROM MVC_MEMBER WHERE mEMAIL = 'go@naver.com';

select * from mvc_member order by mrdate desc;
----------------------------------------------------------------------
--                           FILEBOARD                              --
----------------------------------------------------------------------
-- (1) 글목록(startRow부터 endRow까지) - 글번호, 작성자이름, ...
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID 
                ORDER BY FGROUP DESC, FSTEP; -- 출력 기준
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID 
                ORDER BY FGROUP DESC, FSTEP) A)
    WHERE RN BETWEEN 1 AND 11;
-- (2) 글갯수
SELECT COUNT(*) FROM FILEBOARD;

-- (3) 글쓰기(원글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME,  
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','title','content',null, 
        FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.10.151');
-- (4) FHit 하나 올리기(1번글 조회수 하나 올리기)
UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=1;
-- (5) bId로 글 dto보기
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE M.MID=F.MID AND FID=1;
-- (6) 글 수정하기(FId, FTitle, FContent, FILENAME,  FIp, FDATE)
UPDATE FILEBOARD SET FTITLE = '바뀐제목',
                    FCONTENT = '본문',
                    fFILENAME = NULL,
                    FIP = '192.168.151.10',
                    FRDATE = SYSDATE
            WHERE FID = 1;
-- (7) 글 삭제하기(bId로 삭제하기)
COMMIT;
DELETE FROM FILEBOARD WHERE FID=3;
ROLLBACK;
--  (8) 답변글 추가전 STEP a 수행
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>0;
-- (9) 답변글 쓰기
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','reply','content', null,
        1, 1, 1, '192.168.10.151');
commit;
----------------------------------------------------------------------
--                          ADMIN TABLE                             --
----------------------------------------------------------------------
-- (1) admin loginCheck
SELECT * FROM ADMIN WHERE AID='admin' AND APW='111';
-- (2) 로그인 후 세션에 넣을 용도 : admin aid로 dto 가져오기
SELECT * FROM ADMIN WHERE AID='admin';