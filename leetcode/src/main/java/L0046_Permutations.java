import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/permutations/
public class L0046_Permutations {
    
    public void robot(int idx, int[] nums, boolean[] visit, List<Integer> tmp, List<List<Integer>> ans) {
        if(idx >= nums.length) {
            ans.add(new ArrayList(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visit[i] == false) {
                tmp.add(nums[i]);
                visit[i] = true;
                robot(idx + 1, nums, visit, tmp, ans);
                tmp.remove(tmp.size() - 1);
                visit[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visit = new boolean[nums.length];
        robot(0, nums, visit, tmp, ans);
        return ans;
    }
}