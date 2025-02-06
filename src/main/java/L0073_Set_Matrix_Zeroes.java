
// https://leetcode-cn.com/problems/set-matrix-zeroes/
public class L0073_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return;
		}

		int mx = matrix.length;
		int my = matrix[0].length;

		boolean xflag = false, yflag = false;

		for (int i = 0; i < mx; i++) {
			if (matrix[i][0] == 0) {
				xflag = true;
				break;
			}
		}

		for (int i = 0; i < my; i++) {
			if (matrix[0][i] == 0) {
				yflag = true;
				break;
			}
		}

		for (int i = 1; i < mx; i++) {
			for (int j = 1; j < my; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < mx; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < my; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < my; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j < mx; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		if (xflag) {
			for (int i = 0; i < mx; i++) {
				matrix[i][0] = 0;
			}
		}

		if (yflag) {
			for (int i = 0; i < my; i++) {
				matrix[0][i] = 0;
			}
		}

	}
}