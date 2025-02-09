import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 * 
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 提示：
 * - 1 <= nums.length <= 10
 * - -10 <= nums[i] <= 10
 * - nums 中的所有元素 互不相同
 */
public class L0078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 从空集开始回溯
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    /**
     * 回溯方法
     * @param result 存储所有子集的结果列表
     * @param current 当前正在构建的子集
     * @param nums 输入数组
     * @param start 当前可选的起始位置
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // 每个状态都是一个有效的子集，将其加入结果集
        result.add(new ArrayList<>(current));
        
        // 从 start 开始尝试每个数字
        for (int i = start; i < nums.length; i++) {
            // 选择当前数字
            current.add(nums[i]);
            // 继续递归，注意下一轮从 i+1 开始，避免重复
            backtrack(result, current, nums, i + 1);
            // 回溯，移除最后选择的数字
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        L0078_Subsets solution = new L0078_Subsets();

        // 测试用例 1
        int[] nums1 = {1, 2, 3};
        System.out.println("测试用例 1:");
        System.out.println("输入: nums = " + java.util.Arrays.toString(nums1));
        System.out.println("输出: " + solution.subsets(nums1));
        System.out.println();

        // 测试用例 2
        int[] nums2 = {0};
        System.out.println("测试用例 2:");
        System.out.println("输入: nums = " + java.util.Arrays.toString(nums2));
        System.out.println("输出: " + solution.subsets(nums2));
    }
} 