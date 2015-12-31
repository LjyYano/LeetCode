package LeetCode;

import java.util.List;

public class L120_Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

		int size = triangle.size();

		if (size == 0) {
			return 0;
		}

		if (size == 1) {
			return triangle.get(0).get(0);
		}

		int[] s = new int[size];

		int k = 0;
		for (Integer v : triangle.get(size - 1)) {
			s[k++] = v;
		}

		for (int i = s.length - 2; i >= 0; i--) {
			List<Integer> list = triangle.get(i);
			for (int j = 0; j <= i; j++) {
				s[j] = list.get(j) + Math.min(s[j], s[j + 1]);
			}
		}

		return s[0];
	}

}
