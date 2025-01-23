Table: Stadium

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| visit_date    | date    |
| people        | int     |
+---------------+---------+
visit_date is the column with unique values for this table.
Each row of this table contains the visit date and visit id to the stadium with the number of people during the visit.
As the id increases, the date increases as well.


Write a solution to display the records with three or more rows with consecutive id's,
and the number of people is greater than or equal to 100 for each.

Return the result table ordered by visit_date in ascending order.

The result format is in the following example.



Example 1:

Input:
Stadium table:
+------+------------+-----------+
| id   | visit_date | people    |       id-行号（>99）
+------+------------+-----------+
| 1    | 2017-01-01 | 10        |
| 2    | 2017-01-02 | 109       |       1
| 3    | 2017-01-03 | 150       |       1
| 4    | 2017-01-04 | 99        |
| 5    | 2017-01-05 | 145       |       2
| 6    | 2017-01-06 | 1455      |       2
| 7    | 2017-01-07 | 199       |       2
| 8    | 2017-01-09 | 188       |       2
+------+------------+-----------+
Output:
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-09 | 188       |
+------+------------+-----------+
Explanation:
The four rows with ids 5, 6, 7, and 8 have consecutive ids and each of them has >= 100 people attended.
Note that row 8 was included even though the visit_date was not the next day after row 7.
The rows with ids 2 and 3 are not included because we need at least three consecutive ids.

select * from stadium
where id in (
    select id from stadium
    where people >= 100
    intersect
    select id + 1 from stadium
    where people >= 100
    intersect
    select id + 2 from stadium
    where people >= 100
) or id in (
    select id from stadium
    where people >= 100
    intersect
    select id - 1 from stadium
    where people >= 100
    intersect
    select id + 1 from stadium
    where people >= 100
) or id in (
    select id from stadium
    where people >= 100
    intersect
    select id - 1 from stadium
    where people >= 100
    intersect
    select id - 2 from stadium
    where people >= 100
)
order by visit_date


-- 1. 基于查询条件得出结果集，并且计算id-行号。
-- 2. 如果连续>99，那么id-行号的值是一样的
-- q1的结果是 id,visit_date,people,diffBtwIdAndRowNum 且 people>99
-- 对于上面例子就是：
--| 2    | 2017-01-02 | 109       |       1
--| 3    | 2017-01-03 | 150       |       1
--| 4    | 2017-01-04 | 99        |
--| 5    | 2017-01-05 | 145       |       2
--| 6    | 2017-01-06 | 1455      |       2
--| 7    | 2017-01-07 | 199       |       2
--| 8    | 2017-01-09 | 188       |       2
With q1 as
(
    select
        *, id-row_number() over() as diffBtwIdAndRowNum
    from
        stadium
    where
        people>99
)

-- 3. 对于上面的结果集，找出diffBtwIdAndRowNum的值出现次数>=3的行
select
    id, visit_date, people
from
    q1
where
    diffBtwIdAndRowNum in
    (select diffBtwIdAndRowNum
    from q1
    group by diffBtwIdAndRowNum
    having count(diffBtwIdAndRowNum)>=3)


-- 使用join的方式
-- 三个表join在一起，join的条件是连续态
-- 查询条件是人数都>=100
-- RT最短
select
    distinct s1.*
from Stadium s1
JOIN Stadium s2
JOIN Stadium s3
ON
    (s1.id = s2.id-1 AND s1.id = s3.id-2) OR
    (s1.id = s2.id+1 AND s1.id = s3.id-1) OR
    (s1.id = s2.id+2 AND s1.id = s3.id+1)
where
    s1.people>=100 and s2.people>=100 and s3.people>=100
order by
    s1.visit_date