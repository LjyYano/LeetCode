/**
 * https://leetcode.cn/problems/nth-highest-salary/
 * 
 * 表: Employee
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | id          | int  |
 * | salary      | int  |
 * +-------------+------+
 * id 是这个表的主键。
 * 表的每一行包含员工的工资信息。
 * 
 * 编写一个 SQL 查询来报告 Employee 表中第 n 高的工资。如果没有第 n 个最高工资，查询应该报告为 null 。
 * 
 * 查询结果格式如下所示。
 * 
 * 示例 1：
 * 输入：
 * Employee 表：
 * +----+--------+
 * | id | salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * n = 2
 * 输出：
 * +------------------------+
 * | getNthHighestSalary(2) |
 * +------------------------+
 * | 200                    |
 * +------------------------+
 * 
 * 示例 2：
 * 输入：
 * Employee 表：
 * +----+--------+
 * | id | salary |
 * +----+--------+
 * | 1  | 100    |
 * +----+--------+
 * n = 2
 * 输出：
 * +------------------------+
 * | getNthHighestSalary(2) |
 * +------------------------+
 * | null                   |
 * +------------------------+
 */
public class L0177_NthHighestSalary {
    
    /**
     * SQL 查询语句
     */
    public String getSQL(int n) {
        return "CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT\n" +
               "BEGIN\n" +
               "  DECLARE M INT;\n" +
               "  SET M = N - 1;\n" +
               "  RETURN (\n" +
               "    SELECT DISTINCT salary\n" +
               "    FROM Employee\n" +
               "    ORDER BY salary DESC\n" +
               "    LIMIT 1 OFFSET M\n" +
               "  );\n" +
               "END";
    }

    public static void main(String[] args) {
        L0177_NthHighestSalary solution = new L0177_NthHighestSalary();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL(2));
    }
} 