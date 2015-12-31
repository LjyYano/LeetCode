package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class L187_Repeated_DNA_Sequences {

	public List<String> findRepeatedDnaSequences(String s) {

		if (s == null || s.length() < 11) {
			return new ArrayList<String>();
		}

		int hash = 0;

		Set<Integer> appear = new HashSet<Integer>();
		Set<String> set = new HashSet<String>();

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			hash = (hash << 2) + map.get(c);
			hash &= (1 << 20) - 1;

			if (i >= 9) {
				if (appear.contains(hash)) {
					set.add(s.substring(i - 9, i + 1));
				} else {
					appear.add(hash);
				}
			}
		}

		return new ArrayList<String>(set);
	}

}
