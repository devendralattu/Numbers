package numbers;

import java.util.HashMap;
import java.util.Map;

public class QueueBribes {

	public static void main(String[] args) {

		String str = "12345678";
		String outputStr = "12537864";
		int len = str.length();

		int count = 0;
		
		Map<String, String> inputMap = new HashMap<String, String>();
		Map<String, String> outputMap = new HashMap<String, String>();
		
		System.out.println("<<< Create input string map >>>");
		// for input string
		for (int i = 0; i < len; i++) {
			String key = str.substring(i, i + 1);
			String value = str.substring(i + 1, len);
			inputMap.put(key, value);
			System.out.println(key + " " + inputMap.get(key));
		}

		System.out.println("<<< Create output string map >>>");
		// for output string
		for (int i = 0; i < len; i++) {
			String key = outputStr.substring(i, i + 1);
			String value = outputStr.substring(0, i);
			outputMap.put(key, value);
			System.out.println(key + " " + outputMap.get(key));
		}

		System.out.println("<<< Procesing >>>");
		for (int i = 0; i < len; i++) {
			String key = outputStr.substring(i, i + 1);
			String outputValue = outputMap.get(key);
			String value = inputMap.get(key);
			
			for (int j = 0; j < outputValue.length(); j++) {
				//check in inputMap for the occurrence.
				String outputKey = outputValue.substring(j, j + 1);
				if(value.contains(outputKey)){
					count++;
				}
			}
		}
		
		System.out.println("Total number of bribes = " + count);
	}

}
