Table: Logs

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
In SQL, id is the primary key for this table.
id is an autoincrement column starting from 1.


Find all numbers that appear at least three times consecutively.

Return the result table in any order.

The result format is in the following example.



Example 1:

Input:
Logs table:
+----+-----+
| id | num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
Output:
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
Explanation: 1 is the only number that appears consecutively for at least three times.

-- 894ms
with cte as (
    select num,
    lead(num,1) over() num1,
    lead(num,2) over() num2
    from logs

)

select
    distinct num ConsecutiveNums
from
    cte
where
    (num=num1) and (num=num2)


-- 729ms
SELECT
    DISTINCT l1.num AS ConsecutiveNums
FROM
    logs l1
JOIN
    logs l2
    ON l1.num = l2.num AND l1.id + 1 = l2.id
JOIN
    logs l3
    ON l2.num = l3.num  AND l2.id +1 = l3.id


