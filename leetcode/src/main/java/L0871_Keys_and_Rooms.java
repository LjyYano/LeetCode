import java.util.List;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/keys-and-rooms/
class L0871_Keys_and_Rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Set<Integer> alreadySet = new HashSet<>();
        alreadySet.add(0);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> zero = rooms.get(0);
        for (Integer key : zero) {
            queue.add(key);
        }

        while (!queue.isEmpty()) {
            int room = queue.poll();
            alreadySet.add(room);
            visited[room] = true;
            List<Integer> keys = rooms.get(room);
            for (int key : keys) {
                if (!alreadySet.contains(key)) {
                    queue.add(key);
                }
            }
        }

        // 判断是否所有房间都访问过
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}