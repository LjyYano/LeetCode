/**
 * https://leetcode.cn/problems/game-of-life/
 * 
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 
 * 1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 */
public class L0289_GameOfLife {
    
    // 定义八个方向：上、右上、右、右下、下、左下、左、左上
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, 
        {1, 0}, {1, -1}, {0, -1}, {-1, -1}
    };
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // 使用状态机的思想，用不同的数字表示状态的变化
        // 2: 从活细胞变为死细胞
        // 3: 从死细胞变为活细胞
        
        // 遍历每个细胞
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 统计周围活细胞的数量
                int liveNeighbors = countLiveNeighbors(board, i, j);
                
                // 根据规则更新状态
                if (board[i][j] == 1) {
                    // 当前是活细胞
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        // 规则 1 和规则 3：活细胞死亡
                        board[i][j] = 2;
                    }
                } else {
                    // 当前是死细胞
                    if (liveNeighbors == 3) {
                        // 规则 4：死细胞复活
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        // 更新最终状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
    
    // 统计周围活细胞的数量
    private int countLiveNeighbors(int[][] board, int row, int col) {
        int count = 0;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            // 检查边界条件并统计活细胞（1 或 2，因为 2 表示当前轮次从活变死）
            if (newRow >= 0 && newRow < board.length && 
                newCol >= 0 && newCol < board[0].length && 
                (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        L0289_GameOfLife solution = new L0289_GameOfLife();
        
        // 测试用例 1
        int[][] board1 = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        System.out.println("测试用例 1:");
        System.out.println("初始状态:");
        printBoard(board1);
        solution.gameOfLife(board1);
        System.out.println("下一个状态:");
        printBoard(board1);
        
        // 测试用例 2
        int[][] board2 = {
            {1, 1},
            {1, 0}
        };
        System.out.println("\n测试用例 2:");
        System.out.println("初始状态:");
        printBoard(board2);
        solution.gameOfLife(board2);
        System.out.println("下一个状态:");
        printBoard(board2);
    }
    
    // 打印矩阵的辅助方法
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
} 