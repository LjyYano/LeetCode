package LeetCode;

public class L096_Unique_Binary_Search_Trees {

	public int numTrees(int n) {

		if (n == 1 || n == 2) {
			return n;
		}

		// record[0]没有用，所以长度是n+1
		// 使用数组，从下向上保存结果，能够节省时间，否则会超时
		int[] record = new int[n + 1];

		record[0] = 1;
		record[1] = 1; // 1个元素时，情况为1
		record[2] = 2; // 2个元素时，情况为2

		for (int i = 3; i <= n; i++) {
			int tmp = 0;
			for (int k = 0; k < i; k++) {
				// 以n为根结点的二叉树个数=左结点的二叉树个数*右结点的二叉树个数
				// 题目所求要包括所有情况，分别以1~n为根结点
				tmp += (record[k] * record[i - k - 1]);
			}
			// 记录1~i时，BST的个数
			record[i] = tmp;
		}

		return record[n];
	}
}
