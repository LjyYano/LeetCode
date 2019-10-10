import java.util.Arrays;
import java.util.Comparator;

public class L0179_Largest_Number {

	public String largestNumber(int[] nums) {

		String[] strs = new String[nums.length];

		// ��int���飬ת��string����
		for (int i = 0; i < strs.length; i++) {
			strs[i] = nums[i] + "";
		}

		// ��strs����
		Arrays.sort(strs, new Comparator<String>() {

			public int compare(String x, String y) {
				return (y + x).compareTo(x + y);
			}
		});

		// ���strs��һ��Ԫ���ǡ�0����������0
		if ("0".equals(strs[0])) {
			return "0";
		}

		// ����strs������ַ���
		return String.join("", strs);
	}
}
