import java.util.*;

/**
 * https://leetcode.cn/problems/trapping-rain-water-ii/description/
 * 
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * 
 * 示例 1:
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为 4。
 * 
 * 示例 2:
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 */
public class L0407_TrappingRainWaterII {

    // 定义方向数组，用于遍历四个相邻位置
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        // 使用优先队列存储边界点，按高度排序
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.height - b.height);
        // 访问标记数组
        boolean[][] visited = new boolean[m][n];
        
        // 将边界点加入队列并标记为已访问
        for (int i = 0; i < m; i++) {
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            queue.offer(new Cell(0, j, heightMap[0][j]));
            queue.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }
        
        int result = 0;
        // 从最小高度开始处理
        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            // 遍历四个相邻位置
            for (int[] dir : DIRECTIONS) {
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];
                
                // 检查边界和访问标记
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    // 如果当前位置高度小于最小边界高度，可以接雨水
                    if (heightMap[newRow][newCol] < curr.height) {
                        result += curr.height - heightMap[newRow][newCol];
                        queue.offer(new Cell(newRow, newCol, curr.height));
                    } else {
                        queue.offer(new Cell(newRow, newCol, heightMap[newRow][newCol]));
                    }
                }
            }
        }
        
        return result;
    }
    
    // 定义单元格类，存储位置和高度信息
    private static class Cell {
        int row, col, height;
        
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        L0407_TrappingRainWaterII solution = new L0407_TrappingRainWaterII();
        
        // 测试用例1
        int[][] heightMap1 = {
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}
        };
        System.out.println("测试用例1结果：" + solution.trapRainWater(heightMap1));
        
        // 测试用例2
        int[][] heightMap2 = {
            {3,3,3,3,3},
            {3,2,2,2,3},
            {3,2,1,2,3},
            {3,2,2,2,3},
            {3,3,3,3,3}
        };
        System.out.println("测试用例2结果：" + solution.trapRainWater(heightMap2));
    }
} 