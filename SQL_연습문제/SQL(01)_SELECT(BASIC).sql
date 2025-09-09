--1. 춘기술대학교의 학과 이름과 계열을 표시하시오. 단, 출력 헤더는 "학과 명"과 "계열"로 표시하도록 한다
SELECT DEPARTMENT_NAME "학과 명", CATEGORY "계열"
FROM TB_DEPARTMENT;

--2. 학과의 학과 정원을 다음과 같은 형태로 화면에 출력한다.
SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || '명 입니다' "학과별 정원"
FROM TB_DEPARTMENT;

--3. 국어국문학과에 다니는 여학생 중 현재 휴학 중인 학생
SELECT STUDENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과';

--4. 도서관에서 대출도사 장기 연체자들을 찾으려고 한다. 대상자들의 학번이 다음과 같을 때

--5. 입학정원이 20명 이상 30명 이하인 학과들의 학과 이름과 계열
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

--6. 춘 기술대학교는 총장 빼고 소속학과를 갖고 있는데, 총장의 이름을 알아내라
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

--7. 전산상의 착오로 학과가 지정되어 있지 않은 학생들을 확인해라
SELECT STUDENT_NAME, DEPARTMENT_NO
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

--8. 선수과목이 존재하는 과목번호 조회
SELECT CLASS_NO;

--9. 춘 대학에는 어떤 계열들이 있는지 조회
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

--10. 02학번들의 전주 거주자 모임을 만드려고 할때 재학 중인 학생의 학번, 이름, 주민번호 
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '%전주%' 
AND ENTRANCE_DATE BETWEEN '02/01/01' AND '02/12/31'
AND ABSENCE_YN = 'N';