// I tried solving this using HashMap but then found a optimal solution online and then implemented the same just for my practice.
/* This is not my original logic */

package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeIntWithZeroSum {

	public ArrayList<List<Integer>> findPairs(int arr[]) {

		Arrays.sort(arr);
		ArrayList<List<Integer>> pairs = new ArrayList<List<Integer>>();
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (i == 0 || arr[i] != arr[i - 1]) {
				int j = i + 1;
				int k = len - 1;

				while (j < k) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[k]);

						pairs.add(list);

						j++;
						k--;

						//ignore duplicate values and move pointers
						while (j < k && arr[j] == arr[j + 1]) {
							j++;
						}
						while (k > j && arr[k] == arr[k - 1]) {
							k--;
						}

					} else if (arr[i] + arr[j] + arr[k] < 0) {
						j++;
					} else if (arr[i] + arr[j] + arr[k] > 0) {
						k--;
					}
				}
			}
		}

		return pairs;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = 0;
		while (true) {
			try {
				System.out.println("Enter number of elements in array = ");
				String s = in.next();
				len = Integer.parseInt(s);
				if (len <= 0) {
					System.out.println("Length should be +ve Integer");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Number");
			}
		}

		System.out.println("Enter an array sequence");
		int arr[] = new int[len];
		int i = 0;
		while (len > 0) {
			arr[i++] = in.nextInt();
			len--;
		}

		ThreeIntWithZeroSum ts = new ThreeIntWithZeroSum();
		ArrayList<List<Integer>> pairs = ts.findPairs(arr);

		System.out.println("List of pairs = ");
		for (List<Integer> list : pairs) {
			System.out.println(list);
		}
		System.out.println("\nDone");
	}

}

/*
 * 6 1 -1 -1 0 2 4
 * [-1, -1, 2]
 * [-1, 0, 1]
*/
