--DEPT.XML의 ID=DEPTLIST
SELECT *  FROM DEPT;
--EMP.XML의 ID=EMPLIST
SELECT * FROM EMP WHERE 1=1 
    AND ENAME LIKE '%'||'A'||'%' 
    AND JOB LIKE '%'||'E'||'%'
    AND DEPTNO=20;