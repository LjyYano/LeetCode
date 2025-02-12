import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/lfu-cache/
 * 
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * 
 * 实现 LFUCache 类：
 * - LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * - int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * - void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。
 *   当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。
 *   在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 
 * 为了确定最不经常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最不经常使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。
 * 对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * 
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 
 * 示例：
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * 
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // 返回 1
 *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 是最小的，且最久未使用
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // 返回 4
 *                  // cache=[4,3], cnt(4)=2, cnt(3)=3
 * 
 * 提示：
 * - 0 <= capacity <= 10⁴
 * - 0 <= key <= 10⁵
 * - 0 <= value <= 10⁹
 * - 最多调用 2 * 10⁵ 次 get 和 put 方法
 */
public class L0460_LFUCache {
    // 双向链表节点类
    private class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }
    
    // 双向链表类，用于维护相同频率的节点
    private class DoublyLinkedList {
        Node head;
        Node tail;
        int size;
        
        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        // 在头部添加节点
        void addNode(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        
        // 删除节点
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        // 删除并返回最后一个节点
        Node removeTail() {
            if (size == 0) return null;
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
    }
    
    private int capacity;
    private int minFrequency;
    private Map<Integer, Node> cache;
    private Map<Integer, DoublyLinkedList> frequencyMap;
    
    public L0460_LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            updateNode(node);
        } else {
            if (cache.size() >= capacity) {
                // 删除使用频率最小的元素
                DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);
                Node leastNode = minFreqList.removeTail();
                cache.remove(leastNode.key);
                if (minFreqList.size == 0) {
                    frequencyMap.remove(minFrequency);
                }
            }
            // 添加新节点
            node = new Node(key, value);
            cache.put(key, node);
            DoublyLinkedList list = frequencyMap.computeIfAbsent(1, k -> new DoublyLinkedList());
            list.addNode(node);
            minFrequency = 1;
        }
    }
    
    private void updateNode(Node node) {
        // 从原频率链表中删除
        DoublyLinkedList oldList = frequencyMap.get(node.frequency);
        oldList.removeNode(node);
        if (oldList.size == 0) {
            frequencyMap.remove(node.frequency);
            // 如果当前是最小频率，更新最小频率
            if (node.frequency == minFrequency) {
                minFrequency++;
            }
        }
        
        // 更新节点频率
        node.frequency++;
        
        // 添加到新频率链表
        DoublyLinkedList newList = frequencyMap.computeIfAbsent(node.frequency, k -> new DoublyLinkedList());
        newList.addNode(node);
    }

    public static void main(String[] args) {
        // 测试用例 1
        System.out.println("测试用例 1：");
        L0460_LFUCache lfu = new L0460_LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // 返回 1
                                            // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 是最小的，且最久未使用
                         // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // 返回 -1（未找到）
        System.out.println(lfu.get(3));      // 返回 3
                                            // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
                         // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // 返回 -1（未找到）
        System.out.println(lfu.get(3));      // 返回 3
                                            // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // 返回 4
                                            // cache=[4,3], cnt(4)=2, cnt(3)=3
        
        // 测试用例 2：容量为 0 的缓存
        System.out.println("\n测试用例 2：");
        L0460_LFUCache lfu2 = new L0460_LFUCache(0);
        lfu2.put(0, 0);
        System.out.println(lfu2.get(0));  // 返回 -1
    }
} 