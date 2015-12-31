package LeetCode;

public class L073_Set_Matrix_Zeroes {

	public void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return;
		}

		int mx = matrix.length;
		int my = matrix[0].length;

		// 两个变量，判断第一行和第一列是否有0
		boolean xflag = false, yflag = false;

		// 判断第一行是否有0
		for (int i = 0; i < mx; i++) {
			if (matrix[i][0] == 0) {
				xflag = true;
				break;
			}
		}

		// 判断第一列是否有0
		for (int i = 0; i < my; i++) {
			if (matrix[0][i] == 0) {
				yflag = true;
				break;
			}
		}

		// 其它行、列是否有0
		for (int i = 1; i < mx; i++) {
			for (int j = 1; j < my; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// 对于第一列，为0，则将所在行变成0
		for (int i = 1; i < mx; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < my; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// 对于第一行，为0，则将所在列变成0
		for (int i = 0; i < my; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j < mx; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		// 若原来第一行中有0，则将整行置0
		if (xflag) {
			for (int i = 0; i < mx; i++) {
				matrix[i][0] = 0;
			}
		}

		// 若原来第一列中有0，则将整列置0
		if (yflag) {
			for (int i = 0; i < my; i++) {
				matrix[0][i] = 0;
			}
		}

	}
}
