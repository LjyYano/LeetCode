package LeetCode;

public class L278_First_Bad_Version {

	public int firstBadVersion(int n) {

		int low = 1, high = n;

		while (low < high) {

			int mid = low + (high - low) / 2;

			if (isBadVersion(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	// 无意义，仅仅是为了能够编译通过！
	private boolean isBadVersion(int mid) {
		return false;
	}
}
