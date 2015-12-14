package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class L299_Bulls_and_Cows {

	public String getHint(String secret, String guess) {

		if (secret == null || guess == null
				|| secret.length() != guess.length()) {
			return "";
		}

		char[] s = secret.toCharArray();
		char[] g = guess.toCharArray();

		int A = 0, B = 0, n = s.length;

		// 统计bulls
		for (int i = 0; i < n; i++) {
			if (s[i] == g[i]) {
				s[i] = '#';
				g[i] = '#';
				A++;
			}
		}

		// 统计cows

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < n; i++) {
			if (s[i] != '#') {
				if (!map.containsKey(s[i])) {
					map.put(s[i], 1);
				} else {
					int times = map.get(s[i]);
					times++;
					map.put(s[i], times);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (g[i] != '#') {
				if (map.containsKey(g[i]) && map.get(g[i]) != 0) {
					int times = map.get(g[i]);
					times--;
					map.put(g[i], times);
					B++;
				}
			}
		}

		return A + "A" + B + "B";
	}
}
