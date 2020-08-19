
// https://leetcode-cn.com/problems/maximal-rectangle/
class L0085_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] height = new int[m][n];
        
        // height[i][j] 表示第i行j列的1的高度
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    height[i][j] = (i >= 1 ? height[i - 1][j] : 0) + 1;
                }
            }
        }
                
        int area = 0;
        for(int i = 0; i < m; i++) {
            area = Math.max(area, largestRectangleArea(height[i]));
        }
        
        return area; 
    }
    
    public int largestRectangleArea(int[] A) {
		int area = 0;
		for (int i = 0; i < A.length; i++) {
            // 每找到局部峰值，向前遍历数组
            if(i + 1 < A.length && A[i + 1] >= A[i]) continue;
			int min = A[i];
			for (int j = i; j >= 0; j--) {
				min = Math.min(min, A[j]);
				area = Math.max(area, (i + 1 - j) * min);
			}
		}
		return area;
	}
}