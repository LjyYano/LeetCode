import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/ugly-number-ii/
class L0264_Ugly_Number_II {
	public int nthUglyNumber(int n) {
		List<Integer> ans = new ArrayList<>();
		ans.add(1);
		int i0 = 0, i1 = 0, i2 = 0;
		while (ans.size() < n) {
			int m0 = 2 * ans.get(i0),m1 = 3 * ans.get(i1),m2 = 5 * ans.get(i2);
			int min = Math.min(m0, Math.min(m1, m2));
			if (min == m0) i0++;
			if (min == m1) i1++;
			if (min == m2) i2++;
			ans.add(min);
		}
		return ans.get(n - 1);
	}
}