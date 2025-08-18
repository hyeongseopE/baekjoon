-- 코드를 입력하세요
SELECT b.ANIMAL_ID, b.NAME
FROM ANIMAL_INS a right join ANIMAL_OUTS b on a.ANIMAL_ID = b.ANIMAL_ID
where a.ANIMAL_ID IS NULL
order by b.ANIMAL_ID asc