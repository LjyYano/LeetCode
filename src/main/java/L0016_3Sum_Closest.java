import java.util.Arrays;

// https://leetcode-cn.com/problems/3sum-closest/
class L0016_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int l = 0; l <= nums.length - 3; l++) {
            // 起始位置与前一个值相同，结果不会更多
            if(l > 0 && nums[l] == nums[l - 1]) continue;
            
            for(int m = l + 1, r = nums.length - 1; m < r; ) {
                int sum = nums[l] + nums[m] + nums[r];
                int gap = Math.abs(target - sum);
                
                if(gap < minGap) {
                    minGap = gap;
                    ans = sum;
                }
                
                if(sum == target) {
                    return target;
                } else if(sum > target) {
                    r--;
                } else {
                    m++;
                }
            }
        }
        
        return ans;
    }
}