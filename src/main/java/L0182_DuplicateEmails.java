/**
 * https://leetcode.cn/problems/duplicate-emails/
 * 
 * 表: Person
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | email       | varchar |
 * +-------------+---------+
 * id 是该表的主键。
 * 该表的每一行包含一个电子邮件。电子邮件将不包含大写字母。
 * 
 * 编写一个 SQL 查询来报告所有重复的电子邮件。
 * 注意是重复的电子邮件，也就是指出现至少两次的电子邮件。
 * 
 * 以 任意顺序 返回结果表。
 * 
 * 查询结果格式如下所示。
 * 
 * 示例 1:
 * 输入: 
 * Person 表:
 * +----+---------+
 * | id | email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 * 输出: 
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 * 解释: a@b.com 出现了两次。
 */
public class L0182_DuplicateEmails {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT email AS Email " +
               "FROM Person " +
               "GROUP BY email " +
               "HAVING COUNT(email) > 1";
    }

    public static void main(String[] args) {
        L0182_DuplicateEmails solution = new L0182_DuplicateEmails();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 