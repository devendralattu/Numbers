package numbers;

import java.util.Scanner;

public class NextGreater {

	public String nextGreaterNumber(char charNum[]) {

		int i = 0;
		int len = charNum.length;
		String output = "";

		// Find pointer for smaller number pattern : Time Complexity = O(n)
		for (i = len - 1; i > 0; i--) {
			int num1 = charNum[i] - '0';
			int num2 = charNum[i - 1] - '0';
			if (num1 > num2) {
				break;
			}
		}

		// If the digits have already formed max count.
		if (i - 1 < 0) {
			return "Not possible";
		}

		// Otherwise, find first greater number from num2 : Time Complexity = O(n)
		// set pointer at num2
		i--;
		int num2 = charNum[i] - '0';
		int j = 0;
		for (j = i + 1; j < len; j++) {
			int num3 = charNum[j] - '0';

			if (num3 - num2 <= 0) {
				break;
				// found pointer j
			}
		}

		// Swap two numbers : Time Complexity = O(1)
		j--;
		System.out.println("To swap " + (charNum[i] - '0') + " && " + (charNum[j] - '0'));

		char temp = charNum[i];
		charNum[i] = charNum[j];
		charNum[j] = temp;

		// Reverse numbers after i : Time Complexity = O(n)
		int m = i + 1, n = len - 1;
		
		while (m <= n) {
			temp = charNum[m];
			charNum[m] = charNum[n];
			charNum[n] = temp;
			m++;
			n--;
		}

		output = new String(charNum);
		return output;
	}

	public static void main(String[] args) {
		NextGreater ng = new NextGreater();
		// example: 53698754321
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("Enter a number");
			String num = in.next();
	
			char charNum[] = num.toCharArray();
			String output = ng.nextGreaterNumber(charNum);
			System.out.println("Result = " + output + "\n");
		}
	}

}
