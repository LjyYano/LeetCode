import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
class L1001_N_Repeated_Element_in_Size_2N_Array {
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