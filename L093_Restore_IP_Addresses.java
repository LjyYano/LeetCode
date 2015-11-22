package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L093_Restore_IP_Addresses {

	List<String> result = new ArrayList<String>();
	String[] stack = new String[4];

	public List<String> restoreIpAddresses(String s) {

		if (s == null || s.length() == 0) {
			return new ArrayList<String>();
		}
		dfs(s, 0, 0);
		return result;
	}

	public void dfs(String s, int p, int pstack) {

		if (pstack == 4) {

			if (p >= s.length()) {
				String ip = String.join(".", stack);
				result.add(ip);
			}
			return;
		}

		for (int i = 1; i <= 3; i++) {

			if (p + i > s.length()) {
				return;
			}

			if (i > 1 && s.charAt(p) == '0') {
				continue;
			}

			String number = s.substring(p, p + i);

			if (Integer.parseInt(number) <= 255) {
				stack[pstack] = number;
				dfs(s, p + i, pstack + 1);
			}
		}
	}

}
