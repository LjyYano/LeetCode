import java.util.Arrays;

// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
public class L0153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.min(nums[0], nums[1]);
		}

		int s = 0, e = nums.length - 1;

		int m = (s + e) / 2;

		if (nums[s] < nums[e]) {
			return nums[s];
		}

		if (nums[m] > nums[s]) {
			return findMin(Arrays.copyOfRange(nums, m + 1, e + 1));
		}

		return findMin(Arrays.copyOfRange(nums, s, m + 1));

	
        
    }
}