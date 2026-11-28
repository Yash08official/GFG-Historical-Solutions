# Assign Short Codes in Stream of Words

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/renaming-cities28581833/1](https://www.geeksforgeeks.org/problems/renaming-cities28581833/1)  
**Problem ID:** `701771`  
**Slug:** `renaming-cities28581833`  
**Accepted Submission Date:** `2026-11-28 11:05:03`  

---

## Problem Statement

A railway department is renaming several cities, and the corresponding railway station codes must also be updated.

Given an array **cities[]** containing the names of **n cities** in the order they are renamed. Generate the station code for each city according to the following rules:

- If a city appears for the first time, its station code should be the shortest prefix of its name that is not a prefix of any previously processed city.

- If the city has already appeared before, then no unique prefix can be assigned. Instead, its station code should be the complete city name, followed by a space and its occurrence count (including the current occurrence).

Return an array containing the generated station codes for all the cities in the given order.

**Examples:**

```text
**Input: **cities[] = ["berlin", "bremen", "munich", "bonn", "berlin", "bochum"]
**Output: **["b", "br", "m", "bo", "berlin 2", "boc"]**
Explanation: 
**-> berlin is the first city, so b is assigned.
-> bremen cannot use b, so the shortest unique prefix is br.
-> munich starts with a new prefix, so m is assigned.
-> bonn shares b with previous cities, so bo is assigned.
-> bochum shares b and bo, so the shortest unique prefix is boc.

```

```text
**Input: **cities[] = ["rimini", "milan", "rome", "naples", "ravenna", "rome"]
**Output:** ["r", "m", "ro", "n", "ra", "rome 2"]
**Explanation:**
-> rimini is the first city, so r is assigned.
-> milan starts with a new prefix, so m is assigned.
-> rome cannot use r, so the shortest unique prefix is ro.
-> naples starts with a new prefix, so n is assigned.
-> ravenna shares r with previous cities, so the shortest unique prefix is ra.
-> rome appears for the second time, so its station code becomes rome 2.
```

**Constraints:**
1 <= cities.size() <= 106
1 <= cities[i].size() <= 100

---

## Solution & Approach

### Approach Explanation

Trie Prefix Frequency Tracking:
1. Track frequency of complete city names using a hash map. If a city has appeared before with count > 1, output `city + " " + count`.
2. For unique occurrences, insert the full city name into a Trie, incrementing the node visit count along the path.
3. Traverse the Trie again along the city's characters, building the prefix string until a node with visit count equal to 1 is encountered (the shortest unique prefix).
4. Append the shortest prefix to the result.

### Complexity Analysis
- **Time Complexity:** O(sum |city_i|)
- **Auxiliary Space:** O(sum |city_i|)

---

## Source Code

```java
import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    public ArrayList<String> renameCities(String[] cities) {

        TrieNode root = new TrieNode();

        HashMap<String, Integer> frequency = new HashMap<>();

        ArrayList<String> result = new ArrayList<>();

        for (String city : cities) {

            int occurrence = frequency.getOrDefault(city, 0) + 1;
            frequency.put(city, occurrence);

            // Handle repeated cities
            if (occurrence > 1) {
                result.add(city + " " + occurrence);
                continue;
            }

            // Step 1: Insert the COMPLETE city into Trie
            TrieNode current = root;

            for (char ch : city.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
                current.count++;
            }

            // Step 2: Find the shortest unique prefix
            current = root;

            StringBuilder prefix = new StringBuilder();

            for (char ch : city.toCharArray()) {

                int index = ch - 'a';

                current = current.children[index];

                prefix.append(ch);

                if (current.count == 1) {
                    break;
                }
            }

            result.add(prefix.toString());
        }

        return result;
    }
}
```
