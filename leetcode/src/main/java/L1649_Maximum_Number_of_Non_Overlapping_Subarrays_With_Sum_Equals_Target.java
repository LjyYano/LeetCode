import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
class L1649_Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(sum - target)) {
                ans++;
                set.clear();
                sum = 0;
            }

            set.add(sum);
        }
        return ans;
    }
}