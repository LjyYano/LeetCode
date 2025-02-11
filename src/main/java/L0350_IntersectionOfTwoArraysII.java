import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 * 
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则取较小值）。
 * 
 * 可以不考虑输出结果的顺序。
 * 
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class L0350_IntersectionOfTwoArraysII {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        // 使用 HashMap 统计第一个数组中每个元素出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // 使用 List 存储交集结果
        List<Integer> resultList = new ArrayList<>();
        
        // 遍历第二个数组
        for (int num : nums2) {
            // 如果当前元素在 map 中且次数大于 0
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                resultList.add(num);
                // 减少该元素的计数
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        
        // 将 List 转换为数组
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0350_IntersectionOfTwoArraysII solution = new L0350_IntersectionOfTwoArraysII();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("测试用例 1");
        System.out.println("输入：nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("输出：" + Arrays.toString(solution.intersect(nums1, nums2)));
        System.out.println();
        
        // 测试用例 2
        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println("测试用例 2");
        System.out.println("输入：nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("输出：" + Arrays.toString(solution.intersect(nums1, nums2)));
    }
} 