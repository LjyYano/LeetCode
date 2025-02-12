/**
 * https://leetcode.cn/problems/island-perimeter/
 * 
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 
 * 岛屿中没有"湖"（"湖" 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * 
 * 示例 1：
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是 16，如下图所示的黑色部分。
 * 
 * 示例 2：
 * 输入：grid = [[1]]
 * 输出：4
 * 
 * 示例 3：
 * 输入：grid = [[1,0]]
 * 输出：4
 * 
 * 提示：
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1
 */
public class L0463_IslandPerimeter {
    
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // 遍历每个格子
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果当前格子是陆地
                if (grid[i][j] == 1) {
                    // 初始周长为 4
                    perimeter += 4;
                    
                    // 检查上方格子，如果也是陆地，减去 2（两个相邻边）
                    if (i > 0 && grid[i-1][j] == 1) {
                        perimeter -= 2;
                    }
                    
                    // 检查左方格子，如果也是陆地，减去 2（两个相邻边）
                    if (j > 0 && grid[i][j-1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        
        return perimeter;
    }

    public static void main(String[] args) {
        L0463_IslandPerimeter solution = new L0463_IslandPerimeter();
        
        // 测试用例 1
        int[][] grid1 = {
            {0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}
        };
        System.out.println("测试用例 1 结果：" + solution.islandPerimeter(grid1)); // 预期输出：16
        
        // 测试用例 2
        int[][] grid2 = {{1}};
        System.out.println("测试用例 2 结果：" + solution.islandPerimeter(grid2)); // 预期输出：4
        
        // 测试用例 3
        int[][] grid3 = {{1,0}};
        System.out.println("测试用例 3 结果：" + solution.islandPerimeter(grid3)); // 预期输出：4
    }
} 