import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/partition-array-for-maximum-sum/
class L1043_Partition_Array_for_Maximum_Sum {
public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        Map<Integer, Integer> diag = new HashMap<>(); // y = x + b => b = y - x
        Map<Integer, Integer> adiag = new HashMap<>(); // y = -x + b => b = y + x
        Set<Integer> ls = new HashSet<>(); // lamps by unique ids

        for(int [] l: lamps) {
            int x = l[0];
            int y = l[1];

            rows.put(x, rows.getOrDefault(x, 0) + 1);
            cols.put(y, cols.getOrDefault(y, 0) + 1);
            diag.put(y - x, diag.getOrDefault(y - x, 0) + 1);
            adiag.put(y + x, adiag.getOrDefault(y + x, 0) + 1);
            ls.add(x * N + y);
        }

        int result [] = new int[queries.length];
        int q = 0;
        for(int[] query: queries) {
            int x = query[0];
            int y = query[1];
            result[q++] = rows.containsKey(x) || cols.containsKey(y) || diag.containsKey(y - x) || adiag.containsKey(y + x) ? 1 : 0;

            for(int i = Math.max(0, x - 1); i < Math.min(N, x + 2); i++) {
                for(int j = Math.max(0, y - 1); j < Math.min(N, y + 2); j++) {
                    if(ls.contains(i * N + j)) {
                        ls.remove(i * N + j);
                        rows.compute(i, (k, v) -> v == null || v == 1 ? null : v - 1);
                        cols.compute(j, (k, v) -> v == null || v == 1 ? null : v - 1);
                        diag.compute(j - i, (k, v) -> v == null || v == 1 ? null : v - 1);
                        adiag.compute(j + i, (k, v) ->v == null ||  v == 1 ? null : v - 1);
                    }
                }
            }
        }
        return result;
    }
}