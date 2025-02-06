
// https://leetcode-cn.com/problems/search-a-2d-matrix/
public class L0074_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        

		int mx = matrix.length;
		int my = matrix[0].length;

		int l = 0;
		int r = mx * my;

		while (l < r) {
			
			int m = l + (r - l) / 2;

			int x = m / my;
			int y = m % my;

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