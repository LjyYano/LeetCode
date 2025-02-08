/**
 * https://leetcode.cn/problems/next-permutation/
 * 
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class L0031_NextPermutation {
    public void nextPermutation(int[] nums) {
        // 从后向前找到第一个相邻升序对 (i-1, i)，此时 i 及其后面的元素为降序
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i > 0) {
            // 从后向前找到第一个大于 nums[i-1] 的数
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i - 1]) {
                j--;
            }
            // 交换 nums[i-1] 和 nums[j]
            swap(nums, i - 1, j);
        }

        // 将 i 及其后面的元素反转
        reverse(nums, i);
    }

    // 交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 反转数组中从 start 开始的部分
    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        L0031_NextPermutation solution = new L0031_NextPermutation();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.println("测试用例 1：");
        printArray(nums1); // 预期输出：[1, 3, 2]
        
        // 测试用例 2
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println("测试用例 2：");
        printArray(nums2); // 预期输出：[1, 2, 3]
        
        // 测试用例 3
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println("测试用例 3：");
        printArray(nums3); // 预期输出：[1, 5, 1]
    }

    // 打印数组
    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
} 