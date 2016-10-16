/** Get element at any index for left/right shifted array **/

import java.util.ArrayList;
import java.util.Scanner;

public class ShiftArrayElem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter size of array : ");
		int n = in.nextInt();
		System.out.println("Enter elements of array : ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		printArray(arr);

		System.out.println("Enter amount to shift +ve means to the right and -ve means to the left");
		int k = in.nextInt();

		k = k % n;
		if (k == 0) {
			printArray(arr);
		} else {
			printArray(arr, k);
		}
	}

	private static void printArray(int[] arr, int k) {
		ArrayList<Integer> al = new ArrayList<Integer>();
        //for rotate left
		if (k < 0) {
			for (int i = 0; i < arr.length; i++) {
				if (i - k < arr.length) {
					al.add(arr[i - k]);
				} else {
					int val = Math.abs(-i + k + arr.length);
					al.add(arr[val]);
				}
			}
		}
        //for rotate right
        else {
			for (int i = 0; i < arr.length; i++) {
				if (i - k < 0) {
					al.add(arr[i - k + arr.length]);
				} else {
					al.add(arr[i - k]);
				}
			}
		}

		printArrayList(al);
	}

	private static void printArrayList(ArrayList<Integer> al) {
		for (int a : al) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	private static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
