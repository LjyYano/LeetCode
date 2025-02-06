import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/combination-sum-ii/
class L0040_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] n, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(n);
        combinationSum2Dfs(n, 0, target, ans, new ArrayList<>());
        return ans;
    }

    private void combinationSum2Dfs(int[] n, int start, int left, List<List<Integer>> ans, List<Integer> tmp) {
        if(left == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < n.length; i++) {
            if (i > start && n[i] == n[i - 1]) continue;

            if (left < n[i]) {
                break;
            }

            tmp.add(n[i]);
            combinationSum2Dfs(n, i + 1, left - n[i], ans, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}