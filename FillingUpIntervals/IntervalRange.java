import java.util.Scanner;

class IntervalRange {
	public static void main(String args[]) {

		int arr[] = { 5, 10, 15, 20, 25, 30, 50, 100 };
		Scanner in = new Scanner(System.in);
		System.out.println("Enter b1 & b2");
		int b1 = in.nextInt();
		int b2 = in.nextInt();
		
		String result = "";
		int i = 0, a1 = 0, a2 = 0;
		int p1 = 0, p2 = 0;
		boolean p1Halt = true, p2Halt = true, loop = true;

		i = 0;
		while (i < arr.length) {
			if (b1 < arr[i]) {
				p1 = i;
				break;
			}
			i++;
		}

		i = 0;
		while (i < arr.length) {
			if (b2 < arr[i]) {
				p2 = i;
				break;
			}
			i++;
		}
		
		// b2 element is greater than the max element in array.
		if(i == arr.length){
			i--;
			arr[i] = b2;
			p2 = i;
		}
			
		for (i = 0; i < arr.length; i++) {
			if (i == p1) {
				if (p1 % 2 == 0) {
					result = result + b1 + " ";
				} else {
					result = result + arr[i - 1] + " ";
				}
				p1Halt = false;
			}
			if (i == p2) {
				if (p2 % 2 == 0) {
					result = result + b2 + " ";
				} else {
					result = result + arr[i] + " ";
				}
				p1Halt = p2Halt = true;
				continue;
			}
			if ((p1Halt && p2Halt) && (i % 2 == 1)) {
				result = result + "[" + arr[i - 1] + "," + arr[i] + "]";
				p2Halt = p1Halt = true;
			}
		}
		System.out.println("p1 = " + p1 + " && p2 = " + p2);
		System.out.println(result);
	}
}
