import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/permutations-ii/
public class L0047_Permutations_II {
    
    public void robot(int idx, int[] nums, boolean[] visit, List<Integer> tmp, Set<List<Integer>> ans) {
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visit = new boolean[nums.length];
        robot(0, nums, visit, tmp, ans);
        return new ArrayList<List<Integer>>(ans);
    }
}