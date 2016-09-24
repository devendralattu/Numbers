import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinCommonNumFromArray {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();

		int arr1[] = new int[n1];
		int arr2[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			arr1[i] = in.nextInt();
		}
		for (int i = 0; i < n2; i++) {
			arr2[i] = in.nextInt();
		}

		/** Find min/max array size among the two **/
		int minN = findMin(n1, n2);
		int maxN = findMax(n1, n2);

		/** Add numbers from smallest array to map **/
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (minN == n1) {
			for (int i = 0; i < minN; i++) {
				map.put(arr1[i], 0);
			}
		} else {
			for (int i = 0; i < minN; i++) {
				map.put(arr2[i], 0);
			}
		}

		int c = 0;
		int minCommon = Integer.MAX_VALUE;

		if (maxN == n2) {
			for (int i = 0; i < maxN; i++) {
				if (map.containsKey(arr2[i])) {
					minCommon = findMin(minCommon, arr2[i]);
					c++;
				}
			}
		} else {
			for (int i = 0; i < maxN; i++) {
				if (map.containsKey(arr1[i])) {
					minCommon = findMin(minCommon, arr1[i]);
					c++;
				}
			}
		}

		/** Found! **/
		if (c == 0) {
			System.out.println("No common element found");
		} else {
			System.out.println("Smallest common number between two arrays = " + minCommon);
		}
	}

	private static int findMax(int max, int i) {
		return (max > i) ? max : i;
	}

	private static int findMin(int min, int i) {
		return (min <= i) ? min : i;
	}
}
