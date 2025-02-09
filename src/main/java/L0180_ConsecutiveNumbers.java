/**
 * https://leetcode.cn/problems/consecutive-numbers/
 * 
 * 表：Logs
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | num         | varchar |
 * +-------------+---------+
 * id 是这个表的主键。
 * 
 * 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
 * 返回的结果表中的数据可以按 任意顺序 排列。
 * 
 * 示例 1:
 * 输入：
 * Logs 表：
 * +----+-----+
 * | id | num |
 * +----+-----+
 * | 1  | 1   |
 * | 2  | 1   |
 * | 3  | 1   |
 * | 4  | 2   |
 * | 5  | 1   |
 * | 6  | 2   |
 * | 7  | 2   |
 * +----+-----+
 * 输出：
 * Result 表：
 * +-----------------+
 * | ConsecutiveNums |
 * +-----------------+
 * | 1               |
 * +-----------------+
 * 解释：1 是唯一连续出现至少三次的数字。
 */
public class L0180_ConsecutiveNumbers {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT DISTINCT l1.num AS ConsecutiveNums " +
               "FROM Logs l1, Logs l2, Logs l3 " +
               "WHERE l1.id = l2.id - 1 " +
               "AND l2.id = l3.id - 1 " +
               "AND l1.num = l2.num " +
               "AND l2.num = l3.num";
    }

    public static void main(String[] args) {
        L0180_ConsecutiveNumbers solution = new L0180_ConsecutiveNumbers();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 