package LeetCode;

import java.util.Arrays;

public class L165_Compare_Version_Numbers {

	public static int compareVersion(String version1, String version2) {

		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int m = Math.max(v1.length, v2.length);

		v1 = Arrays.copyOf(v1, m);
		v2 = Arrays.copyOf(v2, m);

		for (int i = 0; i < m; i++) {

			int n1 = 0;
			int n2 = 0;

			if (v1[i] != null) {
				n1 = Integer.valueOf(v1[i]);
			}

			if (v2[i] != null) {
				n2 = Integer.valueOf(v2[i]);
			}

			if (n1 < n2) {
				return -1;
			} else if (n1 > n2) {
				return 1;
			}
		}

		return 0;
	}

}
