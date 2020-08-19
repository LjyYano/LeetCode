import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/group-anagrams/
class L0049_Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			// sort by letter
			char[] array = s.toCharArray();
			Arrays.sort(array);
			String sortString = String.valueOf(array);
			if (map.containsKey(sortString)) {
				map.get(sortString).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(sortString, list);
			}
		}
		return new ArrayList<>(map.values());
	}
}