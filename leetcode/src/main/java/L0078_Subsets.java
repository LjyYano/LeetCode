import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0078_Subsets {

	int target;// ����
	Integer[] stack;// �洢ÿ������

	List<List<Integer>> rt;// �洢���

	public void search(int p, int[] nums) {

		// ������Ϊk����stack������һ�������������
		if (p == target) {
			rt.add(new ArrayList<Integer>(Arrays.asList(stack)));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (p > 0 && nums[i] <= stack[p - 1]) {
				continue;
			}

			stack[p] = nums[i];
			search(p + 1, nums);
		}
	}

	public List<List<Integer>> subsets(int[] nums) {

		Arrays.sort(nums);

		rt = new ArrayList<List<Integer>>();

		// �ֱ���0~num.length���ȵ����
		for (int i = 0; i <= nums.length; i++) {
			target = i;
			stack = new Integer[i];
			search(0, nums);
		}

		return rt;
	}

}
