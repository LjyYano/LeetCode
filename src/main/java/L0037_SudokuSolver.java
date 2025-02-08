/**
 * https://leetcode.cn/problems/sudoku-solver/
 * 
 * 编写一个程序，通过填充空格来解决数独问题。
 * 
 * 数独的解法需遵循如下规则：
 * 1. 数字 1-9 在每一行只能出现一次。
 * 2. 数字 1-9 在每一列只能出现一次。
 * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class L0037_SudokuSolver {
    
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        // 遍历整个数独
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 找到一个空格
                if (board[i][j] == '.') {
                    // 尝试填入数字1-9
                    for (char num = '1'; num <= '9'; num++) {
                        // 检查当前数字是否可以放在这个位置
                        if (isValid(board, i, j, num)) {
                            // 如果可以，就放入这个数字
                            board[i][j] = num;
                            
                            // 继续解决剩余的数独
                            if (solve(board)) {
                                return true;
                            }
                            
                            // 如果无法解决，就回溯，撤销这个数字
                            board[i][j] = '.';
                        }
                    }
                    // 如果1-9都不能放，说明当前路径不对，返回false
                    return false;
                }
            }
        }
        // 所有格子都已填满，返回true
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        // 检查行
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }
        
        // 检查列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        // 检查3x3方格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        L0037_SudokuSolver solution = new L0037_SudokuSolver();
        
        // 测试用例
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        System.out.println("解数独前：");
        printBoard(board);
        
        solution.solveSudoku(board);
        
        System.out.println("\n解数独后：");
        printBoard(board);
    }
    
    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-----------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
} 