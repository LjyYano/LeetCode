import java.util.*;

/**
 * https://leetcode.cn/problems/all-oone-data-structure/
 * 
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
 * 
 * 实现 AllOne 类：
 * - AllOne() 初始化数据结构的对象。
 * - inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
 * - dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
 * - getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * - getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * 
 * 注意：每个函数都应当满足 O(1) 的平均时间复杂度。
 */
public class L0432_AllOne {
    // 双向链表节点类
    private class Node {
        int count;
        Set<String> keys;
        Node prev;
        Node next;
        
        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
            this.prev = null;
            this.next = null;
        }
    }
    
    // 存储每个 key 对应的节点
    private Map<String, Node> keyNodeMap;
    // 双向链表的头尾节点（哨兵节点）
    private Node head;
    private Node tail;
    
    public L0432_AllOne() {
        keyNodeMap = new HashMap<>();
        head = new Node(0);    // 最小值节点
        tail = new Node(0);    // 最大值节点
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        // 如果 key 不存在，插入到第一个节点
        if (!keyNodeMap.containsKey(key)) {
            if (head.next == tail || head.next.count > 1) {
                Node node = new Node(1);
                node.keys.add(key);
                insertAfter(head, node);
                keyNodeMap.put(key, node);
            } else {
                head.next.keys.add(key);
                keyNodeMap.put(key, head.next);
            }
            return;
        }
        
        // key 已存在，将其移动到下一个计数的节点
        Node currNode = keyNodeMap.get(key);
        Node nextNode = currNode.next;
        
        if (nextNode == tail || nextNode.count > currNode.count + 1) {
            // 需要创建新节点
            Node newNode = new Node(currNode.count + 1);
            newNode.keys.add(key);
            insertAfter(currNode, newNode);
            keyNodeMap.put(key, newNode);
        } else {
            // 直接使用下一个节点
            nextNode.keys.add(key);
            keyNodeMap.put(key, nextNode);
        }
        
        // 从原节点移除
        currNode.keys.remove(key);
        if (currNode.keys.isEmpty()) {
            removeNode(currNode);
        }
    }
    
    public void dec(String key) {
        Node currNode = keyNodeMap.get(key);
        
        // 如果当前计数为 1，直接删除
        if (currNode.count == 1) {
            currNode.keys.remove(key);
            keyNodeMap.remove(key);
            if (currNode.keys.isEmpty()) {
                removeNode(currNode);
            }
            return;
        }
        
        // 将 key 移动到前一个计数的节点
        Node prevNode = currNode.prev;
        if (prevNode == head || prevNode.count < currNode.count - 1) {
            // 需要创建新节点
            Node newNode = new Node(currNode.count - 1);
            newNode.keys.add(key);
            insertAfter(prevNode, newNode);
            keyNodeMap.put(key, newNode);
        } else {
            // 直接使用前一个节点
            prevNode.keys.add(key);
            keyNodeMap.put(key, prevNode);
        }
        
        // 从原节点移除
        currNode.keys.remove(key);
        if (currNode.keys.isEmpty()) {
            removeNode(currNode);
        }
    }
    
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
    
    // 在 node 后插入新节点
    private void insertAfter(Node node, Node newNode) {
        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
    }
    
    // 删除节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        L0432_AllOne allOne = new L0432_AllOne();
        
        // 测试用例 1
        System.out.println("测试用例 1:");
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println("最大 key: " + allOne.getMaxKey());  // 应该输出 "hello"
        System.out.println("最小 key: " + allOne.getMinKey());  // 应该输出 "hello"
        allOne.inc("leet");
        System.out.println("最大 key: " + allOne.getMaxKey());  // 应该输出 "hello"
        System.out.println("最小 key: " + allOne.getMinKey());  // 应该输出 "leet"
        
        // 测试用例 2
        System.out.println("\n测试用例 2:");
        L0432_AllOne allOne2 = new L0432_AllOne();
        allOne2.inc("a");
        allOne2.inc("b");
        allOne2.inc("b");
        allOne2.inc("c");
        allOne2.inc("c");
        allOne2.inc("c");
        allOne2.dec("b");
        allOne2.dec("b");
        System.out.println("最大 key: " + allOne2.getMaxKey());  // 应该输出 "c"
        System.out.println("最小 key: " + allOne2.getMinKey());  // 应该输出 "a"
    }
} 