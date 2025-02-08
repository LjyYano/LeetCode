/**
 * 题目链接：https://leetcode.cn/problems/remove-element/
 * 
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class L0027_RemoveElement {

    public int removeElement(int[] nums, int val) {
        // 如果数组为空，返回 0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // 使用双指针，slow 指向当前需要填入的位置
        // fast 用于遍历数组
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            // 当遇到不等于 val 的元素时，将其移动到 slow 位置
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        return slow;
    }

    public static void main(String[] args) {
        L0027_RemoveElement solution = new L0027_RemoveElement();

        // 测试用例 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        System.out.print("测试用例 1 - 结果长度: " + k1 + ", 数组前 " + k1 + " 个元素: ");
        printArray(nums1, k1);  // 预期输出：2, [2,2]

        // 测试用例 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        System.out.print("测试用例 2 - 结果长度: " + k2 + ", 数组前 " + k2 + " 个元素: ");
        printArray(nums2, k2);  // 预期输出：5, [0,1,3,0,4]

        // 测试用例 3：空数组
        int[] nums3 = {};
        int val3 = 1;
        int k3 = solution.removeElement(nums3, val3);
        System.out.print("测试用例 3 - 结果长度: " + k3 + ", 数组前 " + k3 + " 个元素: ");
        printArray(nums3, k3);  // 预期输出：0, []

        // 测试用例 4：数组中所有元素都等于 val
        int[] nums4 = {1, 1, 1};
        int val4 = 1;
        int k4 = solution.removeElement(nums4, val4);
        System.out.print("测试用例 4 - 结果长度: " + k4 + ", 数组前 " + k4 + " 个元素: ");
        printArray(nums4, k4);  // 预期输出：0, []
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