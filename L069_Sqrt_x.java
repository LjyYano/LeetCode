package LeetCode;

public class L069_Sqrt_x {

	public int mySqrt(int x) {

		// 首先对负数和0进行处理
		if (x < 0) {
			return -1;
		} else if (x == 0) {
			return 0;
		}

		int start = 1;
		int end = x;

		while (start < end) {

			// 不能直接相加除以2，因为两个数相加可能溢出
			int m = start + (end - start) / 2;

			// 不能用m^2，(m+1)^2，因为可能溢出
			int m1 = x / m;
			int m2 = x / (m + 1);

			// m*2 == x
			if (m == m1) {
				return m;
			}

			// (m+1)^2 == x
			if (m + 1 == m2) {
				return m + 1;
			}

			// m*2 <= x && (m+1)^2 > x
			if (m < m1 && m + 1 > m2) {
				return m;
			}

			// m*2 > x
			if (m1 < m) {
				end = m;
			} else {
				// (m+1)^2 < x
				start = m + 1;
			}
		}

		return 1;
	}

}
