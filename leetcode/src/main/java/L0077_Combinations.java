import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0077_Combinations {

	int target;// ����
	Integer[] stack;// �洢ÿ������
	Integer[] nums;// �洢1~n

	List<List<Integer>> rt;// �洢���

	public void search(int p) {

		// ������Ϊk����stack������һ�������������
		if (p == target) {
			rt.add(new ArrayList<Integer>(Arrays.asList(stack)));
			return;
		}

		// ����nums(1~n)�е�ÿ��Ԫ��
		for (Integer n : nums) {
			// �ҵ�nums�е�һ����stack���Ԫ�ش��Ԫ��
			if (p > 0 && n <= stack[p - 1]) {
				continue;
			}

			// �ҵ���һ��Ԫ�أ��ݹ�
			stack[p] = n;
			search(p + 1);
		}
	}

	public List<List<Integer>> combine(int n, int k) {

		target = k;
		nums = new Integer[n];
		stack = new Integer[k];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		rt = new ArrayList<List<Integer>>();

		search(0);

		return rt;
	}

}
