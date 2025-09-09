--1. 표에 다음과 같은 값을 집어넣으시오
INSERT INTO TB_CLASS_TYPE VALUES ('01','전공필수')
INSERT INTO TB_CLASS_TYPE VALUES ('02','전공선택')
INSERT INTO TB_CLASS_TYPE VALUES ('01','교양필수')
INSERT INTO TB_CLASS_TYPE VALUES ('01','교양선택')
INSERT INTO TB_CLASS_TYPE VALUES ('01','논문지도')

--2. 학생일반정보 테이블을 작성
INSERT INTO TB_학생일반정보
VALUES(SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
    FROM TB_STUDENT);
    
--3. 국어국문학과 학생들의 정보가 담겨있는 테이블 작성
INSERT INTO TB_국어국문학과
VALUES(SELECT STUDENT_NO, STUDENT_NAME, TODATE(SUBSTR(STUDENT_SSN,1,6)),PROFESSOR_NAME)
        FROM TB_STUDENT
        JOIN TB_PROFESSOR ON(COACH_PROFESSOR_NO = PROFESSOR_NO);
        
--4. 현 학과의 정원을 10% 늘릴때 사용하는 SQL문 작성
UPDATE TB_DEPARTMENT
SET CAPACITY = ROUND(CAPACITY*1.1);

ROLLBACK;

--5. 학번이 A413042인 박건우 학생의 주소를 정정
UPDATE TB_STUDENT
SET STUDENT_ADDRESS = '서울시 종로구 승인동 181-21'
WHERE STUDENT_NAME = '박건우';

--6. 주민등록번호보호법에 따라 뒷자리를 가릴려고 할때 사용할 SQL문 작성
UPDATE TB_STUDENT
SET STUDENT_SSN = SUBSTR(STUDENT_SSN,1,6);

--7. 의학과 피부생리학 김명훈 학생의 학점을 변경
UPDATE TB_GRADE
SET POINT = 3.5
WHERE STUDENT_NO = (SELECT STUDENT_NO
                    FROM TB_STUDENT
                         JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                    WHERE STUDENT_NAME = '김명훈'
                          AND DEPARTMENT_NAME = '의학과')
      AND TERM_NO LIKE '2005%'
      AND CLASS_NO = (SELECT CLASS_NO 
                      FROM TB_CLASS
                      WHERE CLASS_NAME = '피부생리학');


--8. 성적 테이블에서 휴학생들의 성적항목 제거
DELETE FROM TB_GRADE
WHERE STUDENT_NO IN(SELECT STUDENT_NO
                    FROM TB_STUDENT
                    WHERE ABSENCE_YN = 'Y');
                    
ROLLBACK;


