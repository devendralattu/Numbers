import java.util.Scanner;

public class TimeDiff {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of lines = ");
		int N = in.nextInt();
		System.out.println("Enter time in HH:MM format");
		in.nextLine();
		String times[] = new String[N];
		for (int i = 0; i < N; i++) {
			times[i] = in.nextLine();
		}

		int clockDifference = getMinTimeDifference(times);
		System.out.println("clock minimum difference = " + clockDifference);
	}

	static int getMinTimeDifference(String[] times) {
		int timesLen = times.length;
		int minutes[] = new int[timesLen];
		String timesSplit[] = new String[2];

		for (int i = 0; i < timesLen; i++) {
			timesSplit = times[i].split(":");
			int h = Integer.parseInt(timesSplit[0]);
			int m = Integer.parseInt(timesSplit[1]);
			minutes[i] = h * 60 + m;
		}

		// 24 * 60 = 1440 (set as initial max difference)
		int clkDiff = 1440, diff = 0;
		for (int i = 0; i < timesLen; i++) {
			for (int j = i + 1; j < timesLen; j++) {
				diff = Math.abs(minutes[i] - minutes[j]);
				if (diff > (12 * 60)) {
					// If difference > 12 hrs then subtract it from 24hrs.
					// We need smallest diff on either side of clock
					diff = 1440 - diff;
				}
				if (diff < clkDiff) {
					clkDiff = diff;
				}
			}
		}
		return clkDiff;
	}

}
