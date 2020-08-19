
// https://leetcode-cn.com/problems/max-consecutive-ones/
class L0485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                int count = 0;
                while(i < nums.length && nums[i] == 1) {
                    count++;
                    i++;
                }
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }
}