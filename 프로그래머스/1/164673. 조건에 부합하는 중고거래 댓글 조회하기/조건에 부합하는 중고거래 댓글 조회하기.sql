-- 코드를 입력하세요
SELECT b.title,b.board_id,r.reply_id,r.writer_id,r.contents,TO_CHAR(r.created_date,'YYYY-MM-DD') as created_date
FROM USED_GOODS_BOARD b
JOIN USED_GOODS_REPLY r
    on b.board_id = r.board_id 
where extract(Month from b.created_date) = 10 AND extract(year from b.created_date) = 2022
order by r.created_date,b.title
