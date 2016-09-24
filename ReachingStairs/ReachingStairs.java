import java.util.Scanner;

public class ReachingStairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Number of jumps can be either 1, 2 or 3");
		System.out.println("Enter number of stairs, n = ");
		int n = in.nextInt();

		int count = getCountOfSteps(n);
		System.out.println("Number of different steps = " + count);
	}

	private static int getCountOfSteps(int n) {
		int count = 0;
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		count = (getCountOfSteps(n - 1) + getCountOfSteps(n - 2) + getCountOfSteps(n - 3));
		return count;
	}
}
