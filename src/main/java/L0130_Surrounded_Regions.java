import java.util.List;

// https://leetcode-cn.com/problems/surrounded-regions/
class L0130_Surrounded_Regions {
	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if ((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
					bfs(i, j, board);
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '$') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void bfs(int i, int j, char[][] board) {
		int m = board.length, n = board[0].length;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(i * n + j);
		board[i][j] = '$';

		while (!queue.isEmpty()) {
			int index = queue.pop();
			int x = index / n;
			int y = index % n;

			// 广度（上下左右）找 O 点
			if (x > 0 && board[x - 1][y] == 'O') {
				board[x - 1][y] = '$';
				queue.offer((x - 1) * n + y);
			}

			if (y > 0 && board[x][y - 1] == 'O') {
				board[x][y - 1] = '$';
				queue.offer(x * n + y - 1);
			}

			if (x + 1 < m && board[x + 1][y] == 'O') {
				board[x + 1][y] = '$';
				queue.offer((x + 1) * n + y);
			}

			if (y + 1 < n && board[x][y + 1] == 'O') {
				board[x][y + 1] = '$';
				queue.offer(x * n + y + 1);
			}
		}
	}
}