-- 코드를 입력하세요
SELECT pt_name,pt_no,gend_cd,age,NVL(tlno,'NONE')
from patient
where gend_cd = 'W' AND age <= 12
order by age desc, pt_name