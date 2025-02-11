import java.util.*;

/**
 * https://leetcode.cn/problems/pacific-atlantic-water-flow/description/
 * 
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。"太平洋"处于大陆的左边界和上边界，而"大西洋"处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 * 
 * 示例 1：
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 
 * 示例 2：
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 */
public class L0417_PacificAtlanticWaterFlow {
    
    // 定义四个方向：上、下、左、右
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        // 分别记录可以流向太平洋和大西洋的位置
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // 从太平洋边界开始DFS
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);  // 左边界
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);  // 上边界
        }
        
        // 从大西洋边界开始DFS
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n-1, atlantic, heights[i][n-1]);  // 右边界
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, m-1, j, atlantic, heights[m-1][j]);  // 下边界
        }
        
        // 收集同时可以流向两个海洋的位置
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    /**
     * DFS遍历，从边界向内部搜索可以流向海洋的位置
     * 
     * @param heights 高度矩阵
     * @param row 当前行
     * @param col 当前列
     * @param visited 访问标记数组
     * @param prevHeight 上一个位置的高度
     */
    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        // 如果越界、已访问或当前高度小于上一个位置的高度，则返回
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || 
            visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }
        
        // 标记当前位置已访问
        visited[row][col] = true;
        
        // 向四个方向继续搜索
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(heights, newRow, newCol, visited, heights[row][col]);
        }
    }

    public static void main(String[] args) {
        L0417_PacificAtlanticWaterFlow solution = new L0417_PacificAtlanticWaterFlow();
        
        // 测试用例1
        int[][] heights1 = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        System.out.println("测试用例1：");
        System.out.println("输入：heights = " + Arrays.deepToString(heights1));
        System.out.println("输出：" + solution.pacificAtlantic(heights1));
        
        // 测试用例2
        int[][] heights2 = {
            {2,1},
            {1,2}
        };
        System.out.println("\n测试用例2：");
        System.out.println("输入：heights = " + Arrays.deepToString(heights2));
        System.out.println("输出：" + solution.pacificAtlantic(heights2));
    }
} 