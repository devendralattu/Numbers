package gridProblem;

import java.util.Scanner;

public class OptimalSolution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter number of rows, n = ");
		int n = in.nextInt();

		System.out.println("Enter number of rows, m = ");
		int m = in.nextInt();

		int path = calcFact(m + n - 2) / (calcFact(m - 1) * calcFact(n - 1));
		
		System.out.println("Total number of paths = " + path);
	}

	private static int calcFact(int num) {

		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		return fact;
	}

}
