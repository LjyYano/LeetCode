import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 * 
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * 
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class L0046_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // 当临时列表的大小等于数组长度时，说明找到了一个排列
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        // 尝试将每个数字加入临时列表
        for (int i = 0; i < nums.length; i++) {
            // 如果临时列表已经包含了这个数字，跳过
            if (tempList.contains(nums[i])) {
                continue;
            }
            // 将当前数字加入临时列表
            tempList.add(nums[i]);
            // 递归调用
            backtrack(result, tempList, nums);
            // 回溯，移除最后添加的数字
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        L0046_Permutations solution = new L0046_Permutations();
        
        // 测试用例 1
        int[] nums1 = {1, 2, 3};
        System.out.println(solution.permute(nums1));
        
        // 测试用例 2
        int[] nums2 = {0, 1};
        System.out.println(solution.permute(nums2));
        
        // 测试用例 3
        int[] nums3 = {1};
        System.out.println(solution.permute(nums3));
    }
} 