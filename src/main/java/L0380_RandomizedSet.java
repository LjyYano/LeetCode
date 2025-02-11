import java.util.*;

/**
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * 
 * 实现 RandomizedSet 类：
 * - RandomizedSet() 初始化 RandomizedSet 对象
 * - bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true；否则，返回 false。
 * - bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true；否则，返回 false。
 * - int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有相同的概率被返回。
 * 
 * 你必须实现类的所有函数，并满足每个函数的平均时间复杂度为 O(1) 。
 */
public class L0380_RandomizedSet {
    // 使用 ArrayList 存储元素，方便随机访问
    private List<Integer> nums;
    // 使用 HashMap 存储每个元素的索引，方便 O(1) 时间删除
    private Map<Integer, Integer> indices;
    private Random rand;
    
    public L0380_RandomizedSet() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        indices.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        
        // 获取要删除元素的索引
        int index = indices.get(val);
        int lastNum = nums.get(nums.size() - 1);
        
        // 将最后一个元素移动到要删除的位置
        nums.set(index, lastNum);
        indices.put(lastNum, index);
        
        // 删除最后一个元素
        nums.remove(nums.size() - 1);
        indices.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        L0380_RandomizedSet randomizedSet = new L0380_RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // 返回 true，因为 1 被成功插入
        System.out.println(randomizedSet.remove(2)); // 返回 false，因为 2 不存在
        System.out.println(randomizedSet.insert(2)); // 返回 true，因为 2 被成功插入
        System.out.println(randomizedSet.getRandom()); // 应该随机返回 1 或 2
        System.out.println(randomizedSet.remove(1)); // 返回 true，因为 1 存在并被删除
        System.out.println(randomizedSet.insert(2)); // 返回 false，因为 2 已经存在
        System.out.println(randomizedSet.getRandom()); // 应该返回 2
    }
} 