import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/combination-sum-ii/
 * 
 * 给定一个候选人编号的集合 candidates 和一个目标数 target，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次。
 * 注意：解集不能包含重复的组合。 
 * 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class L0040_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 先对数组排序，让相同的数字相邻，方便去重和剪枝
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
            
            // 去重：跳过同一层递归中重复的数字
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // 选择当前数字
            current.add(candidates[i]);
            // 继续搜索（因为每个数字只能用一次，所以下一轮从 i+1 开始）
            backtrack(result, current, candidates, remain - candidates[i], i + 1);
            // 撤销选择
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        L0040_CombinationSumII solution = new L0040_CombinationSumII();
        
        // 测试用例 1
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println("测试用例 1：");
        System.out.println("输入：candidates = [10,1,2,7,6,1,5], target = 8");
        System.out.println("输出：" + solution.combinationSum2(candidates1, target1));
        // 预期输出：[[1,1,6],[1,2,5],[1,7],[2,6]]
        
        // 测试用例 2
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println("\n测试用例 2：");
        System.out.println("输入：candidates = [2,5,2,1,2], target = 5");
        System.out.println("输出：" + solution.combinationSum2(candidates2, target2));
        // 预期输出：[[1,2,2],[5]]
    }
} 