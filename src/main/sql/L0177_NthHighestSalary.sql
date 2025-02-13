-- 题目链接：https://leetcode.cn/problems/nth-highest-salary/
-- 题目描述：编写一个 SQL 查询，找出第 n 高的工资。如果不存在第 n 高的工资，查询应该返回 null。

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    SELECT DISTINCT salary
    FROM (
      SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rank
      FROM Employee
    ) ranked
    WHERE rank = N
  );
END 