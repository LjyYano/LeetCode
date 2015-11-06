package LeetCode;

public class L027_Remove_Element {

	public int removeElement(int[] nums, int val) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int len = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[len++] = nums[i];
			}
		}

		return len;
	}
}
