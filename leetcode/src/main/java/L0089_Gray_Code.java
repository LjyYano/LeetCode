import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/gray-code/
public class L0089_Gray_Code {
    public List<Integer> grayCode(int n) {

		List<Integer> result = new ArrayList<Integer>();

		if (n < 0) {
			return result;
		}

		for (int i = 0; i < Math.pow(2, n); i++) {
			result.add((i >> 1) ^ i);
		}

		return result;

	}
}