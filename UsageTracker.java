//This tracks the times each club is used using a hashmap

import java.util.HashMap;
import java.util.Map;

public class UsageTracker {
    private final HashMap<String, Integer> usageMap = new HashMap<>();

    public void useClub(String name) {
        usageMap.put(name, usageMap.getOrDefault(name, 0) + 1);
        System.out.println("Marked use of: " + name);
    }

    public void printMostUsed() {
        if (usageMap.isEmpty()) {
            System.out.println("No usage data.");
            return;
        }

        System.out.println("Most used clubs:");
        usageMap.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(5)
                .forEach(entry ->
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " uses"));
    }
}