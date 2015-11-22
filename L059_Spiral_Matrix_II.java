package LeetCode;

public class L059_Spiral_Matrix_II {

	public static int[][] generateMatrix(int n) {

		if (n <= 0) {
			return new int[0][0];
		}

		int[][] matrix = new int[n][n];

		int num = 1;

		int startx = 0, endx = n - 1;
		int starty = 0, endy = n - 1;

		while (startx <= endx && starty <= endy) {
			for (int y = starty; y <= endy; y++) {
				matrix[startx][y] = num++;
			}

			for (int x = startx + 1; x <= endx; x++) {
				matrix[x][endy] = num++;
			}

			if (startx == endx || starty == endy) {
				break;
			}

			for (int y = endy - 1; y >= starty; y--) {
				matrix[endx][y] = num++;
			}

			for (int x = endx - 1; x >= startx + 1; x--) {
				matrix[x][starty] = num++;
			}

			startx++;
			starty++;
			endx--;
			endy--;
		}

		return matrix;
	}

}
