## 정답 ##

--1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select to_char(to_date('20201225','yyyymmdd'),'day') 요일
from dual;

--2. 주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select emp_name 사원명
     , emp_no 주민번호
     , dept_title 부서명
     , job_name 직급명
from employee e 
  left join department d on e.dept_code = d.dept_id
  left join job j using(job_code)  
where substr(emp_no,8,1) = 2 and substr(emp_no,1,1) = 7 
    and emp_name like '전%';

또는 

SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE SUBSTR(EMP_NO, 1,2) >= 70 AND SUBSTR(EMP_NO, 1,2) <80
  AND SUBSTR(EMP_NO, 8,1) = 2
  AND EMP_NAME LIKE '전%';

또는


SELECT EMP_NAME,EMP_NO,DEPT_TITLE,JOB_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT DEPT_CODE ON DEPT_CODE = DEPT_ID
LEFT JOIN JOB J ON  E.JOB_CODE = J.JOB_CODE
WHERE SUBSTR(EMP_NO,1,1) = 7 AND SUBSTR(EMP_NO,8,1)=2
AND EMP_NAME LIKE '전%';

또는

SELECT EMP_NAME,EMP_NO,DEPT_TITLE,JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN JOB USING(JOB_CODE)
WHERE (1900+SUBSTR(EMP_NO,1,2)) BETWEEN 1970 AND 1979 
    AND SUBSTR(EMP_NO,8,1)=2 AND EMP_NAME LIKE '전%';




--3. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.

SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE EMP_NAME LIKE '%형%';


--4. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
SELECT  EMP_NAME AS "사원명", 
        JOB_NAME AS "직급명", 
        DEPT_CODE AS "부서코드", 
        DEPT_TITLE AS "부서명"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN JOB USING(JOB_CODE)
WHERE DEPT_TITLE LIKE '해외영업%';


--5. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.

SELECT EMP_NAME, BONUS, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE BONUS IS NOT NULL;


--6. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
SELECT  EMP_NAME AS "사원명", 
        JOB_NAME AS "직급명", 
        DEPT_TITLE AS "부서명", 
        LOCAL_NAME AS "근무지역명"
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN JOB USING(JOB_CODE)
LEFT JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
WHERE DEPT_CODE = 'D2';



--7. 급여등급테이블의 최대급여(MAX_SAL)-500000보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
-- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 조인할 것)
SELECT EMP_NAME
      , JOB_NAME
      , SALARY
      , SALARY*12+SALARY*NVL(BONUS,0) 
      , MAX_SAL
FROM EMPLOYEE E
 JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
 JOIN SAL_GRADE S USING(SAL_LEVEL)
WHERE E.SALARY > S.MAX_SAL-500000;


--8. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
SELECT * FROM NATIONAL;
SELECT * FROM LOCATION;

SELECT  EMP_NAME AS "사원명", 
        DEPT_TITLE AS "부서명",
        LOCAL_NAME AS "지역명", 
        NATIONAL_NAME AS "국가명"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
LEFT JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME IN ('한국','일본');


--9. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
SELECT  E1.EMP_NAME AS "사원명" ,
        DEPT_TITLE AS "부서명",
        E2.EMP_NAME AS "동료이름"
FROM EMPLOYEE E1
LEFT JOIN EMPLOYEE E2 ON (E1.DEPT_CODE = E2.DEPT_CODE)
LEFT JOIN DEPARTMENT ON (E1.DEPT_CODE = DEPT_ID)
WHERE E1.EMP_NAME != E2.EMP_NAME
ORDER BY 1;


--10. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 IN 사용할 것
SELECT  EMP_NAME AS "사원명",
        JOB_NAME AS "직급명", 
        SALARY AS "급여"
FROM EMPLOYEE
LEFT JOIN JOB USING(JOB_CODE)
WHERE BONUS IS NULL AND JOB_NAME IN ('차장','사원');



--11. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
SELECT  DECODE(ENT_YN,'N','재직','Y','퇴사') AS "재직여부",
        COUNT(*) AS "인원 수"
FROM EMPLOYEE
GROUP BY ENT_YN;