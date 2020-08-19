
// https://leetcode-cn.com/problems/next-permutation/
class L0031_Next_Permutation {
	public void nextPermutation(int[] nums) {
        // 1. 向前找首个递减
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				int j = nums.length - 1;
                // 2. 向前找首个大于nums[i]的索引
				for (; j > i; j--) {
					if (nums[j] > nums[i]) {
						break;
					}
				}
                // 3. 交换两个值
				swap(nums, i, j);
                // 4. 交换后面所有
				reverseSwap(nums, i + 1, nums.length - 1);
				return;
			}
		}
		reverseSwap(nums, 0, nums.length - 1);
	}

	private void reverseSwap(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start++, end--);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}