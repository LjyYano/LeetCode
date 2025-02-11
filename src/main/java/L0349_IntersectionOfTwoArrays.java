import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * 
 * 给定两个数组 nums1 和 nums2 ，返回它们的交集。输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序。
 * 
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * 
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class L0349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 使用 HashSet 去重
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        // 使用另一个 HashSet 存储交集
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        
        // 将结果转换为数组
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0349_IntersectionOfTwoArrays solution = new L0349_IntersectionOfTwoArrays();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("测试用例 1");
        System.out.println("输入：nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("输出：" + Arrays.toString(solution.intersection(nums1, nums2)));
        System.out.println();
        
        // 测试用例 2
        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println("测试用例 2");
        System.out.println("输入：nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("输出：" + Arrays.toString(solution.intersection(nums1, nums2)));
    }
} 