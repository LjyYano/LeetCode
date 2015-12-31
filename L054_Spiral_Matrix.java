package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L054_Spiral_Matrix {

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> rt = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return rt;
		}

		int startx = 0, endx = matrix.length - 1;
		int starty = 0, endy = matrix[0].length - 1;

		while (startx <= endx && starty <= endy) {

			// 上边的行，从左向右
			for (int y = starty; y <= endy; y++) {
				rt.add(matrix[startx][y]);
			}

			// 右边的列，从上到下
			for (int x = startx + 1; x <= endx; x++) {
				rt.add(matrix[x][endy]);
			}

			// 如果行或列遍历完，则退出循环
			if (startx == endx || starty == endy) {
				break;
			}

			// 下边的行，从右向左
			for (int y = endy - 1; y >= starty; y--) {
				rt.add(matrix[endx][y]);
			}

			// 左边的列，从下到上
			for (int x = endx - 1; x >= startx + 1; x--) {
				rt.add(matrix[x][starty]);
			}

			startx++;
			starty++;
			endx--;
			endy--;
		}

		return rt;
	}

}
