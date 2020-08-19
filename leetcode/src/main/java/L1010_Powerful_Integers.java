import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/powerful-integers/
class L1010_Powerful_Integers {
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