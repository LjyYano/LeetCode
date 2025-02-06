
// https://leetcode-cn.com/problems/house-robber/
public class L0198_House_Robber {
    
    public static int[] rt;
    
    public int solve(int idx, int[] nums) {
        if(idx < 0) {
            return 0;
        }
        
        if(rt[idx] >= 0) {
            return rt[idx];
        }
        
        rt[idx] = Math.max(solve(idx - 2, nums) + nums[idx],
            solve(idx - 1, nums));
        return rt[idx];
    }
    
    public int rob(int[] nums) {
        rt = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            rt[i] = -1;
        }
        return solve(nums.length- 1, nums);
    }
}