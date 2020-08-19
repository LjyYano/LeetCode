
// https://leetcode-cn.com/problems/reverse-bits/
public class L0190_Reverse_Bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
		
		int rt = 0;
		
		for (int i = 0; i < 32; i++) {
			rt |= ((n >> i) & 1) << (31 - i);
		}
		return rt;
	
        
    }
}