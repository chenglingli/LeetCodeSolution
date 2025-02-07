Table: Trips

+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| client_id   | int      |
| driver_id   | int      |
| city_id     | int      |
| status      | enum     |
| request_at  | varchar  |     
+-------------+----------+
id is the primary key (column with unique values) for this table.
The table holds all taxi trips. Each trip has a unique id, 
while client_id and driver_id are foreign keys to the users_id at the Users table.

Status is an ENUM (category) type of ('completed', 'cancelled_by_driver', 'cancelled_by_client').
 

Table: Users

+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| users_id    | int      |
| banned      | enum     |
| role        | enum     |
+-------------+----------+
users_id is the primary key (column with unique values) for this table.
The table holds all users. Each user has a unique users_id, and role is an ENUM type of ('client', 'driver', 'partner').
banned is an ENUM (category) type of ('Yes', 'No').
 

The cancellation rate is computed by dividing the number of canceled (by client or driver) 
requests with unbanned users by the total number of requests with unbanned users on that day.

Write a solution to find the cancellation rate of requests 
with unbanned users (both client and driver must not be banned) 
each day between "2013-10-01" and "2013-10-03". Round Cancellation Rate to two decimal points.

Return the result table in any order.

The result format is in the following example.

 

Example 1:

Input: 
Trips table:
+----+-----------+-----------+---------+---------------------+------------+
| id | client_id | driver_id | city_id | status              | request_at |
+----+-----------+-----------+---------+---------------------+------------+
| 1  | 1         | 10        | 1       | completed           | 2013-10-01 |
| 2  | 2         | 11        | 1       | cancelled_by_driver | 2013-10-01 |
| 3  | 3         | 12        | 6       | completed           | 2013-10-01 |
| 4  | 4         | 13        | 6       | cancelled_by_client | 2013-10-01 |
| 5  | 1         | 10        | 1       | completed           | 2013-10-02 |
| 6  | 2         | 11        | 6       | completed           | 2013-10-02 |
| 7  | 3         | 12        | 6       | completed           | 2013-10-02 |
| 8  | 2         | 12        | 12      | completed           | 2013-10-03 |
| 9  | 3         | 10        | 12      | completed           | 2013-10-03 |
| 10 | 4         | 13        | 12      | cancelled_by_driver | 2013-10-03 |
+----+-----------+-----------+---------+---------------------+------------+

Users table:
+----------+--------+--------+
| users_id | banned | role   |
+----------+--------+--------+
| 1        | No     | client |
| 2        | Yes    | client |
| 3        | No     | client |
| 4        | No     | client |
| 10       | No     | driver |
| 11       | No     | driver |
| 12       | No     | driver |
| 13       | No     | driver |
+----------+--------+--------+

Output: 
+------------+-------------------+
| Day        | Cancellation Rate |
+------------+-------------------+
| 2013-10-01 | 0.33              |
| 2013-10-02 | 0.00              |
| 2013-10-03 | 0.50              |
+------------+-------------------+

Explanation: 
On 2013-10-01:
  - There were 4 requests in total, 2 of which were canceled.
  - However, the request with Id=2 was made by a banned client (User_Id=2), so it is ignored in the calculation.
  - Hence there are 3 unbanned requests in total, 1 of which was canceled.
  - The Cancellation Rate is (1 / 3) = 0.33
On 2013-10-02:
  - There were 3 requests in total, 0 of which were canceled.
  - The request with Id=6 was made by a banned client, so it is ignored.
  - Hence there are 2 unbanned requests in total, 0 of which were canceled.
  - The Cancellation Rate is (0 / 2) = 0.00
On 2013-10-03:
  - There were 3 requests in total, 1 of which was canceled.
  - The request with Id=8 was made by a banned client, so it is ignored.
  - Hence there are 2 unbanned request in total, 1 of which were canceled.
  - The Cancellation Rate is (1 / 2) = 0.50


-- 计算每日取消率
select 
    request_at as 'Day',  -- 将请求日期重命名为Day
    -- 计算取消率：非completed状态的数量除以总数，四舍五入保留2位小数
    round(sum(status!='completed')/count(*),2) as 'Cancellation Rate'
from Trips t 
-- 连接客户信息表，匹配client_id和users_id
inner join Users clt on t.client_id = clt.users_id
-- 连接司机信息表，匹配driver_id和users_id
inner join Users drv on t.driver_id = drv.users_id
where 
    clt.banned='NO'  -- 筛选未被禁止的客户
    and drv.banned='NO'  -- 筛选未被禁止的司机
    and request_at between '2013-10-01' and '2013-10-03'  -- 限定日期范围
group by request_at  -- 按日期分组统计



-- 创建临时表temp，用于存储符合条件的行程数据
WITH temp AS(
    SELECT 
        t.request_at AS 'Day',  -- 将请求日期重命名为Day
        t.status                -- 选择行程状态
    FROM Trips AS t 
    -- 连接用户表获取客户信息
    JOIN Users AS u1 ON t.client_id = u1.users_id
    -- 连接用户表获取司机信息
    JOIN Users AS u2 ON t.driver_id = u2.users_id
    -- 筛选条件：指定日期范围内且客户和司机都未被禁止
    WHERE request_at BETWEEN '2013-10-01' AND '2013-10-03'
    AND u1.banned='No' AND u2.banned='No'
)

-- 从临时表中计算每日取消率
SELECT 
    Day,
    -- 使用CASE语句计算取消率：
    -- 1. 统计非completed状态的订单数（分子）
    -- 2. 除以总订单数（分母）
    -- 3. 四舍五入保留2位小数
    ROUND(SUM(CASE
        WHEN status!='completed' THEN 1
        ELSE 0
        END)/COUNT(*),2) AS 'Cancellation Rate'
FROM temp
GROUP BY Day    -- 按日期分组
ORDER BY Day    -- 按日期排序