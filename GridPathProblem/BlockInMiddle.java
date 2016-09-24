import java.util.Scanner;

public class GridPath {

	static int mat[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter number of rows, n = ");
		int n = in.nextInt();

		System.out.println("Enter number of rows, m = ");
		int m = in.nextInt();

		System.out.println("Enter number of rows, negN = ");
		int negN = in.nextInt();
		System.out.println("Enter number of rows, negM = ");
		int negM = in.nextInt();

		int arr[][] = new int[n][m];
		mat = new int[n][m];

		for (int j = 0; j < m; j++) {
			arr[0][j] = 1;
		}
		for (int i = 0; i < n; i++) {
			arr[i][0] = 1;
		}

		// blockage at starting point
		if (negN == 0 && negM == 0) {
			System.out.println("0 paths");
			return;
		}

		// blockage at first row or column
		if (negN == 0) {
			for (int i = negM; i < m; i++) {
				arr[0][i] = 0;
			}
		}

		if (negM == 0) {
			for (int i = negN; i < n; i++) {
				arr[i][0] = 0;
			}
		}

		if (negN < n && negM < m) {
			arr[negN][negM] = 0;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (i == negN && j == negM) {
					continue;
				}
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
			}
		}
		int paths = arr[n - 1][m - 1];
		System.out.println("Matrix result = " + paths);

		paths = calculatePath(n - 1, m - 1, negN, negM);
		System.out.println("Recursion result = " + paths);

	}

	private static int calculatePath(int n, int m, int negN, int negM) {
		if (n < 0 || m < 0) {
			return 0;
		}
		if (n == 0 || m == 0) {
			return 1;
		}
		if (n == negN && m == negM) {
			return 0;
		}
		if (mat[n][m] == 0) {
			mat[n][m] = (calculatePath(n, m - 1, negN, negM) + calculatePath(n - 1, m, negN, negM));
		}
		return mat[n][m];
	}
}
