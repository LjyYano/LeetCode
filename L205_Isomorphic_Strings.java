package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L205_Isomorphic_Strings {

	public boolean isIsomorphic(String s, String t) {

		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> set = new HashSet<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			// 保证一对一的映射关系
			if (map.containsKey(c1)) {
				if (map.get(c1) != c2) {
					return false;
				}
			} else {
				if (set.contains(c2)) {
					return false;
				}
				map.put(c1, c2);
				set.add(c2);
			}
		}

		return true;
	}

}
