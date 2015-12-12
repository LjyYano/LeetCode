package LeetCode;

public class L273_Integer_to_English_Words {

	final String[] lessThanTwenty = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	final String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
			"Sixty", "Seventy", "Eighty", "Ninety" };
	final String[] thousands = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {

		if (num <= 0) {
			return "Zero";
		}
		String words = "";
		int index = 0;

		while (num > 0) {
			if (num % 1000 != 0) {
				words = getNum(num % 1000) + thousands[index] + " " + words;
			}
			num /= 1000;
			index++;
		}

		return words.trim();
	}

	private String getNum(int num) {

		if (num <= 0) {
			return "";
		} else if (num < 20) {
			return lessThanTwenty[num] + " ";
		} else if (num < 100) {
			return tens[num / 10] + " " + getNum(num % 10);
		} else {
			return lessThanTwenty[num / 100] + " Hundred " + getNum(num % 100);
		}
	}
}
