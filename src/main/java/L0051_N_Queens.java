import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/n-queens/
public class L0051_N_Queens {
    
    public void dfs(char[][] board, int col, List<List<String>> ans) {
        if(col == board.length) {
            ans.add(construct(board));
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col + 1, ans);
                board[i][col] = '.';
            }
        }
    }
    
    public List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<String>();
        for(int i = 0; i < board.length; i++) {
            String rowString = "";
            for(int j = 0; j < board[0].length; j++) {
                rowString +=board[i][j];
            }
            ans.add(rowString);
        }
        return ans;
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        
        return true;
    }
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        dfs(board, 0, ans);
        return ans;
    }
}