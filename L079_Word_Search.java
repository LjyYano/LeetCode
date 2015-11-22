package LeetCode;

public class L079_Word_Search {

	public static boolean exist(char[][] board, String word) {

		if (board == null || board[0].length == 0 || board.length == 0
				|| word == null) {
			return false;
		}

		int rows = board.length;
		int cols = board[0].length;
		boolean[] visited = new boolean[rows * cols];

		int pathLength = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {

				if (dfs(board, rows, cols, row, col, word, pathLength, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean dfs(char[][] board, int rows, int cols, int row,
			int col, String word, int pathLength, boolean[] visited) {

		if (pathLength == word.length()) {
			return true;
		}

		boolean hasPath = false;

		if (row >= 0 && row < rows && col >= 0 && col < cols
				&& board[row][col] == word.charAt(pathLength)
				&& !visited[row * cols + col]) {

			pathLength++;
			visited[row * cols + col] = true;

			hasPath = dfs(board, rows, cols, row, col - 1, word, pathLength,
					visited)
					|| dfs(board, rows, cols, row - 1, col, word, pathLength,
							visited)
					|| dfs(board, rows, cols, row, col + 1, word, pathLength,
							visited)
					|| dfs(board, rows, cols, row + 1, col, word, pathLength,
							visited);

			if (!hasPath) {
				pathLength--;
				visited[row * cols + col] = false;
			}
		}

		return hasPath;
	}

}
