import java.util.Scanner;

public class GridPath {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter number of rows, n = ");
		int n = in.nextInt();

		System.out.println("Enter number of rows, m = ");
		int m = in.nextInt();

		int arr[][] = new int[n][m];
		
		for (int j = 0; j < m; j++) {
			arr[0][j] = 1;
		}
		for (int i = 0; i < n; i++) {
			arr[i][0] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
			}
		}
		int paths = arr[n - 1][m - 1];

		System.out.println("Matrix result = " + paths);
	}
}	
