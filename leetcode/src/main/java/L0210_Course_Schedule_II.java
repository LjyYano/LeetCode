import java.util.LinkedList;

public class L0210_Course_Schedule_II {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		// �������
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

		// ��¼ÿ��course��prerequisites������
		int[] pCounter = new int[numCourses];
		for (int i = 0; i < len; i++) {
			pCounter[prerequisites[i][0]]++;
		}

		// �ö��м�¼����ֱ�ӷ��ʵ�course
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (pCounter[i] == 0) {
				queue.add(i);
			}
		}

		// ȡ�����е�course���ж�
		int numNoPre = queue.size();
		while (!queue.isEmpty()) {
			int top = queue.remove();
			// ������ +_+
			seq[c++] = top;
			for (int i = 0; i < len; i++) {
				// ��course��ĳ��course��prerequisites
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
