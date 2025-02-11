/**
 * https://leetcode.cn/problems/number-of-boomerangs/
 * 
 * 给定平面上 n 对互不相同的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 
 * 返回平面上所有回旋镖的数量。
 * 
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 * 
 * 提示：
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10⁴ <= xi, yi <= 10⁴
 * 所有点都 互不相同
 */
public class L0447_NumberOfBoomerangs {

    // 使用哈希表记录距离
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        // 遍历每个点作为回旋镖的顶点
        for (int i = 0; i < points.length; i++) {
            // 使用哈希表记录到其他点的距离及其出现次数
            java.util.Map<Integer, Integer> distanceMap = new java.util.HashMap<>();
            
            // 计算到其他点的距离
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    // 计算距离的平方（不需要开方，因为只需要比较相等）
                    int distance = getDistance(points[i], points[j]);
                    // 更新距离的出现次数
                    distanceMap.put(distance, distanceMap.getOrDefault(distance, 0) + 1);
                }
            }
            
            // 对于每个距离，如果有 n 个点到当前点的距离相等
            // 那么可以形成 n * (n-1) 个回旋镖（考虑顺序）
            for (int count : distanceMap.values()) {
                result += count * (count - 1);
            }
        }
        
        return result;
    }
    
    // 计算两点间距离的平方
    private int getDistance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        L0447_NumberOfBoomerangs solution = new L0447_NumberOfBoomerangs();

        // 测试用例 1
        int[][] points1 = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println("测试用例 1 结果：" + solution.numberOfBoomerangs(points1)); // 预期输出：2

        // 测试用例 2
        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println("测试用例 2 结果：" + solution.numberOfBoomerangs(points2)); // 预期输出：2

        // 测试用例 3
        int[][] points3 = {{1, 1}};
        System.out.println("测试用例 3 结果：" + solution.numberOfBoomerangs(points3)); // 预期输出：0
    }
} 