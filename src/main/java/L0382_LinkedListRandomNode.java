import java.util.Random;

/**
 * https://leetcode.cn/problems/linked-list-random-node/
 * 
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点被选中的概率一样。
 * 
 * 实现 Solution 类：
 * - Solution(ListNode head) 使用整数数组初始化对象。
 * - int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 * 
 * 示例：
 * 输入
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出
 * [null, 1, 3, 2, 2, 3]
 * 
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // 返回 1
 * solution.getRandom(); // 返回 3
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 3
 * // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
 * 
 * 提示：
 * - 链表中的节点数在范围 [1, 10⁴] 内
 * - -10⁴ <= Node.val <= 10⁴
 * - 至多调用 getRandom 方法 10⁴ 次
 * 
 * 进阶：
 * - 如果链表非常大且长度未知，该怎么处理？
 * - 你能否在不使用额外空间的情况下解决此问题？
 */
public class L0382_LinkedListRandomNode {
    private ListNode head;
    private Random rand;
    
    public L0382_LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    /**
     * 使用蓄水池抽样算法
     * 1. 遍历链表时，对于第 i 个节点，以 1/i 的概率选择它替换当前的结果
     * 2. 这样可以保证每个节点被选中的概率相等，都是 1/n
     */
    public int getRandom() {
        int result = head.val;
        ListNode current = head.next;
        int i = 2;
        
        while (current != null) {
            // 生成一个 [0, i) 范围内的随机数
            // 如果这个随机数是 0，则选择当前节点
            if (rand.nextInt(i) == 0) {
                result = current.val;
            }
            current = current.next;
            i++;
        }
        
        return result;
    }
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 创建测试用的链表：1->2->3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        
        L0382_LinkedListRandomNode solution = new L0382_LinkedListRandomNode(head);
        
        // 测试 getRandom 方法多次，观察随机性
        System.out.println("随机获取 5 次节点值：");
        for (int i = 0; i < 5; i++) {
            System.out.println(solution.getRandom());
        }
    }
} 