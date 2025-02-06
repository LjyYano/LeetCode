import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/permutation-sequence/
public class L0060_Permutation_Sequence {
    public String getPermutation(int n, int k) {

		if (n <= 0 || k <= 0) {
			return "";
		}

		String result = "";

		List<Integer> list = new ArrayList<Integer>();
		int fact = 1;

		for (int i = 1; i <= n; i++) {
			list.add(i);
			fact *= i;
		}

		k--;

		for (int i = 0; i < n; i++) {
			fact /= (n - i);
			int index = k / fact;
			result += list.get(index);
			list.remove(index);
			k %= fact;
		}

		return result;
	
        
    }
}