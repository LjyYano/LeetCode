/**
 * https://leetcode.cn/problems/patching-array/
 * 
 * 给定一个已排序的正整数数组 nums 和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。
 * 
 * 请返回满足上述要求的最少需要补充的数字个数。
 * 
 * 示例 1:
 * 输入: nums = [1,3], n = 6
 * 输出: 1 
 * 解释:
 * nums 数组为 [1, 3]，其中 [1, 3] 能组成的和有 1、3、4。
 * 补充数字 2，之后能组成的和有 1、2、3、4、5、6。
 * 所以最少需要补充 1 个数字。
 * 
 * 示例 2:
 * 输入: nums = [1,5,10], n = 20
 * 输出: 2
 * 解释: nums 数组为 [1, 5, 10]，其中 [1, 5, 10] 能组成的和有 1、5、6、10、11、15、16。
 * 补充数字 2 和 4，之后能组成的和有 1、2、3、4、5、6、7、8、9、10、11、12、13、14、15、16、17、18、19、20。
 * 所以最少需要补充 2 个数字。
 * 
 * 示例 3:
 * 输入: nums = [1,2,2], n = 5
 * 输出: 0
 * 
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^4
 * nums 按升序排列
 * 1 <= n <= 2^31 - 1
 */
public class L0330_PatchingArray {
    
    /**
     * 贪心算法
     * 时间复杂度：O(m + logn)，其中 m 是数组 nums 的长度
     * 空间复杂度：O(1)
     */
    public int minPatches(int[] nums, int n) {
        // 记录需要补充的数字个数
        int patches = 0;
        // 当前能够表示的数字范围是 [1, miss)
        long miss = 1;
        int i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // 如果当前数字小于等于 miss，则可以扩展范围
                miss += nums[i];
                i++;
            } else {
                // 需要补充一个数字（补充 miss）
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }

    public static void main(String[] args) {
        L0330_PatchingArray solution = new L0330_PatchingArray();
        
        // 测试用例 1
        int[] nums1 = {1, 3};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [1,3], n = 6");
        System.out.println("输出：" + solution.minPatches(nums1, 6));
        System.out.println("预期输出：1");
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {1, 5, 10};
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = [1,5,10], n = 20");
        System.out.println("输出：" + solution.minPatches(nums2, 20));
        System.out.println("预期输出：2");
        System.out.println();
        
        // 测试用例 3
        int[] nums3 = {1, 2, 2};
        System.out.println("测试用例 3：");
        System.out.println("输入：nums = [1,2,2], n = 5");
        System.out.println("输出：" + solution.minPatches(nums3, 5));
        System.out.println("预期输出：0");
    }
} 