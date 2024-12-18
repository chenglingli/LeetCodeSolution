Table: Employee

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
id is the primary key (column with unique values) for this table.
departmentId is a foreign key (reference columns) of the ID from the Department table.
Each row of this table indicates the ID, name, and salary of an employee. It also contains the ID of their department.


Table: Department

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
id is the primary key (column with unique values) for this table. It is guaranteed that department name is not NULL.
Each row of this table indicates the ID of a department and its name.


Write a solution to find employees who have the highest salary in each of the departments.

Return the result table in any order.

The result format is in the following example.

Example 1:

Input:
Employee table:
+----+-------+--------+--------------+
| id | name  | salary | departmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
Department table:
+----+-------+
| id | name  |
+----+-------+
| 1  | IT    |
| 2  | Sales |
+----+-------+
Output:
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
| IT         | Max      | 90000  |
+------------+----------+--------+
Explanation: Max and Jim both have the highest salary in the IT department
and Henry has the highest salary in the Sales department.


-- 1084ms
select
    d.name as Department, e.name as Employee, e.salary as Salary
from
    Employee e
left join
    Department d
    on e.departmentId = d.id
where
    (e.departmentId, e.salary) in (
        select
            departmentId, max(salary)
        from
            Employee
        group by
            departmentId
    )



--
with table1 as (
    select name, salary, departmentId,
    dense_rank() over(partition by departmentId order by salary desc) as ranking
    from Employee
)

select
    t2.name as Department, t1.name as Employee, t1.salary as Salary
from
    table1 t1
left join Department t2
on t1.departmentId = t2.id
where t1.ranking = 1;




