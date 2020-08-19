import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/k-closest-points-to-origin/
class L1014_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int K) {
        if (points.length < K) return null;
        int[][] ans = new int[K][2];
        Map<Long, List<Point>> map = new HashMap<>();
        List<Long> sort = new ArrayList<>();
        for (int[] point : points) {
            long d = point[0] * point[0] + point[1] * point[1];
            if (map.containsKey(d)) {
                map.get(d).add(new Point(point));
            } else {
                ArrayList<Point> list = new ArrayList<Point>();
                list.add(new Point(point));
                map.put(d, list);
                sort.add(d);
            }
        }

        Collections.sort(sort);
        int count = 0, i = 0;
        while (count < K) {
            long d = sort.get(i++);
            List<Point> tmp = map.get(d);
            for (int i1 = 0; i1 < tmp.size(); i1++) {
                ans[count++] = new int[]{tmp.get(i1).getX(), tmp.get(i1).getY()};
            }
        }

        return ans;
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int[] p) {
            this.x = p[0];
            this.y = p[1];
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}