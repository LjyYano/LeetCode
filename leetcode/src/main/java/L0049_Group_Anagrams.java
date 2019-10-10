import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L0049_Group_Anagrams {

	public List<List<String>> groupAnagrams(String[] strs) {

		if (strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}

		List<List<String>> rt = new ArrayList<List<String>>();

		Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

		// �ѵ��ʷ���
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String k = Arrays.toString(c);
			ArrayList<Integer> list = new ArrayList<Integer>();
			if (map.containsKey(k)) {
				list = map.get(k);
			}
			list.add(i);
			map.put(k, list);
		}

		for (String s : map.keySet()) {

			List<Integer> l = map.get(s);
			List<String> group = new ArrayList<String>();

			// ����ͬ��ĸ�ĵ��ʷ���ͬһ��list
			for (Integer i : l) {
				group.add(strs[i]);
			}

			// ���ֵ�������
			group.sort(new Comparator<String>() {
				public int compare(String x, String y) {
					return x.compareTo(y);
				}
			});

			rt.add(group);
		}

		return rt;
	}
}
