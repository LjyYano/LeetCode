public class L0075_Sort_Colors {

	public void sortColors(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}

		// ���������������洢������ɫ���ִ���
		int red = 0;
		int white = 0;
		int blue = 0;

		// ѭ��һ�Σ���¼ÿ����ɫ���ִ���
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				red++;
			} else if (nums[i] == 1) {
				white++;
			} else {
				blue++;
			}
		}

		// ��nums�������¸�ֵ
		int i = 0;
		while (red-- > 0) {
			nums[i++] = 0;
		}
		while (white-- > 0) {
			nums[i++] = 1;
		}
		while (blue-- > 0) {
			nums[i++] = 2;
		}
	}
}
