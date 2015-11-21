package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L054_Spiral_Matrix {

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return result;
		}

		int startx = 0, endx = matrix.length - 1;
		int starty = 0, endy = matrix[0].length - 1;

		while (startx <= endx && starty <= endy) {

			for (int y = starty; y <= endy; y++) {
				result.add(matrix[startx][y]);
			}

			for (int x = startx + 1; x <= endx; x++) {
				result.add(matrix[x][endy]);
			}

			if (startx == endx || starty == endy) {
				break;
			}

			for (int y = endy - 1; y >= starty; y--) {
				result.add(matrix[endx][y]);
			}

			for (int x = endx - 1; x >= startx + 1; x--) {
				result.add(matrix[x][starty]);
			}

			startx++;
			starty++;
			endx--;
			endy--;
		}

		return result;
	}

}
