## ���� ##

--1. 2020�� 12�� 25���� ���� �������� ��ȸ�Ͻÿ�.
select to_char(to_date('20201225','yyyymmdd'),'day') ����
from dual;

--2. �ֹι�ȣ�� 1970��� ���̸鼭 ������ �����̰�, ���� ������ �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�Ͻÿ�.
select emp_name �����
     , emp_no �ֹι�ȣ
     , dept_title �μ���
     , job_name ���޸�
from employee e 
  left join department d on e.dept_code = d.dept_id
  left join job j using(job_code)  
where substr(emp_no,8,1) = 2 and substr(emp_no,1,1) = 7 
    and emp_name like '��%';

�Ǵ� 

SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE SUBSTR(EMP_NO, 1,2) >= 70 AND SUBSTR(EMP_NO, 1,2) <80
  AND SUBSTR(EMP_NO, 8,1) = 2
  AND EMP_NAME LIKE '��%';

�Ǵ�


SELECT EMP_NAME,EMP_NO,DEPT_TITLE,JOB_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT DEPT_CODE ON DEPT_CODE = DEPT_ID
LEFT JOIN JOB J ON  E.JOB_CODE = J.JOB_CODE
WHERE SUBSTR(EMP_NO,1,1) = 7 AND SUBSTR(EMP_NO,8,1)=2
AND EMP_NAME LIKE '��%';

�Ǵ�

SELECT EMP_NAME,EMP_NO,DEPT_TITLE,JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN JOB USING(JOB_CODE)
WHERE (1900+SUBSTR(EMP_NO,1,2)) BETWEEN 1970 AND 1979 
    AND SUBSTR(EMP_NO,8,1)=2 AND EMP_NAME LIKE '��%';




--3. �̸��� '��'�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�Ͻÿ�.

SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE EMP_NAME LIKE '%��%';


--4. �ؿܿ����ο� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�Ͻÿ�.
SELECT  EMP_NAME AS "�����", 
        JOB_NAME AS "���޸�", 
        DEPT_CODE AS "�μ��ڵ�", 
        DEPT_TITLE AS "�μ���"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN JOB USING(JOB_CODE)
WHERE DEPT_TITLE LIKE '�ؿܿ���%';


--5. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.

SELECT EMP_NAME, BONUS, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE BONUS IS NOT NULL;


--6. �μ��ڵ尡 D2�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.
SELECT  EMP_NAME AS "�����", 
        JOB_NAME AS "���޸�", 
        DEPT_TITLE AS "�μ���", 
        LOCAL_NAME AS "�ٹ�������"
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN JOB USING(JOB_CODE)
LEFT JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
WHERE DEPT_CODE = 'D2';



--7. �޿�������̺��� �ִ�޿�(MAX_SAL)-500000���� ���� �޴� �������� �����, ���޸�, �޿�, ������ ��ȸ�Ͻÿ�.
-- (������̺�� �޿�������̺��� SAL_LEVEL�÷��������� ������ ��)
SELECT EMP_NAME
      , JOB_NAME
      , SALARY
      , SALARY*12+SALARY*NVL(BONUS,0) 
      , MAX_SAL
FROM EMPLOYEE E
 JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
 JOIN SAL_GRADE S USING(SAL_LEVEL)
WHERE E.SALARY > S.MAX_SAL-500000;


--8. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����, �μ���, ������, �������� ��ȸ�Ͻÿ�.
SELECT * FROM NATIONAL;
SELECT * FROM LOCATION;

SELECT  EMP_NAME AS "�����", 
        DEPT_TITLE AS "�μ���",
        LOCAL_NAME AS "������", 
        NATIONAL_NAME AS "������"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
LEFT JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME IN ('�ѱ�','�Ϻ�');


--9. ���� �μ��� �ٹ��ϴ� �������� �����, �μ���, �����̸��� ��ȸ�Ͻÿ�. (self join ���)
SELECT  E1.EMP_NAME AS "�����" ,
        DEPT_TITLE AS "�μ���",
        E2.EMP_NAME AS "�����̸�"
FROM EMPLOYEE E1
LEFT JOIN EMPLOYEE E2 ON (E1.DEPT_CODE = E2.DEPT_CODE)
LEFT JOIN DEPARTMENT ON (E1.DEPT_CODE = DEPT_ID)
WHERE E1.EMP_NAME != E2.EMP_NAME
ORDER BY 1;


--10. ���ʽ�����Ʈ�� ���� ������ �߿��� ������ ����� ����� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�. ��, join�� IN ����� ��
SELECT  EMP_NAME AS "�����",
        JOB_NAME AS "���޸�", 
        SALARY AS "�޿�"
FROM EMPLOYEE
LEFT JOIN JOB USING(JOB_CODE)
WHERE BONUS IS NULL AND JOB_NAME IN ('����','���');



--11. �������� ������ ����� ������ ���� ��ȸ�Ͻÿ�.
SELECT  DECODE(ENT_YN,'N','����','Y','���') AS "��������",
        COUNT(*) AS "�ο� ��"
FROM EMPLOYEE
GROUP BY ENT_YN;