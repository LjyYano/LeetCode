/**
 * https://leetcode.cn/problems/rank-scores/
 * 
 * 表: Scores
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | score       | decimal |
 * +-------------+---------+
 * id 是该表的主键。
 * 该表的每一行都包含了一场比赛的分数。Score 是一个有两位小数点的浮点值。
 * 
 * 编写 SQL 查询对分数进行排序。排名按以下规则计算:
 * - 分数应按从高到低排序
 * - 如果两个分数相同，那么两个分数的排名应该相同
 * - 在排名相同的分数后，排名数应该是下一个连续的整数。换句话说，排名之间不应该有空缺的数字
 * 
 * 按 score 降序返回结果表。
 * 
 * 查询结果格式如下所示。
 * 
 * 示例 1：
 * 输入：
 * Scores 表：
 * +----+-------+
 * | id | score |
 * +----+-------+
 * | 1  | 3.50  |
 * | 2  | 3.65  |
 * | 3  | 4.00  |
 * | 4  | 3.85  |
 * | 5  | 4.00  |
 * | 6  | 3.65  |
 * +----+-------+
 * 输出：
 * +-------+------+
 * | score | rank |
 * +-------+------+
 * | 4.00  | 1    |
 * | 4.00  | 1    |
 * | 3.85  | 2    |
 * | 3.65  | 3    |
 * | 3.65  | 3    |
 * | 3.50  | 4    |
 * +-------+------+
 */
public class L0178_RankScores {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT\n" +
               "  score,\n" +
               "  DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'\n" +
               "FROM Scores";
    }

    public static void main(String[] args) {
        L0178_RankScores solution = new L0178_RankScores();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 