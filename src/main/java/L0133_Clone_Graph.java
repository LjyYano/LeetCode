import java.util.HashMap;
import java.util.Map;
import common.Node;

// https://leetcode-cn.com/problems/clone-graph/
public class L0133_Clone_Graph {
	public Node cloneGraph(Node node) {
		Map<Integer, Node> map = new HashMap<>();
		return dfs(node, map);
	}

	private Node dfs(Node node, Map<Integer, Node> map) {

		if (node == null) {
			return node;
		}

		if (map.containsKey(node.val)) {
			return map.get(node.val);
		}

		Node newNode = new Node(node.val);
		map.put(newNode.val, newNode);

		for (Node neighbors : node.neighbors) {
			newNode.neighbors.add(dfs(neighbors, map));
		}

		return newNode;
	}
}