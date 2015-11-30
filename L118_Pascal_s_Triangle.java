package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L118_Pascal_s_Triangle {

	public List<List<Integer>> generate(int numRows) {

		ArrayList<List<Integer>> rt = new ArrayList<List<Integer>>();

		Integer[] pre = null;

		for (int i = 1; i <= numRows; i++) {

			//must be defined as Integer[]
			Integer[] row = new Integer[i];

			row[0] = 1;
			row[i - 1] = 1;

			for (int j = 1; j < i - 1; j++) {
				row[j] = pre[j] + pre[j - 1];
			}

			rt.add(new ArrayList<Integer>(Arrays.asList(row)));
			pre = row;
		}

		return rt;
	}

}
