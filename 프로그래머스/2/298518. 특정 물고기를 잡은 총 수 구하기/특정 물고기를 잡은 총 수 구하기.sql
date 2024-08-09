-- 코드를 작성해주세요
Select count(i.FISH_TYPE) as FISH_COUNT
from FISH_INFO i join FISH_NAME_INFO n
on i.FISH_TYPE = n.FISH_TYPE
where n.FISH_NAME in ('BASS','SNAPPER');