import java.util.Stack;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * 
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 
 * 实现 MyQueue 类：
 * - void push(int x) 将元素 x 推到队列的末尾
 * - int pop() 从队列的开头移除并返回元素
 * - int peek() 返回队列开头的元素
 * - boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 
 * 说明：
 * - 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * - 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 
 * 示例 1：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * 
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * 
 * 提示：
 * - 1 <= x <= 9
 * - 最多调用 100 次 push、pop、peek 和 empty
 * - 假设所有操作都是有效的（例如，一个空的队列不会调用 pop 或者 peek 操作）
 * 
 * 进阶：
 * - 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 */
public class L0232_ImplementQueueUsingStacks {
    
    private Stack<Integer> stackIn;  // 用于入队操作
    private Stack<Integer> stackOut; // 用于出队操作
    
    public L0232_ImplementQueueUsingStacks() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    /**
     * 将元素 x 推到队列的末尾
     * 直接压入 stackIn 即可
     */
    public void push(int x) {
        stackIn.push(x);
    }
    
    /**
     * 从队列的开头移除并返回元素
     * 如果 stackOut 为空，将 stackIn 中的所有元素倒序压入 stackOut
     */
    public int pop() {
        // 如果 stackOut 为空，将 stackIn 中的元素全部倒序压入 stackOut
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }
    
    /**
     * 返回队列开头的元素
     * 如果 stackOut 为空，将 stackIn 中的所有元素倒序压入 stackOut
     */
    public int peek() {
        // 如果 stackOut 为空，将 stackIn 中的元素全部倒序压入 stackOut
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
    
    /**
     * 如果队列为空，返回 true；否则，返回 false
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public static void main(String[] args) {
        L0232_ImplementQueueUsingStacks myQueue = new L0232_ImplementQueueUsingStacks();
        
        // 测试用例
        myQueue.push(1);
        System.out.println("将 1 入队后，队列为：[1]");
        
        myQueue.push(2);
        System.out.println("将 2 入队后，队列为：[1, 2]");
        
        System.out.println("队首元素为：" + myQueue.peek());  // 返回 1
        
        System.out.println("出队元素为：" + myQueue.pop());   // 返回 1
        
        System.out.println("队列是否为空：" + myQueue.empty()); // 返回 false
    }
} 