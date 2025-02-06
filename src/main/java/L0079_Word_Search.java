
// https://leetcode-cn.com/problems/word-search/
class L0079_Word_Search {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordSearchDfs(i, j, word, 0, visited, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordSearchDfs(int row, int col, String word, int index, boolean[][] visited, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        boolean hasPath = false;

        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col] && board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            index++;

            hasPath = wordSearchDfs(row + 1, col, word, index, visited, board) ||
                    wordSearchDfs(row - 1, col, word, index, visited, board) ||
                    wordSearchDfs(row, col + 1, word, index, visited, board) ||
                    wordSearchDfs(row, col - 1, word, index, visited, board);

            if (!hasPath) {
                visited[row][col] = false;
                index--;
            }
        }

        return hasPath;
    }

}