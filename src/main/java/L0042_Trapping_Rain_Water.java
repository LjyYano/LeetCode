
// https://leetcode-cn.com/problems/trapping-rain-water/
class L0042_Trapping_Rain_Water {
    public int trap(int[] height) {
        if(height == null) return 0;
        
        int ans = 0, maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;
        
        while(left < right) {
            
            // 左位置的左边的最高值，右位置的右边的最高值
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            
            if(maxLeft < maxRight) {
                ans += maxLeft - height[left++];
            } else {
                ans += maxRight - height[right--];
            }
        }
        
        return ans;
    }
}