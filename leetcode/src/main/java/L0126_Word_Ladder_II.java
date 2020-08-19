import java.util.HashMap;
import java.util.Map;
import common.Node;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/word-ladder-ii/
class L0126_Word_Ladder_II {
	public static class Node {
		public String word;
		public List<Node> next;

		public Node(String word) {
			this.word = word;
			next = new ArrayList<>();
		}
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// value：从begin到达该key的最短长度。
		Map<String, Node> map = new HashMap<>();
		Set<String> notVisitSet = new HashSet<>(wordList);
		List<List<String>> ans = new ArrayList<>();
		if (!notVisitSet.contains(endWord)) {
			return ans;
		}
		notVisitSet.remove(beginWord);

		// 构建map
		map.put(beginWord, new Node(beginWord));
		bfs(beginWord, endWord, map, notVisitSet);

		if (map.isEmpty()) {
			return ans;
		}

		Map<String, Set<List<String>>> hashMap = new HashMap<String, Set<List<String>>>();
		dfs(map.get(beginWord), endWord, hashMap);

		if (hashMap.get(beginWord) != null) {
			Set<List<String>> set = hashMap.get(beginWord);
			for (List<String> list : set) {
				Collections.reverse(list);
				ans.add(list);
			}
		}
		
		return ans;
	}

	private void dfs(Node node, String endWord, Map<String, Set<List<String>>> map) {
		if (map.containsKey(node.word)) {
			return;
		}
		
		if (node.next.isEmpty() && node.word.equals(endWord)) {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(endWord);
			Set<List<String>> aa= new HashSet<>();
			aa.add(arrayList);
			map.put(endWord, aa);
			return;
		}
		
		Set<List<String>> nodeAnsSet = new HashSet<>();
		for (Node child : node.next) {
			dfs(child, endWord, map);
			if (map.get(child.word) == null) {
				continue;
			}
			Set<List<String>> childSet = map.get(child.word);
			for (List<String> tmp : childSet) {
				ArrayList<String> arrayList = new ArrayList<>(tmp);
				arrayList.add(node.word);
				nodeAnsSet.add(arrayList);
			}
		}
		
		if (!nodeAnsSet.isEmpty()) {
			map.put(node.word, nodeAnsSet);
		} else {
			map.put(node.word, null);
		}
		
	}

	private void bfs(String beginWord, String endWord, Map<String, Node> map, Set<String> notVisitSet) {
		LinkedList<String> queue = new LinkedList<>();
		// 在队列中放入初始元素
		queue.offer(beginWord);
		boolean find = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			Set<String> removeSet = new HashSet<>();
			while (size > 0) {
				String currString = queue.poll();
				Node currNode = map.get(currString);
				Iterator<String> iterator = notVisitSet.iterator();

				while (iterator.hasNext()) {
					String next = iterator.next();
					int diff = diff(currString, next);
					if (diff == 1) {
						// 若在某一步找到，则当前步数结束即可
						if (next.equals(endWord)) {
							find = true;
						} else {
							removeSet.add(next);
						}
						queue.offer(next);
						Node child = map.containsKey(next) ? map.get(next) : new Node(next);
						currNode.next.add(child);
						map.put(next, child);
					}
				}
				size--;
			}
			if (find) {
				break;
			}
			notVisitSet.removeAll(removeSet);
		}
	}

	private int diff(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return 0;
		}
		int diff = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
			}
			if (diff >= 2) {
				return 2;
			}
		}
		return diff;
	}
}