import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RobotLoopDetection {
	static Map<String, String> coordsMap = new HashMap<String, String>(){
		{
			put("(0,0)", "");
		}
	};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String commands = in.nextLine();
		doesCircleExist(commands);

	}

	static void doesCircleExist(String commands) {
		String c[] = commands.split("");
		int left[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		int right[][] = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

		int lPointer = 3, rPointer = 3; // last index of left and right array
		int xCoord = 0, yCoord = 0;
		int len = c.length;
		int previous = 1; // 0 for left and 1 for right

		for (int i = 0; i < len; i++) {
			if (c[i].equals("L") || c[i].equals("R")) {
				if (c[i].equals("L")) {
					previous = 0;
					lPointer = (lPointer + 1) % 4;
				} else {
					previous = 1;
					rPointer = (rPointer + 1) % 4;
				}
			}

			else if (c[i].equals("G") && previous == 0) {
				xCoord = xCoord + left[lPointer][0];
				yCoord = yCoord + left[lPointer][1];
				if (containsLoop(xCoord, yCoord)) {
					break;
				}
			}

			else if (c[i].equals("G") && previous == 1) {
				xCoord = xCoord + right[rPointer][0];
				yCoord = yCoord + right[rPointer][1];
				if (containsLoop(xCoord, yCoord)) {
					break;
				}
			}

			else if (c[i].equals("L")) {
				lPointer = (lPointer + 1) % 4;
			}

			else if (c[i].equals("R")) {
				rPointer = (rPointer + 1) % 4;
			}
		}

		System.out.println("(x,y) = (" + xCoord + "," + yCoord + ")");
	}

	public static boolean containsLoop(int xCoord, int yCoord) {
		String key = "(" + xCoord + "," + yCoord + ")";
		if (coordsMap.containsKey(key)) {
			System.out.println("loop detected at " + key);
			return true;
		}
		coordsMap.put(key, "");
		return false;
	}

}
