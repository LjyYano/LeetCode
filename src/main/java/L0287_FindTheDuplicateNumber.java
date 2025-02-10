import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 * 
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有一个重复的整数，返回这个重复的数。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * 
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 
 * 提示：
 * 1 <= n <= 10⁵
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中只有一个整数出现两次或多次，其余整数均只出现一次
 * 
 * 进阶：
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 */
public class L0287_FindTheDuplicateNumber {
    
    /**
     * 使用快慢指针（Floyd 判圈算法）解决
     * 将数组看作一个链表，nums[i] 表示下一个节点的下标
     * 由于有重复数字，所以一定会形成环
     * 找到环的入口就是重复的数字
     */
    public int findDuplicate(int[] nums) {
        // 快慢指针初始化指向第一个位置
        int slow = nums[0];
        int fast = nums[0];
        
        // 1. 找到相遇点
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // 2. 找到环的入口
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }

    public static void main(String[] args) {
        L0287_FindTheDuplicateNumber solution = new L0287_FindTheDuplicateNumber();
        
        // 测试用例 1
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("测试用例 1：");
        System.out.println("输入：" + Arrays.toString(nums1));
        System.out.println("输出：" + solution.findDuplicate(nums1));
        
        // 测试用例 2
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：" + Arrays.toString(nums2));
        System.out.println("输出：" + solution.findDuplicate(nums2));
    }
} 