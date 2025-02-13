-- 题目链接：https://leetcode.cn/problems/combine-two-tables/
-- 题目描述：编写一个 SQL 查询，来获取 Person 表中每个人的姓名，以及其对应的城市和州（即使这个人没有地址信息）。

SELECT p.firstName, p.lastName, a.city, a.state
FROM Person p
LEFT JOIN Address a ON p.personId = a.personId 