/**
 * https://leetcode.cn/problems/department-top-three-salaries/
 * 
 * 表: Employee
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | id           | int     |
 * | name         | varchar |
 * | salary       | int     |
 * | departmentId | int     |
 * +--------------+---------+
 * id 是该表的主键。
 * departmentId 是 Department 表中 id 的外键。
 * 该表的每一行都包含员工的 ID、姓名、工资和所属部门的 ID。
 * 
 * 表: Department
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * +-------------+---------+
 * id 是该表的主键。
 * 该表的每一行都包含一个部门的 ID 和名称。
 * 
 * 公司的主管们感兴趣的是公司每个部门中谁赚的钱最多。一个部门的 高收入者 是指一个员工的工资在该部门的 不同 工资中 排名前三 的员工。
 * 
 * 编写一个SQL查询，找出每个部门中收入前三高的员工。
 * 以 任意顺序 返回结果表。
 * 
 * 示例 1:
 * 输入：
 * Employee 表：
 * +----+-------+--------+--------------+
 * | id | name  | salary | departmentId |
 * +----+-------+--------+--------------+
 * | 1  | Joe   | 85000  | 1            |
 * | 2  | Henry | 80000  | 2            |
 * | 3  | Sam   | 60000  | 2            |
 * | 4  | Max   | 90000  | 1            |
 * | 5  | Janet | 69000  | 1            |
 * | 6  | Randy | 85000  | 1            |
 * | 7  | Will  | 70000  | 1            |
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
 * | IT         | Max      | 90000  |
 * | IT         | Joe      | 85000  |
 * | IT         | Randy    | 85000  |
 * | Sales      | Henry    | 80000  |
 * | Sales      | Sam      | 60000  |
 * +------------+----------+--------+
 * 解释：
 * 在 IT 部门：
 * - Max 的工资最高
 * - 工资第二高的是 Joe 和 Randy，他们都有相同的工资
 * - 工资第三高的是 Will，他的工资为 70000
 * 在 Sales 部门：
 * - Henry 的工资最高
 * - Sam 的工资第二高
 * - 没有工资第三高的员工
 */
public class L0185_DepartmentTopThreeSalaries {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT d.name AS Department, e1.name AS Employee, e1.salary AS Salary " +
               "FROM Employee e1 " +
               "JOIN Department d ON e1.departmentId = d.id " +
               "WHERE 3 > (" +
               "    SELECT COUNT(DISTINCT e2.salary) " +
               "    FROM Employee e2 " +
               "    WHERE e2.salary > e1.salary " +
               "    AND e1.departmentId = e2.departmentId" +
               ")";
    }

    public static void main(String[] args) {
        L0185_DepartmentTopThreeSalaries solution = new L0185_DepartmentTopThreeSalaries();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 