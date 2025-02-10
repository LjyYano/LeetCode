/**
 * https://leetcode.cn/problems/self-crossing/
 * 
 * 给你一个整数数组 distance 。
 * 
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 个单位，然后向西移动 distance[1] 个单位，向南移动 distance[2] 个单位，向东移动 distance[3] 个单位，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * 
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：distance = [2,1,1,2]
 * 输出：true
 * 解释：路径交叉于点 (0,1)
 * 
 * 示例 2：
 * 输入：distance = [1,2,3,4]
 * 输出：false
 * 解释：路径没有相交的部分
 * 
 * 示例 3：
 * 输入：distance = [1,1,1,1]
 * 输出：true
 * 解释：路径相交于点 (0,0)
 * 
 * 提示：
 * 1 <= distance.length <= 10⁵
 * 1 <= distance[i] <= 10⁵
 */

public class L0335_SelfCrossing {
    
    /**
     * 判断路径是否相交
     * 时间复杂度：O(n)，其中 n 是数组的长度
     * 空间复杂度：O(1)，只使用了常数额外空间
     */
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        
        // 处理数组长度小于 4 的情况
        if (n < 4) {
            return false;
        }
        
        // 遍历数组，检查是否存在相交
        for (int i = 3; i < n; i++) {
            // 第一种情况：第四条边与第一条边相交
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            
            // 第二种情况：第五条边与第一条边相交
            if (i >= 4 && distance[i - 1] == distance[i - 3] && 
                distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }
            
            // 第三种情况：第六条边与第一条边相交
            if (i >= 5 && distance[i - 2] >= distance[i - 4] && 
                distance[i - 2] <= distance[i - 4] + distance[i] && 
                distance[i - 1] <= distance[i - 3] && 
                distance[i - 1] >= distance[i - 3] - distance[i - 5]) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        L0335_SelfCrossing solution = new L0335_SelfCrossing();
        
        // 测试用例 1
        int[] distance1 = {2, 1, 1, 2};
        System.out.println("测试用例 1：");
        System.out.println("输入：[2,1,1,2]");
        System.out.println("输出：" + solution.isSelfCrossing(distance1));
        System.out.println("预期输出：true");
        System.out.println();
        
        // 测试用例 2
        int[] distance2 = {1, 2, 3, 4};
        System.out.println("测试用例 2：");
        System.out.println("输入：[1,2,3,4]");
        System.out.println("输出：" + solution.isSelfCrossing(distance2));
        System.out.println("预期输出：false");
        System.out.println();
        
        // 测试用例 3
        int[] distance3 = {1, 1, 1, 1};
        System.out.println("测试用例 3：");
        System.out.println("输入：[1,1,1,1]");
        System.out.println("输出：" + solution.isSelfCrossing(distance3));
        System.out.println("预期输出：true");
    }
} 