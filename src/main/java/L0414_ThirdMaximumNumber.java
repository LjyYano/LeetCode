import java.util.*;

/**
 * https://leetcode.cn/problems/third-maximum-number/description/
 * 
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * 
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 */
public class L0414_ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        // 使用 Long 类型是为了处理 Integer.MIN_VALUE 的情况
        Long firstMax = null;
        Long secondMax = null;
        Long thirdMax = null;
        
        for (int num : nums) {
            Long n = Long.valueOf(num);
            // 跳过重复的数字
            if (n.equals(firstMax) || n.equals(secondMax) || n.equals(thirdMax)) {
                continue;
            }
            
            // 更新三个最大值
            if (firstMax == null || n > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            } else if (secondMax == null || n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (thirdMax == null || n > thirdMax) {
                thirdMax = n;
            }
        }
        
        // 如果第三大的数不存在，返回最大的数
        return thirdMax == null ? firstMax.intValue() : thirdMax.intValue();
    }

    public static void main(String[] args) {
        L0414_ThirdMaximumNumber solution = new L0414_ThirdMaximumNumber();
        
        // 测试用例1
        int[] nums1 = {3, 2, 1};
        System.out.println("测试用例1：");
        System.out.println("输入：" + Arrays.toString(nums1));
        System.out.println("输出：" + solution.thirdMax(nums1));
        
        // 测试用例2
        int[] nums2 = {1, 2};
        System.out.println("\n测试用例2：");
        System.out.println("输入：" + Arrays.toString(nums2));
        System.out.println("输出：" + solution.thirdMax(nums2));
        
        // 测试用例3
        int[] nums3 = {2, 2, 3, 1};
        System.out.println("\n测试用例3：");
        System.out.println("输入：" + Arrays.toString(nums3));
        System.out.println("输出：" + solution.thirdMax(nums3));
        
        // 测试用例4：包含 Integer.MIN_VALUE
        int[] nums4 = {1, Integer.MIN_VALUE, 2};
        System.out.println("\n测试用例4：");
        System.out.println("输入：" + Arrays.toString(nums4));
        System.out.println("输出：" + solution.thirdMax(nums4));
    }
} 