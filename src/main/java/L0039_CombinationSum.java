import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/combination-sum/
 * 
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target，找出 candidates 中可以使数字和为目标数 target 的所有不同组合，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * 
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class L0039_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 先对数组排序，方便剪枝
        Arrays.sort(candidates);
        // 回溯搜索所有可能的组合
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    /**
     * 回溯方法
     * @param result 存储所有符合条件的组合
     * @param current 当前正在构建的组合
     * @param candidates 候选数组
     * @param remain 剩余需要凑成的目标值
     * @param start 当前可以选择的起始位置
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
            int[] candidates, int remain, int start) {
        // 找到一个符合条件的组合
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // 尝试选择每个可能的数字
        for (int i = start; i < candidates.length; i++) {
            // 剪枝：如果当前数字已经大于剩余目标值，后面的数字更大，一定不符合要求
            if (candidates[i] > remain) {
                break;
            }
            
            // 选择当前数字
            current.add(candidates[i]);
            // 继续搜索（因为可以重复使用，所以传入的起始位置仍然是 i）
            backtrack(result, current, candidates, remain - candidates[i], i);
            // 撤销选择
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        L0039_CombinationSum solution = new L0039_CombinationSum();
        
        // 测试用例 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("测试用例 1：");
        System.out.println("输入：candidates = [2,3,6,7], target = 7");
        System.out.println("输出：" + solution.combinationSum(candidates1, target1));
        // 预期输出：[[2,2,3],[7]]
        
        // 测试用例 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("\n测试用例 2：");
        System.out.println("输入：candidates = [2,3,5], target = 8");
        System.out.println("输出：" + solution.combinationSum(candidates2, target2));
        // 预期输出：[[2,2,2,2],[2,3,3],[3,5]]
        
        // 测试用例 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("\n测试用例 3：");
        System.out.println("输入：candidates = [2], target = 1");
        System.out.println("输出：" + solution.combinationSum(candidates3, target3));
        // 预期输出：[]
    }
} 