import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/
 * 
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * 
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 
 * 提示：
 * - 1 <= n <= 20
 * - 1 <= k <= n
 */
public class L0077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // 从 1 开始回溯
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    /**
     * 回溯方法
     * @param result 存储所有组合的结果列表
     * @param current 当前正在构建的组合
     * @param start 当前可选的起始数字
     * @param n 最大的数字
     * @param k 还需要选择的数字个数
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // 如果已经选够了 k 个数字，将当前组合加入结果集
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 剪枝优化：如果剩余的数字不够凑成 k 个，就不用继续了
        // 还需要 k 个数字，但是从 start 到 n 只剩下 n-start+1 个数字
        if (n - start + 1 < k) {
            return;
        }

        // 尝试选择每个可能的数字
        for (int i = start; i <= n; i++) {
            // 选择当前数字
            current.add(i);
            // 继续递归选择下一个数字
            backtrack(result, current, i + 1, n, k - 1);
            // 回溯，移除最后选择的数字
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        L0077_Combinations solution = new L0077_Combinations();

        // 测试用例 1
        int n1 = 4, k1 = 2;
        System.out.println("测试用例 1:");
        System.out.println("输入: n = " + n1 + ", k = " + k1);
        System.out.println("输出: " + solution.combine(n1, k1));
        System.out.println();

        // 测试用例 2
        int n2 = 1, k2 = 1;
        System.out.println("测试用例 2:");
        System.out.println("输入: n = " + n2 + ", k = " + k2);
        System.out.println("输出: " + solution.combine(n2, k2));
    }
} 