
// https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
class L0084_Largest_Rectangle_in_Histogram {
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