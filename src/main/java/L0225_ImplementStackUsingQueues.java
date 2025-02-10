import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * 
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 
 * 实现 MyStack 类：
 * - void push(int x) 将元素 x 压入栈顶。
 * - int pop() 移除并返回栈顶元素。
 * - int top() 返回栈顶元素。
 * - boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 
 * 注意：
 * - 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * - 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 */
public class L0225_ImplementStackUsingQueues {
    
    private Queue<Integer> queue;
    
    public L0225_ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        // 将新元素添加到队列末尾
        queue.offer(x);
        // 将队列中除了新元素之外的所有元素重新排列
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        L0225_ImplementStackUsingQueues myStack = new L0225_ImplementStackUsingQueues();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());   // 返回 2
        System.out.println(myStack.pop());   // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }
} 