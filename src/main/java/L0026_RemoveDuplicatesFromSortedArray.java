/**
 * 题目链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * 
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * - 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * - 返回 k 。
 */
public class L0026_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        // 如果数组为空，返回 0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // 使用双指针，slow 指向当前需要填入的位置
        // fast 用于遍历数组
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            // 当遇到不同的元素时，将其移动到 slow 位置
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        return slow;
    }

    public static void main(String[] args) {
        L0026_RemoveDuplicatesFromSortedArray solution = new L0026_RemoveDuplicatesFromSortedArray();

        // 测试用例 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.print("测试用例 1 - 结果长度: " + k1 + ", 数组前 " + k1 + " 个元素: ");
        printArray(nums1, k1);  // 预期输出：2, [1,2]

        // 测试用例 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.print("测试用例 2 - 结果长度: " + k2 + ", 数组前 " + k2 + " 个元素: ");
        printArray(nums2, k2);  // 预期输出：5, [0,1,2,3,4]

        // 测试用例 3：空数组
        int[] nums3 = {};
        int k3 = solution.removeDuplicates(nums3);
        System.out.print("测试用例 3 - 结果长度: " + k3 + ", 数组前 " + k3 + " 个元素: ");
        printArray(nums3, k3);  // 预期输出：0, []

        // 测试用例 4：只有一个元素
        int[] nums4 = {1};
        int k4 = solution.removeDuplicates(nums4);
        System.out.print("测试用例 4 - 结果长度: " + k4 + ", 数组前 " + k4 + " 个元素: ");
        printArray(nums4, k4);  // 预期输出：1, [1]
    }

    // 辅助方法：打印数组的前 k 个元素
    private static void printArray(int[] nums, int k) {
        System.out.print("[");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
} 