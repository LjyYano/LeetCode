-- 题目链接：https://leetcode.cn/problems/department-highest-salary/
-- 题目描述：编写一个 SQL 查询，找出每个部门工资最高的员工。

SELECT d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE (e.departmentId, e.salary) IN (
    SELECT departmentId, MAX(salary)
    FROM Employee
    GROUP BY departmentId
) 