/**
 * 题目链接：https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class L0004_MedianOfTwoSortedArrays {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组，优化时间复杂度
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        // 在 nums1 的区间 [0, m] 中查找恰当的分割点
        int left = 0;
        int right = m;
        
        while (left <= right) {
            // nums1 的分割点
            int i = (left + right) / 2;
            // nums2 的分割点
            int j = (m + n + 1) / 2 - i;
            
            // nums1 分割点左边的元素
            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            // nums1 分割点右边的元素
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            // nums2 分割点左边的元素
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            // nums2 分割点右边的元素
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // 找到合适的分割点
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // 如果总长度为奇数
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
                // 如果总长度为偶数
                else {
                    return (Math.max(nums1LeftMax, nums2LeftMax) + 
                           Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                }
            }
            // 需要调整分割点
            else if (nums1LeftMax > nums2RightMin) {
                right = i - 1;
            }
            else {
                left = i + 1;
            }
        }
        
        throw new IllegalArgumentException("输入数组不是有序的");
    }

    public static void main(String[] args) {
        L0004_MedianOfTwoSortedArrays solution = new L0004_MedianOfTwoSortedArrays();
        
        // 测试用例 1：奇数长度
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("测试用例 1：");
        System.out.println("nums1 = [1,3], nums2 = [2]");
        System.out.println("中位数：" + solution.findMedianSortedArrays(nums1, nums2));  // 预期输出：2.0
        
        // 测试用例 2：偶数长度
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("\n测试用例 2：");
        System.out.println("nums1 = [1,2], nums2 = [3,4]");
        System.out.println("中位数：" + solution.findMedianSortedArrays(nums3, nums4));  // 预期输出：2.5
        
        // 测试用例 3：数组长度差异大
        int[] nums5 = {1};
        int[] nums6 = {2, 3, 4, 5, 6};
        System.out.println("\n测试用例 3：");
        System.out.println("nums1 = [1], nums2 = [2,3,4,5,6]");
        System.out.println("中位数：" + solution.findMedianSortedArrays(nums5, nums6));  // 预期输出：3.5
    }
} 