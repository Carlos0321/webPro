--- [VII] DDL, DML, DCL 
-- SQL = DDL (���̺� ����, ���̺� ����, ���̺�  ��������, ���̺� ��� ������ ����)
     --   = DML(�˻� =SELECT, �߰�=INSERT, ����=UPDATE, ����=DELETE)
     --   = DCL(����ڰ�������, ����ڱ��� �ο�,���ѹ�Ż, ����ڰ�������, Ʈ����� ���ɾ� = ROLLBACK,COMMIT) 

-- DDL (�ѹ�Ұ�)
-- 1. ���̺�  ����(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),  --������ȣ BOOKID �ʵ� Ÿ���� ���� 4�ڸ� 
    BOOKNAME VARCHAR2(300),  --å �̸� BOOKNAME �ʵ�� ���� 300BYTE
    PUBLISHER VARCHAR2(300), --���ǻ� PUBLISHER �ʵ�� ���� 300BYTE
    RDATE       DATE,               --������ RDATE �ʵ�� DATE��
    PRICE        NUMBER(8),        -- ���� PRICE �ʵ�� ����8�ڸ�
    PRIMARY KEY(BOOKID));       --���̺� �� ��Ű(PRIMAY KEY) ���� -NOT NULL, ������ �� �Է� 
    
SELECT * FROM BOOK;    

DROP TABLE BOOK;
CREATE TABLE book(
    bookid NUMBER(4) PRIMARY KEY,
    BOOKNAME VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE       DATE,
    PRICE        NUMBER(8)   );
    
SELECT * FROM BOOK;    
SELECT ROWNUM, EMPNO, ENAME FROM EMP; --ROWNUM : ���̺����� �о���� ������ ����
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO=20 ORDER BY ENAME; 
--EMP ���̺��� ������ EMP01 : EMPNO(����4), ENAME(����20), SAL(����7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2));
DESC EMP01;
--DEPT�� ������ DEPT01 : DEPTNO(����2, PK), DNAME(����14), LOC(����13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2),
    DNAME  VARCHAR2(14),
    LOC       VARCHAR2(13),
    PRIMARY KEY(DEPTNO));
DESC DEPT01;    
DESC DEPT;

--���������� �̿��� ���̺� ���� 
CREATE TABLE EMP02 
    AS SELECT * FROM EMP; -- �������� ����� EMP02���̺� ������ ��(���������� ������)
SELECT *FROM EMP02;
DESC EMP02 ;
    --EX EMP03 : EMP���̺����� EMPNO, ENAME, DEPTNO�� ������ �����ͷ� ���̺� 
CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    --EX. EMP04 : EMP���̺����� 10�� �μ��� ������ �����ͷ� ���̺� 
CREATE TABLE EMP04 AS SELECT * FROM EMP WHERE DEPTNO =10;
SELECT * FROM EMP04;
    --EX. EMP05 : EMP���̺� ����(�ʵ�� ���� Ÿ��)�� ���� 
CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE  1=0;
SELECT * FROM EMP05;

-- 2. ���̺� ���� ����(ALTER TABLE)
--ALTER TABLE ���̺��� ADD || MODIFY || DROP ~ 
-- (1) �ʵ� �߰�(ADD)  :�߰��� �ʵ��� �����ʹ� NULL
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2));
SELECT * FROM EMP03;
ALTER TABLE EMP03 ADD(COMM NUMBER(7,2));

-- (2) �ʵ� ���� (MODIFY) 
SELECT * FROM EMP03 ; -- EMPNO(��4), ENAME(��10), DEPTNO(��2), /JOB(��20)�� SAL�� COMM(��7,2)�� ������ NULL
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); --���� �����Ͱ� ����ִ� ���¿����� ���ڷθ� ���� ����
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); --����
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); --����_
ALTER TABLE EMP03 MODIFY(ENAME NUMBER(4)); --���� �����Ͱ� ��� �ִ� ���¿����� ���ڷθ� ���氡��
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY(ENAME VARCHAR2(3000));
DESC EMP03;
ALTER TABLE EMP03 MODIFY(ENAME VARCHAR2(10));
ALTER TABLE EMP03 MODIFY(ENAME VARCHAR2(5)); --�Ұ��� (6BYTE ���� �����Ͱ� �־)
ALTER TABLE EMP03 MODIFY(JOB NUMBER(4));

-- (3) �ʵ� ����(DROP)
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;
--���������� Ư�� �ʵ带 ���� ���ϵ��� (��)
ALTER TABLE EMP03 SET UNUSED (DEPTNO);
SELECT * FROM EMP03;
--���������� ���� �Ұ��ߴ� �ʵ带 ���������� ����(����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;

-- 3. ���̺� ���� (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- �ٸ� ���̺����� �����ϴ� �����Ͱ� ���� ��� �ٷ� DROP �Ұ�

-- 4. ���̺��� ��� ���� ���� (TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03;  --EMP03���� ������ ���� (��ҺҰ�)
SELECT * FROM EMP03;

-- 5. ���̺��� ����(RENAME ���̸� TO ���̸�)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT*FROM EMP2;

-- 6. ������ ��ųʸ�(���� �Ұ�) VS ������ ��ųʸ� ��(����� ���ٿ�)
--����
-- USER_XXX : �� ������ �����ϰ� �ִ� ��ü(���̺�, �ε���, ��������, ��)
        --EX. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS , USER_VIEWS
--ALL_ XXX : �� ������ ���� ������ ��ü (���̺�, �ε���, ��������, ��)
    --EX. ALL_TABLE, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
--DBA_XXX : DBA�����ڸ� ���ٰ���, DBMS�� ��� ��ü
    --EX. DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS


SELECT * FROM ALL_TABLES;
SELECT * FROM  ALL_INDEXES; 
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;
SELECT * FROM USER_TABLES; --�� ������ ������ ���̺� ��ü ���� 
SELECT * FROM USER_INDEXES; -- �� ������ ������ �ε��� ���� 
SELECT * FROM USER_CONSTRAINTS; --�� ������ ������ �������ǵ�
SELECT * FROM USER_VIEWS; --�� ������ ������ �� ���� 
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES; 
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;


--- DCL(����ڰ�������, ����ڱ��Ѻο�, ���ѹ�Ż, ����ڰ�������)
CREATE USER scott2 IDENTIFIED BY 1234;
-- ���Ѻο�(���Ǳ���, scott.EMP, scott.DEPT ���̺��� ���� ��� ����)
GRANT CREATE SESSION TO scott2;
GRANT ALL ON EMP TO scott2; --EMP���̺��� ���� ��� ����(�˻�, �߰�, ����, ����) 
GRANT ALL ON DEPT TO scott2;
show user;
--���� ��Ż(���ѹ�Ż�� ����ڰ����� ��������)
REVOKE ALL ON EMP FROM scott2; --scott2�� emp ���̺��� ���� ��� ���� ��Ż
REVOKE ALL ON DEPT FROM scott2;
show user;
--����� ���� ����(���� ���� ���� ���� �Ұ�)
DROP USER scott2 CASCADE; 

-- DML(SELECT, INSERT, UPDATE, DELETE)
-- 1. INSERT INTO ���̺��� VALUES(��1, ��2, ��3....);
-- INSERT INTO ���̺��� (�ʵ��1, �ʵ��2...) VALUES (��1, ��2 , ..)
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT01 (DEPTNO,DNAME,LOC) VALUES (60,'IT','SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70,'OPERATION'); --���������� LOC�� NULL�߰�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES(80, 'HR', NULL); --���������� NULL �߰�
INSERT INTO DEPT01 VALUES(90,'SALES',NULL); --���������� NULL�߰�
--���������� �̿��� INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
--Ʈ����� ���ɾ�(DML ���ɾ)
COMMIT;

------------------------------
CREATE TABLE SAM01(
    EMPNO NUMBER(4),
    ENAME  VARCHAR2(10),
    JOB       VARCHAR2(9),
    SAL       NUMBER(7,2)
    PRIMARY KEY(EMPNO));
SELECT * FROM SAM01;   
SELECT * FROM USER_CONSTRAINTS;
DROP TABLE SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4),
    ENAME  VARCHAR2(10),
    JOB       VARCHAR2(9),
    SAL       NUMBER(7,2),
    CONSTRAINT SAM_PK PRIMARY KEY(EMPNO));
SELECT * FROM SAM01;   
SELECT * FROM USER_CONSTRAINTS;
INSERT INTO SAM01 VALUES(1000,'APPLE','POLICE',10000);
INSERT INTO SAM01 VALUES(1010,'BANANA','NURSE',15000);
INSERT INTO SAM01 VALUES(1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 VALUES(1030,'VERY',NULL,25000);
INSERT INTO SAM01 VALUES(1040,'CAT',NULL,2000);
INSERT INTO SAM01 VALUES(7782,'CLARK','MANAGER',2450);
INSERT INTO SAM01 VALUES(7839,'KING','PRESIDENT',5000);
INSERT INTO SAM01 VALUES(7934,'MILLER','CLERK',1300);
SELECT * FROM SAM01;    


--Ʈ����� ���ɾ�
COMMIT;
-- 2. UPDATE ���̺��� SET �ʵ��1=��1[, �ʵ��2=��2, ..] WHERE ����
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;
--EMP01 ���̺��� �μ���ȣ�� 30���� ���� (WHERE �� ���̴� ��� ���� ����)
UPDATE EMP01 SET DEPTNO=30;
ROLLBACK; --Ʈ����� ��� (DML�� ��� ����)
SELECT * FROM EMP01;
--EMP01���̺��� ��� ����� �޿��� 10%�λ�
UPDATE EMP01 SET SAL = SAL*1.1;
SELECT * FROM EMP01;
--10�� �μ��� ������ �Ի����� ���÷�, �μ���ȣ�� 30������ ���� 
UPDATE EMP01
    SET HIREDATE = SYSDATE,
            DEPTNO =30 
            WHERE DEPTNO =10 ;
SELECT * FROM EMP01;            
--SAL�� 3000�̻��� ����� SAL�� 10% �λ� 
UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL >=3000;
-- 'DALLAS'�� �ٹ��ϴ� ������ �޿��� 1000$�� �λ�(�������� ���)
UPDATE EMP01 SET SAL = SAL +1000 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
--SCOTT�� �μ���ȣ�� 20����, JOB�� MANAGER��, SAL�� COMM�� 500�� �λ�, ��縦 KING���� ����
UPDATE EMP01
    SET DEPTNO=20,
        JOB = 'MANAGER',
        SAL = SAL +500,
        COMM = NVL(COMM,0) +500,
        MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING')
    WHERE ENAME = 'SCOTT';    
SELECT * FROM EMP01 WHERE  ENAME = 'SCOTT';
SELECT * FROM DEPT01;
--DEPT01���� 20������ �������� DEPT���̺��� 60�������� ���������� ����
UPDATE DEPT01 SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO=60)
    WHERE DEPTNO >= 20;  --DEPT���̺��� 60�� �μ��� ��� NULL������ ����
SELECT * FROM DEPT01;    
--EMP01���̺��� ��� ����� �޿��� �Ի����� 'KING'�� �޿��� �Ի��Ϸ� ����
COMMIT;
ROLLBACK;
SELECT* FROM EMP01;
UPDATE EMP01 
    SET SAL = (SELECT SAL FROM EMP WHERE ENAME='KING'),
        HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME= 'KING');
UPDATE EMP01
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');
--DEPT01 ���̺��� 20�� �μ��� �������� �μ����� 40�� �μ��� �������� �μ������� ���� 
UPDATE DEPT01
    SET (DNAME, LOC) = (SELECT DNAME,LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO = 20;
    COMMIT;
    
-- 3. DELETE FROM ���̺��� (WHERE ����); 
SELECT * FROM EMP01 ;
DELETE FROM EMP01 ;  --WHERE���� �� �� ��� ��ü ���� ��� ����(��� ����) 
SELECT * FROM EMP01;
ROLLBACK;
--EMP01(���̺����� 'FORD'�� ����� ����)
DELETE FROM EMP01 WHERE ENAME = 'FORD';
SELECT * FROM EMP01 WHERE ENAME ='FORD';
ROLLBACK;
--EMP01 ���̺����� 30�� �μ� ������ ���� 
DELETE FROM EMP01 WHERE DEPTNO = 30;
SELECT * FROM EMP01;
--EMP01���̺����� �μ����� RESEARCH�μ���  ������ ����
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
--SAM01 ���̺����� JOB�� �������� ���� ����� ���� 
SELECT * FROM SAM01;
DELETE FROM SAM01 WHERE JOB IS NULL;
--SAM01���̺����� ENAME�� ORANGE�� ����� �����Ͻÿ�
DELETE FROM SAM01 WHERE ENAME='ORANGE';
COMMIT;

CREATE TABLE MY_DATA(
    ID NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2));
INSERT INTO MY_DATA VALUES(1, 'Scott', 'sscott',10000.00);   
INSERT INTO MY_DATA VALUES(2, 'Ford', 'fford',13000.00);
INSERT INTO MY_DATA VALUES(3, 'Patel', 'ppatel',33000.00);
INSERT INTO MY_DATA VALUES(4, 'Report', 'rreport', 23500.00);
INSERT INTO MY_DATA VALUES(5, 'Good', 'ggood', 44450.00);
SELECT * FROM MY_DATA;
COMMIT;
UPDATE MY_DATA
    SET SALARY = 65000
    WHERE ID='3';
DELETE FROM MY_DATA WHERE NAME = 'Ford';
COMMIT;
UPDATE MY_DATA 
    SET SALARY = 15000
    WHERE SALARY <= 15000;
    COMMIT;
SELECT * FROM MY_DATA;   
DROP TABLE MY_DATA;