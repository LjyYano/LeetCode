// https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
// 80. 删除有序数组中的重复项 II
// 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

public class L0080_RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 数组长度小于等于 2，不需要处理
        if (nums.length <= 2) {
            return nums.length;
        }
        // 慢指针，指向当前可以放置元素的位置
        int slow = 2;
        // 快指针，用于遍历数组
        for (int fast = 2; fast < nums.length; fast++) {
            // 如果当前元素与倒数第二个元素不同，说明可以放置
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        L0080_RemoveDuplicatesFromSortedArrayII solution = new L0080_RemoveDuplicatesFromSortedArrayII();

        // 测试用例 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int len1 = solution.removeDuplicates(nums1);
        System.out.println("测试用例 1:");
        System.out.print("新长度: " + len1 + ", 数组前 " + len1 + " 个元素: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        // 测试用例 2
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len2 = solution.removeDuplicates(nums2);
        System.out.println("测试用例 2:");
        System.out.print("新长度: " + len2 + ", 数组前 " + len2 + " 个元素: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }
} 