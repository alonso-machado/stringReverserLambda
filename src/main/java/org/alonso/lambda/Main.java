package org.alonso.lambda;


import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		System.out.println("Input: " + input +"\n");
		List<Character> splitted = input.chars().mapToObj(c -> (char) c).toList();;
		long count = splitted.stream().count();
		StringBuilder sb = new StringBuilder("Original Array: {");
		splitted.stream().limit(count - 1).forEach(c -> sb.append(c+", "));
		sb.append(splitted.get((int) count - 1));
		System.out.println(sb.toString()+" }\n");
		StringBuilder sortedArray = new StringBuilder("Sorted Array: {");
		List<Character> reversed = splitted.stream().sorted(Comparator.naturalOrder()).toList(); // .collect(Collectors.toList()) is not needed in Java 17
		reversed.stream().limit(count - 1).forEach(c -> sortedArray.append(c+", "));
		sortedArray.append(splitted.get((int) count - 1));
		System.out.println(sortedArray.toString()+" }\n");
		String reversedString = reversed.stream().map(String::valueOf).collect(Collectors.joining());
		System.out.println("Final String (Reversed): " + reversedString +"\n");
		scanner.close();
	}
}