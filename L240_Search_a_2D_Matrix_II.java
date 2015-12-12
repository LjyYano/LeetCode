package LeetCode;

public class L240_Search_a_2D_Matrix_II {

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0, y = n - 1;

		while (x < m && y >= 0) {
			if (matrix[x][y] == target) {
				return true;
			} else if (matrix[x][y] < target) {
				x++;
			} else {
				y--;
			}
		}

		return false;
	}
}
