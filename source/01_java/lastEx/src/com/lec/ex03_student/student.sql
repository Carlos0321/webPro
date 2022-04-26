--테이블 만들기 
DROP TABLE STUDENT;
DROP TABLE MAJOR;
CREATE TABLE MAJOR (
    MNO NUMBER(2) PRIMARY KEY,
    MNAME VARCHAR2(50) NOT NULL
);


CREATE TABLE STUDENT(
    SNO NUMBER(8) PRIMARY KEY,
    SNAME  VARCHAR2(20) NOT NULL,
    MNO NUMBER(2) REFERENCES MAJOR(MNO),
    SCORE NUMBER(3) DEFAULT 0 CHECK(SCORE BETWEEN 0 AND 100),
    SEXPEL NUMBER(1) DEFAULT 0 CHECK(SEXPEL=0 OR SEXPEL =1));
    
DROP SEQUENCE STUDENT_SEQ;  
DROP SEQUENCE MAJOR_SEQ;

CREATE SEQUENCE STUDENT_SEQ
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;

INSERT INTO MAJOR VALUES(1, '컴퓨터공학');
INSERT INTO MAJOR VALUES(2, '산업경영공학');
INSERT INTO MAJOR VALUES(3, '빅데이터학부');
INSERT INTO MAJOR VALUES(4, '인공지능학과');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),'조승우',1,90,1);
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),'정우성',3,97,1);
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),'배수지',2,95,1);
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),'아이린',1,90,0);
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),'홍길동',4,99,1);
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),'김제적',1,10,0);
SELECT * FROM STUDENT;
COMMIT;
--0 첫 화면에 전공이름들 콤보박스에 추가 
SELECT MNAME FROM MAJOR;
--1.학번 검색 
SELECT SNO, SNAME, MNAME, SCORE FROM MAJOR M , STUDENT S
    WHERE M.MNO = S.MNO AND SNO =2022001;
--2. 이름 검색   
SELECT SNO, SNAME, MNAME, SCORE FROM MAJOR M , STUDENT S
    WHERE M.MNO = S.MNO AND SNAME ='배수지';
--3. 전공 검색 
SELECT ROWNUM RANK , SNAME||'('||SNO||')' 이름, MNAME||'('||M.MNO||')'전공,SCORE 
    FROM MAJOR M, STUDENT S
    WHERE M.MNO = S.MNO AND MNAME = '컴퓨터공학';
--4. 학생입력
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),'김민우',
(SELECT MNO FROM MAJOR WHERE MNAME='컴퓨터공학'),97,1);
--5. 학생수정
UPDATE STUDENT SET SNAME='김민우' , MNO= (SELECT MNO FROM MAJOR WHERE MNAME = '빅데이터학부'),
    SCORE = 100  WHERE SNO = 2022008;
UPDATE STUDENT SET  SEXPEL = (SELECT 1 FROM STUDENT WHERE SNO = 2022008 AND 100>60)
    WHERE SNO = 2022008;
--6. 학생출력 (rank, sName(sNo포함), mName(mNo포함), score) 
SELECT ROWNUM||'등' RANK  ,  A.* 
    FROM (SELECT SNAME||'('||SNO||')' 이름, MNAME||'('||M.MNO||')'학과명,SCORE 점수
    FROM MAJOR M, STUDENT S
    WHERE M.MNO = S.MNO AND SEXPEL = 1
    ORDER BY SCORE DESC) A;
--7. 제적자출력 (rank, sName(sNo포함), mName(mNo포함), score) 
SELECT ROWNUM||'등' RANK  ,  A.* 
    FROM (SELECT SNAME||'('||SNO||')' 이름, MNAME||'('||M.MNO||')'학과명,SCORE 점수
    FROM MAJOR M, STUDENT S
    WHERE M.MNO = S.MNO AND SEXPEL = 0
    ORDER BY SCORE DESC) A;
--8. 제적처리 : public int sNoExpel(String sNo)    
UPDATE STUDENT  SET SEXPEL =0 WHERE SNO =2022004 ;
ROLLBACK;