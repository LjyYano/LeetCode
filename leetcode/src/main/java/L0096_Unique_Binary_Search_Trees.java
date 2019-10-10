public class L0096_Unique_Binary_Search_Trees {

	public int numTrees(int n) {

		if (n == 1 || n == 2) {
			return n;
		}

		// record[0]û���ã����Գ�����n+1
		// ʹ�����飬�������ϱ��������ܹ���ʡʱ�䣬����ᳬʱ
		int[] record = new int[n + 1];

		record[0] = 1;
		record[1] = 1; // 1��Ԫ��ʱ�����Ϊ1
		record[2] = 2; // 2��Ԫ��ʱ�����Ϊ2

		for (int i = 3; i <= n; i++) {
			int tmp = 0;
			for (int k = 0; k < i; k++) {
				// ��nΪ�����Ķ���������=����Ķ���������*�ҽ��Ķ���������
				// ��Ŀ����Ҫ��������������ֱ���1~nΪ�����
				tmp += (record[k] * record[i - k - 1]);
			}
			// ��¼1~iʱ��BST�ĸ���
			record[i] = tmp;
		}

		return record[n];
	}
}
