package LeetCode;

import java.util.LinkedList;

public class L210_Course_Schedule_II {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		// 参数检查
		if (prerequisites == null) {
			throw new IllegalArgumentException();
		}

		int len = prerequisites.length;
		if (len == 0) {
			int[] seq = new int[numCourses];
			for (int i = 0; i < seq.length; i++) {
				seq[i] = i;
			}
			return seq;
		}

		int[] seq = new int[numCourses];
		int c = 0;

		// 记录每个course的prerequisites的数量
		int[] pCounter = new int[numCourses];
		for (int i = 0; i < len; i++) {
			pCounter[prerequisites[i][0]]++;
		}

		// 用队列记录可以直接访问的course
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (pCounter[i] == 0) {
				queue.add(i);
			}
		}

		// 取出队列的course，判断
		int numNoPre = queue.size();
		while (!queue.isEmpty()) {
			int top = queue.remove();
			// 保存结果 +_+
			seq[c++] = top;
			for (int i = 0; i < len; i++) {
				// 该course是某个course的prerequisites
				if (prerequisites[i][1] == top) {
					pCounter[prerequisites[i][0]]--;
					if (pCounter[prerequisites[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}

		if (numNoPre != numCourses) {
			return new int[] {};
		}

		return seq;
	}

}
