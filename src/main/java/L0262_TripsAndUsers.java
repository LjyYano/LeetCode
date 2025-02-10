/**
 * https://leetcode.cn/problems/trips-and-users/
 * 
 * 表：Trips
 * 
 * +-------------+----------+
 * | Column Name | Type     |
 * +-------------+----------+
 * | id          | int      |
 * | client_id   | int      |
 * | driver_id   | int      |
 * | city_id     | int      |
 * | status      | enum     |
 * | request_at  | date     |     
 * +-------------+----------+
 * id 是这张表的主键（具有唯一值的列）。
 * 这张表中存所有出租车的行程信息。每段行程有唯一 id ，其中 client_id 和 driver_id 是 Users 表中 users_id 的外键。
 * status 是一个表示行程状态的枚举类型，枚举成员为('completed', 'cancelled_by_driver', 'cancelled_by_client') 。
 * 
 * 表：Users
 * 
 * +-------------+----------+
 * | Column Name | Type     |
 * +-------------+----------+
 * | users_id    | int      |
 * | banned      | enum     |
 * | role        | enum     |
 * +-------------+----------+
 * users_id 是这张表的主键（具有唯一值的列）。
 * 这张表中存所有用户，每个用户都有一个唯一的 users_id ，role 是一个表示用户身份的枚举类型，枚举成员为 ('client', 'driver', 'partner') 。
 * banned 是一个表示用户是否被禁止的枚举类型，枚举成员为 ('Yes', 'No') 。
 * 
 * 取消率 的计算方式如下：(被司机或乘客取消的非禁止用户生成的订单数量) / (非禁止用户生成的订单总数)。
 * 
 * 写一段 SQL 语句查出 "2013-10-01" 至 "2013-10-03" 期间非禁止用户（乘客和司机都必须未被禁止）的取消率。
 * 返回结果表中的数据可以按任意顺序组织。
 * 
 * 查询结果格式如下所示：
 * 
 * Trips 表：
 * +----+-----------+-----------+---------+---------------------+------------+
 * | id | client_id | driver_id | city_id | status             | request_at |
 * +----+-----------+-----------+---------+---------------------+------------+
 * | 1  | 1         | 10        | 1       | completed          | 2013-10-01 |
 * | 2  | 2         | 11        | 1       | cancelled_by_driver| 2013-10-01 |
 * | 3  | 3         | 12        | 6       | completed          | 2013-10-01 |
 * | 4  | 4         | 13        | 6       | cancelled_by_client| 2013-10-01 |
 * | 5  | 1         | 10        | 1       | completed          | 2013-10-02 |
 * | 6  | 2         | 11        | 6       | completed          | 2013-10-02 |
 * | 7  | 3         | 12        | 6       | completed          | 2013-10-02 |
 * | 8  | 2         | 12        | 12      | completed          | 2013-10-03 |
 * | 9  | 3         | 10        | 12      | completed          | 2013-10-03 |
 * | 10 | 4         | 13        | 12      | cancelled_by_driver| 2013-10-03 |
 * +----+-----------+-----------+---------+---------------------+------------+
 * 
 * Users 表：
 * +----------+--------+--------+
 * | users_id | banned | role   |
 * +----------+--------+--------+
 * | 1        | No     | client |
 * | 2        | Yes    | client |
 * | 3        | No     | client |
 * | 4        | No     | client |
 * | 10       | No     | driver |
 * | 11       | No     | driver |
 * | 12       | No     | driver |
 * | 13       | No     | driver |
 * +----------+--------+--------+
 * 
 * Result 表：
 * +------------+-------------------+
 * | Day        | Cancellation Rate |
 * +------------+-------------------+
 * | 2013-10-01 | 0.33             |
 * | 2013-10-02 | 0.00             |
 * | 2013-10-03 | 0.50             |
 * +------------+-------------------+
 * 
 * 2013-10-01：
 * - 4 个请求中有 2 个来自未被禁止的用户（ID 为 1，3，4 的用户）
 * - 2 个未被禁止的用户的请求中有 1 个取消
 * - 因此取消率为 (1/2)=0.33
 * 
 * 2013-10-02：
 * - 3 个请求中有 3 个来自未被禁止的用户（ID 为 1，3 的用户）
 * - 3 个未被禁止的用户的请求中有 0 个取消
 * - 因此取消率为 (0/3)=0.00
 * 
 * 2013-10-03：
 * - 3 个请求中有 2 个来自未被禁止的用户（ID 为 3，4 的用户）
 * - 2 个未被禁止的用户的请求中有 1 个取消
 * - 因此取消率为 (1/2)=0.50
 */
public class L0262_TripsAndUsers {
    
    // 这是一道 SQL 题目，SQL 语句如下：
    public static final String SQL = 
        "SELECT \n" +
        "    t.request_at AS Day,\n" +
        "    ROUND(\n" +
        "        SUM(\n" +
        "            CASE \n" +
        "                WHEN t.status != 'completed' THEN 1 \n" +
        "                ELSE 0 \n" +
        "            END\n" +
        "        ) / COUNT(*),\n" +
        "        2\n" +
        "    ) AS 'Cancellation Rate'\n" +
        "FROM Trips t\n" +
        "JOIN Users u1 ON t.client_id = u1.users_id AND u1.banned = 'No'\n" +
        "JOIN Users u2 ON t.driver_id = u2.users_id AND u2.banned = 'No'\n" +
        "WHERE t.request_at BETWEEN '2013-10-01' AND '2013-10-03'\n" +
        "GROUP BY t.request_at";

    public static void main(String[] args) {
        System.out.println("这是一道数据库题目，请在数据库中执行以下 SQL：");
        System.out.println(SQL);
    }
} 