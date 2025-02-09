/**
 * https://leetcode.cn/problems/merge-sorted-array/
 * 
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 
 * 示例 3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存储到 nums1 中。
 * 
 * 提示：
 * - nums1.length == m + n
 * - nums2.length == n
 * - 0 <= m, n <= 200
 * - 1 <= m + n <= 200
 * - -10⁹ <= nums1[i], nums2[j] <= 10⁹
 */
public class L0088_MergeSortedArray {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前遍历，将较大的数放到 nums1 的末尾
        int p1 = m - 1;    // nums1 的指针
        int p2 = n - 1;    // nums2 的指针
        int p = m + n - 1; // 合并后数组的指针
        
        // 当两个数组都还有元素时
        while (p1 >= 0 && p2 >= 0) {
            // 将较大的数放到 nums1 的末尾
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        
        // 如果 nums2 还有剩余元素，将其复制到 nums1 的前面
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        // 注意：如果 nums1 还有剩余元素，不需要处理，因为它们已经在正确的位置上了
    }

    public static void main(String[] args) {
        L0088_MergeSortedArray solution = new L0088_MergeSortedArray();

        // 测试用例 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        System.out.println("测试用例 1：");
        System.out.print("合并前 nums1 = ");
        printArray(nums1);
        System.out.print("nums2 = ");
        printArray(nums2);
        solution.merge(nums1, m, nums2, n);
        System.out.print("合并后 nums1 = ");
        printArray(nums1);
        System.out.println();

        // 测试用例 2
        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        System.out.println("测试用例 2：");
        System.out.print("合并前 nums1 = ");
        printArray(nums1);
        System.out.print("nums2 = ");
        printArray(nums2);
        solution.merge(nums1, m, nums2, n);
        System.out.print("合并后 nums1 = ");
        printArray(nums1);
        System.out.println();

        // 测试用例 3
        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        System.out.println("测试用例 3：");
        System.out.print("合并前 nums1 = ");
        printArray(nums1);
        System.out.print("nums2 = ");
        printArray(nums2);
        solution.merge(nums1, m, nums2, n);
        System.out.print("合并后 nums1 = ");
        printArray(nums1);
    }

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