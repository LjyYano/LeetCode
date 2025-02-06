
// https://leetcode-cn.com/problems/length-of-last-word/
public class L0058_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = 0;
		int i = s.length() - 1;

		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}

		while (i >= 0 && s.charAt(i) != ' ') {
			len++;
			i--;
		}

		return len;
	
        
    }
}