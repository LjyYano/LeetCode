package LeetCode;

public class L036_Valid_Sudoku {

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}

		int mx = board.length;
		int my = board[0].length;

		// row
		for (int x = 0; x < mx; x++) {
			boolean[] flag = new boolean[10];
			for (int y = 0; y < my; y++) {

				char c = board[x][y];
				if (c != '.') {
					if (flag[c - '0'] == false) {
						flag[c - '0'] = true;
					} else {
						return false;
					}
				}
			}
		}

		// column
		for (int y = 0; y < my; y++) {
			boolean[] flag = new boolean[10];
			for (int x = 0; x < mx; x++) {

				char c = board[x][y];
				if (c != '.') {
					if (flag[c - '0'] == false) {
						flag[c - '0'] = true;
					} else {
						return false;
					}
				}
			}
		}

		// square
		for (int x = 0; x < mx / 3; x++) {
			for (int y = 0; y < my / 3; y++) {

				boolean[] flag = new boolean[10];

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {

						char c = board[x * 3 + i][y * 3 + j];
						if (c != '.') {
							if (flag[c - '0'] == false) {
								flag[c - '0'] = true;
							} else {
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}

}
