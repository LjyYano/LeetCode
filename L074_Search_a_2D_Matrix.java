package LeetCode;

public class L074_Search_a_2D_Matrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		int mx = matrix.length;
		int my = matrix[0].length;

		int l = 0;
		int r = mx * my;

		while (l < r) {

			int m = l + (r - l) / 2;

			// 将m转换成x、y
			int x = m / my;
			int y = m % my;

			// 二分查找：matrix[x][y]转换成一维数组，坐标就是m
			if (matrix[x][y] == target) {
				return true;
			} else if (matrix[x][y] < target) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		return false;
	}

}
