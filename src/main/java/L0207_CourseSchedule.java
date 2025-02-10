import java.util.*;

/**
 * https://leetcode.cn/problems/course-schedule/
 * 
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且在完成课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * 
 * 提示：
 * 1 <= numCourses <= 10⁵
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class L0207_CourseSchedule {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表和入度数组
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] inDegrees = new int[numCourses];
        
        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        
        // 构建邻接表和计算入度
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacency.get(prerequisiteCourse).add(course);
            inDegrees[course]++;
        }
        
        // 将所有入度为 0 的课程加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 记录已学习的课程数量
        int count = 0;
        
        // BFS 拓扑排序
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            
            // 将当前课程的所有后续课程的入度减 1
            for (int nextCourse : adjacency.get(course)) {
                inDegrees[nextCourse]--;
                // 如果入度变为 0，则加入队列
                if (inDegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // 如果所有课程都已学习，则返回 true
        return count == numCourses;
    }

    public static void main(String[] args) {
        L0207_CourseSchedule solution = new L0207_CourseSchedule();
        
        // 测试用例 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("测试用例 1：");
        System.out.println("输入：numCourses = " + numCourses1 + ", prerequisites = [[1,0]]");
        System.out.println("输出：" + solution.canFinish(numCourses1, prerequisites1));
        
        // 测试用例 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：numCourses = " + numCourses2 + ", prerequisites = [[1,0],[0,1]]");
        System.out.println("输出：" + solution.canFinish(numCourses2, prerequisites2));
    }
} 