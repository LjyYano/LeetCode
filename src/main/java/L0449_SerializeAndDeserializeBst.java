import common.TreeNode;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 * 
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 
 * 设计一个算法来序列化和反序列化 二叉搜索树 。对序列化/反序列化算法的工作方式没有限制。您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 
 * 编码的字符串应尽可能紧凑。
 * 
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 
 * 提示：
 * 树中节点数范围是 [0, 10⁴]
 * 0 <= Node.val <= 10⁴
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 */
public class L0449_SerializeAndDeserializeBst {

    // 序列化二叉搜索树
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        // 使用前序遍历序列化
        serializeHelper(root, sb);
        // 删除最后一个逗号
        return sb.substring(0, sb.length() - 1);
    }
    
    // 前序遍历辅助方法
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        // 前序遍历：根-左-右
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // 反序列化二叉搜索树
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        
        // 将字符串转换为整数数组
        String[] values = data.split(",");
        int[] nums = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }
        
        // 使用数组重建二叉搜索树
        return deserializeHelper(nums, 0, nums.length - 1);
    }
    
    // 重建二叉搜索树的辅助方法
    private TreeNode deserializeHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        // 创建根节点
        TreeNode root = new TreeNode(nums[start]);
        
        // 找到第一个大于根节点的值的位置，这就是右子树的起始位置
        int rightStart = start + 1;
        while (rightStart <= end && nums[rightStart] <= nums[start]) {
            rightStart++;
        }
        
        // 递归构建左右子树
        root.left = deserializeHelper(nums, start + 1, rightStart - 1);
        root.right = deserializeHelper(nums, rightStart, end);
        
        return root;
    }

    public static void main(String[] args) {
        L0449_SerializeAndDeserializeBst solution = new L0449_SerializeAndDeserializeBst();

        // 测试用例 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        
        String serialized1 = solution.serialize(root1);
        System.out.println("测试用例 1 序列化结果：" + serialized1);
        TreeNode deserialized1 = solution.deserialize(serialized1);
        System.out.println("测试用例 1 反序列化结果：" + solution.serialize(deserialized1));
        
        // 测试用例 2
        TreeNode root2 = null;
        String serialized2 = solution.serialize(root2);
        System.out.println("测试用例 2 序列化结果：" + serialized2);
        TreeNode deserialized2 = solution.deserialize(serialized2);
        System.out.println("测试用例 2 反序列化结果：" + solution.serialize(deserialized2));
    }
} 