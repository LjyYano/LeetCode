package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L093_Restore_IP_Addresses {

	List<String> rt = new ArrayList<String>();
	String[] stack = new String[4];

	public List<String> restoreIpAddresses(String s) {

		if (s == null || s.length() == 0) {
			return new ArrayList<String>();
		}
		dfs(s, 0, 0);
		return rt;
	}

	/**
	 * 
	 * @param s
	 * @param p
	 *            :指针
	 * @param pstack
	 *            :stack的下标
	 */
	public void dfs(String s, int p, int pstack) {

		if (pstack == 4) {

			// 如果stack长度为4，且s的字符全部用上
			// 则stack[0...3]存了一个结果
			if (p >= s.length()) {
				String ip = String.join(".", stack);
				rt.add(ip);
			}
			return;
		}

		// 获取1~3个字符
		for (int i = 1; i <= 3; i++) {

			// 如果超过字符串长度，返回
			if (p + i > s.length()) {
				return;
			}

			// 若选取的第一个字符是0，则停止选取
			if (i > 1 && s.charAt(p) == '0') {
				continue;
			}

			String number = s.substring(p, p + i);

			// 如果number<=255，递归
			if (Integer.parseInt(number) <= 255) {
				stack[pstack] = number;
				dfs(s, p + i, pstack + 1);
			}
		}
	}

}
