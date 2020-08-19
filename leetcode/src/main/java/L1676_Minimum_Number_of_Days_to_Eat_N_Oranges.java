import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges/
class L1676_Minimum_Number_of_Days_to_Eat_N_Oranges {
    private Map<Integer, Integer> map = new HashMap<>();

    public int minDays(int n) {
        if (n < 2) {
            return n;
        }
        if (!map.containsKey(n)) {
            map.put(n, Math.min(minDays(n / 2) + 1 + n % 2, minDays(n / 3) + 1 + n % 3));
        }
        return map.get(n);
    }
}