import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class L0207_Course_Schedule {

	// BFS
	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		// �������
		if (prerequisites == null) {
			return false;
		}

		int len = prerequisites.length;
		if (numCourses <= 0 || len == 0) {
			return true;
		}

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

		return numNoPre == numCourses;
	}

	// DFS
	public static boolean canFinish2(int numCourses, int[][] prerequisites) {

		// �������
		if (prerequisites == null) {
			return false;
		}

		int len = prerequisites.length;
		if (numCourses <= 0 || len == 0) {
			return true;
		}

		int[] visit = new int[numCourses];

		// key��course��value���Ը�courseΪprerequisites��course
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		// ��ʼ��map
		for (int[] p : prerequisites) {
			if (map.containsKey(p[1])) {
				map.get(p[1]).add(p[0]);
			} else {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(p[0]);
				map.put(p[1], l);
			}
		}

		// dfs
		for (int i = 0; i < numCourses; i++) {
			if (!canFinishDFS(map, visit, i)) {
				return false;
			}
		}

		return true;
	}

	private static boolean canFinishDFS(
			HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i) {

		if (visit[i] == -1) {
			return false;
		}

		if (visit[i] == 1) {
			return true;
		}

		visit[i] = -1;

		// course i��ĳЩcourse��prerequisites
		if (map.containsKey(i)) {
			for (int j : map.get(i)) {
				if (!canFinishDFS(map, visit, j)) {
					return false;
				}
			}
		}

		visit[i] = 1;

		return true;
	}

}
