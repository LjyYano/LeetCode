package LeetCode;

public class L080_Remove_Duplicates_from_Sorted_Array_II {

	public int removeDuplicates(int[] nums) {

		int cur = 2;
		for (int i = cur; i < nums.length; i++) {
			// 一个数字，最多出现2次
			if (!(nums[i] == nums[cur - 1] && nums[i] == nums[cur - 2])) {
				nums[cur++] = nums[i];
			}
		}

		return Math.min(cur, nums.length);
	}
}
