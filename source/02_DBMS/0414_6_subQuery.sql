-- [VI] SUB QUERY ; QUERY안에 QUERY가 내포 
-- SELECT 필드1, (SELECT 필드 FROM 테이블 WHERE 조건)
--   FROM 테이블
--   WHERE 조건

-- 1. 서브 쿼리 개념(필요성) 
-- 급여를 제일 많이 받는 사람의 사번, 이름, 급여 
SELECT EMPNO, MAX(SAL) FROM EMP;  -- 모든 사원이 다 나옴 
SELECT MAX(SAL) FROM EMP; --서브쿼리
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
        WHERE SAL = (SELECT MAX(SAL) FROM EMP ); --메인쿼리(서브쿼리는 괄호로 묶여 있어야함)
-- 서브쿼리의 종류(1) 단일행 서브쿼리(서브쿼리 결과가 단일행) : =, >, >= ,!=
    -- EX. SCOTT이 근무하는 부서이름 출력 
    SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT' ; -- 서브쿼리 
    SELECT DNAME FROM DEPT 
        WHERE  DEPTNO =(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); --메인쿼리
    SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME = 'SCOTT'; --JOIN이용   

-- 서브쿼리의 종류(2) 다중행 서브쿼리(서브쿼리 결과 2행 이상) : IN, ANY, ALL, EXISTS
    --EX JOB이 MANAGER인 사람의 부서이름 
    SELECT DEPTNO FROM EMP WHERE JOB= 'MANAGER'; -- 서브쿼리
    SELECT DNAME FROM DEPT 
        WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB= 'MANAGER');
        
-- 2. 단일행 서브쿼리        
    -- 아래 문제 전처리 
    SELECT DEPTNO,LOC  
        FROM EMP E , DEPT D 
            WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT';
   INSERT INTO DEPT VALUES(50,'IT','DALLAS');         
   INSERT INTO EMP (EMPNO,ENAME,DEPTNO) VALUES (9999, '홍길동', 50);  
   SELECT * FROM DEPT;
   SELECT * FROM EMP WHERE EMPNO = 9999;
    --EX1. SCOTT과 같은 부서인 사람의 이름과 급여 
    SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT' ; --서브쿼리
    SELECT ENAME, SAL FROM EMP
        WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT') AND ENAME!='SCOTT';
    --EX2. SCOTT과 같은 근무지인 사람의 이름과 급여 
    SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- 서브쿼리
    SELECT ENAME, SAL
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO 
            AND LOC=(SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT') 
            AND ENAME!='SCOTT'; -- 메인쿼리
    ROLLBACK; -- 데이터 추가 취소 (DML-데이터추가,수정,삭제를 취소)
    SELECT * FROM EMP WHERE EMPNO=9999;
    SELECT * FROM DEPT;
    
    --EX 최초입사일과 최초입사한 사람이름
    SELECT MIN(HIREDATE) FROM EMP; -- 단일행 서브쿼리
    SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) ; --메인쿼리
    --EX 최근입사일과 최근입사한사람 이름
    SELECT MAX(HIREDATE) FROM EMP;
    SELECT HIREDATE, ENAME FROM EMP
    WHERE HIREDATE =( SELECT MAX(HIREDATE) FROM EMP);
    --EX 최초입사일과 최초입사한 사람이름, 최근입사일과 최근입사한사람이름
    SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME 
    FROM EMP E1, EMP E2
    WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) 
    AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    --EX SCOTT과 같은 부서에 근무하는 사람들의 급여합
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT' ;
    SELECT SUM(SAL) FROM EMP WHERE DEPTNO =(SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT' );
    --EX SCOTT과 동일한 직책(JOB)을 가진 사원의 모든 필드 
    SELECT JOB FROM EMP WHERE ENAME = 'SCOTT';
    SELECT * FROM EMP WHERE JOB= (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT');
    --EX DALLAS에서 근무하는 사원의 이름, 부서번호 
    SELECT DEPTNO FROM DEPT;
    SELECT ENAME, DEPTNO FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
    --EX 'KING'이 직속상사인 사원의 이름과 급여
    SELECT EMPNO FROM EMP WHERE ENAME = 'KING';
    SELECT ENAME, SAL FROM EMP WHERE MGR =( SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
    
    SELECT W.ENAME, W.SAL 
        FROM EMP W, EMP M
        WHERE W.MGR =M.EMPNO AND M. ENAME='KING'; --SELF JOIN 이용
     
     --EX1 평균 급여 이하로 받는 사원의 이름과 급여를 출력   
     SELECT ENAME, SAL FROM EMP WHERE SAL <=(SELECT AVG(SAL) FROM EMP);
     --EX2 평균급여 이하로 받는 사원의 이름, 급여 평균급여 출력 
     SELECT ENAME, SAL , ROUND((SELECT AVG(SAL) FROM EMP)) AVG FROM EMP 
     WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
     --EX3 평균급여 이하로 받는 사원의 이름, 급여, 평균과 차이를 출력 
     SELECT ENAME, SAL , ROUND((SELECT AVG(SAL) FROM EMP)-SAL,1) 
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
        
--단일행 다중열 서브쿼리 : SCOTT이랑 JOB과 DEPTNO가 같은 직원의 모든 필드 출력 
SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- 서브쿼리(단일행 다중열)
SELECT * FROM EMP
    WHERE (JOB,DEPTNO) = (SELECT JOB,DEPTNO FROM EMP WHERE ENAME='SCOTT') 
        AND ENAME != 'SCOTT';


-- 다중행 서브쿼리 : IN, ALL, ANY=SOME, EXISTS 
    -- (1) IN : 서브쿼리 결과 중 하나라도 일치하면 참 
        --EX. 부서번호별로 입사일이 가장 늦은 사람의 이름, 입사일, 부서번호 
      SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO;  --서브쿼리(다중행 다중열)
      SELECT ENAME, HIREDATE, DEPTNO FROM EMP 
        WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) 
            FROM EMP GROUP BY DEPTNO);
       --EX 급여 3000이상 받는 사원이 소속된 부서에서 근무하는 사원의 모든 필드 
       SELECT DEPTNO FROM EMP WHERE SAL >= 3000; --서브쿼리(다중행)
       SELECT * FROM EMP 
        WHERE DEPTNO IN ( SELECT DEPTNO FROM EMP WHERE SAL >= 3000) ;
    
    -- (2) ALL  :
        --EX 30번 부서 급여들 모두보다 큰 경우 (= 30번 부서 최대 급여보다 큰 경우) 직원의 모든 필드
        SELECT SAL FROM EMP WHERE DEPTNO=30;
        SELECT * FROM EMP WHERE SAL >ALL ( SELECT SAL FROM EMP WHERE DEPTNO=30);
        
        -- 위의 다중행 서브쿼리를 단일행서브쿼리로 
        SELECT MAX(SAL) FROM EMP WHERE DEPTNO =30;
        SELECT * FROM EMP WHERE SAL >( SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);
   
   -- (3) ANY=SOME;     
       --EX 30번 부서 급여들 중 하나만이라도 큰 경우(=30번 부서 최소 급여보다 큰 경우) 직원의 모든 필드
       SELECT SAL FROM EMP WHERE DEPTNO=30;
       SELECT * FROM EMP WHERE SAL > ANY ( SELECT SAL FROM EMP WHERE DEPTNO=30);
   
   -- (4) EXISTS ; 서브쿼리 결과가 존재하면 참 
      -- EX 직속부하가 있는직원들의 사번, 이름 , 급여 
      SELECT EMPNO, ENAME, SAL
         FROM EMP MANAGER 
            WHERE EXISTS(SELECT * FROM EMP WHERE MANAGER.EMPNO =MGR);
     SELECT M.EMPNO, M.ENAME, M.SAL
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO ; --SELF JOIN 이용
        
        --EX 말단 사원의 모든 필드 출력 
        SELECT *
            FROM EMP MANAGER
            WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR); --서브쿼리 이용
            
        SELECT  M.*
        FROM EMP W, EMP M
        WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;

--탄탄1. 부서별로 가장 급여를 많이 받는 사원의 정보(사원 번호, 사원이름, 급여, 부서번호)를 출력(IN 연산자 이용)       
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; --서브
SELECT EMPNO, ENAME, SAL ,DEPTNO FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
--탄탄2. 직급(JOB)이 MANAGER인 사람이 속한 부서번호와 부서명과 지역을 출력 (IN) 
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';
SELECT DEPTNO, DNAME, LOC FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');
--탄탄3. 	연봉이 3000이상인 사람들 중 급여 등급을 나누어서 
            --해당 등급별 최고 급여를 받는 사람들의 
            --사번, 이름, 직업, 입사일, 급여, 급여등급을 출력    
SELECT GRADE, MAX(SAL) 
    FROM SALGRADE, EMP 
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >=3000 
    GROUP BY GRADE; --서브 쿼리 (4,5등급)
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM SALGRADE, EMP
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND(GRADE, SAL) IN (SELECT GRADE, MAX(SAL) 
                                         FROM SALGRADE, EMP 
                                         WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >=3000 
                                          GROUP BY GRADE);

--탄탄4. 응용심화 : 입사일 분기별로 가장 높은 연봉을 받는 사람들의
            --  분기, 사번, 이름, JOB, 상사사번, 입사일, 급여, 상여를 출력하세요  
            -- 1,2,3 ->1분기  4,5,6->2분기 ...  분기추출은 MM/3을 올림
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP;
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUARTER" FROM EMP;
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) 
    FROM EMP 
    GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3); -- 서브쿼리
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN
            (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) 
                FROM EMP 
                GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
    ORDER BY QUARTER; -- 메인쿼리
--탄탄 5. SALESMAN 모든 사원들 보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 
                --영업 사원은 출력하지 않는다.(ALL이용)
SELECT SAL FROM EMP WHERE JOB='SALESMAN'; --서브쿼리
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB='SALESMAN') AND JOB != 'SALSESMAN'; --다중행 서브쿼리 이용한 메인쿼리
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL >(SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN';

--탄탄 6 .  SALESMAN 일부 어떤 한 사원보다 급여를 많이 받는 
    --사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원도 출력(ANY) 
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL >ANY(SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN');                   
--탄탄 7. 연봉이 3000미만인 사람 중에 
            --가장 최근에 입사한 사람의 사원번호와 이름, 연봉, 입사일을 출력                   
SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000;                 
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP 
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);
--탄탄 8. 직급이 ‘SALESMAN’인 사원이 받는 급여의 최소 급여보다 많이 받는 사원들의 
                --이름, 급여, 직급, 부서번호를 출력하되 
                        --부서번호가 20번인 사원은 제외한다(ANY 연산자 이용)
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --서브쿼리              
SELECT ENAME, SAL, JOB, DEPTNO  
    FROM EMP 
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')
    AND DEPTNO !=20;

    
    -- ★ 총 연습문제
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL,HIREDATE FROM EMP 
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); 
-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT ENAME, SAL FROM EMP WHERE SAL =(SELECT MIN(SAL)FROM EMP);
-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ENAME, SAL, DEPTNO  FROM EMP WHERE SAL >= (SELECT AVG(SAL)FROM EMP);
--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DNAME FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO AND SAL <= (SELECT AVG(SAL)FROM EMP) ; 
--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE 
        WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT' );
--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, DEPT D, SALGRADE 
        WHERE E.DEPTNO=D.DEPTNO AND
        SAL BETWEEN LOSAL AND HISAL AND
        HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT' )
        ORDER BY SAL DESC;
--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL  FROM EMP 
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');
--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일
SELECT EMPNO, ENAME, HIREDATE FROM EMP
    WHERE HIREDATE <(SELECT HIREDATE FROM EMP WHERE ENAME ='MILLER');
--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK')
    AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = '7698');
--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
    AND DNAME = (SELECT DNAME FROM EMP E, DEPT D  WHERE  E.DEPTNO = D.DEPTNO 
    AND ENAME = 'CLARK')
    AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = '7698');
--12. BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자
SELECT ENAME, HIREDATE FROM EMP 
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME= 'BLAKE');
--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름 단 급여가 많은 순으로 출력)
SELECT EMPNO, ENAME FROM EMP
    WHERE SAL > (SELECT AVG(SAL)FROM EMP)
    ORDER BY SAL DESC;

-- 여기서부터는 다중행서브쿼리와 단일행서브쿼리, 이전은 단일행서브쿼리

-- 14.  이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 직원의 사원 번호,이름,급여(단 사번 순 출력)
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE ENAME IN (SELECT ENAME FROM EMP WHERE ENAME LIKE '%T%');
-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여
SELECT ENAME , JOB, SAL FROM EMP W , DEPT D 
    WHERE W.DEPTNO=D.DEPTNO
    AND LOC IN (SELECT LOC FROM EMP WHERE LOC = 'DALLAS' ); 
-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여
SELECT ENAME, SAL 
FROM EMP 
WHERE MGR = (SELECT EMPNO FROM EMP  WHERE ENAME= 'KING');
-- 17. SALES부서 사원의 이름, 업무
SELECT ENAME,JOB FROM EMP  W, DEPT D
WHERE W.DEPTNO = D.DEPTNO
AND DNAME IN (SELECT DNAME FROM EMP W, DEPT D
WHERE W.DEPTNO = D.DEPTNO AND DNAME ='SALES');
-- 18. 월급이 부서 30의 최저 월급보다 높은 사원의 모든 필드
SELECT * FROM EMP 
WHERE SAL > ANY(SELECT MIN(SAL)FROM EMP WHERE DEPTNO ='30');
-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무
SELECT ENAME , JOB FROM EMP
WHERE DEPTNO =10 
AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO='30');
-- 20.  FORD와 업무도 월급도 같은 사원의 모든 필드
SELECT * FROM EMP 
WHERE (JOB, SAL) IN(SELECT JOB, SAL FROM EMP WHERE ENAME ='FORD' );
-- 21. 이름이 JONES인 직원의 JOB과 같거나 FORD의 SAL 이상을 받는 사원의 정보를 이름, 업무, 부서번호, 급여
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력
SELECT ENAME, JOB, DEPTNO,SAL FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES')
OR SAL >=(SELECT SAL FROM EMP WHERE ENAME = 'FORD');
-- 22. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여
SELECT ENAME, JOB , SAL FROM EMP 
WHERE SAL IN(SELECT SAL FROM EMP WHERE ENAME ='SCOTT' OR ENAME='WARD');
-- 23. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무
SELECT ENAME, JOB FROM EMP W , DEPT D
WHERE W.DEPTNO=D.DEPTNO
AND LOC =(SELECT LOC FROM DEPT WHERE LOC = 'CHICAGO');

-- 24. 부서별 평균 월급보다 높은 사원을 사번, 이름, 급여, 부서번호
SELECT  EMPNO, ENAME, SAL, DEPTNO FROM EMP E
WHERE SAL > (SELECT AVG(SAL) FROM EMP
WHERE E.DEPTNO = DEPTNO);

-- 부서번호와 부서별 평균을 추가 
SELECT EMPNO, ENAME, SAL, DEPTNO, 
        (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO)
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
    
-- 추가문제 : 해당부서평균보다 높은 사원의 정보 - 사번, 이름, 급여, 부서번호, 해당부서의평균(소수점2자리)
SELECT EMPNO, ENAME, SAL, DEPTNO, ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO),2) AVG
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
SELECT EMPNO, ENAME, SAL, DEPTNO, ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO),2)    
    FROM EMP E, (SELECT DEPTNO, ROUND(AVG(SAL),2)AVG FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO=A.DEPTNO AND SAL >AVG; --INLINE VIEW 이용
-- 25. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여
SELECT DEPTNO, ENAME, SAL FROM EMP E
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB =E.JOB);


-- 26. 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무, 이름, 사번, 부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP MANAGER
WHERE  EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO =MGR)
ORDER BY DEPTNO ;

-- 27.  말단 사원의 사번, 이름, 업무, 부서번호
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP MANAGER
        WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR);