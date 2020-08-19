
// https://leetcode-cn.com/problems/sort-colors/
class L0075_Sort_Colors {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        for(int i = 0; i <= end; i++) {
            // 顺序不能换，因为i后面可能换到0，但是i前面是不可能有2的
            while(nums[i] == 2 && i < end) swap(nums, i, end--);
            while(nums[i] == 0 && i > start) swap(nums, i, start++);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}