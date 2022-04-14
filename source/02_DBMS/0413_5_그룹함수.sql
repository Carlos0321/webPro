--[V] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV(ǥ������), VARIANCE(�л�)

SELECT ENAME, ROUND(SAL, -2) FROM EMP;
SELECT MAX(SAL) FROM EMP;
SELECT DEPTNO,MAX(SAL) FROM EMP GROUP BY DEPTNO;
SELECT ENAME, MAX(SAL) FROM EMP ; --����(������� ������ ���� �Ἥ) �ִ�޿��� �޴� ����� �̸� (6��)

--1. �׷��Լ��� �ǽ� ()�ȿ� ���� �־�� �Ѵ�
SELECT AVG(SAL) FROM EMP;
SELECT COUNT(*) FROM EMP; --EMP ���̺��� ��(ROW) ��
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP;
-- ��� �׷��Լ��� NULL���� ���� 
SELECT SUM(COMM), AVG(COMM), COUNT(COMM) FROM EMP;
--SAL�� ���, ��, �ּұ޿�, �ִ�޿�, �޿��л�, �޿�ǥ������, ����
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), VARIANCE(SAL), STDDEV(SAL)   
    FROM EMP;
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) FROM EMP;
-- �׷��Լ� MIN,MAX,COUNT�� ������, ������, ��¥�� ��� ��밡�� 
SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME)ENAME����, COUNT(COMM) COMM���� FROM EMP;
SELECT MIN(HIREDATE) �����Ի���, MAX(HIREDATE) �ֱ��Ի���, COUNT(HIREDATE) FROM EMP;
--źź1. ���� �ֱٿ� �Ի��� ����� �Ի��ϰ� ���� �����Ի��� ����� �Ի���
SELECT MIN(HIREDATE) �����Ի���, MAX(HIREDATE) �ֱ��Ի���, COUNT(HIREDATE) FROM EMP;
--źź2. 83/01/12 �ֱ��Ի��� : XX,XXX�� �ٹ� , 80/12/17 �����Ի��� : XX,XXX�� �ٹ�
SELECT MAX(HIREDATE) || '�ֱ��Ի��� : ' || 
    TO_CHAR(SYSDATE-MAX(HIREDATE) ,'99,999')||'�� �ٹ�' || 
    MIN(HIREDATE) || '�����Ի��� : '||
    TO_CHAR(SYSDATE-MIN(HIREDATE), '99,999') || '�� �ٹ� ' 
    FROM EMP;
SELECT MAX(HIREDATE) || '�ֱ� �Ի��� : ' ||
    TO_CHAR(MIN(SYSDATE-HIREDATE), '99,999') || '�� �ٹ�, '  ||
    MIN(HIREDATE) || '�����Ի��� : ' ||
    TO_CHAR(MAX(SYSDATE-HIREDATE), '99,999') || '�� �ٹ�, '
    FROM EMP;
-- 10�� �μ��Ҽ��� ��� �޿� ��� 
SELECT AVG(SAL) FROM EMP WHERE DEPTNO=10;

-- 2. GROUP BY ��
-- �μ���ȣ�� �ִ�޿�, �ּұ޿�, �޿����, �޿���
SELECT DEPTNO �μ�, MAX(SAL), MIN(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO; 
SELECT DEPTNO �μ�, MAX(SAL), MIN(SAL), ROUND(AVG(SAL)), SUM(SAL) FROM EMP GROUP BY DEPTNO;
 -- EX. SAL�� 5000�̸��� ����� ���ؼ��� �μ���ȣ�� ����� , �ִ�޿�, �ּұ޿�, ��ձ޿�(�μ���ȣ�� ����)
 SELECT DEPTNO �μ�, COUNT(*) �����, MAX(SAL), MIN(SAL), ROUND(AVG(SAL)) 
    FROM EMP 
    WHERE SAL<5000  -- WHERE�������� �ʵ� ��Ī ��� �Ұ� 
    GROUP BY DEPTNO -- GROUP BY�������� �ʵ� ��Ī ��� �Ұ� 
    ORDER BY �μ�; -- ORDER BY�������� �ʵ� ��Ī ��� ���� 
 -- EX �μ��� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�   
 SELECT DNAME, COUNT(*) , MAX(SAL) ,MIN(SAL), ROUND(AVG(SAL),2)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    ORDER BY COUNT(*) DESC;
 
 -- 3. HAVING �� : �׷��Լ� ����� ���� 
 -- �μ���ȣ�� ��� �޿� (��ձ޿��� 2000�̻��� �μ��� ���, ��� �޿� ������ ����)
 SELECT DEPTNO, AVG(SAL) "AVG"
    FROM EMP 
        GROUP BY DEPTNO
        HAVING AVG(SAL) >=2000  --HAVING������ ��Ī ��� �Ұ� 
        ORDER BY AVG;
--SAL�� 5000�̸��� ����� ���� �μ��� �ּұ޿�, �ִ�޿�, ��ձ޿�
    --(��, ��ձ޿��� 2000�̻��� �μ��� ���ؼ� ��ձ޿������� ���� ���)     
SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL) 
    FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO
        AND SAL <5000
        GROUP BY DNAME
        HAVING AVG(SAL) >=1000
        ORDER BY AVG(SAL) ;
--     ��� ������ �� ���谪 ����   
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
-- �μ���, JOB�� �޿� ��
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;
-- �μ��� JOB�� �޿��� (�Ұ�� ��ü�� ����)
SELECT DEPTNO, NVL(JOB,'��'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO,JOB);

-- ��<�� ��������>

-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;
-- 2. ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(JOB)  FROM EMP GROUP BY JOB;
--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL), MIN(SAL) , MAX(SAL)-MIN(SAL) ���� FROM EMP;
-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT DNAME, COUNT(*) , ROUND(AVG(SAL),1), MIN(SAL), MAX(SAL), SUM(SAL) 
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO
GROUP BY DNAME
ORDER BY SUM(SAL);
-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;
-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*),  AVG(SAL), SUM(SAL)
FROM EMP 
GROUP BY JOB, DEPTNO
ORDER BY JOB, DEPTNO ;
--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(*) FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) >=5;
-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(*) 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*) >=5;
--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, AVG(SAL), SUM(SAL)
FROM EMP 
GROUP BY JOB
HAVING AVG(SAL) >=3000;
--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB, SUM(SAL) 
FROM EMP 
GROUP BY JOB
HAVING SUM(SAL) >5000;
--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT DEPTNO, ROUND(AVG(SAL),1), SUM(SAL), MIN(SAL)
FROM EMP
GROUP BY DEPTNO;
--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL))
FROM EMP
GROUP BY DEPTNO;
--13. ��� ���̺��� �Ʒ��� ����� ���
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE,'RR'), COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL) ,SUM(SAL)
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'RR')
ORDER BY TO_CHAR(HIREDATE,'RR');
-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE,'YYYY'),'total'), COUNT(*)
FROM EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'))
ORDER BY TO_CHAR(HIREDATE,'YYYY');

--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL),1)
FROM EMP;
--16. �μ��� �ο��� ���
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO;
--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(DEPTNO) >=6;
--18. �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����
SELECT  E1.ENAME, COUNT(E2.ENAME)+1 RANK
FROM EMP E1 , EMP E2
WHERE E1.SAL < E2.SAL(+)
GROUP BY E1.ENAME
ORDER BY RANK;

SELECT ENAME,RANK() OVER(ORDER BY SAL DESC) FROM EMP;