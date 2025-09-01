-- 코드를 입력하세요
select *
from CAR_RENTAL_COMPANY_CAR;

# select *
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY;


SELECT distinct a.CAR_ID, a.CAR_TYPE, ROUND(a.DAILY_FEE * 30 * (1 - c.DISCOUNT_RATE / 100),0) as FEE
FROM CAR_RENTAL_COMPANY_CAR a Left Join CAR_RENTAL_COMPANY_RENTAL_HISTORY b on a.CAR_ID = b.CAR_ID
right Join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c on a.CAR_TYPE = c.CAR_TYPE
where a.CAR_TYPE in ('세단','SUV') and
c.DURATION_TYPE = '30일 이상' and
a.CAR_ID NOT IN (select CAR_ID
                 from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                 where START_DATE <= '2022-11-30' and END_DATE >='2022-11-01') 
                 and
a.DAILY_FEE * 30 * (1 - c.DISCOUNT_RATE / 100) >= 500000 and
a.DAILY_FEE * 30 * (1 - c.DISCOUNT_RATE / 100) < 2000000
order by FEE desc, a.CAR_TYPE asc, a.CAR_ID desc