/**
 * https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/
 * 
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * 
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 
 * 示例 1:
 * 输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 
 * 示例 2:
 * 输入: preorder = "1,#"
 * 输出: false
 * 
 * 示例 3:
 * 输入: preorder = "9,#,#,1"
 * 输出: false
 * 
 * 提示：
 * 1 <= preorder.length <= 10⁴
 * preorder 由以逗号 "," 分隔的 [0-9] 和 "#" 组成
 */
public class L0331_VerifyPreorderSerializationOfABinaryTree {
    
    /**
     * 使用槽位思想验证前序序列化
     * 时间复杂度：O(n)，其中 n 是字符串的长度
     * 空间复杂度：O(1)
     */
    public boolean isValidSerialization(String preorder) {
        // 初始槽位数为 1（根节点的位置）
        int slots = 1;
        
        // 遍历序列中的每个节点
        int i = 0;
        while (i < preorder.length()) {
            // 如果没有剩余槽位，但序列还未结束，则无效
            if (slots == 0) {
                return false;
            }
            
            // 根据逗号分隔处理每个节点
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                // 遇到空节点，消耗一个槽位
                slots--;
                i++;
            } else {
                // 遇到数字节点，消耗一个槽位，但产生两个新槽位（左右子节点）
                while (i < preorder.length() && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // -1 + 2 = 1（消耗一个，产生两个）
            }
        }
        
        // 序列结束时，槽位数应该正好为 0
        return slots == 0;
    }

    public static void main(String[] args) {
        L0331_VerifyPreorderSerializationOfABinaryTree solution = new L0331_VerifyPreorderSerializationOfABinaryTree();
        
        // 测试用例 1
        System.out.println("测试用例 1：");
        System.out.println("输入：preorder = \"9,3,4,#,#,1,#,#,2,#,6,#,#\"");
        System.out.println("输出：" + solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println("预期输出：true");
        System.out.println();
        
        // 测试用例 2
        System.out.println("测试用例 2：");
        System.out.println("输入：preorder = \"1,#\"");
        System.out.println("输出：" + solution.isValidSerialization("1,#"));
        System.out.println("预期输出：false");
        System.out.println();
        
        // 测试用例 3
        System.out.println("测试用例 3：");
        System.out.println("输入：preorder = \"9,#,#,1\"");
        System.out.println("输出：" + solution.isValidSerialization("9,#,#,1"));
        System.out.println("预期输出：false");
    }
} 