
// https://leetcode-cn.com/problems/longest-repeating-substring/
class L1062_Longest_Repeating_Substring {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int v : A) {
            sum += v;
        }
        if (sum % 3 != 0 || sum == 0) return false;

        int div = sum / 3;
        int count = 0;
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp += A[i];
            if (tmp == div) {
                count++;
                if (count == 2) {
                    return true;
                }
                tmp = 0;
                continue;
            }
        }

        return false;
    }
}