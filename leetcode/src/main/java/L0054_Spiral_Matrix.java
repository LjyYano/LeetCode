import java.util.ArrayList;
import java.util.List;

public class L0054_Spiral_Matrix {

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> rt = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return rt;
		}

		int startx = 0, endx = matrix.length - 1;
		int starty = 0, endy = matrix[0].length - 1;

		while (startx <= endx && starty <= endy) {

			// �ϱߵ��У���������
			for (int y = starty; y <= endy; y++) {
				rt.add(matrix[startx][y]);
			}

			// �ұߵ��У����ϵ���
			for (int x = startx + 1; x <= endx; x++) {
				rt.add(matrix[x][endy]);
			}

			// ����л��б����꣬���˳�ѭ��
			if (startx == endx || starty == endy) {
				break;
			}

			// �±ߵ��У���������
			for (int y = endy - 1; y >= starty; y--) {
				rt.add(matrix[endx][y]);
			}

			// ��ߵ��У����µ���
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
