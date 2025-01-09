Table: Queue

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| person_id   | int     |
| person_name | varchar |
| weight      | int     |
| turn        | int     |
+-------------+---------+
person_id column contains unique values.
This table has the information about all people waiting for a bus.
The person_id and turn columns will contain all numbers from 1 to n, where n is the number of rows in the table.
turn determines the order of which the people will board the bus,
where turn=1 denotes the first person to board and turn=n denotes the last person to board.
weight is the weight of the person in kilograms.


There is a queue of people waiting to board a bus. However, the bus has a weight limit of 1000 kilograms,
so there may be some people who cannot board.

Write a solution to find the person_name of the last person that can fit on the bus without exceeding the weight limit.
The test cases are generated such that the first person does not exceed the weight limit.

Note that only one person can board the bus at any given turn.

The result format is in the following example.



Example 1:

Input:
Queue table:
+-----------+-------------+--------+------+
| person_id | person_name | weight | turn |
+-----------+-------------+--------+------+
| 5         | Alice       | 250    | 1    |
| 4         | Bob         | 175    | 5    |
| 3         | Alex        | 350    | 2    |
| 6         | John Cena   | 400    | 3    |
| 1         | Winston     | 500    | 6    |
| 2         | Marie       | 200    | 4    |
+-----------+-------------+--------+------+
Output:
+-------------+
| person_name |
+-------------+
| John Cena   |
+-------------+
Explanation: The folowing table is ordered by the turn for simplicity.
+------+----+-----------+--------+--------------+
| Turn | ID | Name      | Weight | Total Weight |
+------+----+-----------+--------+--------------+
| 1    | 5  | Alice     | 250    | 250          |
| 2    | 3  | Alex      | 350    | 600          |
| 3    | 6  | John Cena | 400    | 1000         | (last person to board)
| 4    | 2  | Marie     | 200    | 1200         | (cannot board)
| 5    | 4  | Bob       | 175    | ___          |
| 6    | 1  | Winston   | 500    | ___          |
+------+----+-----------+--------+--------------+


SELECT
    q1.person_name
FROM Queue q1
JOIN Queue q2
ON q1.turn >= q2.turn
GROUP BY q1.turn
HAVING SUM(q2.weight) <= 1000
ORDER BY SUM(q2.weight) DESC
LIMIT 1




Intuition
The goal is to find the last person who can fit on the bus without exceeding the weight limit.
We need to consider the order of people based on their turn and calculate the cumulative weight at each turn
 to check if it exceeds the weight limit.

Approach
We join the Queue table with itself, creating combinations of rows
where each row is paired with all rows that have a higher or equal turn value.

We group the rows by turn and calculate the sum of weights for each group.
Using the HAVING clause, we filter out groups whose sum of weights exceeds the weight limit of 1000.
We order the results by the sum of weights in descending order, ensuring the last person who can fit is at the top.
Finally, we limit the result to 1 row since we only need the information of the last person.

Complexity
Time complexity:
The time complexity of this query is dependent on the number of rows in the Queue table.
Let's denote this number as 'n'. The join operation has a complexity of O(n^2),
as it pairs each row with all the rows that have a higher turn.

 The grouping operation has a complexity of O(n), as it groups the rows by turn.
 Finally, ordering the result and limiting it to 1 row have a complexity of O(nlogn).
 Therefore, the overall time complexity is O(n^2).

Space complexity:
The space complexity is determined by the memory required to store the rows and the intermediate results of the query.
In this case, it is proportional to the number of rows in the Queue table, so the space complexity is O(n).


1，先join两个表，q1和q2，q1.turn >= q2.turn
q1.turn q2.turn
1       1
2       1, 2
3       1, 2, 3
4       1, 2, 3, 4
5       1, 2, 3, 4, 5
6       1, 2, 3, 4, 5, 6

2，然后按照q1.turn分组，计算每组的weight总和，HAVING SUM(q2.weight) <= 1000
q1.turn SUM(q2.weight)

3，最后按照SUM(q2.weight)降序排序，取第一个即可

注意，这里的q1和q2是同一个表，只是join的时候，q1.turn >= q2.turn，所以q1.turn是大于等于q2.turn的，所以q1.turn是递增的，q2.turn是递减的



SELECT person_name
FROM (
    SELECT
        person_id,
        person_name,
        weight,
        turn,
        SUM(weight) OVER (ORDER BY turn) AS cumulative_weight
    FROM Queue
    ORDER BY turn
    ) AS cumulative
WHERE cumulative_weight <= 1000
ORDER BY cumulative_weight DESC
LIMIT 1