--[X] VIEW, INLINE VIEW, TOP-N����
-- 1. VIEW : ������ ���̺� (1)�ܼ��� (2)���պ� 
--  (1) �ܼ��� : �ϳ��� ���̺��� ������ �� 
--EMPv0�̶�� VIEW���� �Ǵ� ���� = EMP���̺� �Ϻ� �ʵ带 ���� ������ ���̺�
SELECT * FROM USER_VIEWS; --������ ��ųʸ� �� Ȯ�� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE,DEPTNO 
        FROM EMP; --DDL�� �����ϸ� �����͵�ųʸ� �ڵ�����
SELECT * FROM USER_VIEWS;
SELECT * FROM EMPv0; --������ ���̺� 
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER',7369,SYSDATE,40); --�信 INSERT�ϸ� EMP���̺����� INSERT
SELECT * FROM EMPv0 WHERE EMPNO=1111;
SELECT * FROM EMP;
UPDATE EMPv0 SET JOB='MANAGER' WHERE EMPNO=1111; --�� ������Ʈ�ϸ� EMP���̺��� UPDATE
DELETE FROM EMPv0 WHERE EMPNO=1111; --�� DELETE�ϸ� EMP���̺��� ��������

--EMPv0�̶�� VIEW : EMP���̺��� 30�� �μ��ุ 
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT * FROM EMP WHERE DEPTNO=30;
DESC EMPv0;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111,'ȫ',NULL,NULL,SYSDATE,9000,900,30);
SELECT * FROM EMPv0;
SELECT * FROM EMP;
-- 40�� �μ� �Է��� �����ϳ� ������ ����  
INSERT INTO EMPv0 VALUES(1112,'��',NULL,NULL,SYSDATE,8000,800,40);
SELECT * FROM EMPv0;
SELECT * FROM EMP;
DELETE FROM EMPv0 WHERE EMPNO IN (1111,1112); --30�� �μ��� ������
SELECT * FROM EMPV0;
SELECT * FROM EMP;
DELETE FROM EMP WHERE EMPNO=1112;

-- EMPV0 �� ���� : ENAME, JOB, HIREDATE������ �� ���� (NOT NULL �ʵ带 �������ϸ� INSERT �Ұ�)
CREATE OR REPLACE VIEW EMPV0 
    AS SELECT ENAME, JOB, HIREDATE FROM EMP;
INSERT INTO EMPv0 VALUES ('ȫ','SALESMAN','SYSDATE');    
SELECT * FROM EMPv0;
COMMIT;

--VIEW�� ���� ���� (1)���� ���� (2)�б����� 
--WITH CHECK OPTION�� ������ ��� ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ����
--WITH READ ONLY�� ������ ��� �б� ���� �� 

--EMPv0 : EMP���̺����� 30�� �μ��� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30
        WITH CHECK OPTION;
INSERT INTO EMPv0 VALUES(1111,'HONG',NULL,NULL,SYSDATE,9000,900,30); --30�� �μ��� INSERT
INSERT INTO EMPv0 VALUES(1111,'HONG',NULL,NULL,SYSDATE,9000,900,40); -- WHERE ���ǿ� �������� ������ �Ұ�   
SELECT * FROM EMP;
DELETE FROM EMPv0 WHERE ENAME='SMITH'; --SMITH�� 20�� �μ��� ����
DELETE FROM EMPv0 WHERE EMPNO=1111;

--EMPv0 : �б����� �� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO FROM EMP;
INSERT INTO EMPv0 VALUES(1111, 'HONG', NULL, NULL, 40); --����(�б����� ��)  
SELECT * FROM EMP;

-- (2) ���պ� : 2�� �̻��� ���̺��� ������ ���̰ų� ������ �ʵ�� �並 ���� ��� , DML���� ���������� ��� 
-- �� 2�� �̻��� ���̺��� �� ����
CREATE OR REPLACE VIEW EMPV0 
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM EMPV0;        
INSERT INTO EMPV0 VALUES(1111,'HONG','MANAGER','RESEARCH','DALLAS'); --���պ�� ���źҰ�
-- �� ������ �ʵ�� �� : �÷��� ��Ī(�����ڷν���, ������,����,_)�� �̿��Ͽ� �� ����  
CREATE OR REPLACE VIEW EMPV0 (EMPNO, ENAME, YEAR_SAL)
    AS SELECT EMPNO, ENAME, SAL*12  FROM EMP WHERE DEPTNO= 10; --�ʵ忡 Ư������ ���� �ȵȴ� 
SELECT * FROM EMPV0;
INSERT INTO EMPV0 VALUES (1111,'ȫ',2400); --���պ�� ���� �Ұ� 

--EX. �μ���ȣ , �ּұ޿� , �ִ�޿�, �μ���ձ޿��� ������ DEPTV1 �並 ����
CREATE OR REPLACE VIEW DEPTV1
    AS SELECT DEPTNO, MIN(SAL) MINSAL, MAX(SAL) MAXASAL, ROUND(AVG(SAL),1) AVGSAL
        FROM EMP  GROUP BY DEPTNO;
        SELECT * FROM DEPTV1;
--EX. ��å, �μ��� ������ EMPV0 �並 ���� : DISTINCT ������ ��� �б� ���� 
CREATE OR REPLACE VIEW EMPV0
    AS SELECT DISTINCT JOB, DEPTNO FROM EMP ORDER BY DEPTNO;
    SELECT * FROM EMPV0;
INSERT INTO EMPV0 VALUES('CLERK', 10); -- �б� �����̶� ����     

-- 2. INLINE VIEW : FROM�� ���� ���������� INLINE VIEW�� �ϸ�, FROM���� ���� ���������� VIEWó�� �ۿ�
--EX �޿��� 2000�� �ʰ��ϴ� ����� ��� �޿� 
SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000);
--EX �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿�(�������� �������� 24, 25)
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO); --��������
SELECT EMPNO, ENAME, SAL, AVGSAL
    FROM EMP E, (SELECT DEPTNO, ROUND(AVG(SAL),1) AVGSAL FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO=A.DEPTNO AND SAL > AVGSAL;  --INLINE VIEW

-- 3. TOP-N����(TOP 1~10��/ TOP 11~20�� 6~10�� ) ��ŷ �ű�°Ŷ� �ٸ���  
-- ROWNUM : FROM�� ���̺��κ��� ������ ���� 
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20;
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20 ORDER BY ENAME;
--��� , �̸� SAL(��ü�࿡ ����)
SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL DESC; --ROWNUM�� ����� �ƴϰ� ���̺��� ���� ������ ����
SELECT ROWNUM, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL DESC);
--�Լ��� �̿��� RANK ��� 
SELECT RANK() OVER(ORDER BY SAL DESC) RANK,
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,
    ENAME, SAL FROM EMP;

-- SAL �������� 1~5�� 
SELECT ROWNUM, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 5;
-- SAL�������� 6~10��
SELECT ROWNUM, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 6 AND 10;  --����� ���൵ �ȳ���
    
-- TOP-N ���� 1�ܰ�
SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);
-- TOP-N ���� 2�ܰ�(�ϼ��� TOP-N����)
SELECT RN,ENAME, SAL 
    FROM  (SELECT ROWNUM RN, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)) A
    WHERE RN BETWEEN 6 AND 10 ;
--�̸��� ���ĺ� ������� �����ؼ� 6~10��° ���� ���(���, �̸�, ���, JOB,HIREDATE) 
SELECT AN , ENAME,EMPNO,JOB,MGR,HIREDATE 
FROM (SELECT ROWNUM AN,ENAME,EMPNO,JOB,MGR,HIREDATE FROM (SELECT*FROM EMP ORDER BY ENAME))
    WHERE AN BETWEEN 6 AND 10;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

--<�� ��������>
-- 1. �μ����� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VW AS SELECT  DNAME, ENAME  FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO ;
SELECT * FROM DNAME_ENAME_VW;
-- 2. ������� ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU AS SELECT E.ENAME �����, D.ENAME ���ӻ�� FROM EMP E, EMP D
WHERE E.MGR =D.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;
-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). -- �л� ����
SELECT  DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC;
SELECT  DEPTNO, SUMSAL, ROWNUM FROM (SELECT  DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);
-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT RN,DEPTNO, SUMSAL 
    FROM (SELECT ROWNUM RN,DEPTNO,SUMSAL FROM (SELECT  DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
    WHERE RN BETWEEN 2 AND 3; 
-- 4. ������̺����� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC );
-- 5. ������̺����� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
    SELECT ROWNUM, EMPNO,ENAME,HIREDATE
        FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC)
        WHERE ROWNUM <=5;
-- 6. ��� ���̺����� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT RN,EMPNO,ENAME,HIREDATE 
    FROM (SELECT ROWNUM RN, A.*
    FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10; 