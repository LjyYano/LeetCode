package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L228_Summary_Ranges {

	public List<String> summaryRanges(int[] nums) {

		List<String> rt = new ArrayList<String>();

		if (nums == null || nums.length == 0) {
			return rt;
		}

		for (int i = 0; i < nums.length; i++) {
			int st = nums[i];
			int ed = st;

			while (i + 1 < nums.length && nums[i + 1] - ed == 1) {
				i++;
				ed++;
			}

			if (ed == st) {
				rt.add(st + "");
			} else {
				rt.add(st + "->" + ed);
			}
		}

		return rt;
	}

}
