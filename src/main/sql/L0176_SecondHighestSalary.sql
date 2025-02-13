-- 题目链接：https://leetcode.cn/problems/second-highest-salary/
-- 题目描述：编写一个 SQL 查询，找出第二高的工资。如果不存在第二高的工资，查询应该返回 null。

SELECT MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee) 