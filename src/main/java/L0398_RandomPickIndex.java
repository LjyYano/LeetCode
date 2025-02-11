import java.util.Random;

/**
 * https://leetcode.cn/problems/random-pick-index/
 * 
 * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
 * 
 * 实现 Solution 类：
 * - Solution(int[] nums) 用数组 nums 初始化对象。
 * - int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i。如果存在多个有效的索引，则每个索引的返回概率应当相等。
 * 
 * 示例：
 * 输入
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * 输出
 * [null, 4, 0, 2]
 * 
 * 解释
 * Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // 随机返回索引 2, 3, 4 之一。每个索引的返回概率应该相等。
 * solution.pick(1); // 返回 0。因为只有 nums[0] 等于 1。
 * solution.pick(3); // 随机返回索引 2, 3, 4 之一。每个索引的返回概率应该相等。
 * 
 * 提示：
 * - 1 <= nums.length <= 2 * 10⁴
 * - -2³¹ <= nums[i] <= 2³¹ - 1
 * - target 存在于 nums 中
 * - 最多调用 pick 函数 10⁴ 次
 * 
 * 进阶：如果给你的数组 nums 很大，且 pick 操作很多，那么对于使用线性时间复杂度的解决方案，它的运行效率相比于使用哈希表存储索引的解决方案会如何？
 */
public class L0398_RandomPickIndex {
    private int[] nums;
    private Random rand;
    
    public L0398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    /**
     * 使用蓄水池抽样算法
     * 1. 遍历数组，对于第 k 个等于 target 的数，以 1/k 的概率选择它
     * 2. 这样可以保证每个等于 target 的索引被选中的概率相等
     */
    public int pick(int target) {
        int count = 0;  // 记录遇到目标数字的次数
        int result = 0;  // 存储选中的索引
        
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;  // 遇到目标数字，计数加一
                
                // 以 1/count 的概率选择当前索引
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = {1, 2, 3, 3, 3};
        L0398_RandomPickIndex solution = new L0398_RandomPickIndex(nums);
        
        // 测试 pick(3)，应该随机返回 2、3、4 中的一个
        System.out.println("测试 pick(3) 5 次：");
        for (int i = 0; i < 5; i++) {
            System.out.println(solution.pick(3));
        }
        
        // 测试 pick(1)，应该返回 0
        System.out.println("\n测试 pick(1)：");
        System.out.println(solution.pick(1));
    }
} 