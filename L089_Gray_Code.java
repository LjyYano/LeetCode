package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L089_Gray_Code {

	public List<Integer> grayCode(int n) {

		List<Integer> rt = new ArrayList<Integer>();

		if (n < 0) {
			return rt;
		}

		for (int i = 0; i < Math.pow(2, n); i++) {
			rt.add((i >> 1) ^ i);
		}

		return rt;
	}

}
