import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/grid-illumination/
class L1001_Grid_Illumination {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int v : A) {
            if (set.contains(v)) {
                return v;
            }
            set.add(v);
        }
        return 0;
    }
}