import java.util.Scanner;

public class FindNearestNumberInArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = -1;
		while (n <= 0) {
			System.out.print("Enter number of elements in array = ");
			n = in.nextInt();
		}

		System.out.print("Enter elements in sorted order = ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		System.out.print("Enter a number to be searched = ");
		int element = in.nextInt();

		if (element < arr[0]) {
			System.out.println("Element " + element + " is less than index 0 in array");
			System.out.println("Nearest element = arr[0] = " + arr[0]);
			return;
		}
		if (element > arr[n - 1]) {
			System.out.println("Element " + element + " is greater than index " + (n - 1) + " in array");
			System.out.println("Nearest element = arr[" + (n - 1) + "] = " + arr[n - 1]);
			return;
		}
		
		int index = search(0, n - 1, element, arr);
		System.out.println("index = " + index + " & arr[" + index + "] = " + arr[index]);
	}

	private static int search(int start, int end, int element, int arr[]) {

		if (start > end) {
			int sDiff = Math.abs(arr[start] - element);
			int eDiff = Math.abs(arr[end] - element);
			if (sDiff < eDiff) {
				return start;
			} else {
				return end;
			}
		}

		int mid = (start + end) / 2;

		if (arr[mid] == element) {
			return mid;
		}

		if (arr[mid] < element) {
			return search(mid + 1, end, element, arr);
		} else {
			return search(start, mid - 1, element, arr);
		}
	}
}
