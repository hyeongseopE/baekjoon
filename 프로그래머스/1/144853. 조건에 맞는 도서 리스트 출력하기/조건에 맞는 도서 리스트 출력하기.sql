-- 코드를 입력하세요
SELECT book_id,TO_CHAR(published_date,'YYYY-MM-DD') as published_date
from book
where extract(year from published_date) = '2021' AND CATEGORY = '인문'
order by published_date