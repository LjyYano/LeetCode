import java.util.Iterator;

/**
 * https://leetcode.cn/problems/peeking-iterator/
 * 
 * 请你在设计一个迭代器，在集成现有迭代器拥有的 hasNext 和 next 操作的基础上，还额外支持 peek 操作。
 * 
 * 实现 PeekingIterator 类：
 * - PeekingIterator(Iterator<int> nums) 使用指定整数迭代器 nums 初始化迭代器。
 * - int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
 * - boolean hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
 * - int peek() 返回数组中的下一个元素，但 不 移动指针。
 * 
 * 示例：
 * 输入：
 * ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出：
 * [null, 1, 2, 2, 3, false]
 * 
 * 解释：
 * PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
 * peekingIterator.next();    // 返回 1，指针移动到下一个元素 [1|2,3]
 * peekingIterator.peek();    // 返回 2，指针不移动 [1|2,3]
 * peekingIterator.next();    // 返回 2，指针移动到下一个元素 [1,2|3]
 * peekingIterator.next();    // 返回 3，指针移动到下一个元素 [1,2,3|]
 * peekingIterator.hasNext(); // 返回 False
 * 
 * 提示：
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= 1000
 * - 对 next 和 peek 的调用均有效
 * - next、hasNext 和 peek 最多调用 1000 次
 */
public class L0284_PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> iterator;
    private Integer nextElement;
    
    public L0284_PeekingIterator(Iterator<Integer> iterator) {
        // 初始化时，将迭代器的第一个元素缓存
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        }
    }
    
    public Integer peek() {
        // 直接返回缓存的下一个元素
        return nextElement;
    }
    
    @Override
    public Integer next() {
        // 保存当前缓存的元素
        Integer result = nextElement;
        // 更新缓存的下一个元素
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return result;
    }
    
    @Override
    public boolean hasNext() {
        // 如果缓存的下一个元素不为空，说明还有元素
        return nextElement != null;
    }

    public static void main(String[] args) {
        // 创建一个包含 [1, 2, 3] 的迭代器
        Iterator<Integer> it = java.util.Arrays.asList(1, 2, 3).iterator();
        L0284_PeekingIterator peekingIterator = new L0284_PeekingIterator(it);
        
        // 测试用例
        System.out.println(peekingIterator.next());     // 返回 1
        System.out.println(peekingIterator.peek());     // 返回 2
        System.out.println(peekingIterator.next());     // 返回 2
        System.out.println(peekingIterator.next());     // 返回 3
        System.out.println(peekingIterator.hasNext());  // 返回 false
    }
} 