import java.util.Stack;

/**
 * https://leetcode.cn/problems/min-stack/
 * 
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 实现 MinStack 类:
 * - MinStack() 初始化堆栈对象。
 * - void push(int val) 将元素 val 推入堆栈。
 * - void pop() 删除堆栈顶部的元素。
 * - int top() 获取堆栈顶部的元素。
 * - int getMin() 获取堆栈中的最小元素。
 * 
 * 你必须设计一个时间复杂度为 O(1) 的算法来实现特定的栈。
 */
public class L0155_MinStack {

    // 主栈，用于存储所有元素
    private Stack<Integer> stack;
    // 辅助栈，用于存储最小值
    private Stack<Integer> minStack;

    public L0155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // 如果辅助栈为空，或者新元素小于等于辅助栈顶元素，则将新元素压入辅助栈
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // 如果主栈弹出的元素等于辅助栈顶元素，说明这个元素是当前最小值
        // 需要同时从辅助栈中弹出
        if (!stack.isEmpty() && stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        L0155_MinStack minStack = new L0155_MinStack();
        
        // 测试用例 1
        System.out.println("测试用例 1：");
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin() = " + minStack.getMin()); // 返回 -3
        minStack.pop();
        System.out.println("top() = " + minStack.top());       // 返回 0
        System.out.println("getMin() = " + minStack.getMin()); // 返回 -2
        
        // 测试用例 2
        System.out.println("\n测试用例 2：");
        L0155_MinStack minStack2 = new L0155_MinStack();
        minStack2.push(-1);
        System.out.println("top() = " + minStack2.top());      // 返回 -1
        System.out.println("getMin() = " + minStack2.getMin()); // 返回 -1
        minStack2.push(-2);
        System.out.println("getMin() = " + minStack2.getMin()); // 返回 -2
        minStack2.pop();
        System.out.println("getMin() = " + minStack2.getMin()); // 返回 -1
    }
} 