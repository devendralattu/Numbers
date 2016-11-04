/**
01  02  03  04  05  
16  17  18  19  06  
15  24  25  20  07  
14  23  22  21  08  
13  12  11  10  09  

Complexity = O(n^2)
**/


package matrix;

import java.text.DecimalFormat;

public class SpiralMatrix {

	public static void main(String[] args) {

		int n = 5;
		int[][] mat = new int[n][n];

		int i = 0, j = 0, count = 0;
		boolean iFixed = true, jPos = true, iPos = true;

		while (count < n * n) {

			if (iFixed) { // i is fixed and move j
				if (jPos) { // move j towards right
					mat[i][j++] = ++count;

					if (j == n || mat[i][j] != 0) {
						jPos = false; // now start decrementing j
						iFixed = false; // now start moving i and keep j fixed
						iPos = true; // make i movable towards bottom
						i++; // go to inner loops
						j--; // go to inner loops
					}
				} else { // move j towards left
					mat[i][j--] = ++count;

					if (j == -1 || mat[i][j] != 0) {
						jPos = true; // now start incrementing j
						iFixed = false; // now start moving i and keep j fixed
						iPos = false; // make i movable towards top
						i--; // go to inner loops
						j++; // go to inner loops
					}

				}
			} else { // move i
				if (iPos) { // move i towards bottom
					mat[i++][j] = ++count;

					if (i == n || mat[i][j] != 0) {
						iPos = false; // now start decrementing i
						iFixed = true; // now again keep i fixed and start moving j
						jPos = false; // make j movable towards left
						i--; // go to inner loops
						j--; // go to inner loops
					}
				} else { // move i towards top
					mat[i--][j] = ++count;

					if (i == -1 || mat[i][j] != 0) {
						iPos = true; // now start incrementing i
						iFixed = true; // now again keep i fixed and start moving j
						jPos = true; // make j movable towards right
						i++; // go to inner loops
						j++; // go to inner loops
					}

				}
			}
		}

		printMatrix(mat);

	}

	private static void printMatrix(int[][] mat) {

		int n = mat.length;
		int len = (int) (Math.log10(n * n) + 1);
		StringBuilder pattern = new StringBuilder();
		for (int i = 0; i < len; i++) {
			pattern.append("0");
		}
		DecimalFormat df = new DecimalFormat(pattern.toString());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				System.out.print(df.format(mat[i][j]) + "  ");
			}
			System.out.println();
		}

		System.out.println();

	}

}
