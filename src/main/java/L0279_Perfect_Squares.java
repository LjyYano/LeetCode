import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/perfect-squares/
class L0279_Perfect_Squares {
	public int numSquares(int n) {
		List<Integer> ans = new ArrayList<>();
		ans.add(0);
		while (ans.size() <= n) {
			int m = ans.size(), val = Integer.MAX_VALUE;
			for (int i = 1; i * i <= m; i++) {
				val = Math.min(val, ans.get(m - i * i) + 1);
			}
			ans.add(val);
		}
		return ans.get(n);
	}
}