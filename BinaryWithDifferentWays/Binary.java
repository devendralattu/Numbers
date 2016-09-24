import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		int num = a;
		int c = 0;

		/*** find no. of 1's in a binary representation of a number ***/

		// method 1
		System.out.println("\nMethod 1");
		String str = "";
		while (a != 0) {
			c = c + (a & 1);
			str = (a & 1) + str;
			a = a >> 1;
		}

		System.out.println(str);
		System.out.println("c = " + c);

		// method 2
		System.out.println("\nMethod 2");
		str = "";
		c = 0;
		a = num;
		int reminder = 1;

		while (a != 0) {
			reminder = a % 2;
			if (reminder == 1) {
				c++;
			}
			a = a / 2;
			str = reminder + str;
		}

		System.out.println(str);
		System.out.println("c = " + c);

		/*** Find if number is power of 2 ***/
		// method 1
		System.out.println("\nMethod 1");

		str = "";
		c = 0;
		a = num;

		System.out.println(Integer.toBinaryString(num) + " = " + num);
		System.out.println(Integer.toBinaryString(num - 1) + " = " + (num - 1));
		int addRes = (num & (num - 1));
		System.out.println(Integer.toBinaryString(addRes) + " = " + addRes);
		if ((num & num - 1) == 0) {
			System.out.println(num + " is power of 2.");
		} else {
			System.out.println(num + " is NOT power of 2.");
		}

		// method 2
		System.out.println("\nMethod 2");
		System.out.println("Binary num = " + Integer.toBinaryString(num));
		double d = Math.log(num) / Math.log(2);
		System.out.println("d = " + d);
		int di = (int) d;
		if (di == d) {
			System.out.println(num + " is power of 2.");
		} else {
			System.out.println(num + " is NOT power of 2.");
		}

		// method 3
		System.out.println("\nMethod 3");
		c = 0;
		a = num;
		while (a != 0) {
			reminder = a % 2;
			a = a / 2;
			if (reminder == 1) {
				c++;
			}
		}
		System.out.println("Number of 1's in " + num + " = " + c);
		if (c == 1 || num == 1) {
			System.out.println(num + " is power of 2.");
		} else {
			System.out.println(num + " is NOT power of 2.");
		}
	}
}
