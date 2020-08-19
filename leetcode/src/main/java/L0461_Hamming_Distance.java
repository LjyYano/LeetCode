
// https://leetcode-cn.com/problems/hamming-distance/
class L0461_Hamming_Distance {
    public int hammingDistance(int x, int y) {

        int val = x ^ y;
        int result = 0;
        while (val != 0) {
			if ((val & 1) == 1) {
				result++;
			}
			val >>= 1;
		}
        return result;
    
    
    }
}