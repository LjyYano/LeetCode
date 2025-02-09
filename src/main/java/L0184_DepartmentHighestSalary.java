/**
 * https://leetcode.cn/problems/department-highest-salary/
 * 
 * 表: Employee
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * | salary      | int     |
 * | departmentId| int     |
 * +-------------+---------+
 * id 是该表的主键。
 * departmentId 是 Department 表中 id 的外键。
 * 该表包含员工的 ID、姓名、工资和所属部门的 ID。
 * 
 * 表: Department
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * +-------------+---------+
 * id 是该表的主键。
 * 该表包含公司所有部门的 ID 和名称。
 * 
 * 编写一个 SQL 查询，找出每个部门中薪资最高的员工。
 * 以 任意顺序 返回结果表。
 * 
 * 示例 1：
 * 输入：
 * Employee 表：
 * +----+-------+--------+--------------+
 * | id | name  | salary | departmentId |
 * +----+-------+--------+--------------+
 * | 1  | Joe   | 70000  | 1            |
 * | 2  | Jim   | 90000  | 1            |
 * | 3  | Henry | 80000  | 2            |
 * | 4  | Sam   | 60000  | 2            |
 * | 5  | Max   | 90000  | 1            |
 * +----+-------+--------+--------------+
 * Department 表：
 * +----+-------+
 * | id | name  |
 * +----+-------+
 * | 1  | IT    |
 * | 2  | Sales |
 * +----+-------+
 * 输出：
 * +------------+----------+--------+
 * | Department | Employee | Salary |
 * +------------+----------+--------+
 * | IT         | Jim      | 90000  |
 * | IT         | Max      | 90000  |
 * | Sales      | Henry    | 80000  |
 * +------------+----------+--------+
 * 解释：在 IT 部门中，Jim 和 Max 都有最高的薪资，他们的薪资都是 90000。
 * 在销售部中，Henry 的薪资最高，为 80000。
 */
public class L0184_DepartmentHighestSalary {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary " +
               "FROM Employee e " +
               "JOIN Department d ON e.departmentId = d.id " +
               "WHERE (e.departmentId, e.salary) IN " +
               "(SELECT departmentId, MAX(salary) " +
               "FROM Employee " +
               "GROUP BY departmentId)";
    }

    public static void main(String[] args) {
        L0184_DepartmentHighestSalary solution = new L0184_DepartmentHighestSalary();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 