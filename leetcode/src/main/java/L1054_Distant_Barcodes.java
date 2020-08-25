
// https://leetcode-cn.com/problems/distant-barcodes/
class L1054_Distant_Barcodes {
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