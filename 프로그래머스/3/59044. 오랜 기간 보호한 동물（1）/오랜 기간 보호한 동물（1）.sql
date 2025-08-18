-- 코드를 입력하세요
SELECT a.NAME, a.DATETIME
FROM ANIMAL_INS a left join ANIMAL_OUTS b on a.ANIMAL_ID = b.ANIMAL_ID
WHERE b.ANIMAL_ID IS NULL 
order by a.DATETIME asc 
limit 3;