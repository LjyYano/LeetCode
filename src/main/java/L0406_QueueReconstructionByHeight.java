import java.util.*;

/**
 * https://leetcode.cn/problems/queue-reconstruction-by-height/description/
 * 
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面正好有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * 
 * 示例 1：
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 * 
 * 示例 2：
 * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 */
public class L0406_QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        // 按身高降序排序，身高相同时按 k 值升序排序
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        
        // 使用 List 存储结果，方便插入操作
        List<int[]> result = new ArrayList<>();
        // 按照 k 值将每个人插入到对应位置
        for (int[] person : people) {
            result.add(person[1], person);
        }
        
        // 将 List 转换为数组返回
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        L0406_QueueReconstructionByHeight solution = new L0406_QueueReconstructionByHeight();
        
        // 测试用例1
        int[][] people1 = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println("测试用例1：");
        System.out.println("输入：" + Arrays.deepToString(people1));
        System.out.println("输出：" + Arrays.deepToString(solution.reconstructQueue(people1)));
        
        // 测试用例2
        int[][] people2 = {{6,0}, {5,0}, {4,0}, {3,2}, {2,2}, {1,4}};
        System.out.println("\n测试用例2：");
        System.out.println("输入：" + Arrays.deepToString(people2));
        System.out.println("输出：" + Arrays.deepToString(solution.reconstructQueue(people2)));
    }
} 