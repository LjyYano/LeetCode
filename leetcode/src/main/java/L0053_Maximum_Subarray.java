
// https://leetcode-cn.com/problems/maximum-subarray/
class L0053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        if(nums == null) return 0;
        // 数组可省略
        int[] result = new int[nums.length];
        int max = nums[0];
        result[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            // f(i + 1) = max(f(i) + n[i + 1], n[i + 1])
            result[i] = Math.max(nums[i] + result[i - 1], nums[i]);
            max = Math.max(max, result[i]);
        }
        return max;
    }
}