import java.util.Scanner;

public class FirstNonRepeatedElem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		/** Method 1 **/
		String str = "";
		boolean cond = true;
		int count = 0;
		int p1 = 0, p2 = 0;
		for (int i = 1; i < N; i++) {
			p2++;
			if (arr[p1] != arr[p2]) {
				if (count == 0) {
					str = "First distinct element found : " + arr[p1];
					break;
				}
				p1 = p2;
				count = 0;
			} else {
				count++;
			}
		}

		System.out.println("p1 : " + p1 + " -- p2 : " + p2);
		if (p2 == p1) {
			str = "First distinct element found : " + arr[N - 1];
		}
		System.out.println(str);
		
		/** Method 2 **/
		/** Method 2 **/
		System.out.println("\nMethod 2");
		str = "";
		int i = 0;
		int temp;
		while (i < N) {
			temp = arr[i];
			count = 0;
			i++;
			while (i < N && arr[i] == temp) {
				count++;
				i++;
			}
			if (count == 0) {
				str = "Found :: " + temp;
				break;
			}

			if (i == N) {
				str = "Not found";
				break;
			}
		}
		
		System.out.println(str);
	}
}
