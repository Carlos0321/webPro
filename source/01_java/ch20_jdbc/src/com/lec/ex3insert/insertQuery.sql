-- 부서번호 중복체크
SELECT * FROM DEPT WHERE DEPTNO=70; -- rs.next()결과가 true(중복출력) / false(부서명/부서위치입력받아 입력)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;  -- 0이면 중복X / 1이면 중복O
--입력
INSERT INTO DEPT VALUES(55, 'IT','SEOUL');
DELETE FROM DEPT WHERE DEPTNO = 55;
UPDATE DEPT SET DNAME = 'ABC' WHERE DEPTNO= 55;
--수정
UPDATE DEPT SET DNAME = 'ABC', LOC='SEOUL' WHERE DEPTNO=11;
COMMIT;
SELECT * FROM DEPT;
SELECT DEPTNO  FROM DEPT; 

--삭제
DELETE FROM DEPT WHERE DEPTNO=55;
COMMIT;
SELECT * FROM DEPT;
SELECT * FROM EMP;
-- 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오 
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E , DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('sales');
UPDATE DEPT SET DNAME='SALES' WHERE DEPTNO=30;
COMMIT;