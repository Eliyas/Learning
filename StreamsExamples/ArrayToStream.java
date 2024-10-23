package StreamsExamples;

import java.util.*;
import java.util.stream.*;

class ArrayToStream {

    public static void main(String[] args) {
		ArrayToStream.ex1();
		ArrayToStream.ex2();
	}

	static void ex1() {
		// Step 1: Declare and initialize an array of strings 
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry"}; 

        // Step 2: Create a stream from the array 
        Stream<String> fruitStream = Stream.of(fruits); 

        // Step 3: Print each item in the stream 
        fruitStream.forEach(System.out::println); 
	}	

    static void ex2() {
		// Step 1: Declare and initialize an array of strings 
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry"}; 

        // Step 2: Create a stream from the array 
        Stream<String> fruitStream = Arrays.stream(fruits); 

         // Step 3: Print each item in the stream 
        fruitStream.forEach(System.out::println); 
	}	
}