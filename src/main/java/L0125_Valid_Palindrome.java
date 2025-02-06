
// https://leetcode-cn.com/problems/valid-palindrome/
public class L0125_Valid_Palindrome {


	public static boolean isPalindrome(String s) {

		if (s.length() <= 1) {
			return true;
		}

		char[] chars = s.toLowerCase().toCharArray();

		for (int st = 0, ed = chars.length - 1; st <= ed; st++, ed--) {

			while (st < ed && !isValid(s, st))
				st++;
			while (st < ed && !isValid(s, ed))
				ed--;

			if (chars[st] != chars[ed])
				return false;

		}

		return true;
	}

	static boolean isValid(String s, int i) {

		char c = s.charAt(i);

		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')|| (c >= 'A' && c <= 'Z');

	}
}