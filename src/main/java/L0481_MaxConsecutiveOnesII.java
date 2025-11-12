public class L0481_MaxConsecutiveOnesII {
    // 方法一：滑动窗口
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            
            // 当窗口内的0超过1个时，移动左边界
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
    
    // 方法二：动态规划
    public int findMaxConsecutiveOnesDP(int[] nums) {
        int noFlip = 0;  // 不使用翻转机会
        int oneFlip = 0; // 使用一次翻转机会
        int maxLen = 0;
        
        for (int num : nums) {
            if (num == 1) {
                noFlip++;
                oneFlip++;
            } else {
                // 遇到0，使用翻转机会
                oneFlip = noFlip + 1;
                noFlip = 0;
            }
            maxLen = Math.max(maxLen, oneFlip);
        }
        
        return maxLen;
    }
} 