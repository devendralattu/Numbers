public class CoinsRecursion {

	static int coins[] = { 1, 3, 5, 11 };
	final static int arrLen = coins.length;

	public static void main(String[] args) {

		for (int temp = 1; temp < 100; ++temp) {
			String s = "";
			int N = temp;
			int i = arrLen - 1;
			s = calculate(N, i);
			System.out.println("Number = " + temp + "\n" + s + "\n");
		}
	}

	private static String calculate(int N, int i) {
		int c = 0;
		String s = "";
		while (N > 0) {
			c = N / coins[i];
			if (c > 0) {
				N = N % coins[i];
				s = s + (c + " coins of " + coins[i]) + " \n";
				s = s + calculate(N, arrLen - 1);
				break;
			}
			i--;
		}
		return s;
	}

}
