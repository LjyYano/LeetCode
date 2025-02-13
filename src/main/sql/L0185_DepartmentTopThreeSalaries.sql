-- 题目链接：https://leetcode.cn/problems/department-top-three-salaries/
-- 题目描述：编写一个 SQL 查询，找出每个部门工资前三高的所有员工。

SELECT d.name AS Department,
    e1.name AS Employee,
    e1.salary AS Salary
FROM Employee e1
JOIN Department d ON e1.departmentId = d.id
WHERE 3 > (
    SELECT COUNT(DISTINCT e2.salary)
    FROM Employee e2
    WHERE e2.salary > e1.salary
    AND e1.departmentId = e2.departmentId
) 