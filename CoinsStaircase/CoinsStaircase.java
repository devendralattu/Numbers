package numbers;

import java.util.Scanner;

public class CoinsStaircase {

	public void printMaxStairs(int arr[]) {
		System.out.println("Max items at 'c'th step => n(n + 1)/2");

		for (int i = 0; i < arr.length; i++) {
			int c = -2 * arr[i];

			System.out.println("n^2 + n " + c + " = 0");

			// finding positive root of quadratic equation
			// -b +- SqRoot(b^2 - 4ac)/2a
			double r = (-1 + Math.sqrt(1 - 4 * 1 * (c))) / 2;

			int maxSteps = (int) r;
			System.out.println(maxSteps);
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter length of array = ");
		int len = in.nextInt();
		int arr[] = new int[len];
		int i = 0;
		while (len-- > 0) {
			System.out.print("Enter coin number " + (i+1) + " = ");
			arr[i++] = in.nextInt();
		}

		CoinsStaircase cs = new CoinsStaircase();
		cs.printMaxStairs(arr);
	}

}

/*
 * 
 * For #coins = 4, we have
 * $  1 coin on 1st row
 * $$ 2 coins on 2nd row
 * $  1 coin on 3rd row
 * total = 4 coins
 * We need unique number of coins per row.
 * Therefore, answer = 2

Enter length of array = 
2
Enter coin number 1 = 4
Enter coin number 2 = 6
Max items at 'c'th step => n(n + 1)/2
n^2 + n -8 = 0
2
n^2 + n -12 = 0
3

*/
