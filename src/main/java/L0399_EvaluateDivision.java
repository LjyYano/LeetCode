import java.util.*;

/**
 * https://leetcode.cn/problems/evaluate-division/
 * 
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。
 * 每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * 
 * 示例 1：
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 
 * 示例 2：
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 
 * 示例 3：
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * 
 * 提示：
 * - 1 <= equations.length <= 20
 * - equations[i].length == 2
 * - 1 <= Ai.length, Bi.length <= 5
 * - values.length == equations.length
 * - 0.0 < values[i] <= 20.0
 * - 1 <= queries.length <= 20
 * - queries[i].length == 2
 * - 1 <= Cj.length, Dj.length <= 5
 * - Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 */
public class L0399_EvaluateDivision {
    
    class UnionFind {
        private Map<String, String> parent;  // 存储节点的父节点
        private Map<String, Double> weight;  // 存储节点到父节点的权重（除法结果）
        
        public UnionFind() {
            parent = new HashMap<>();
            weight = new HashMap<>();
        }
        
        // 添加新节点
        public void add(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                weight.put(x, 1.0);
            }
        }
        
        // 查找父节点并进行路径压缩
        public String find(String x) {
            if (!parent.containsKey(x)) {
                return null;
            }
            
            // 路径压缩，更新权重
            if (!x.equals(parent.get(x))) {
                String oldParent = parent.get(x);
                String newParent = find(oldParent);
                parent.put(x, newParent);
                weight.put(x, weight.get(x) * weight.get(oldParent));
            }
            
            return parent.get(x);
        }
        
        // 合并两个节点
        public void union(String x, String y, double value) {
            add(x);
            add(y);
            String rootX = find(x);
            String rootY = find(y);
            
            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY);
                // 更新权重
                weight.put(rootX, value * weight.get(y) / weight.get(x));
            }
        }
        
        // 计算两个节点的除法结果
        public double calculate(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            
            if (rootX == null || rootY == null || !rootX.equals(rootY)) {
                return -1.0;
            }
            
            return weight.get(x) / weight.get(y);
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        
        // 构建并查集
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            uf.union(x, y, values[i]);
        }
        
        // 处理查询
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            results[i] = uf.calculate(x, y);
        }
        
        return results;
    }

    public static void main(String[] args) {
        L0399_EvaluateDivision solution = new L0399_EvaluateDivision();
        
        // 测试用例 1
        List<List<String>> equations1 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );
        
        System.out.println("测试用例 1：");
        System.out.println(Arrays.toString(solution.calcEquation(equations1, values1, queries1)));
        
        // 测试用例 2
        List<List<String>> equations2 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c"),
            Arrays.asList("bc", "cd")
        );
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("c", "b"),
            Arrays.asList("bc", "cd"),
            Arrays.asList("cd", "bc")
        );
        
        System.out.println("\n测试用例 2：");
        System.out.println(Arrays.toString(solution.calcEquation(equations2, values2, queries2)));
    }
} 