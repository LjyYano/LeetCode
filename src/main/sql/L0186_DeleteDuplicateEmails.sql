-- 题目链接：https://leetcode.cn/problems/delete-duplicate-emails/
-- 题目描述：编写一个 SQL 查询来删除所有重复的电子邮件，只保留 ID 最小的唯一电子邮件。

DELETE p1
FROM Person p1, Person p2
WHERE p1.email = p2.email
AND p1.id > p2.id 