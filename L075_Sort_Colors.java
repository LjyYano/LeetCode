package LeetCode;

public class L075_Sort_Colors {

	public void sortColors(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}

		// 定义三个变量，存储三种颜色出现次数
		int red = 0;
		int white = 0;
		int blue = 0;

		// 循环一次，记录每种颜色出现次数
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				red++;
			} else if (nums[i] == 1) {
				white++;
			} else {
				blue++;
			}
		}

		// 对nums数组重新赋值
		int i = 0;
		while (red-- > 0) {
			nums[i++] = 0;
		}
		while (white-- > 0) {
			nums[i++] = 1;
		}
		while (blue-- > 0) {
			nums[i++] = 2;
		}
	}
}
