Table: Insurance

+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| pid         | int   |
| tiv_2015    | float |
| tiv_2016    | float |
| lat         | float |
| lon         | float |
+-------------+-------+
pid is the primary key (column with unique values) for this table.
Each row of this table contains information about one policy where:
pid is the policyholder's policy ID.
tiv_2015 is the total investment value in 2015 and tiv_2016 is the total investment value in 2016.
lat is the latitude of the policy holder's city. It's guaranteed that lat is not NULL.
lon is the longitude of the policy holder's city. It's guaranteed that lon is not NULL.


Write a solution to report the sum of all total investment values in 2016 tiv_2016, for all policyholders who:

have the same tiv_2015 value as one or more other policyholders, and
are not located in the same city as any other policyholder (i.e., the (lat, lon) attribute pairs must be unique).
Round tiv_2016 to two decimal places.

The result format is in the following example.



Example 1:

Input:
Insurance table:
+-----+----------+----------+-----+-----+
| pid | tiv_2015 | tiv_2016 | lat | lon |
+-----+----------+----------+-----+-----+
| 1   | 10       | 5        | 10  | 10  |
| 2   | 20       | 20       | 20  | 20  |
| 3   | 10       | 30       | 20  | 20  |
| 4   | 10       | 40       | 40  | 40  |
+-----+----------+----------+-----+-----+
Output:
+----------+
| tiv_2016 |
+----------+
| 45.00    |
+----------+
Explanation:
The first record in the table, like the last record, meets both of the two criteria.
The tiv_2015 value 10 is the same as the third and fourth records, and its location is unique.

The second record does not meet any of the two criteria. Its tiv_2015 is not like any other policyholders
and its location is the same as the third record, which makes the third record fail, too.
So, the result is the sum of tiv_2016 of the first and last record, which is 45.



select
    round(sum(tiv_2016), 2) as tiv_2016
from
    Insurance
where tiv_2015 in (
    select tiv_2015
    from Insurance
    group by tiv_2015
    having count(*) > 1)
and
    (pid, lat, lon) in (
    select pid, lat, lon
    from Insurance
    group by lat, lon
    having count(*) = 1)


select
    round(sum(tiv_2016),2) as tiv_2016
from
    Insurance I1
inner join
    (
    select lat,lon ,count(*) lat_lon
    from Insurance
    group by lat,lon) I_lon_lot
on I1.lat =I_lon_lot.lat and I1.lon =I_lon_lot.lon and lat_lon =1
inner join
    (
    select tiv_2015, count(*) as tiv_count
    from Insurance
    group by tiv_2015 ) I_tiv
on I1.tiv_2015 =  I_tiv.tiv_2015 and  tiv_count > 1


select
    round(sum(tiv_2016),2) as tiv_2016
from
(
    select *, count(*) over (partition by tiv_2015) as cnt1,
    count(*) over (partition by lat, lon) as cnt2
    from insurance) a
where
    a.cnt1>1 and a.cnt2=1



