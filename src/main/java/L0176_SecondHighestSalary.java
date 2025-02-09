/**
 * https://leetcode.cn/problems/second-highest-salary/
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
 * 编写一个 SQL 查询，获取并返回 Employee 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null 。
 * 
 * 查询结果如下例所示。
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
 * 输出：
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |
 * +---------------------+
 * 
 * 示例 2：
 * 输入：
 * Employee 表：
 * +----+--------+
 * | id | salary |
 * +----+--------+
 * | 1  | 100    |
 * +----+--------+
 * 输出：
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | null                |
 * +---------------------+
 */
public class L0176_SecondHighestSalary {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT " +
               "(SELECT DISTINCT salary " +
               "FROM Employee " +
               "ORDER BY salary DESC " +
               "LIMIT 1 OFFSET 1) AS SecondHighestSalary";
    }

    public static void main(String[] args) {
        L0176_SecondHighestSalary solution = new L0176_SecondHighestSalary();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 