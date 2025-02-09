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
 * id 是该表的主键。
 * 该表的每一行都包含有关员工工资的信息。
 * 
 * 编写一个 SQL 查询，获取并返回 Employee 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null 。
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
public class L0186_SecondHighestSalary {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT (SELECT DISTINCT salary " +
               "FROM Employee " +
               "ORDER BY salary DESC " +
               "LIMIT 1 OFFSET 1) AS SecondHighestSalary";
    }

    public static void main(String[] args) {
        L0186_SecondHighestSalary solution = new L0186_SecondHighestSalary();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 