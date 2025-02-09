/**
 * https://leetcode.cn/problems/gas-station/
 * 
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 * 
 * 示例 1:
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，此时油箱有 5 - 5 + 4 = 4 升汽油
 * 你可以返回 3 号加油站，因为此时油箱中有 4 升汽油，足以返回 3 号加油站。
 * 
 * 示例 2:
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * 
 * 提示:
 * - gas.length == n
 * - cost.length == n
 * - 1 <= n <= 10⁵
 * - 0 <= gas[i], cost[i] <= 10⁴
 */
public class L0134_GasStation {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;    // 总油量
        int currGas = 0;     // 当前油量
        int startStation = 0; // 起始加油站
        
        for (int i = 0; i < n; i++) {
            totalGas += gas[i] - cost[i];
            currGas += gas[i] - cost[i];
            
            // 如果当前油量小于0，说明从起始加油站到当前加油站的路线不可行
            if (currGas < 0) {
                // 将起始加油站设为下一个加油站
                startStation = i + 1;
                // 重置当前油量
                currGas = 0;
            }
        }
        
        // 如果总油量小于0，说明无论从哪个加油站出发都不可能绕一圈
        return totalGas >= 0 ? startStation : -1;
    }

    public static void main(String[] args) {
        L0134_GasStation solution = new L0134_GasStation();
        
        // 测试用例 1
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("测试用例 1：");
        System.out.println("输入：gas = [1,2,3,4,5], cost = [3,4,5,1,2]");
        System.out.println("输出：" + solution.canCompleteCircuit(gas1, cost1));
        System.out.println("预期：3");
        System.out.println();
        
        // 测试用例 2
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("测试用例 2：");
        System.out.println("输入：gas = [2,3,4], cost = [3,4,3]");
        System.out.println("输出：" + solution.canCompleteCircuit(gas2, cost2));
        System.out.println("预期：-1");
    }
} 