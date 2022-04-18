-- [III] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻�
SELECT * FROM EMP WHERE ENAME='SCOTT'; -- �μ���ȣ(DEPTNO 20)
SELECT * FROM DEPT;
-- CROSS JOIN (FROM���� ���̺� 2�� �̻�)
SELECT * FROM EMP, DEPT WHERE ENAME='SCOTT'; -- 1  *  4  =4��
SELECT * FROM EMP, DEPT; -- 14*4=56��

-- �� 1. EQUI JOIN (�������� : �����ʵ忣 DEPTNO���� ��ġ�Ǵ� ���� JOIN)
SELECT * FROM EMP, DEPT
    WHERE ENAME='SCOTT' AND EMP.DEPTNO=DEPT.DEPTNO;
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
  -- ���̺��� ��Ī�� ������ ��Ī���θ� ���̺��� �׼����� �� �ֽ��ϴ�.
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    -- ex. �޿��� 2000�̻��� ������ �̸�, ��å(job), �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL >= 2000;
    -- ex. LOC�� 'CHICAGO'�� ����� �̸�, ����, �޿�, �μ���ȣ, �ٹ����� ���
SELECT ENAME, JOB, SAL, D.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
    -- ex. �μ���ȣ 10�̰ų� 20���� ����� �̸�, ����, �ٹ���, �޿�. (�޿��� ����)
SELECT ENAME, JOB, LOC, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN (10, 20)
    ORDER BY SAL;
    -- ex. JOB�� SALESMAN�̰ų� MANAGER�� ����� �̸�, �޿�, ��, ����((SAL+COMM)*12), �μ���
          -- �ٹ����� ���(������ ū������ ����)
SELECT ENAME, SAL, COMM, (SAL+COMM)*12 ANNUAL_SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB IN ('SALESMAN', 'MANAGER')
    ORDER BY ANNUAL_SAL DESC;
    -- ex. COMM�� NULL�̰� �޿��� 1200�̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ��� ���
          -- (�μ�����, �޿�ū�� ����)
SELECT ENAME, SAL, HIREDATE, D.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME, SAL DESC;
    -- ex. 'NEW YORK'���� �ٹ��ϴ� ����� �̸��� �޿� ���
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
    -- ex. 'ACCOUNTING' �μ� �Ҽ��� ����̸��� �Ի��� ���
SELECT ENAME, HIREDATE FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
    -- ex. ����(JOB)�� MANAGER�� ����� �̸�, �μ��� ���
SELECT ENAME, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
    -- ex. comm�� NULL�� �ƴ� ����� �̸�, �޿�, �μ���ȣ, �ٹ��� ���
SELECT ENAME, SAL, E.DEPTNO, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND NOT COMM IS NULL;

-- �� 2. NON-EQUI JOIN
SELECT * FROM EMP WHERE ENAME='SCOTT'; -- �������
SELECT * FROM SALGRADE; -- �޿� ��� ����
-- CROSS JOIN = EMP�� 1�� * SALGRADE�� 5��
SELECT * FROM EMP, SALGRADE WHERE ENAME='SCOTT';
SELECT * FROM EMP, SALGRADE WHERE ENAME='SCOTT' AND SAL BETWEEN LOSAL AND HISAL;
SELECT * FROM EMP, SALGRADE WHERE ENAME='SCOTT' AND SAL>=LOSAL AND SAL<=HISAL;
    -- ex. ��� ����� ���, �̸�, job, �����, �޿�, �޿����(1���, 2���, ..)
SELECT * FROM SALGRADE;
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'���' GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- źź1. Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, D.DEPTNO, DNAME, LOC
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND E.DEPTNO=D.DEPTNO
        AND NOT COMM IS NULL;
-- źź2. �̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;
-- źź3. �̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
-- źź4. �̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND NOT COMM IS NULL;
-- źź5. �̸�, �޿�, �޿����, ����, �μ��� (�μ���, �μ��� ������ ������ ����)
        -- ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 ����, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, (SAL+NVL(COMM,0))*12;
-- źź6. �̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. 
    -- �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
        AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL DESC;
-- źź7. �̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
        AND HIREDATE LIKE '%81%'
    ORDER BY GRADE DESC;

-- �� 3. SELF JOIN
SELECT EMPNO, ENAME , MGR FROM EMP WHERE ENAME='SMITH'; -- SMITH �����:7902
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO=7902;
SELECT WORKER.EMPNO ���, WORKER.ENAME �̸�, WORKER.MGR �����, 
            MANAGER.EMPNO �����, MANAGER.ENAME ����̸�
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.ENAME='SMITH' AND WORKER.MGR=MANAGER.EMPNO;
    -- ex. ��� ����� ���, �̸�, �����, ����̸� (13��-KING�� MGR�� NULL�̶� KING��¾ȵ�)
SELECT W.EMPNO ���, W.ENAME �̸�, W.MGR �����, M.ENAME ����̸�
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
    -- ex. 'SMITH�� ���� FORD��' �������� ������� ���
SELECT W.ENAME || '�� ���� ' || M.ENAME || '��'
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
-- źź1. SCOTT�� ������ �μ���ȣ(20��)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT * FROM EMP WHERE ENAME='SCOTT';
SELECT ENAME FROM EMP WHERE DEPTNO=20 AND ENAME!='SCOTT';
-- 1�ܰ�
SELECT E1.ENAME, E1.DEPTNO, E2.ENAME, E2.DEPTNO
    FROM EMP E1, EMP E2
    WHERE E1.ENAME='SCOTT' AND E1.DEPTNO=E2.DEPTNO AND E2.ENAME != 'SCOTT';
-- 2�ܰ� ����
SELECT E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.ENAME='SCOTT' AND E1.DEPTNO=E2.DEPTNO AND E2.ENAME != 'SCOTT';
    
-- źź2. SCOTT�� ������ �ٹ���(DALLAS)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
SELECT * FROM DEPT;
    -- ���������� DALLAS �ٹ��� �μ��� �ϳ� �߰�
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
SELECT * FROM DEPT; 
    -- ���������� 50�� �μ� ��� �߰�
SELECT * FROM EMP;
INSERT INTO EMP VALUES (9999, 'ȫ�浿',NULL, NULL, NULL, 9000,900,50);
SELECT * FROM EMP;
-- 1�ܰ�
SELECT E1.ENAME, D1.LOC, E2.ENAME, D2.LOC
    FROM EMP E1, DEPT D1, EMP E2, DEPT D2
    WHERE E1.DEPTNO=D1.DEPTNO AND E2.DEPTNO=D2.DEPTNO AND D1.LOC=D2.LOC
        AND E1.ENAME='SCOTT' AND E2.ENAME != 'SCOTT';
-- 2�ܰ� ����
SELECT E2.ENAME
    FROM EMP E1, DEPT D1, EMP E2, DEPT D2
    WHERE E1.DEPTNO=D1.DEPTNO AND E2.DEPTNO=D2.DEPTNO AND D1.LOC=D2.LOC
        AND E1.ENAME='SCOTT' AND E2.ENAME != 'SCOTT';
      
ROLLBACK;  -- INSERT ���
--źź3. ����� �̸��� 'KING'�� ������� �̸��� JOB�� ���
SELECT W.ENAME, W.JOB -- , M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';

-- �� 4. OUTER JOIN : ���ν� ���ǿ� �������� ���� ����� ��Ÿ����
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D -- 40�� �μ� ����
    WHERE E.DEPTNO(+) = D.DEPTNO; -- E.DEPTNO���� 40�� �μ� ����
-- ���� ����� �̸���
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO AND W.EMPNO IS NULL;
    
-- �� <��������> PART1
--1. �̸�, ���ӻ���
SELECT  W.ENAME, M.ENAME MANAGER
    FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ���
SELECT W.ENAME, W.SAL, W.JOB, M.EMPNO
    FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��� . (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME,'����')
    FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO(+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, DNAME, M.EMPNO
    FROM EMP W, EMP M, DEPT D
        WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO,DNAME, LOC, M.ENAME
    FROM EMP W, EMP M, DEPT D
        WHERE W.MGR=M.EMPNO(+)  AND W.DEPTNO=D.DEPTNO;
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, W.DEPTNO, GRADE, M.ENAME 
    FROM EMP W, EMP M, SALGRADE 
        WHERE W.MGR=M.EMPNO(+) AND W.SAL >=2000;
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, W.DEPTNO, GRADE, M.ENAME
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR=M.EMPNO(+) 
    AND W.DEPTNO=D.DEPTNO
    AND W.SAL BETWEEN LOSAL AND HISAL
     ORDER BY DEPTNO;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W. ENAME, W.SAL, W.DEPTNO, GRADE, (W.SAL*12+NVL(W.COMM,0))���� ,M.ENAME ���ӻ���
FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO(+)
    AND W.DEPTNO = D.DEPTNO
    AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, (W.SAL*12+NVL(W.COMM,0));
    
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W. ENAME, W.SAL, W.DEPTNO, GRADE, (W.SAL*12+NVL(W.COMM,0))���� ,M.ENAME ���ӻ���
FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO(+)
    AND W.DEPTNO = D.DEPTNO
    AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, (W.SAL*12+NVL(W.COMM,0)) ,DNAME;
    
--  PART2
--1.EMP ���̺����� ��� ����� ���� �̸�, �μ���ȣ, �μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME �̸�, DEPTNO �μ���ȣ, JOB �μ��� FROM EMP;

--2. EMP ���̺����� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ���
SELECT ENAME, JOB, SAL, DNAME 
    FROM EMP E, DEPT D  
    WHERE E.DEPTNO=D.DEPTNO 
    AND LOC='NEW YORK';

--3. EMP ���̺����� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
        AND COMM IS NOT NULL;

--4. EMP ���̺����� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP E , DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
    AND ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������� ������������
SELECT EMPNO, ENAME, W.DEPTNO, DNAME
    FROM EMP W, DEPT D
    WHERE W.DEPTNO=D.DEPTNO
    ORDER BY ENAME DESC;
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP W, DEPT D
    WHERE W.DEPTNO = D.DEPTNO
    AND SAL >=2000
    ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
    FROM EMP W, DEPT D
    WHERE W.DEPTNO=D.DEPTNO
    AND JOB = 'MANAGER'
    AND SAL >=2500
    ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, GRADE
    FROM EMP W, DEPT D, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL;
    
--9. ������̺����� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME, M.ENAME ����
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+) ;
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME, M.ENAME ����, E.ENAME "����� ����"
    FROM EMP W, EMP M, EMP E
    WHERE W.MGR=M.EMPNO
        AND M.MGR=E.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME, M.ENAME ����, E.ENAME "����� ����"
    FROM EMP W, EMP M, EMP E
    WHERE W.MGR=M.EMPNO(+)
        AND M.MGR=E.EMPNO(+);