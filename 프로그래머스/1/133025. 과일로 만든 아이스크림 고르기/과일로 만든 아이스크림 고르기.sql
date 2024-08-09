-- 코드를 입력하세요
SELECT f.flavor
from FIRST_HALF f join ICECREAM_INFO c
on f.FLAVOR = c.FLAVOR
where f.total_order > 3000 AND c.INGREDIENT_TYPE = 'fruit_based'
order by total_order desc;

