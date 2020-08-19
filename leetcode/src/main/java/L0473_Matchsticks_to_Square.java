import java.util.Arrays;

// https://leetcode-cn.com/problems/matchsticks-to-square/
class L0473_Matchsticks_to_Square {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
			return false;
		}
        
        int tmp = 0;
        for(int i : nums) {
        	tmp += i;
        }
        
        if (tmp % 4 != 0) {
			return false;
		}
        
        Arrays.sort(nums);
        return robot(0, nums, new int[4], tmp / 4);
    }
	
	private boolean robot(int pos, int[] nums, int[] sum, int each) {
		if (pos == nums.length) {
			return sum[0] == each &&sum[1] == each && sum[2] == each;  
		}
		
		for(int i = 0; i < 4; i++) {
			int index = nums.length - 1 - pos;
			if (sum[i] + nums[index] > each) {
				continue;
			}
			sum[i] += nums[index];
			if (robot(pos + 1, nums, sum, each)) {
				return true;
			}
			sum[i] -= nums[index];
		}
		
		return false;
	}
}