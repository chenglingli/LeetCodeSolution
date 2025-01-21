Table: Scores

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| student_id  | int     |
| subject     | varchar |
| score       | int     |
| exam_date   | varchar |
+-------------+---------+
(student_id, subject, exam_date) is the primary key for this table.
Each row contains information about a student's score in a specific subject on a particular exam date.
score is between 0 and 100 (inclusive).

Write a solution to find the students who have shown improvement.
A student is considered to have shown improvement if they meet both of these conditions:

Have taken exams in the same subject on at least two different dates
Their latest score in that subject is higher than their first score
Return the result table ordered by student_id, subject in ascending order.

The result format is in the following example.



Example:

Input:

Scores table:

+------------+----------+-------+------------+
| student_id | subject  | score | exam_date  |
+------------+----------+-------+------------+
| 101        | Math     | 70    | 2023-01-15 |
| 101        | Math     | 85    | 2023-02-15 |
| 101        | Physics  | 65    | 2023-01-15 |
| 101        | Physics  | 60    | 2023-02-15 |
| 102        | Math     | 80    | 2023-01-15 |
| 102        | Math     | 85    | 2023-02-15 |
| 103        | Math     | 90    | 2023-01-15 |
| 104        | Physics  | 75    | 2023-01-15 |
| 104        | Physics  | 85    | 2023-02-15 |
+------------+----------+-------+------------+
Output:

+------------+----------+-------------+--------------+
| student_id | subject  | first_score | latest_score |
+------------+----------+-------------+--------------+
| 101        | Math     | 70          | 85           |
| 102        | Math     | 80          | 85           |
| 104        | Physics  | 75          | 85           |
+------------+----------+-------------+--------------+
Explanation:

Student 101 in Math: Improved from 70 to 85
Student 101 in Physics: No improvement (dropped from 65 to 60)
Student 102 in Math: Improved from 80 to 85
Student 103 in Math: Only one exam, not eligible
Student 104 in Physics: Improved from 75 to 85
Result table is ordered by student_id, subject.


-- 步骤1: 使用窗口函数找出每个学生在每科目的第一次和最后一次考试的成绩
-- 步骤2: 筛选出那些第一次成绩小于最后一次成绩的记录
WITH Ranked AS (
    SELECT
        student_id,
        subject,
        FIRST_VALUE(score) OVER(PARTITION BY student_id,subject ORDER BY exam_date) AS first_score,
        FIRST_VALUE(score) OVER(PARTITION BY student_id,subject ORDER BY exam_date DESC) AS latest_score
    FROM Scores
)

SELECT DISTINCT *
FROM Ranked
WHERE first_score<latest_score
ORDER BY student_id,subject


-- 另一种方法，使用ROW_NUMBER()窗口函数来标记每个学生在每科目的第一次和最后一次考试
-- 然后从结果中筛选出那些第一次成绩小于最后一次成绩的记录
WITH ExamDates AS (
    SELECT student_id,
           subject,
           score,
           exam_date,
           ROW_NUMBER() OVER (PARTITION BY student_id, subject ORDER BY exam_date ASC) AS first_exam,
           ROW_NUMBER() OVER (PARTITION BY student_id, subject ORDER BY exam_date DESC) AS last_exam
    FROM Scores
)
SELECT student_id,
       subject,
       MAX(CASE WHEN first_exam = 1 THEN score END) AS first_score,
       MAX(CASE WHEN last_exam = 1 THEN score END) AS latest_score
FROM ExamDates
GROUP BY student_id, subject
HAVING latest_score > first_score
ORDER BY student_id, subject;



-- 另一种方法，使用子查询来找出每个学生在每科目的第一次和最后一次考试的成绩
-- 然后从结果中筛选出那些第一次成绩小于最后一次成绩的记录
select
    f.student_id,f.subject,f.score as first_score,l.score as latest_score
from
    scores f
join scores l
    on f.student_id = l.student_id
    and f.subject = l.subject
    and f.exam_date != l.exam_date
    and f.exam_date = (select min(exam_date) from scores where f.student_id = student_id and f.subject = subject)
    and l.exam_date = (select max(exam_date) from scores where l.student_id = student_id and l.subject = subject)
where
    f.score < l.score
order by
    f.student_id,f.subject





