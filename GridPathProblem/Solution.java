package gridProblem;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int n = 0, m = 0, temp, i, j, k;
		int path = 0;
		int arr[][];
		String strArr[][];
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.print("Enter n = ");
			n = in.nextInt();

			System.out.print("Enter m = ");
			m = in.nextInt();

			if (n > 0 && m > 0) {
				break;
			}
		}
		if (n == 1 && m == 1) {
			System.out.println("Path = " + path);
			System.exit(0);
		}

		if (n > m) {
			temp = m;
			m = n;
			n = temp;
		}
		
		arr = new int[n][m];
		strArr = new String[n][m];
		System.out.println("Taking n<m. Therefore, n = " + n + " & m = " + m);

		// set top row as blank
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				arr[i][j] = 0;
				strArr[i][j] = 0 + "";
			}
		}
		strArr[0][0] = "S";
		strArr[n-1][m-1] = "D";
		
		// print the grid
		System.out.println("Grid will look like this before calculating all paths");
		printStrGrid(strArr, m, n);

		// There is now at least one top row path
		path = 1;

		if (n > 1) {
			// set first row as all 1(s)
			for (j = 0; j < m - 1; j++) {
				arr[1][j] = 1;
				path++;
			}
		}

		// build the rest of the grid
		for (i = 2; i < n; i++) {
			for (j = 0; j < m - 1; j++) {
				for (k = 0; k <= j; k++) {
					arr[i][j] = arr[i][j] + arr[i - 1][k];
				}
				path = path + arr[i][j];
			}
		}

		// print the grid
		System.out.println("Grid will look like this after calculation of all paths");
		printGrid(arr, m, n);

		System.out.println("Total number of paths = " + path);
	}

	private static void printGrid(int arr[][], int m, int n) {
		int i, j;
		// print the grid
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printStrGrid(String strArr[][], int m, int n) {
		int i, j;
		// print the grid
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				System.out.print(strArr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
