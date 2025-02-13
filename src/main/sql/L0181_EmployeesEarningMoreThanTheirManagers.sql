-- 题目链接：https://leetcode.cn/problems/employees-earning-more-than-their-managers/
-- 题目描述：编写一个 SQL 查询，找出收入比经理高的员工。

SELECT e1.name AS Employee
FROM Employee e1
JOIN Employee e2 ON e1.managerId = e2.id
WHERE e1.salary > e2.salary 