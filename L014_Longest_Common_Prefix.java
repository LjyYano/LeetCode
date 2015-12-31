package LeetCode;

public class L014_Longest_Common_Prefix {

	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		String string = strs[0];

		for (int i = 0; i < string.length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (!(i < strs[j].length() && string.charAt(i) == strs[j]
						.charAt(i))) {
					return string.substring(0, i);
				}
			}
		}

		return string;
	}

}
