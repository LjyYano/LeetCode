import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets-ii/
 * 
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 提示：
 * - 1 <= nums.length <= 10
 * - -10 <= nums[i] <= 10
 */
public class L0090_SubsetsII {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 先将数组排序，这样相同的数字会相邻
        Arrays.sort(nums);
        // 回溯生成所有子集
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // 将当前子集加入结果集
        result.add(new ArrayList<>(current));
        
        // 从 start 开始遍历，避免重复
        for (int i = start; i < nums.length; i++) {
            // 跳过重复元素，确保每个数字在相同位置只被使用一次
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 选择当前元素
            current.add(nums[i]);
            // 递归生成子集，从 i+1 开始，避免重复使用当前元素
            backtrack(nums, i + 1, current, result);
            // 撤销选择
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        L0090_SubsetsII solution = new L0090_SubsetsII();

        // 测试用例 1
        int[] nums1 = {1, 2, 2};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1));
        List<List<Integer>> result1 = solution.subsetsWithDup(nums1);
        System.out.println("输出：" + result1);
        System.out.println();

        // 测试用例 2
        int[] nums2 = {0};
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2));
        List<List<Integer>> result2 = solution.subsetsWithDup(nums2);
        System.out.println("输出：" + result2);
        System.out.println();

        // 测试用例 3：包含多个重复元素
        int[] nums3 = {1, 2, 2, 2};
        System.out.println("测试用例 3：");
        System.out.println("输入：nums = " + Arrays.toString(nums3));
        List<List<Integer>> result3 = solution.subsetsWithDup(nums3);
        System.out.println("输出：" + result3);
    }
} 