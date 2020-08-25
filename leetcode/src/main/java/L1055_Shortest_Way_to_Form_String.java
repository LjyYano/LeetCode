
// https://leetcode-cn.com/problems/shortest-way-to-form-string/
class L1055_Shortest_Way_to_Form_String {
    public int numPairsDivisibleBy60(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}