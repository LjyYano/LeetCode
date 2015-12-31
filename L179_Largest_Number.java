package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class L179_Largest_Number {

	public String largestNumber(int[] nums) {

		String[] strs = new String[nums.length];

		// 将int数组，转成string数组
		for (int i = 0; i < strs.length; i++) {
			strs[i] = nums[i] + "";
		}

		// 对strs排序
		Arrays.sort(strs, new Comparator<String>() {

			public int compare(String x, String y) {
				return (y + x).compareTo(x + y);
			}
		});

		// 如果strs第一个元素是“0”，则结果是0
		if ("0".equals(strs[0])) {
			return "0";
		}

		// 连接strs数组成字符串
		return String.join("", strs);
	}
}
