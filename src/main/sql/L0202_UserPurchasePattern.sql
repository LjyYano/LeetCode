-- 题目链接：https://leetcode.cn/problems/user-purchase-pattern/
-- 题目描述：分析用户的购买模式。

SELECT DISTINCT u.user_id,
    u.item_id,
    DATE_FORMAT(u.created_date, '%Y-%m-%d') as purchase_date
FROM UserActivity u
WHERE EXISTS (
    SELECT 1
    FROM UserActivity u2
    WHERE u2.user_id = u.user_id
    AND u2.item_id = u.item_id
    AND DATE(u2.created_date) = DATE(u.created_date)
    GROUP BY u2.user_id, DATE(u2.created_date)
    HAVING COUNT(*) >= 2
)
ORDER BY u.user_id ASC, u.item_id ASC 