package LeetCode;

public class L200_Number_of_Islands {

	int mx, my;

	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		mx = grid.length;
		my = grid[0].length;

		int rt = 0;

		for (int x = 0; x < mx; x++) {
			for (int y = 0; y < my; y++) {
				if (grid[x][y] != '1') {
					continue;
				}
				rt++;
				dfs(grid, x, y);
			}
		}

		return rt;
	}

	void dfs(char[][] grid, int x, int y) {

		if (x < 0 || x >= mx || y < 0 || y >= my) {
			return;
		}

		if (grid[x][y] == '1') {

			grid[x][y] = '2';

			dfs(grid, x + 1, y);
			dfs(grid, x - 1, y);
			dfs(grid, x, y + 1);
			dfs(grid, x, y - 1);
		}
	}

}
