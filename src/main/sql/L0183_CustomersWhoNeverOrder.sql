-- 题目链接：https://leetcode.cn/problems/customers-who-never-order/
-- 题目描述：找出所有从不订购任何东西的客户。

SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o ON c.id = o.customerId
WHERE o.id IS NULL 