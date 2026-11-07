import java.util.*;

class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {

        HashSet<String> used = new HashSet<>();

        // Initially reserve all original usernames
        for (String name : arr) {
            used.add(name);
        }

        HashMap<String, Integer> nextSuffix = new HashMap<>();

        ArrayList<String> result = new ArrayList<>();

        for (String name : arr) {

            // First occurrence keeps original username
            if (!nextSuffix.containsKey(name)) {
                result.add(name);
                nextSuffix.put(name, 1);
            } 
            else {
                int suffix = nextSuffix.get(name);

                String candidate = name + suffix;

                while (used.contains(candidate)) {
                    suffix++;
                    candidate = name + suffix;
                }

                result.add(candidate);
                used.add(candidate);

                nextSuffix.put(name, suffix + 1);
            }
        }

        return result;
    }
}
