import java.util.Scanner;

public class Multiplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();

		int min = (a < b) ? a : b;
		int max = (a > b) ? a : b;
		int tempMax = 0;
		int tempMin = 0;
		if (min < 0) {
			// check if min has abs value greater than max
			tempMin = min + (-min) + (-min);
			if (tempMin > max) {
				// switch min and max keeing the negative sign for min
				min = max - max - max;
				max = tempMin;
			}
		}

		while (min != 1 && min != -1 && min != 0) {
			if (min % 2 == 1 || min % 2 == -1) {
				// min is odd number
				min++;
				tempMax = tempMax + max;
			} else {
				// min is even number
				max = max << 1;
				min = min >> 1;
			}
		}

		if (min < 0) {
			max = max + tempMax;
			max = max - max - max;
		} else if (min == 0) {
			max = 0;
		} else {
			max = max - tempMax;
		}
		System.out.println("Product of " + a + " * " + b + " = " + max);
	}

}
