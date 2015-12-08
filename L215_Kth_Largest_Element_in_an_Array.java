package LeetCode;

public class L215_Kth_Largest_Element_in_an_Array {

	public int findKthLargest(int[] nums, int k) {

		return findK(nums, nums.length - k, 0, nums.length - 1);

	}

	int findK(int[] nums, int k, int low, int high) {

		if (low >= high) {
			return nums[low];
		}

		int p = partition(nums, low, high);

		if (p == k) {
			return nums[p];
		} else if (p < k) {
			// 求第k大的，所以要反过来
			return findK(nums, k, p + 1, high);
		} else {
			return findK(nums, k, low, p - 1);
		}
	}

	int partition(int[] nums, int low, int high) {

		int privotKey = nums[low];

		while (low < high) {

			while (low < high && nums[high] >= privotKey) {
				high--;
			}
			swap(nums, low, high);

			while (low < high && nums[low] <= privotKey) {
				low++;
			}
			swap(nums, low, high);
		}

		return low;
	}

	private void swap(int[] nums, int low, int high) {
		int t = nums[low];
		nums[low] = nums[high];
		nums[high] = t;
	}

}
