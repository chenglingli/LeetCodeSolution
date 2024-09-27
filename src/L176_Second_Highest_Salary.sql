Table: Employee

+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key (column with unique values) for this table.
Each row of this table contains information about the salary of an employee.


Write a solution to find the second highest distinct salary from the Employee table. If there is no second highest salary, return null (return None in Pandas).

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
Output:
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
Example 2:

Input:
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
Output:
+---------------------+
| SecondHighestSalary |
+---------------------+
| null                |
+---------------------+


-- 262 ms
select
(select distinct Salary as SecondHighestSalary
from Employee order by salary desc
limit 1 offset 1)
as SecondHighestSalary;

-- 744 ms
select max(salary) as SecondHighestSalary
from employee
where salary !=
    (select max(salary) from employee);

-- 213 ms
select max(e.salary) as SecondHighestSalary
from Employee as e
join (select max(salary) as salary from Employee) as max
where e.salary < max.salary

