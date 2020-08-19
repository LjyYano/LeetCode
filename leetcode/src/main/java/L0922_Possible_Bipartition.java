import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/possible-bipartition/
class L0922_Possible_Bipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N + 1];
        List<List<Integer>> adj = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }

        for (int i = 1; i < N + 1; i++) {
            if (color[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int nb : adj.get(cur)) {
                        if (color[nb] == 0) {
                            color[nb] = color[cur] == 1 ? 2 : 1;
                            q.add(nb);
                        } else {
                            if (color[nb] == color[cur]) return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}