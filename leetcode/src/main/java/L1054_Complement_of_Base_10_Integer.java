
// https://leetcode-cn.com/problems/complement-of-base-10-integer/
class L1054_Complement_of_Base_10_Integer {
    public int bitwiseComplement(int N) {
        StringBuilder ans = new StringBuilder();
        for (Character c : Integer.toBinaryString(N).toCharArray()) {
            if (c == '0') {
                ans.append("1");
            } else {
                ans.append("0");
            }
        }

        return Integer.parseInt(ans.toString(), 2);
    }
}