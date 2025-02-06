import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/minimum-window-substring/
class L0076_Minimum_Window_Substring {
	public String minWindow(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int left = 0;
		int minLeft = 0;
		int minLen = Integer.MAX_VALUE;
		int count = 0;
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) >= 0) {
					count++;
				}
				while (count == t.length()) {
					if (right - left + 1 < minLen) {
						minLeft = left;
						minLen = right - left + 1;
					}
					if (map.containsKey(s.charAt(left))) {
						map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
						if (map.get(s.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}
		if (minLen > s.length()) {
			return "";
		}

		return s.substring(minLeft, minLeft + minLen);
	}
}