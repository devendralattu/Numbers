import java.util.Scanner;

public class IntervalRangeSimple {

	public static void main(String[] args) {
		int arr[] = { 5, 10, 15, 20, 30, 50, 70, 100 };
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int len = arr.length;
		
		for (int i = 0; i < len; i = i + 2) {
			if (a > arr[i + 1] || b < arr[i]) {
				System.out.println(arr[i] + " " + arr[i + 1]);
			} else {
				a = min(arr[i], a);
				b = max(arr[i + 1], b);
			}
		}
		System.out.println(a + " " + b);
	}

	private static int max(int i, int b) {
		return (i < b) ? b : i;
	}

	private static int min(int i, int a) {
		return (i > a) ? a : i;
	}
}

/*
Input = 7 25
Output = 
30 50
70 100
5 25
*/
