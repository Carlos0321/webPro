SELECT ENAME, SAL, HIREDATE FROM EMP WHERE HIREDATE= (SELECT MIN(HIREDATE) FROM EMP);
SELECT ENAME, SAL FROM EMP WHERE SAL = (SELECT MIN(SAL) FROM EMP);
