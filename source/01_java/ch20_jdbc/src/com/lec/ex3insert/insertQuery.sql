-- �μ���ȣ �ߺ�üũ
SELECT * FROM DEPT WHERE DEPTNO=70; -- rs.next()����� true(�ߺ����) / false(�μ���/�μ���ġ�Է¹޾� �Է�)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;  -- 0�̸� �ߺ�X / 1�̸� �ߺ�O
--�Է�
INSERT INTO DEPT VALUES(55, 'IT','SEOUL');
DELETE FROM DEPT WHERE DEPTNO = 55;
UPDATE DEPT SET DNAME = 'ABC' WHERE DEPTNO= 55;
--����
UPDATE DEPT SET DNAME = 'ABC', LOC='SEOUL' WHERE DEPTNO=11;
COMMIT;
SELECT * FROM DEPT;
SELECT DEPTNO  FROM DEPT; 

--����
DELETE FROM DEPT WHERE DEPTNO=55;
COMMIT;
SELECT * FROM DEPT;
SELECT * FROM EMP;
-- �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ� 
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E , DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('sales');
UPDATE DEPT SET DNAME='SALES' WHERE DEPTNO=30;
COMMIT;