import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sort-colors/
 * 
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 
 * 提示：
 * - n == nums.length
 * - 1 <= n <= 300
 * - nums[i] 为 0、1 或 2
 * 
 * 进阶：
 * - 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class L0075_SortColors {
    public void sortColors(int[] nums) {
        // 使用双指针法，一个指针 p0 指向 0 的最右边界，一个指针 p2 指向 2 的最左边界
        int p0 = 0;  // 指向 0 的最右边界
        int p2 = nums.length - 1;  // 指向 2 的最左边界
        int curr = 0;  // 当前遍历的位置

        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 如果当前数字是 0，就和 p0 指向的数字交换
                swap(nums, curr, p0);
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                // 如果当前数字是 2，就和 p2 指向的数字交换
                swap(nums, curr, p2);
                p2--;
                // 注意这里不需要 curr++，因为交换过来的数字还需要继续判断
            } else {
                // 如果当前数字是 1，就直接跳过
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 