import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum-iii/
 * 
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 
 * - 只使用数字 1 到 9
 * - 每个数字 最多使用一次
 * 
 * 返回 所有可能的有效组合的列表。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 
 * 示例 1：
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 
 * 示例 2：
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 
 * 示例 3：
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * 
 * 提示:
 * - 2 <= k <= 9
 * - 1 <= n <= 60
 */
public class L0216_CombinationSumIII {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int remain, int start) {
        // 如果当前组合已经有 k 个数字
        if (current.size() == k) {
            // 如果剩余和为 0，说明找到了一个有效组合
            if (remain == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        
        // 剪枝：如果剩余数字不够凑成 k 个，或者剩余和小于 0，直接返回
        if (remain < 0 || 9 - start + 1 < k - current.size()) {
            return;
        }
        
        // 尝试选择每个可能的数字
        for (int i = start; i <= 9; i++) {
            // 选择当前数字
            current.add(i);
            // 继续递归，寻找下一个数字
            backtrack(result, current, k, remain - i, i + 1);
            // 回溯，移除最后选择的数字
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        L0216_CombinationSumIII solution = new L0216_CombinationSumIII();
        
        // 测试用例 1
        System.out.println("输入：k = 3, n = 7");
        System.out.println("输出：" + solution.combinationSum3(3, 7));  // 预期输出：[[1,2,4]]
        
        // 测试用例 2
        System.out.println("\n输入：k = 3, n = 9");
        System.out.println("输出：" + solution.combinationSum3(3, 9));  // 预期输出：[[1,2,6], [1,3,5], [2,3,4]]
        
        // 测试用例 3
        System.out.println("\n输入：k = 4, n = 1");
        System.out.println("输出：" + solution.combinationSum3(4, 1));  // 预期输出：[]
    }
} 