/*
 * https://leetcode.cn/problems/bulb-switcher/
 * 
 * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。第二轮，你将会每两个灯泡关闭第二个。
 * 
 * 第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。
 * 直到第 n 轮，你只需要切换最后一个灯泡的开关。
 * 
 * 找出并返回 n 轮后有多少个亮着的灯泡。
 * 
 * 示例 1：
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * 
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 
 * 示例 3：
 * 输入：n = 1
 * 输出：1
 * 
 * 提示：
 * 0 <= n <= 10⁹
 */

public class L0319_BulbSwitcher {
    
    public int bulbSwitch(int n) {
        // 对于第 i 个灯泡，它会在第 j 轮被切换，其中 j 是 i 的因子
        // 因此，第 i 个灯泡最终的状态取决于它的因子数量：
        // - 如果因子数量为奇数，最终是亮的
        // - 如果因子数量为偶数，最终是灭的
        // 只有完全平方数的因子数量为奇数（因为除了平方根外，因子都是成对出现的）
        // 所以，最终亮着的灯泡数量等于 n 以内完全平方数的数量
        // 即为 n 的平方根向下取整
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        L0319_BulbSwitcher solution = new L0319_BulbSwitcher();
        
        // 测试用例 1
        System.out.println(solution.bulbSwitch(3)); // 应输出 1
        
        // 测试用例 2
        System.out.println(solution.bulbSwitch(0)); // 应输出 0
        
        // 测试用例 3
        System.out.println(solution.bulbSwitch(1)); // 应输出 1
        
        // 测试用例 4
        System.out.println(solution.bulbSwitch(4)); // 应输出 2
    }
} 