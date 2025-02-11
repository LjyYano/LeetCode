import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-genetic-mutation/description/
 * 
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。
 * 如果无法完成此基因变化，返回 -1 。
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * 
 * 示例 1：
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 
 * 示例 2：
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAAAACC", "CCCCCCCC", "AACANCC", "AACCCCCC"]
 * 输出：3
 */
public class L0433_MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        // 将基因库转换为 Set，方便查找
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        // 如果目标基因不在基因库中，无法完成变化
        if (!bankSet.contains(end)) {
            return -1;
        }
        
        // 可能的基因字符
        char[] genes = {'A', 'C', 'G', 'T'};
        
        // 使用队列进行广度优先搜索
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        
        // 记录已访问的基因序列
        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        // 记录变化次数
        int steps = 0;
        
        // 广度优先搜索
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // 处理当前层的所有基因序列
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                // 如果找到目标基因序列，返回变化次数
                if (curr.equals(end)) {
                    return steps;
                }
                
                // 尝试改变当前基因序列的每一个位置
                char[] currArray = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char original = currArray[j];
                    
                    // 尝试替换为每个可能的基因字符
                    for (char gene : genes) {
                        currArray[j] = gene;
                        String next = new String(currArray);
                        
                        // 如果新的基因序列在基因库中且未访问过
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    
                    // 恢复原始字符
                    currArray[j] = original;
                }
            }
            
            steps++;
        }
        
        // 无法完成变化
        return -1;
    }

    public static void main(String[] args) {
        L0433_MinimumGeneticMutation solution = new L0433_MinimumGeneticMutation();
        
        // 测试用例1
        String start1 = "AACCGGTT";
        String end1 = "AACCGGTA";
        String[] bank1 = {"AACCGGTA"};
        System.out.println("测试用例1：");
        System.out.println("输入：start = \"" + start1 + "\", end = \"" + end1 + "\", bank = " + Arrays.toString(bank1));
        System.out.println("输出：" + solution.minMutation(start1, end1, bank1));
        
        // 测试用例2
        String start2 = "AAAAACCC";
        String end2 = "AACCCCCC";
        String[] bank2 = {"AAAAAACC", "CCCCCCCC", "AACANCC", "AACCCCCC"};
        System.out.println("\n测试用例2：");
        System.out.println("输入：start = \"" + start2 + "\", end = \"" + end2 + "\", bank = " + Arrays.toString(bank2));
        System.out.println("输出：" + solution.minMutation(start2, end2, bank2));
    }
} 