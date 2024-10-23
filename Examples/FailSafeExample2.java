import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class FailSafeExample2 {
    public static void main(String[] args) {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");

        // Get an iterator
        Iterator<String> iterator = map.keySet().iterator();

        // Iterate over the map
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ": " + map.get(key));

            // Modify the map while iterating
            map.put("4", "Four");
        }

        // Print the final map after modification
        System.out.println("Final map: " + map);

        List<String> strList = Arrays.asList("apple", "banana", "orange");

        String res = strList.stream()
                .map(fruit -> fruit.toUpperCase())
                .collect(Collectors.joining(","));
        System.out.println("Final res: " + res);

    }
}
