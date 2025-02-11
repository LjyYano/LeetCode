/**
 * https://leetcode.cn/problems/water-and-jug-problem/
 * 
 * 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
 * 
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 * 
 * 你可以：
 * - 装满任意一个水壶
 * - 清空任意一个水壶
 * - 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 
 * 示例 1: 
 * 输入: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
 * 输出: true
 * 解释：该算法如下：
 * 1. 装满 5 升水壶 (0, 5)
 * 2. 向 3 升水壶倒水直到装满 (3, 2)
 * 3. 清空 3 升水壶 (0, 2)
 * 4. 从 5 升水壶向 3 升水壶倒水 (2, 0)
 * 5. 装满 5 升水壶 (2, 5)
 * 6. 向 3 升水壶倒水直到装满 (3, 4)
 * 7. 清空 3 升水壶 (0, 4)
 * 
 * 示例 2:
 * 输入: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
 * 输出: false
 * 
 * 示例 3:
 * 输入: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
 * 输出: true
 * 
 * 提示:
 * 1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10⁶
 */
public class L0365_WaterAndJugProblem {
    
    /**
     * 使用贝祖定理解决水壶问题
     * ax + by = z 有解当且仅当 z 是 x, y 的最大公约数的倍数
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 如果目标容量大于两个水壶的总容量，则不可能实现
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        
        // 如果目标容量为 0，则一定可以实现（两个水壶都不装水）
        if (targetCapacity == 0) {
            return true;
        }
        
        // 如果其中一个水壶容量为 0，则目标容量必须是另一个水壶容量的倍数
        if (jug1Capacity == 0) {
            return targetCapacity % jug2Capacity == 0;
        }
        if (jug2Capacity == 0) {
            return targetCapacity % jug1Capacity == 0;
        }
        
        // 使用贝祖定理，目标容量必须是两个水壶容量的最大公约数的倍数
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }
    
    /**
     * 计算两个数的最大公约数（使用辗转相除法）
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        L0365_WaterAndJugProblem solution = new L0365_WaterAndJugProblem();
        
        // 测试用例 1
        System.out.println(solution.canMeasureWater(3, 5, 4)); // 应输出 true
        
        // 测试用例 2
        System.out.println(solution.canMeasureWater(2, 6, 5)); // 应输出 false
        
        // 测试用例 3
        System.out.println(solution.canMeasureWater(1, 2, 3)); // 应输出 true
    }
} 