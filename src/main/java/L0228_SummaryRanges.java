import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/summary-ranges/
 * 
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * - "a->b" ，如果 a != b
 * - "a" ，如果 a == b
 * 
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 
 * 提示：
 * - 0 <= nums.length <= 20
 * - -2³¹ <= nums[i] <= 2³¹ - 1
 * - nums 中的所有值都 互不相同
 * - nums 按升序排列
 */
public class L0228_SummaryRanges {
    
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 区间的起始位置
        int start = nums[0];
        
        // 遍历数组，寻找区间
        for (int i = 1; i <= nums.length; i++) {
            // 当到达数组末尾或者不连续时，生成区间字符串
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // 如果起始位置和结束位置相同，只输出一个数字
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    // 否则输出区间
                    result.add(start + "->" + nums[i - 1]);
                }
                
                // 如果还没到数组末尾，更新起始位置
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0228_SummaryRanges solution = new L0228_SummaryRanges();
        
        // 测试用例 1
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println("输入：" + java.util.Arrays.toString(nums1));
        System.out.println("输出：" + solution.summaryRanges(nums1));  // 预期输出：["0->2","4->5","7"]
        
        // 测试用例 2
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println("\n输入：" + java.util.Arrays.toString(nums2));
        System.out.println("输出：" + solution.summaryRanges(nums2));  // 预期输出：["0","2->4","6","8->9"]
    }
} 