--[XI] 인덱스 : 조회를 빠르게 하는 인덱스
SELECT * FROM USER_INDEXES; -- 딕셔너리뷰에서 SCOTT이 소유한 인덱스 정보
SELECT * FROM EMP;
DROP TABLE EMP01;                        -- ★
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- ★ EMP내용과 같은 EMP01 생성
SELECT * FROM EMP01; -- 14행
INSERT INTO EMP01 SELECT * FROM EMP01;   -- ★ 1번(28행) 2번(56)행
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01;   -- ★ 11번 (11만4천개 행)
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40);  -- ★
INSERT INTO EMP01 SELECT * FROM EMP01;   -- ★ 3번 (91만개 행) 
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
-- 인덱스 생성 전 조회
SELECT * FROM EMP01 WHERE ENAME='HONG';  -- 인덱스 생성 전 : 0.035초 -> 0.017초
-- 인덱스 생성(EMP01테이블의 ENAME)하고 조회
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); -- 인덱스 생성 : 1.13초 -> 0.395초
SELECT * FROM EMP01 WHERE ENAME='HONG';  -- 인덱스 생성 후 : 0.001초
SELECT * FROM USER_INDEXES WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
COMMIT; -- 90만개 행
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 생성 후 INSERT 속도 : 21.3초
ROLLBACK; -- 취소속도 : 10.3초 90만개 행
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
DROP INDEX IDX_EMP01_ENAME; 
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 제거 후 INSERT 속도 : 2.8초
DROP TABLE EMP01;