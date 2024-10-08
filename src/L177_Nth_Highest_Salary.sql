
Table: Employee

+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key (column with unique values) for this table.
Each row of this table contains information about the salary of an employee.


Write a solution to find the nth highest salary from the Employee table. If there is no nth highest salary, return null.

The result format is in the following example.



Example 1:

Input:
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
n = 2
Output:
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
Example 2:

Input:
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
n = 2
Output:
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| null                   |
+------------------------+



-- 667 ms
-- 实现方式：
-- 使用limit和offset获取第N高的工资
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N-1;
    RETURN (
    select distinct Salary as SecondHighestSalary
    from Employee order by salary desc
    limit 1 offset N
    );
END


-- 469 ms
-- 实现方式：
-- 1. 使用row_number()为每一行分配一个唯一编号，基于工资按降序排列（需要group by salary）
-- 2. 使用CTE获取工资和行号。
-- 3. 选择行号等于N的工资。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
   with CTE as (
        select salary, row_number() over (order by salary desc) as rnk
        from Employee
        group by salary
    )
    select salary from CTE where rnk = N
  );
END

-- 3933 ms
-- 实现方式：
-- 1. 使用DENSE_RANK()为每一行分配一个唯一编号，基于工资按降序排列（不需要group by salary）
-- 2. 使用CTE获取工资和行号。
-- 3. 选择行号等于N的工资。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
   with CTE as (
        select salary, DENSE_RANK() over (order by salary desc) as rnk
        from Employee
    )
    select salary from CTE where rnk = N limit 1
  );
END

--
--RANK() 和 DENSE_RANK() 的区别
--
--	•	RANK()：相同工资的员工会有相同的排名，但下一名的排名会跳过
--	•	DENSE_RANK()：相同工资的员工会有相同的排名，下一名不会跳过
--	•	ROW_NUMBER()：不会跳过任何行