package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class L290_Word_Pattern {

	public boolean wordPattern(String pattern, String str) {

		if (pattern == null || str == null) {
			return false;
		}

		String[] strs = str.split(" ");

		if (pattern.length() != strs.length) {
			return false;
		}

		Map<Character, String> map = new HashMap<Character, String>();

		for (int i = 0; i < pattern.length(); i++) {

			char c = pattern.charAt(i);

			if (map.containsKey(c)) {
				if (!map.get(c).equals(strs[i])) {
					return false;
				}
			} else {
				// 保证1对1的映射
				if (map.containsValue(strs[i])) {
					return false;
				}
				map.put(c, strs[i]);
			}
		}

		return true;
	}
}
