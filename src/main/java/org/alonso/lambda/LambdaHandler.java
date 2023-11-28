package org.alonso.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaHandler implements RequestHandler<String, String> {
	public String handleRequest(String input, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("Input: " + input + "\n");
		StringBuilder sb = new StringBuilder("Original Array: {");
		List<Character> splitted = input.chars().mapToObj(c -> (char) c).toList(); // .collect(Collectors.toList()) is not needed in Java 17
		long count = splitted.stream().count();
		splitted.stream().limit(count - 1).forEach(c -> sb.append(c + ", "));
		sb.append(splitted.get((int) count - 1));
		logger.log(sb.toString() + " }\n");
		StringBuilder sortedArray = new StringBuilder("Sorted Array: {");
		List<Character> reversed = splitted.stream().sorted(Comparator.naturalOrder()).toList(); // .collect(Collectors.toList()) is not needed in Java 17
		reversed.stream().limit(count - 1).forEach(c -> sortedArray.append(c + ", "));
		sortedArray.append(splitted.get((int) count - 1));
		logger.log(sortedArray.toString() + " }\n");
		String reversedString = reversed.stream().map(String::valueOf).collect(Collectors.joining());
		logger.log("Final String (Reversed): " + reversedString + "\n");

		return reversedString;

	}

}
