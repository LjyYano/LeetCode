import java.util.*;

/**
 * https://leetcode.cn/problems/lru-cache/
 * 
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 
 * 实现 LRUCache 类：
 * - LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * - int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * - void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * 
 * 提示：
 * - 1 <= capacity <= 3000
 * - 0 <= key <= 10000
 * - 0 <= value <= 10⁵
 * - 最多调用 2 * 10⁵ 次 get 和 put 操作
 */
public class L0146_LRUCache {
    
    // 双向链表节点类
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node() {}
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // 缓存容量
    private final int capacity;
    // 哈希表，存储 key 到节点的映射
    private final Map<Integer, Node> cache;
    // 双向链表的头尾节点（哨兵节点）
    private final Node head;
    private final Node tail;
    
    public L0146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 将访问的节点移动到链表头部
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            // 如果 key 存在，更新值并移动到头部
            node.value = value;
            moveToHead(node);
        } else {
            // 如果 key 不存在，创建新节点
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            // 如果超出容量，删除尾部节点
            if (cache.size() > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
            }
        }
    }
    
    // 将节点添加到头部
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    // 删除节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // 将节点移动到头部
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    // 删除尾部节点并返回
    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        // 测试用例 1
        System.out.println("测试用例 1:");
        L0146_LRUCache lRUCache = new L0146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
        
        // 测试用例 2：容量为 1 的缓存
        System.out.println("\n测试用例 2:");
        L0146_LRUCache cache2 = new L0146_LRUCache(1);
        cache2.put(1, 1);
        cache2.put(2, 2);
        System.out.println(cache2.get(1)); // 返回 -1
        System.out.println(cache2.get(2)); // 返回 2
        
        // 测试用例 3：重复更新相同的 key
        System.out.println("\n测试用例 3:");
        L0146_LRUCache cache3 = new L0146_LRUCache(2);
        cache3.put(1, 1);
        cache3.put(1, 2);
        System.out.println(cache3.get(1)); // 返回 2
    }
} 