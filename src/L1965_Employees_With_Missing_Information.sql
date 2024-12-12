Table: Employees

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| employee_id | int     |
| name        | varchar |
+-------------+---------+
employee_id is the column with unique values for this table.
Each row of this table indicates the name of the employee whose ID is employee_id.


Table: Salaries

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| employee_id | int     |
| salary      | int     |
+-------------+---------+
employee_id is the column with unique values for this table.
Each row of this table indicates the salary of the employee whose ID is employee_id.


Write a solution to report the IDs of all the employees with missing information.
The information of an employee is missing if:

The employee's name is missing, or
The employee's salary is missing.
Return the result table ordered by employee_id in ascending order.

The result format is in the following example.



Example 1:

Input:
Employees table:
+-------------+----------+
| employee_id | name     |
+-------------+----------+
| 2           | Crew     |
| 4           | Haven    |
| 5           | Kristian |
+-------------+----------+
Salaries table:
+-------------+--------+
| employee_id | salary |
+-------------+--------+
| 5           | 76071  |
| 1           | 22517  |
| 4           | 63539  |
+-------------+--------+
Output:
+-------------+
| employee_id |
+-------------+
| 1           |
| 2           |
+-------------+
Explanation:
Employees 1, 2, 4, and 5 are working at this company.
The name of employee 1 is missing.
The salary of employee 2 is missing.


-- 1000ms
select Employees.employee_id from Employees natural left join Salaries
where Salaries.salary is null
union
select Salaries.employee_id from salaries natural left join Employees
where Employees.name is null
order by employee_id;


-- 862ms
select e.employee_id from employees e
left join salaries s on e.employee_id  = s.employee_id
where salary is null

union

select s.employee_id from salaries s
left join employees e on e.employee_id  = s.employee_id
where name is null
order by employee_id  asc


with cte as (
    select employee_id from Employees
    union
    select employee_id from Salaries
)

-- 563ms
with cte as (
    select employee_id from Employees
    union
    select employee_id from Salaries
)

select employee_id
from cte
where employee_id not in (select employee_id from Employees)

union

select employee_id
from cte
where employee_id not in (select employee_id from Salaries)

order by employee_id



-- 800+ms
select e.employee_id
from employees e
left join salaries s
on e.employee_id = s.employee_id
where salary is null

union

select s.employee_id
from employees e
right join salaries s
on e.employee_id = s.employee_id
where name is null

order by employee_id