import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/restore-ip-addresses/
class L0093_Restore_IP_Addresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ans;
		}
		robot(0, 0, "", ans, s);
		return ans;
	}

	private void robot(int pos, int dot, String tmp, List<String> ans, String s) {
		if (pos >= s.length()) {
			return;
		}
		
		if (dot == 3) {
			// 防止都是0的情况，出现0.0.0.0000
			if (isValid(s.substring(pos)) && s.length() - pos <= 3) {
				ans.add(tmp + s.substring(pos));
				return;
			} else {
				return;
			}
		}

		for (int i = 1; i <= 3; i++) {
			if (pos + i <= s.length() && isValid(s.substring(pos, pos + i))) {
				robot(pos + i, dot + 1, tmp + s.substring(pos, pos + i) + ".", ans, s);
			}
		}
	}

	private boolean isValid(String string) {
        if (string.length() > 3) {
			return false;
		}
		int v = Integer.valueOf(string);
        if (string.charAt(0) == '0' && string.length() > 1) {
			return false;
		}
		return v >= 0 && v <= 255;
	}
}