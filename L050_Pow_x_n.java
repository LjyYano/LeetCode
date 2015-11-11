package LeetCode;

public class L050_Pow_x_n {

	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / pow(x, -n);
		} else {
			return pow(x, n);
		}
	}

	private double pow(double x, int n) {

		if (n == 0) {
			return 1;
		}

		double v = pow(x, n / 2);

		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
}
