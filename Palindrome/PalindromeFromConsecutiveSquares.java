import java.util.Scanner;

public class PalindromeFromConsecutiveSquares {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int i, j, n[], d[], lines = 0, sum = 0;
		String strInput = "";
		String strSplit[];
		int finalSum[];

		while (true) {
			try {
				lines = in.nextInt();
			} catch (Exception e) {
				System.out.println("Number is not an Integer");
				System.exit(0);
			}

			if (lines >= 1 && lines <= 20) {
				break;
			}
		}

		n = new int[lines];
		d = new int[lines];
		finalSum = new int[lines];
		strSplit = new String[lines];

		strInput = in.nextLine();
		int palindromes[];
		int maxN = 0;
		for (i = 0; i < lines; i++) {

			while (true) {
				strInput = in.nextLine();
				strSplit = strInput.split(" ");

				if (strSplit.length != 2) {
					System.out.println("Error in input format");
					System.exit(0);
				}

				try {
					n[i] = Integer.parseInt(strSplit[0]);
					d[i] = Integer.parseInt(strSplit[1]);
				} catch (Exception e) {
					System.out.println("Number is not an Integer");
					System.exit(0);
				}

				if (n[i] > 0 && d[i] > 0 && n[i] >= d[i]) {
					break;
				}
			}
			if (maxN < n[i]) {
				maxN = n[i];
			}
		}

		int palinLimit = 0;
		if (maxN > 99) {
			palinLimit = 18 + (int) (maxN / 100) * 10;
		} else {
			palinLimit = 9 + (int) (maxN / 10);
		}
		palindromes = new int[palinLimit];
		int p = 0;
		for (i = 1; i < maxN; i++) {
			if (isPalindrome(i)) {
				palindromes[p] = i;
				p++;
			}
		}

		p = 0;
		i = 0;
		j = 1;
		int count = 0;
		int currentPalindrome = 1;
		int fdn = 0;

		while (fdn < lines) {
			while (i < palindromes.length) {
				currentPalindrome = palindromes[i];
				p = 1;
				while (p < currentPalindrome && currentPalindrome <= n[fdn]) {
					j = p;
					sum = 0;
					while (sum < currentPalindrome && currentPalindrome <= n[fdn]) {
						sum = sum + (int) Math.pow(j, 2);
						count++;

						if (sum == currentPalindrome && count > 1) {
							finalSum[fdn] = finalSum[fdn] + currentPalindrome;
						}
						j = j + d[fdn];
					}
					count = 0;
					p++;
				}
				i++;
			}
			System.out.println("finalSum[" + fdn + "] = " + finalSum[fdn]);
			fdn++;
			i = 0;
		}
	}

	private static boolean isPalindrome(int sum) {
		int count = 0;
		String str = sum + "";
		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - 1 - i)) {
				count++;
			}
		}
		if (count >= 1) {
			// "Not palindrome"
			return false;
		} else {
			// "Palindrome"
			return true;
		}
	}
}
