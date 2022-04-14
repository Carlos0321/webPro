--- [VII] DDL, DML, DCL 
-- SQL = DDL (���̺� ����, ���̺� ����, ���̺�  ��������, ���̺� ��� ������ ����)
     --   = DML(�˻� =SELECT, �߰�=INSERT, ����=UPDATE, ����=DELETE)
     --   = DCL(����ڰ�������, ����ڱ��� �ο�,���ѹ�Ż, ����ڰ�������, Ʈ����� ��ɾ� = ROLLBACK,COMMIT) 

-- DDL 
-- 1. ���̺�  ����(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),  --������ȣ BOOKID �ʵ� Ÿ���� ���� 4�ڸ� 
    BOOKNAME VARCHAR2(300),  --å �̸� BOOKNAME �ʵ�� ���� 300BYTE
    PUBLISHER VARCHAR2(300), --���ǻ� PUBLISHER �ʵ�� ���� 300BYTE
    RDATE       DATE,               --������ RDATE �ʵ�� DATE��
    PRICE        NUMBER(8),        -- ���� PRICE �ʵ�� ����8�ڸ�
    PRIMARY KEY(BOOKID));       --���̺� �� ��Ű(PRIMAY KEY) ���� -NOT NULL, ������ �� �Է� 
SELECT * FROM BOOK;    