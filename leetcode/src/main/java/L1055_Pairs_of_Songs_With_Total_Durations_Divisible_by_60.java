
// https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
class L1055_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}