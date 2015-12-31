package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class L217_Contains_Duplicate {

	public boolean containsDuplicate(int[] nums) {

		Set<Integer> s = new HashSet<Integer>();

		for (int n : nums) {
			if (s.contains(n)) {
				return true;
			}
			s.add(n);
		}

		return false;
	}

}
