public class L0081_Search_in_Rotated_Sorted_Array_II {

	public boolean search(int[] nums, int target) {

		int l = 0, r = nums.length - 1;

		while (l <= r) {

			int m = (l + r) / 2;

			if (nums[m] == target)
				return true;

			if (nums[l] < nums[m]) {
				if (target <= nums[m] && target >= nums[l])
					r = m - 1;
				else
					l = m + 1;
			} else if (nums[l] > nums[m]) {
				if (target >= nums[l] || target <= nums[m])
					r = m - 1;
				else
					l = m + 1;
			} else
				l++;
		}

		return false;
	}

}
