--- [VII] DDL, DML, DCL 
-- SQL = DDL (���̺� ����, ���̺� ����, ���̺�  ��������, ���̺� ��� ������ ����)
     --   = DML(�˻� =SELECT, �߰�=INSERT, ����=UPDATE, ����=DELETE)
     --   = DCL(����ڰ�������, ����ڱ��� �ο�,���ѹ�Ż, ����ڰ�������, Ʈ����� ��ɾ� = ROLLBACK,COMMIT) 

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
SELECT ROWNUM, EMPNO, ENAME FROM EMP; --ROWNUM : ���̺��� �о���� ���� ����
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO=20 ORDER BY ENAME; 
--EMP ���̺�� ������ EMP01 : EMPNO(����4), ENAME(����20), SAL(����7,2)
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
    --EX EMP03 : EMP���̺��� EMPNO, ENAME, DEPTNO�� ������ �����ͷ� ���̺� 
CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    --EX. EMP04 : EMP���̺��� 10�� �μ��� ������ �����ͷ� ���̺� 
CREATE TABLE EMP04 AS SELECT * FROM EMP WHERE DEPTNO =10;
SELECT * FROM EMP04;
    --EX. EMP05 : EMP���̺� ����(�ʵ�� ���� Ÿ��)�� ���� 
CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE  1=0;
SELECT * FROM EMP05;

-- 2. ���̺� ���� ����(ALTER TABLE)
--ALTER TABLE ���̺�� ADD || MODIFY || DROP ~ 
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
--�������� Ư�� �ʵ带 ���� ���ϵ��� (��)
ALTER TABLE EMP03 SET UNUSED (DEPTNO);
SELECT * FROM EMP03;
--�������� ���� �Ұ��ߴ� �ʵ带 ���������� ����(����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;

-- 3. ���̺� ���� (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- �ٸ� ���̺��� �����ϴ� �����Ͱ� ���� ��� �ٷ� DROP �Ұ�

-- 4. ���̺��� ��� ���� ���� (TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03;  --EMP03���� ������ ���� (��ҺҰ�)
SELECT * FROM EMP03;

-- 5. ���̺�� ����(RENAME ���̸� TO ���̸�)
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
-- ���Ѻο�(���Ǳ���, scott.EMP, scott.DEPT ���̺� ���� ��� ����)
GRANT CREATE SESSION TO scott2;
GRANT ALL ON EMP TO scott2; --EMP���̺� ���� ��� ����(�˻�, �߰�, ����, ����) 
GRANT ALL ON DEPT TO scott2;
show user;
--���� ��Ż(���ѹ�Ż�� ����ڰ����� ��������)
REVOKE ALL ON EMP FROM scott2; --scott2�� emp ���̺� ���� ��� ���� ��Ż
REVOKE ALL ON DEPT FROM scott2;
show user;
--����� ���� ����(���� ���� ���� ���� �Ұ�)
DROP USER scott2 CASCADE; 

-- DML(SELECT, INSERT, UPDATE, DELETE)
-- 1. INSERT INTO ���̺� VALUES(��1, ��2, ��3....);
-- INSERT INTO ���̺�� (�ʵ��1, �ʵ��2...) VALUES (��1, ��2 , ..)
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT01 (DEPTNO,DNAME,LOC) VALUES (60,'IT','SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70,'OPERATION'); --���������� LOC�� NULL�߰�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES(80, 'HR', NULL); --��������� NULL �߰�
INSERT INTO DEPT01 VALUES(90,'SALES',NULL); --��������� NULL�߰�
--���������� �̿��� INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
--Ʈ����� ��ɾ�(DML ��ɾ)
COMMIT;

------------------------------
DROP TABLE SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4),
    ENAME  VARCHAR2(10),
    JOB       VARCHAR2(9),
    SAL       NUMBER(7,2)
    PRIMARY KEY(EMPNO));
SELECT * FROM SAM01;    
INSERT INTO SAM01 VALUES(1000,'APPLE','POLICE',10000);
INSERT INTO SAM01 VALUES(1010,'BANANA','NURSE',15000);
INSERT INTO SAM01 VALUES(1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 VALUES(1030,'VERY',NULL,25000);
INSERT INTO SAM01 VALUES(1040,'CAT',NULL,2000);
INSERT INTO SAM01 VALUES(7782,'CLARK','MANAGER',2450);
INSERT INTO SAM01 VALUES(7839,'KING','PRESIDENT',5000);
INSERT INTO SAM01 VALUES(7934,'MILLER','CLERK',1300);
SELECT * FROM SAM01;    
UPDATE  SAM01  SET  DEPTNO=10 WHERE EMP;
SELECT * FROM SAM01;    