package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class L166_Fraction_to_Recurring_Decimal {

	public String fractionToDecimal(int numerator, int denominator) {

		String sign = "";

		if (Math.signum(numerator) * Math.signum(denominator) < 0) {
			sign = "-";
		}

		long n = Math.abs(numerator);
		long d = Math.abs(denominator);

		String intPart = Math.abs(n / d) + "";

		// 如果整除，直接返回结果
		if (n % d == 0) {
			return sign + intPart;
		}

		// 计算小数部分
		n %= d;
		n *= 10;

		StringBuilder sb = new StringBuilder();
		Map<Long, Integer> mod = new HashMap<Long, Integer>();

		for (int i = 0; n != 0; i++) {

			long q = n / d;

			Integer start = mod.get(n / 10);

			if (start != null) {
				sb.insert(start, "(");
				sb.append(")");
				break;
			}

			sb.append(Math.abs(q));
			mod.put(n / 10, i);

			n %= d;
			n *= 10;
		}

		String fractionalPart = sb.toString();

		return sign + intPart + "." + fractionalPart;
	}

}
