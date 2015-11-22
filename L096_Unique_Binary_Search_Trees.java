package LeetCode;

public class L096_Unique_Binary_Search_Trees {

	public static int numTrees(int n) {

		if (n == 1 || n == 2) {
			return n;
		}

		int[] record = new int[n + 1];

		record[0] = 1;
		record[1] = 1;
		record[2] = 2;

		for (int i = 3; i <= n; i++) {
			int tmp = 0;
			for (int k = 0; k < i; k++) {
				tmp += (record[k] * record[i - k - 1]);
			}
			record[i] = tmp;
		}

		return record[n];
	}

}
