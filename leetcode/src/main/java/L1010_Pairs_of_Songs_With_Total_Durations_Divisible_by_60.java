import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
class L1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        int px;
        for (int i = 0; (px = (int) Math.pow(x, i)) < bound; i++) {
            int py;
            for (int j = 0; (py = (int) Math.pow(y, j)) + px <= bound; j++) {
                set.add(px + py);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }
}