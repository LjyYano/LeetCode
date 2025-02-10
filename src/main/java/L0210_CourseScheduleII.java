import java.util.*;

/**
 * https://leetcode.cn/problems/course-schedule-ii/
 * 
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * 
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * 
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 
 * 示例 2：
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 
 * 示例 3：
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * 
 * 提示：
 * - 1 <= numCourses <= 2000
 * - 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * - prerequisites[i].length == 2
 * - 0 <= ai, bi < numCourses
 * - ai != bi
 * - 所有[ai, bi] 互不相同
 */
public class L0210_CourseScheduleII {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        // 记录课程顺序
        int[] result = new int[numCourses];
        int count = 0;
        
        // BFS 拓扑排序
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[count++] = course;
            
            // 将当前课程的所有后续课程的入度减 1
            for (int nextCourse : adjacency.get(course)) {
                inDegrees[nextCourse]--;
                // 如果入度变为 0，则加入队列
                if (inDegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // 如果无法完成所有课程，返回空数组
        return count == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        L0210_CourseScheduleII solution = new L0210_CourseScheduleII();
        
        // 测试用例 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("测试用例 1：");
        System.out.println("输入：numCourses = " + numCourses1 + ", prerequisites = [[1,0]]");
        System.out.print("输出：");
        int[] result1 = solution.findOrder(numCourses1, prerequisites1);
        System.out.println(Arrays.toString(result1));
        
        // 测试用例 2
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：numCourses = " + numCourses2 + ", prerequisites = [[1,0],[2,0],[3,1],[3,2]]");
        System.out.print("输出：");
        int[] result2 = solution.findOrder(numCourses2, prerequisites2);
        System.out.println(Arrays.toString(result2));
        
        // 测试用例 3
        int numCourses3 = 1;
        int[][] prerequisites3 = {};
        System.out.println("\n测试用例 3：");
        System.out.println("输入：numCourses = " + numCourses3 + ", prerequisites = []");
        System.out.print("输出：");
        int[] result3 = solution.findOrder(numCourses3, prerequisites3);
        System.out.println(Arrays.toString(result3));
    }
} 