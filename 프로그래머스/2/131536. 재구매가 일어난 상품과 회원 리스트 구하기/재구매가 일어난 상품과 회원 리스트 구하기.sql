-- 코드를 입력하세요
SELECT USER_ID,product_id
from(
    SELECT USER_ID,PRODUCT_ID,COUNT(PRODUCT_ID) as PRODUCT_CNT
    FROM ONLINE_SALE
    GROUP BY USER_ID,PRODUCT_ID
    HAVING COUNT(*) >= 2
)
order by user_id, product_id desc