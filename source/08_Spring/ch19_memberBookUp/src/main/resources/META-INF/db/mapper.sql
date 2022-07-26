--★MEMBER.XML (회원가입, id로 memberDto 가져오기, 로그인, 정보수정 )
--idConfirm
SELECT * FROM MEMBER WHERE MID = 'aaa';
-- joinMember
INSERT INTO MEMBER VALUES('asd','1','토레타','asd@naver.com','152-955','서울');
-- getMember
SELECT * FROM MEMBER WHERE MID='asd';

SELECT * FROM MEMBER;
-- modifyMember

                                
--★Book.xml(페이징 없이 신규 순서대로 list, 페이징 포함된 도서보기(책 이름순), 책 개수, 상세보기, 도서등록, 도서수정
--mainList
SELECT * FROM BOOK ORDER BY BRDATE;
--bookList
SELECT * FROM (SELECT ROWNUM RN, A.* 
            FROM (SELECT * FROM BOOK ORDER BY BTITLE DESC) A)
        WHERE RN BETWEEN 1 AND 3;
--bookList_search
SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOOK WHERE BTITLE LIKE '%'||'캐슬'||'%' ORDER BY BTITLE)A )
    WHERE RN BETWEEN 1 AND 3;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOOK WHERE BWRITER LIKE '%'||'만'||'%' ORDER BY BTITLE)A )
    WHERE RN BETWEEN 1 AND 3;    
SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOOK WHERE BWRITER LIKE '%'||'만'||'%' OR BTITLE LIKE '%'||'캐슬'||'%' ORDER BY BTITLE)A )
   WHERE RN BETWEEN 1 AND 3;   
--totCntBook
SELECT COUNT(*) FROM BOOK;
SELECT COUNT(*) FROM BOOK WHERE BTITLE LIKE '%'||'호랑이형님'||'%' OR BWRITER LIKE '%'||'이'||'%';
--getDetailBook
SELECT * FROM BOOK WHERE BNUM='1';
--registerBook
INSERT INTO BOOK VALUES (BOOK_SEQ.NEXTVAL,'python','백도찬',SYSDATE,'noImg.png','noImg.png','캐슬');
INSERT INTO BOOK VALUES (BOOK_SEQ.NEXTVAL,'호랑이형님','이상규',SYSDATE,'noImg.png','noImg.png','동양판타지');
--modifyBook
UPDATE BOOK SET  BTITLE = '캐슬',
                            BWRITER = '만신정연',
                            BRDATE = '19/11/26',
                            BIMG1 = 'noImg.png',
                            BIMG2 = 'noImg.png'                        
                            WHERE BNUM = 1;
commit;
select * from book;
update book set bimg1 ='noImg.png' where bnum= 2;