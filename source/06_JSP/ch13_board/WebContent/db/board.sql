--table drop & create
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM NUMBER(5,0) PRIMARY KEY,             --글번호
    WRITER VARCHAR2(30) NOT NULL,            --글쓴이
    SUBJECT VARCHAR2(100) NOT NULL,         --글제목
    CONTENT VARCHAR2(4000) NOT NULL,      --본문
    EMAIL VARCHAR2(30),                              --작성자 이메일
    READCOUNT NUMBER(5)  DEFAULT 0 ,       --글 HIT 조회수
    PW  VARCHAR2(30) NOT NULL,                 --글 삭제시 쓸 비밀번호
    REF  NUMBER(5) NOT NULL,                      --글 그룹(원글일 경우, 글번호로/답변글인 경우 원글의 글번호로)  
    RE_STEP NUMBER(5) NOT NULL,                 --그룹내 출력 순서(0) 
    RE_INDENT NUMBER NOT NULL,                --글 LIST 출력시 제목 들여쓰기 정도(원글0)
    IP  VARCHAR2(20) NOT NULL,                    --글작성시 컴퓨터 IP주소                   
    RDATE DATE DEFAULT SYSDATE NOT NULL --글쓴 시점(날짜+시간)
     );

-- 1.글갯수
SELECT COUNT(*) FROM BOARD;
-- 2.글목록 (최신글이 위로)
SELECT * FROM BOARD ORDER BY NUM DESC;
SELECT * FROM BOARD ORDER BY REF DESC;
commit;
-- 3.글쓰기(원글쓰기)
        --글쓰기시 글번호 생성
        SELECT NVL (MAX(NUM),0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES( (SELECT NVL (MAX(NUM),0)+1 FROM BOARD),'홍길동','글제목1','본문입니다\n금요일방가',NULL,
    '1',(SELECT NVL (MAX(NUM),0)+1 FROM BOARD),0,0,'192.168.10.3');
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES( (SELECT NVL (MAX(NUM),0)+1 FROM BOARD),'홍길동','글제목2','본문입니다',NULL,
    '1',(SELECT NVL (MAX(NUM),0)+1 FROM BOARD),0,0,'192.168.10.3');
    INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES( (SELECT NVL (MAX(NUM),0)+1 FROM BOARD),'홍길동','글제목3','본문입니다',NULL,
    '1',(SELECT NVL (MAX(NUM),0)+1 FROM BOARD),0,0,'192.168.10.3');
-- 4.글 번호로 글(DTO) 가져오기 = 글 상세보기
SELECT * FROM BOARD WHERE NUM=1;
-- 5.조회수 올리기 
UPDATE BOARD SET READCOUNT  = READCOUNT +1 WHERE NUM =1;
-- 6.글 수정하기
UPDATE BOARD SET SUBJECT = '수정된제목1', 
                            CONTENT = '수정된 본문입니다\n와우',
                            EMAIL='hong@hong.com',  
                            PW='1',
                            IP= '127.0.0.1'
                            WHERE NUM=1;
-- 7.글 삭제 (비밀번호)
DELETE FROM BOARD WHERE NUM=1 AND PW='1';

SELECT * FROM BOARD;
ROLLBACK;
-- 8.글 조회수 조작
UPDATE BOARD SET READCOUNT = 12 WHERE NUM =4;
COMMIT;