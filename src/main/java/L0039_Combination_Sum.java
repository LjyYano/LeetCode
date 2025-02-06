import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/combination-sum/
class L0039_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] n, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n == null || n.length == 0) return ans;
        
        Arrays.sort(n);
        robot(n, 0, target, ans, new ArrayList<Integer>());
        return ans;
    }
    
    private void robot(int[] n, int start, int left, List<List<Integer>> ans, List<Integer> tmp) {
        if(left == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i = start; i < n.length; i++) {
            // 如果不符合条件，则循环后面可以省略
            if(left >= n[i]) {
                tmp.add(n[i]);
                robot(n, i, left - n[i], ans, tmp);
                tmp.remove(tmp.size() - 1);
            } else {
                break;
            }
        }
    }
}