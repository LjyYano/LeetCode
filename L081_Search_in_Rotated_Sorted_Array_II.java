package LeetCode;

public class L081_Search_in_Rotated_Sorted_Array_II {

	public boolean search(int[] nums, int target) {

		int left = 0, right = nums.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (nums[mid] == target)
				return true;

			if (nums[left] < nums[mid]) {
				if (target <= nums[mid] && target >= nums[left])
					right = mid - 1;
				else
					left = mid + 1;
			} else if (nums[left] > nums[mid]) {
				if (target >= nums[left] || target <= nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else
				left++;
		}

		return false;
	}

}
