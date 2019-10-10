public class L0283_Move_Zeroes {

	public void moveZeroes(int[] nums) {

		int t = 0;

		// �ѷ�0Ԫ���Ƶ�ǰ��
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[t++] = nums[i];
			}
		}

		// �Ѻ���Ԫ��ֵ0
		for (int i = t; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

}
