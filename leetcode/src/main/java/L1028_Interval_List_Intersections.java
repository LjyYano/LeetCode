import java.util.Arrays;

// https://leetcode-cn.com/problems/interval-list-intersections/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class L1028_Interval_List_Intersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int a = 0, b = 0;
        Interval[] ans = new Interval[A.length + B.length];
        int p = 0;

        while (a < A.length && b < B.length) {
            int l = Math.max(A[a].start, B[b].start);
            int r = Math.min(A[a].end, B[b].end);
            if (l <= r) {
                ans[p++] = new Interval(l, r);
            }

            if (A[a].end < B[b].end) {
                a++;
            } else {
                b++;
            }
        }

        return Arrays.copyOf(ans, p);
    }
}