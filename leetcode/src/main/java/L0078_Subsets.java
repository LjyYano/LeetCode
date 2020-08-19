import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/subsets/
class L0078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null) return ans;
        robot(0, nums, ans, new ArrayList<Integer>());
        return ans;
    }
    
    private void robot(int start, int[] nums, List<List<Integer>> ans, List<Integer> tmp) {
        ans.add(new ArrayList(tmp));
        
        for(int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            robot(i + 1, nums, ans, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}