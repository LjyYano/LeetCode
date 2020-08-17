public class L1551_Minimum_Operations_to_Make_Array_Equal {
    public int minOperations(int n) {
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int curr = 2 * i + 1;
            ans += Math.abs(n - curr);
        }
        return ans;
    }
}
