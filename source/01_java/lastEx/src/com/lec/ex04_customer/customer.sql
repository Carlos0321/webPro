DROP TABLE CUSTOMER;
DROP TABLE CUS_LEVEL;

--CREATE TABLE
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMERIC(1,0) PRIMARY KEY,
    LEVELNAME VARCHAR2(20) ,
    LOW NUMERIC(10,0) ,
    HIGH  NUMERIC(10,0));

CREATE TABLE CUSTOMER(
    CID NUMERIC(6,0) PRIMARY KEY,
    CTEL VARCHAR2(20) NOT NULL,
    CNAME VARCHAR2(20) NOT NULL,
    CPOINT NUMERIC(10,0) DEFAULT 1000,
    CAMOUNT NUMERIC(10,0) DEFAULT 0,
    LEVELNO NUMERIC(1,0) REFERENCES CUS_LEVEL(LEVELNO));
DROP  SEQUENCE CUS_SEQ;
CREATE SEQUENCE CUS_SEQ MAXVALUE 9999 NOCACHE NOCYCLE;    

INSERT INTO CUS_LEVEL VALUES (1, 'NORMAL', 0, 999999);
INSERT INTO CUS_LEVEL VALUES (2, 'SILVER', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES (3, 'GOLD',   2000000, 2999999);
INSERT INTO CUS_LEVEL VALUES (4, 'VIP',    3000000, 3999999);
INSERT INTO CUS_LEVEL VALUES (5, 'VVIP',   4000000, 999999999);

INSERT INTO CUSTOMER VALUES(CUS_SEQ.NEXTVAL,'010-9999-9999','ȫ�浿',99000,2000000,3);
INSERT INTO CUSTOMER VALUES(CUS_SEQ.NEXTVAL,'010-8888-8888','��浿',1000,4000000,5);
INSERT INTO CUSTOMER VALUES(CUS_SEQ.NEXTVAL,'010-7777-7777','�ű浿',51000,1000000,2);
COMMIT;
SELECT * FROM CUS_LEVEL;
SELECT * FROM CUSTOMER;
-- ���α׷����� �ʿ��� QUERY
-- 0. �����̸��� �˻� : public Vector<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL ;
-- 1. cId�� �˻� : public CustomerDto cIdGetCustomer(int cId)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT,LEVELNAME ,
(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) forLEVELUP
FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO AND CID=1;
-- 2. ����4�ڸ�(FULL) �˻� - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
--                       public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
SELECT CTEL, CNAME, CPOINT, CAMOUNT , LEVELNAME, (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) forLEVELUP
FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO
AND TO_CHAR(CTEL,);
-- 3. ���̸��˻� - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
--                       public ArrayList<CustomerDto> cNameGetCustomers(String cName);

-- 4. ����Ʈ�θ� ����(1000��¥���� ����Ʈ�θ� ����) : public int buyWithPoint(int cAmount, int cId)

-- 5. ��ǰ���� (1000000��¥���� ������ ���. ����Ʈ�� ���űݾ��� 5%)
    -- ��ǰ���Ž� UPDATE 2ȸ �ʿ�(���Ŵ����ݾ� UPDATE�� LEVELNO UPDATE)
    --  public int buy(int cAmount, int cId)

-- 5-1�� 5-2�� ����

-- 6. ��޺���� - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �����������Ѿ���
--              public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)

-- 7.��ü��� - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �����������Ѿ���
--            public ArrayList<CustomerDto> getCustomers()

-- 8. ȸ������(����ȭ�� ���̸��� �Է¹޾� INSERT)
--          public int insertCustomer(String cTel, String cName)

-- 9. ��ȣ���� : public int updateCustomer(String cTel, int cId)

-- 10. ȸ��Ż�� : public int deleteCustomer(String cTel)