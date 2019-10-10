import java.util.ArrayList;
import java.util.List;

public class L0093_Restore_IP_Addresses {

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
	 *            :ָ��
	 * @param pstack
	 *            :stack���±�
	 */
	public void dfs(String s, int p, int pstack) {

		if (pstack == 4) {

			// ���stack����Ϊ4����s���ַ�ȫ������
			// ��stack[0...3]����һ�����
			if (p >= s.length()) {
				String ip = String.join(".", stack);
				rt.add(ip);
			}
			return;
		}

		// ��ȡ1~3���ַ�
		for (int i = 1; i <= 3; i++) {

			// ��������ַ������ȣ�����
			if (p + i > s.length()) {
				return;
			}

			// ��ѡȡ�ĵ�һ���ַ���0����ֹͣѡȡ
			if (i > 1 && s.charAt(p) == '0') {
				continue;
			}

			String number = s.substring(p, p + i);

			// ���number<=255���ݹ�
			if (Integer.parseInt(number) <= 255) {
				stack[pstack] = number;
				dfs(s, p + i, pstack + 1);
			}
		}
	}

}
