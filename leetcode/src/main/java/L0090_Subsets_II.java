import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L0090_Subsets_II {

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		if (nums == null) {
			return null;
		}

		if (nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}

		Set<List<Integer>> set = new HashSet<List<Integer>>();

		// ��Ŀ��Ҫ��ÿ��list�Ƿǽ�������Ҫ�ȴ�С��������
		Arrays.sort(nums);

		// ����nλ����2^n�����
		for (int i = 0; i < Math.pow(2, nums.length); i++) {

			List<Integer> list = new ArrayList<Integer>();
			int tmp = i;

			// ����ÿ��������ֱ���ö�������1�ĸ���
			// 0����ѡ��1����ѡ��
			for (int j = 0; j < nums.length; j++) {
				int bit = tmp & 1;
				tmp >>= 1;
				if (bit == 1) {
					list.add(nums[j]);
				}
			}
			set.add(list);
		}

		return new ArrayList<List<Integer>>(set);
	}

}
