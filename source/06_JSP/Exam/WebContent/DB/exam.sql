DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
     cID         VARCHAR2(50) PRIMARY KEY,
    CPW         VARCHAR2(50) NOT NULL,
    cNAME       VARCHAR2(50) NOT NULL , 
    cEMAIL       VARCHAR2(50),
    cIMAGE       VARCHAR2(50),
    cADDRESS    VARCHAR2(250),
    cBIRTH      DATE  NOT NULL
);
DROP SEQUENCE FILEBOARD_SEQ;
DROP TABLE FBOARD;
SELECT * FROM CUSTOMER;
SELECT * FROM FBOARD;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
CREATE TABLE FBOARD (
    FNUM NUMBER(7) PRIMARY KEY, --글번호
    CID VARCHAR2(50) REFERENCES CUSTOMER(CID), --작성자 ID
     AID  VARCHAR2(50) REFERENCES ADMIN(AID), --관리자 ID
    FTITLE VARCHAR2(250) NOT NULL, --글 제목
    FCONTENT VARCHAR2(4000), --본문
    FFILENAME VARCHAR2(50), --첨부파일명
    FPW VARCHAR2(50) NOT NULL, --비번
    FHIT NUMBER(7) DEFAULT 0 NOT NULL, --조회수
    FREF NUMBER(7) NOT NULL, --글 그룹
    FRE_STEP NUMBER(7) NOT NULL, --그룹내 출력순서
    FRE_LEVEL NUMBER(7) NOT NULL, --들여쓰기 정도
    FIP VARCHAR2(50) NOT NULL, --글쓴 컴퓨터 IP
    FRDATE DATE DEFAULT SYSDATE NOT NULL  --등록일 
   
);
CREATE TABLE ADMIN(
    AID VARCHAR2(50) PRIMARY KEY,
    APW VARCHAR2(50) NOT NULL
);

--CUSTOMER 
--회원가입시 CID 중복체크
SELECT * FROM CUSTOMER WHERE CID = 'MAX1';
--회원가입
INSERT INTO CUSTOMER (CID, CPW, CNAME, CEMAIL,CIMAGE,CBIRTH,CADDRESS)
    VALUES('MAX1', '111', '김김김', 'ASD@ASD.COM', 'IMAGE.JPG' ,'1993-12-12','서울');
    INSERT INTO CUSTOMER (CID, CPW, CNAME, CEMAIL,CIMAGE,CBIRTH,CADDRESS)
    VALUES('MAX2', '111', '민민민', 'ASD@ASD.COM', 'IMAGE.JPG' ,'1993-12-12','서울');
    INSERT INTO CUSTOMER (CID, CPW, CNAME, CEMAIL,CIMAGE,CBIRTH,CADDRESS)
    VALUES('MAX3', '111', '우우우', 'ASD@ASD.COM', 'IMAGE.JPG' ,'1993-12-12','서울');
--로그인
SELECT * FROM CUSTOMER WHERE CID='MAX1' AND CPW ='111';
--회원정보 수정
UPDATE CUSTOMER SET CPW = '1111', CNAME='김토치' , CEMAIL='DSA@ASD.COM',
CIMAGE ='NOTHING.JPG' , CADDRESS ='강남'  WHERE CID = 'MAX1';

--FBOARD
--글쓰기(회원)
INSERT INTO FBOARD (fNUM, cID, FTITLE, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'MAX1', '시험중','','본문','111', FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.12.12');
INSERT INTO FBOARD (fNUM, cID, FTITLE, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'MAX2', '시험중1','','본문1','111', FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.12.13');
INSERT INTO FBOARD (fNUM, cID, FTITLE, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'MAX3', '시험중2','','본문2','111', FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.12.14');
--글쓰기(관리자) 
INSERT INTO FBOARD (fNUM, AID, FTITLE, fCONTENT, fFILENAME, fPW, 
                fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ADMIN1', '공지사항','','본문2','123', FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.12.14');
--답변글 쓰기 전 
UPDATE FBOARD SET FRE_STEP = FRE_STEP + 1 WHERE FREF = 1 AND FRE_STEP > 0 ;
--답변글 쓰기
INSERT INTO FBOARD (FNUM,AID,FTITLE,FCONTENT,FFILENAME,FPW,FREF,FRE_STEP,FRE_LEVEL,FIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL,'ADMIN1','답변글','답',NULL,'123',1,1,1,'192.168.15.17');
SELECT * FROM FBOARD WHERE FREF = 1 
    ORDER BY FRE_STEP;
--글목록(전체)
SELECT F.*, CNAME FROM FBOARD F, CUSTOMER C
    WHERE F.CID =C.CID ORDER BY FREF DESC , FRE_STEP;

--글 목록(페이징)     
SELECT * 
    FROM(SELECT ROWNUM RN, A.*
        FROM (SELECT F.* , CNAME, CEMAIL
                     FROM FBOARD F, CUSTOMER C
                     WHERE F.CID=C.CID
                     ORDER BY FREF DESC, FRE_STEP) A)
       WHERE RN BETWEEN 2 AND 3 ;
--글 보기 
SELECT F.*, CNAME , CEMAIL FROM FBOARD F, CUSTOMER  C 
    WHERE F.CID=C.CID AND FNUM = 1; 
--글 수정     
UPDATE FBOARD SET FTITLE = '수정수정' ,FCONTENT='수정된 본문', FPW='123' WHERE FNUM = 7;
DELETE FROM FBOARD WHERE FNUM = 7 AND FPW ='123';
COMMIT;
--ADMIN
--관리자 등록
INSERT INTO ADMIN(AID,APW) VALUES('ADMIN1' ,'123');
--관리자 로그인 
SELECT * FROM ADMIN WHERE AID ='ADMIN1' AND APW='123';