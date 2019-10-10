public class L0059_Spiral_Matrix_II {

	public int[][] generateMatrix(int n) {

		if (n <= 0) {
			return new int[0][0];
		}

		int[][] matrix = new int[n][n];

		int num = 1;

		int startx = 0, endx = n - 1;
		int starty = 0, endy = n - 1;

		while (startx <= endx && starty <= endy) {

			// �ϱߵ��У���������
			for (int y = starty; y <= endy; y++) {
				matrix[startx][y] = num++;
			}

			// �ұߵ��У����ϵ���
			for (int x = startx + 1; x <= endx; x++) {
				matrix[x][endy] = num++;
			}

			// ����л��б����꣬���˳�ѭ��
			if (startx == endx || starty == endy) {
				break;
			}

			// �±ߵ��У���������
			for (int y = endy - 1; y >= starty; y--) {
				matrix[endx][y] = num++;
			}

			// ��ߵ��У����µ���
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
