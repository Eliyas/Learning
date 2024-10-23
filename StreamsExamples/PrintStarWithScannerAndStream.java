package StreamsExamples;

import java.util.*;
import java.util.stream.*;

class PrintStarWithScannerAndStream {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter number between 1 to 10");
		
		String number = myObj.nextLine();
		System.out.println("You have entered "+ number);
		
		IntStream.range(0, Integer.parseInt(number))
			.forEach((i) -> {
				System.out.println("*");
			});
	

		PrintStarWithScannerAndStream.example1(Integer.parseInt(number));
		PrintStarWithScannerAndStream.example2(Integer.parseInt(number));
		PrintStarWithScannerAndStream.example3(Integer.parseInt(number));

	}

	static void example1(int n) {
		
		IntStream.rangeClosed(1, n)
			.map(i -> n - i + 1)
			.forEach(i -> {
				Stream.generate(() -> "*")
					.limit(i)
					 .forEach(System.out::print);
				System.out.println();
			}); 	

	}

	static void example2(int n) {
		IntStream.rangeClosed(1, n)
			.map(i -> n - i + 1)
			.forEach(i -> System.out.println("*".repeat(i)));
	}
		
	static void example3(int n) {
		IntStream.rangeClosed(1, n)
			.map(i -> n - i + 1)
			.forEach(i -> {
				String str = IntStream.range(0, i)
					.mapToObj(x -> "*")
					.collect(Collectors.joining(""));
				System.out.println(str);
			}); 	

	}
















		
	
}