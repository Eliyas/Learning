package StreamsExamples.IntStream;

import java.util.*;
import java.util.stream.*;

class IntStreamExamples {

	static String[] str;

	public static void main(String[] args) {
		IntStreamExamples.generateEx1();
		str = new String[]{"tesn"};
		Stream.of(str).forEach(System.out::println);
	}

	static void generateEx1() {
		int[] numbers = new int[]{1};

		IntStream.generate(() -> numbers[0]++)
			.limit(10)
			.forEach(System.out::println); 	

	}

	














		
	
}