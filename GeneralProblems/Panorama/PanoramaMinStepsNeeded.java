package GeneralProblems.Panorama;

import java.util.HashMap;
import java.util.Map;


// s= aba   t= abb  output aba
public class PanoramaMinStepsNeeded {

    public static void main(String args[]) {
        PanoramaMinStepsNeeded.findMinStepsForPanorama("panorama", "manager");
        PanoramaMinStepsNeeded.findMinStepsForPanorama("aabbcc", "abcabc");
        PanoramaMinStepsNeeded.findMinStepsForPanorama("abcd", "abcc");

        String a = "aabbcc";
        String b = "abc";
        System.out.println("Minimum steps to make b a panorama of a: " + minStepsToPanorama(a, b));
    }

    static void findMinStepsForPanorama(String source, String target) {
        Map<Character, Integer> targetCharAndCountMap = new HashMap<>();
        Map<Character, Integer> sourceCharAndCountMap = new HashMap<>();

        int stepsCount = 0;
        for(Character c : target.toCharArray()) {
            if(targetCharAndCountMap.containsKey(c)) {
                targetCharAndCountMap.put(c, targetCharAndCountMap.get(c) + 1);
            } else {
                targetCharAndCountMap.put(c, 1);
            }
        }

        for(Character c : source.toCharArray()) {
            if(sourceCharAndCountMap.containsKey(c)) {
                sourceCharAndCountMap.put(c, sourceCharAndCountMap.get(c) + 1);
            } else {
                sourceCharAndCountMap.put(c, 1);
            }
        }

        for(Character c : sourceCharAndCountMap.keySet()) {
            if(!targetCharAndCountMap.containsKey(c)) {
                stepsCount += sourceCharAndCountMap.get(c);
            } else if(sourceCharAndCountMap.get(c) > targetCharAndCountMap.get(c)) {
                stepsCount += sourceCharAndCountMap.get(c) - targetCharAndCountMap.get(c);
            }
        }
        System.out.println("Steps needed for "+ source +" to "+ target +" is "+ stepsCount);
    }

    public static int minStepsToPanorama(String a, String b) {
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

        int steps = 0;

        // Compare frequencies of characters in string a
        for (char c : freqA.keySet()) {
            int countA = freqA.get(c);
            int countB = freqB.getOrDefault(c, 0);  // Get count from b, default is 0 if not present
            // If b has fewer instances, we need to add characters
            if (countA > countB) {
                steps += (countA - countB);  // Add the difference to the step count
            }
        }

        // Compare frequencies of characters in string b
        for (char c : freqB.keySet()) {
            if (!freqA.containsKey(c)) {
                // If a does not contain the character at all, we need to remove all occurrences of it from b
                steps += freqB.get(c);
            }
        }

        return steps;
    }



}
