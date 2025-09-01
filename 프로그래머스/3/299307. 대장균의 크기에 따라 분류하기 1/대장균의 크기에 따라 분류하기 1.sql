-- 코드를 작성해주세요
select a.ID, case 
    when a.SIZE_OF_COLONY <= 100 then 'LOW' 
    when a.SIZE_OF_COLONY <= 1000 then 'MEDIUM' 
    ELSE 'HIGH'
    end as SIZE
from ECOLI_DATA a
order by a.ID