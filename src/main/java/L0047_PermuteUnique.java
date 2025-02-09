import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations-ii/
 * 
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：[[1,1,2], [1,2,1], [2,1,1]]
 * 
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class L0047_PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 先排序，让相同的数字相邻，方便去重
        Arrays.sort(nums);
        // 使用 boolean 数组标记已使用的数字
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // 当临时列表的大小等于数组长度时，说明找到了一个排列
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        // 尝试将每个数字加入临时列表
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已经使用过，跳过
            if (used[i]) {
                continue;
            }
            
            // 去重：如果当前数字与前一个数字相同，且前一个数字未被使用，跳过
            // 这样可以确保相同数字按照顺序使用，避免产生重复排列
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            
            // 将当前数字标记为已使用
            used[i] = true;
            // 将当前数字加入临时列表
            tempList.add(nums[i]);
            // 递归调用
            backtrack(result, tempList, nums, used);
            // 回溯，移除最后添加的数字，并标记为未使用
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        L0047_PermuteUnique solution = new L0047_PermuteUnique();
        
        // 测试用例 1
        int[] nums1 = {1, 1, 2};
        System.out.println("测试用例 1：");
        System.out.println(solution.permuteUnique(nums1));
        
        // 测试用例 2
        int[] nums2 = {1, 2, 3};
        System.out.println("测试用例 2：");
        System.out.println(solution.permuteUnique(nums2));
    }
} 