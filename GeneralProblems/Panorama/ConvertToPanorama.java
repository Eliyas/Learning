package GeneralProblems.Panorama;

import java.util.*;
import java.util.stream.Collectors;

//Steps:
//1. Character Frequency Count:
//Count the occurrences of each character in both strings.
//2. Add or Remove Characters:
//For characters that are present in a but appear fewer times in b, you need to add them.
//For characters that are present in b but exceed the count in a, you need to remove them.
//3. Modify String b:
//Adjust b accordingly by adding or removing characters until the frequency of characters in b matches that of a.

// s= aba   t= abb  output aba
public class ConvertToPanorama {

    public static void main(String args[]) {
        //ConvertToPanorama.convertToPanorama("aba", "abb");
        ConvertToPanorama.convertToPanorama("panorama", "manager");
        ConvertToPanorama.convertToPanorama2("panorama", "manager");
    }

    static void convertToPanorama(String source, String target) {
        List<String> targetCharList = Arrays.stream(target.split("")).collect(Collectors.toList());
        Map<Character, Integer> targetCharAndCountMap = new HashMap<>();
        Map<Character, Integer> sourceCharAndCountMap = new HashMap<>();
        List<Integer> differenceCharIndexes = new ArrayList<>();
        List<String> sourceCharList = Arrays.stream(source.split("")).collect(Collectors.toList());

        for (Character c : target.toCharArray()) {
            targetCharAndCountMap.put(c, targetCharAndCountMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : source.toCharArray()) {
            sourceCharAndCountMap.put(c, sourceCharAndCountMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < target.length(); i++) {
            int index = sourceCharList.indexOf(String.valueOf(target.charAt(i)));
            if (index != -1) {
                sourceCharList.remove(index);
            } else {
                differenceCharIndexes.add(i);
            }
        }

        for (Character c : sourceCharAndCountMap.keySet()) {
            int missingCount = 0;
            if (!targetCharAndCountMap.containsKey(c)) {
                missingCount += sourceCharAndCountMap.get(c);
            } else if (sourceCharAndCountMap.get(c) > targetCharAndCountMap.get(c)) {
                missingCount += sourceCharAndCountMap.get(c) - targetCharAndCountMap.get(c);
            }
            for (int i = 0; i < missingCount; i++) {
                if (differenceCharIndexes.size() != 0) {
                    int index = differenceCharIndexes.get(0);
                    targetCharList.add(index, String.valueOf(c));
                    differenceCharIndexes.remove(0);
                } else {
                    targetCharList.add(String.valueOf(c));
                }
            }
        }
        System.out.println("Converted panorama of " + source + " and " + target + " is " + String.join("", targetCharList));
    }

    public static void convertToPanorama2(String a, String b) {
        // Frequency maps for both strings
        HashMap<Character, Integer> freqA = new HashMap<>();
        HashMap<Character, Integer> freqB = new HashMap<>();

        // Count frequencies for string a
        for (char c : a.toCharArray()) {
            freqA.put(c, freqA.getOrDefault(c, 0) + 1);
        }

        // Count frequencies for string b
        for (char c : b.toCharArray()) {
            freqB.put(c, freqB.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder(b);

        // Add missing characters or adjust frequencies to match string a
        for (char c : freqA.keySet()) {
            int countA = freqA.get(c);
            int countB = freqB.getOrDefault(c, 0);

            if (countA > countB) {
                // Add missing characters
                for (int i = 0; i < (countA - countB); i++) {
                    result.append(c);  // Add missing characters to the result
                }
            }
        }

        // Remove extra characters in b
        for (char c : freqB.keySet()) {
            int countA = freqA.getOrDefault(c, 0);
            int countB = freqB.get(c);

            if (countB > countA) {
                // Remove extra characters
                for (int i = 0; i < (countB - countA); i++) {
                    int index = result.lastIndexOf(String.valueOf(c));  // Find the last occurrence of the character
                    if (index != -1) {
                        result.deleteCharAt(index);  // Remove the character
                    }
                }
            }
        }

        System.out.println("Converted panorama of " + a + " and " + b + " is " + result.toString());
    }

}
