Table: Sales

+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| sale_id     | int   |
| product_id  | int   |
| year        | int   |
| quantity    | int   |
| price       | int   |
+-------------+-------+
(sale_id, year) is the primary key (combination of columns with unique values) of this table.
product_id is a foreign key (reference column) to Product table.
Each row of this table shows a sale on the product product_id in a certain year.
Note that the price is per unit.


Table: Product

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| product_id   | int     |
| product_name | varchar |
+--------------+---------+
product_id is the primary key (column with unique values) of this table.
Each row of this table indicates the product name of each product.


Write a solution to select the product id, year, quantity, and price for the first year of every product sold.

Return the resulting table in any order.

The result format is in the following example.



Example 1:

Input:
Sales table:
+---------+------------+------+----------+-------+
| sale_id | product_id | year | quantity | price |
+---------+------------+------+----------+-------+
| 1       | 100        | 2008 | 10       | 5000  |
| 2       | 100        | 2009 | 12       | 5000  |
| 7       | 200        | 2011 | 15       | 9000  |
+---------+------------+------+----------+-------+
Product table:
+------------+--------------+
| product_id | product_name |
+------------+--------------+
| 100        | Nokia        |
| 200        | Apple        |
| 300        | Samsung      |
+------------+--------------+
Output:
+------------+------------+----------+-------+
| product_id | first_year | quantity | price |
+------------+------------+----------+-------+
| 100        | 2008       | 10       | 5000  |
| 200        | 2011       | 15       | 9000  |
+------------+------------+----------+-------+



-- 某产品某一年有多笔销售记录，找出每个产品的第一年的销售记录
select
    product_id, year as first_year, quantity, price
from
    Sales
where product_id, year in (
    select
        product_id, min(year)
    from
        Sales
    group by
        product_id
)

-- 1846ms
-- 用with子句, 先找出每个产品的第一年, 再和Sales表连接
WITH FirstYearSales AS (
    SELECT
        product_id,
        MIN(year) AS first_year
    FROM
        Sales
    GROUP BY
        product_id
)
SELECT
    s.product_id,
    f.first_year,
    s.quantity,
    s.price
FROM
    Sales s
JOIN
    FirstYearSales f
ON
    s.product_id = f.product_id
    AND s.year = f.first_year;

-- 1483ms
-- 子查询，找出每个产品按照product_id进行分区，按照year排序，找出每个产品的第一年
SELECT product_id, first_year, quantity, price
FROM (
    SELECT
        product_id,
        year AS first_year,
        quantity,
        price,
        RANK() OVER (PARTITION BY product_id ORDER BY year) AS row_num
    FROM Sales
) subQuery
WHERE row_num = 1





