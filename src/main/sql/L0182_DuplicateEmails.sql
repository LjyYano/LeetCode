-- 题目链接：https://leetcode.cn/problems/duplicate-emails/
-- 题目描述：编写一个 SQL 查询来报告所有重复的电子邮件。
-- 注意是重复的电子邮件，也就是指出现至少两次的电子邮件。

SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1 