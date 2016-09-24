import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class PairsInArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Number of elements in array = ");
		int N = in.nextInt();

		System.out.println("Sum to find pairs of = ");
		int sum = in.nextInt();

		System.out.println("Enter all elements of array = ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		/** Method 1 **/
		System.out.println("Method 1");
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			ht.put(arr[i], 0);
		}

		for (int i = 0; i < N; i++) {
			int num = sum - arr[i];
			if (ht.containsKey(num)) {
				System.out.println("Pair found : " + arr[i] + ", " + num);

				ht.remove(num);
				ht.remove(arr[i]);
			}
		}

		/** Method 2 **/
		System.out.println("Method 2");
		Arrays.sort(arr);
		int p1 = 0, p2 = N - 1;

		while (arr[p1] + arr[p2] > sum && p2 > 0) {
			p2--;
		}

		while (p1 < p2) {
			if (arr[p1] + arr[p2] == sum) {
				System.out.println("Pairs (p1, p2) : (" + arr[p1] + ", " + arr[p2] + ")");
				p1++;
				p2--;
			} else {
				p2--;
			}
		}
	}
}

// Number of elements in array =
// 10
// Sum to find pairs of =
// 5
// Enter all elements of array =
// 2 9 0 1 3 5 4 8 6 7
// Pair found : 2, 3
// Pair found : 0, 5
// Pair found : 1, 4
// Pairs (p1, p2) : (0, 5)
// Pairs (p1, p2) : (1, 4)
// Pairs (p1, p2) : (2, 3)
