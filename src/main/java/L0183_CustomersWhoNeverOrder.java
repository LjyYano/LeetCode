/**
 * https://leetcode.cn/problems/customers-who-never-order/
 * 
 * 表: Customers
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * +-------------+---------+
 * id 是该表的主键。
 * 该表包含客户的 ID 和姓名。
 * 
 * 表: Orders
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | id          | int  |
 * | customerId  | int  |
 * +-------------+------+
 * id 是该表的主键。
 * customerId 是 Customers 表中 ID 的外键。
 * 该表包含客户的订单信息。
 * 
 * 编写一个 SQL 查询，报告所有从不订购任何东西的客户的姓名。
 * 
 * 以 任意顺序 返回结果表。
 * 
 * 查询结果格式如下所示。
 * 
 * 示例 1：
 * 输入：
 * Customers 表：
 * +----+-------+
 * | id | name  |
 * +----+-------+
 * | 1  | Joe   |
 * | 2  | Henry |
 * | 3  | Sam   |
 * | 4  | Max   |
 * +----+-------+
 * Orders 表：
 * +----+------------+
 * | id | customerId |
 * +----+------------+
 * | 1  | 3          |
 * | 2  | 1          |
 * +----+------------+
 * 输出：
 * +-----------+
 * | Customers |
 * +-----------+
 * | Henry     |
 * | Max       |
 * +-----------+
 * 解释：
 * Henry 和 Max 从没有下过订单。
 */
public class L0183_CustomersWhoNeverOrder {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT name AS Customers " +
               "FROM Customers " +
               "WHERE id NOT IN (SELECT customerId FROM Orders)";
    }

    public static void main(String[] args) {
        L0183_CustomersWhoNeverOrder solution = new L0183_CustomersWhoNeverOrder();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 