package LeetCode;

public class L035_Search_Insert_Position {

	public int searchInsert(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				return i;
			}
		}

		return nums.length;
	}

}
