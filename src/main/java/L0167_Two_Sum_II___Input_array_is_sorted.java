
// https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
class L0167_Two_Sum_II___Input_array_is_sorted {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
			return null;
        
        int start = 0, end = nums.length - 1;

		while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == target) return new int[]{start + 1, end + 1};
            else if(sum < target) start++;
            else end--;
        }

		return null;
    }
}