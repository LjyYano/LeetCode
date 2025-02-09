/**
 * https://leetcode.cn/problems/combine-two-tables/
 * 
 * 表: Person
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * personId 是该表的主键列。
 * 该表包含一些人的 ID 和他们的姓和名的信息。
 * 
 * 表: Address
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * addressId 是该表的主键列。
 * 该表的每一行都包含一个 ID = PersonId 的人的城市和州的信息。
 * 
 * 编写一个SQL查询来报告 Person 表中每个人的姓、名、城市和州。如果 personId 的地址不在 Address 表中，则报告为空。
 * 
 * 以 任意顺序 返回结果表。
 * 
 * 查询结果格式如下所示。
 * 
 * 示例 1:
 * 输入: 
 * Person表:
 * +----------+----------+-----------+
 * | personId | lastName | firstName |
 * +----------+----------+-----------+
 * | 1        | Wang     | Allen     |
 * | 2        | Alice    | Bob       |
 * +----------+----------+-----------+
 * Address表:
 * +-----------+----------+---------------+------------+
 * | addressId | personId | city          | state      |
 * +-----------+----------+---------------+------------+
 * | 1         | 2        | New York City | New York   |
 * | 2         | 3        | Leetcode      | California |
 * +-----------+----------+---------------+------------+
 * 输出: 
 * +-----------+----------+---------------+----------+
 * | firstName | lastName | city          | state    |
 * +-----------+----------+---------------+----------+
 * | Allen     | Wang     | null          | null     |
 * | Bob       | Alice    | New York City | New York |
 * +-----------+----------+---------------+----------+
 * 解释: 
 * 地址表中没有 personId = 1 的地址，所以它们的城市和州返回 null。
 * addressId = 1 包含了 personId = 2 的地址信息。
 */
public class L0175_CombineTwoTables {
    
    /**
     * SQL 查询语句
     */
    public String getSQL() {
        return "SELECT p.firstName, p.lastName, a.city, a.state " +
               "FROM Person p " +
               "LEFT JOIN Address a ON p.personId = a.personId";
    }

    public static void main(String[] args) {
        L0175_CombineTwoTables solution = new L0175_CombineTwoTables();
        System.out.println("SQL 查询语句：");
        System.out.println(solution.getSQL());
    }
} 