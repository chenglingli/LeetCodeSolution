Table: Accounts

+-------------+------+
| Column Name | Type |
+-------------+------+
| account_id  | int  |
| income      | int  |
+-------------+------+
account_id is the primary key (column with unique values) for this table.
Each row contains information about the monthly income for one bank account.


Write a solution to calculate the number of bank accounts for each salary category. The salary categories are:

"Low Salary": All the salaries strictly less than $20000.
"Average Salary": All the salaries in the inclusive range [$20000, $50000].
"High Salary": All the salaries strictly greater than $50000.
The result table must contain all three categories. If there are no accounts in a category, return 0.

Return the result table in any order.

The result format is in the following example.



Example 1:

Input:
Accounts table:
+------------+--------+
| account_id | income |
+------------+--------+
| 3          | 108939 |
| 2          | 12747  |
| 8          | 87709  |
| 6          | 91796  |
+------------+--------+
Output:
+----------------+----------------+
| category       | accounts_count |
+----------------+----------------+
| Low Salary     | 1              |
| Average Salary | 0              |
| High Salary    | 3              |
+----------------+----------------+
Explanation:
Low Salary: Account 2.
Average Salary: No accounts.
High Salary: Accounts 3, 6, and 8.



with cte as
(
    select
        sum(case when income >= 20000 and income <= 50000  then 1 else 0 end) as a_count
        ,sum(case when income < 20000 then 1 else 0 end) as l_count
        ,sum(case when income > 50000 then 1 else 0 end) as h_count
     from
        Accounts
)

select
   'Low Salary' as category, l_count as accounts_count from cte
union
select
   'Average Salary' as category, a_count as accounts_count from cte
union
select
   'High Salary' as category, h_count as accounts_count from cte
;


-- Another solution
SELECT 'Low Salary' AS category,
       COUNT(if(income<20000,1,null)) AS accounts_count
FROM Accounts
UNION ALL
SELECT 'Average Salary',
       COUNT(if(income>=20000 and income<=50000,1,null))
FROM Accounts
UNION ALL
SELECT 'High Salary',
       COUNT(if(income>50000,1,null))
FROM Accounts;