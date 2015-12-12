package LeetCode;

public class L258_Add_Digits {

	public int addDigits(int num) {
		return 1 + (num - 1) % 9;
	}
}
