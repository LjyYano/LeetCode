package LeetCode;

public class L026_Remove_Duplicates_from_Sorted_Array {

	public int removeDuplicates(int[] nums) {

		if (nums == null) {
			return -1;
		}

		if (nums.length < 2) {
			return nums.length;
		}

		int len = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[len] != nums[i]) {
				nums[++len] = nums[i];
			}
		}

		return len + 1;
	}
}
