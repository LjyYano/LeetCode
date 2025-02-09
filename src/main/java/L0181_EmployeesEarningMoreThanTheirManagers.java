/**
 * https://leetcode.cn/problems/employees-earning-more-than-their-managers/
 * 
 * 表：Employee
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * | salary      | int     |
 * | managerId   | int     |
 * +-------------+---------+
 * id 是该表的主键。
 * 该表的每一行都表示雇员的ID、姓名、工资和经理的ID。
 * 
 * 编写一个SQL查询来查找收入比经理高的员工。
 * 以 任意顺序 返回结果表。
 * 
 * 示例 1：
 * 输入：
 * Employee 表：
 * +----+-------+--------+-----------+
 * | id | name  | salary | managerId |
 * +----+-------+--------+-----------+
 * | 1  | Joe   | 70000  | 3         |
 * | 2  | Henry | 80000  | 4         |
 * | 3  | Sam   | 60000  | NULL      |
 * | 4  | Max   | 90000  | NULL      |
 * +----+-------+--------+-----------+
 * 输出：
 * +----------+
 * | Employee |
 * +----------+
 * | Joe      |
 * +----------+
 * 解释：Joe 是唯一挣得比经理多的员工。Sam 和 Max 都没有经理。
 */
public class L0181_EmployeesEarningMoreThanTheirManagers {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT e1.name AS Employee " +
               "FROM Employee e1 " +
               "JOIN Employee e2 ON e1.managerId = e2.id " +
               "WHERE e1.salary > e2.salary";
    }

    public static void main(String[] args) {
        L0181_EmployeesEarningMoreThanTheirManagers solution = new L0181_EmployeesEarningMoreThanTheirManagers();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 