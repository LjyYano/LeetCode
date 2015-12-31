package LeetCode;

public class L079_Word_Search {

	public boolean exist(char[][] board, String word) {

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

				// 以row,col为开始，能够遍历得到结果
				if (dfs(board, rows, cols, row, col, word, pathLength, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean dfs(char[][] board, int rows, int cols, int row, int col,
			String word, int pathLength, boolean[] visited) {

		// 如果pathLength的长度已经是查找字串的长度，则已经找到
		if (pathLength == word.length()) {
			return true;
		}

		boolean hasPath = false;

		// 符合条件的情况下：
		// 1. 行、列均在矩阵范围内
		// 2. board[row][col]是所要找的字符
		// 3. board[row][col]没有遍历过
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

			// 若board[row][col]的前后左右没有满足条件的字符，则回退
			if (!hasPath) {
				pathLength--;
				visited[row * cols + col] = false;
			}
		}

		return hasPath;
	}
}
