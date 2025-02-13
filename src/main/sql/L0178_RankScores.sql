-- 题目链接：https://leetcode.cn/problems/rank-scores/
-- 题目描述：编写一个 SQL 查询，将分数按照降序排序，并返回排名。排名按以下规则计算：
-- - 分数应按从高到低排序
-- - 如果两个分数相同，那么两个分数的排名应该相同
-- - 在排名相同的分数后，排名数应该是下一个连续的整数。换句话说，排名之间不应该有空缺的数字

SELECT score, DENSE_RANK() OVER (ORDER BY score DESC) AS rank
FROM Scores 