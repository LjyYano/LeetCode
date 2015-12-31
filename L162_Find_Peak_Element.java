package LeetCode;

public class L162_Find_Peak_Element {

	public int findPeakElement(int[] nums) {

		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid + 1]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

}
