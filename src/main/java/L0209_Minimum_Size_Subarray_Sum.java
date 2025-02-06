
// https://leetcode-cn.com/problems/minimum-size-subarray-sum/
class L0209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int start = 0, end = 0, sum = 0, ans = Integer.MAX_VALUE;
        while(end < nums.length && start < nums.length) {
            
            // 滑动窗口，end
            while(end < nums.length && sum < s) {
                sum += nums[end++];
                if(sum >= s) {
                    ans = Math.min(ans, end - start);
                }
            }
            
            // 滑动窗口，start
            while(start < nums.length && sum >= s) {
                sum -= nums[start++];
                if(sum < s) {
                    ans = Math.min(ans, end - start + 1);
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}