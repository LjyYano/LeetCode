
// https://leetcode-cn.com/problems/number-of-islands/
public class L0200_Number_of_Islands {
    
    public void clearRestOfLand(int x, int y, char[][] grid) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0'){
            return;
        }
        
        grid[x][y] = '0';
        clearRestOfLand(x - 1, y, grid);
        clearRestOfLand(x + 1, y, grid);
        clearRestOfLand(x, y - 1, grid);
        clearRestOfLand(x, y + 1, grid);
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(i, j, grid);
                }
            }
        }
        return count;
    }
}