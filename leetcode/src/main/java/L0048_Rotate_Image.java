
// https://leetcode-cn.com/problems/rotate-image/
class L0048_Rotate_Image {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix[0] == null || matrix.length != matrix[0].length) return;
        int n = matrix.length;
        // 中轴互换
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                swap(matrix, i, j, n - i - 1, j);
            }
        }
        
        // 正对角线互换
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    private void swap(int[][] matrix, int x0, int y0, int x1, int y1) {
        int tmp = matrix[x0][y0];
        matrix[x0][y0] = matrix[x1][y1];
        matrix[x1][y1] = tmp;
    }
}