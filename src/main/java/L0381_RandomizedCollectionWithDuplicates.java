import java.util.*;

/**
 * https://leetcode.cn/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * 
 * RandomizedCollection 是一个包含数字集合(可能包含重复项)的数据结构。它应该支持插入和删除特定元素，以及删除随机元素。
 * 
 * 实现 RandomizedCollection 类:
 * - RandomizedCollection() 初始化空的 RandomizedCollection 对象
 * - bool insert(int val) 将一个 val 项插入到集合中，即使该项已存在。如果该项不存在，则返回 true ，否则返回 false 。
 * - bool remove(int val) 从集合中删除一个 val 项，如果该项存在，则返回 true，否则返回 false。如果该项有多个，则删除其中任意一个。
 * - int getRandom() 从当前的多个元素集合中返回一个随机元素。每个元素被返回的概率与集合中包含该元素的数量呈线性相关。
 * 
 * 你必须实现类的所有函数，并满足每个函数的平均时间复杂度为 O(1) 。
 */
public class L0381_RandomizedCollectionWithDuplicates {
    // 使用 ArrayList 存储所有元素(包括重复的)
    private List<Integer> nums;
    // 使用 HashMap 存储每个值对应的所有索引
    private Map<Integer, Set<Integer>> indices;
    private Random rand;
    
    public L0381_RandomizedCollectionWithDuplicates() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        // 获取或创建该值的索引集合
        indices.putIfAbsent(val, new HashSet<>());
        indices.get(val).add(nums.size());
        nums.add(val);
        // 如果这是该值的第一个实例，返回 true
        return indices.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if (!indices.containsKey(val) || indices.get(val).isEmpty()) {
            return false;
        }
        
        // 获取要删除元素的一个索引
        int index = indices.get(val).iterator().next();
        // 获取最后一个元素
        int lastNum = nums.get(nums.size() - 1);
        
        // 将最后一个元素移动到要删除的位置
        nums.set(index, lastNum);
        
        // 更新索引
        indices.get(val).remove(index);
        if (indices.get(val).isEmpty()) {
            indices.remove(val);
        }
        
        // 如果被删除的不是最后一个元素，需要更新最后一个元素的索引
        if (index != nums.size() - 1) {
            indices.get(lastNum).remove(nums.size() - 1);
            indices.get(lastNum).add(index);
        }
        
        // 删除最后一个元素
        nums.remove(nums.size() - 1);
        
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        L0381_RandomizedCollectionWithDuplicates collection = new L0381_RandomizedCollectionWithDuplicates();
        
        // 测试用例
        System.out.println(collection.insert(1));   // 返回 true，因为集合不包含 1
        System.out.println(collection.insert(1));   // 返回 false，因为集合已经包含 1
        System.out.println(collection.insert(2));   // 返回 true，因为集合不包含 2
        System.out.println(collection.getRandom()); // 随机返回 1 或 2，每个元素被返回的概率与其在集合中的数量成正比
        System.out.println(collection.remove(1));   // 返回 true，因为集合包含 1
        System.out.println(collection.getRandom()); // 返回 1 或 2，每个元素被返回的概率与其在集合中的数量成正比
    }
} 