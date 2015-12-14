package LeetCode;

public class L275_H_Index_II {

	public int hIndex(int[] citations) {

		int n = citations.length;
		int low = 0, high = n - 1;

		while (low <= high) {

			int mid = low + (high - low) / 2;

			if (citations[mid] == n - mid) {
				return n - mid;
			} else if (citations[mid] < n - mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return n - low;
	}

}
