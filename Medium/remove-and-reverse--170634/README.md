# Remove and Reverse

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/remove-and-reverse--170634/1](https://www.geeksforgeeks.org/problems/remove-and-reverse--170634/1)  
**Problem ID:** `709208`  
**Slug:** `remove-and-reverse--170634`  
**Accepted Submission Date:** `2026-11-27 00:25:22`  

---

## Problem Statement

Given a string **s **which consists of only lowercase English alphabets.

You need to perform the below operations while there is a repeating character
- Remove the first repeating character and reverse the string
- Again perform the above operation on the modified string if there is a repeating character.

Find the final string after all possible operations.

**Examples:**
```text
**Input: **s = "abab"
**Output:** "ba"
**Explanation:
**In 1st operation the first repeating character is 'a'. After Removing the first character, s = "bab". After Reversing the string, s = "bab".
In 2nd operation the first repeating character is 'b'. After Removing the first character, s = "ab". After Reversing the  string, s = "ba". Now the string s does not contain any repeating character.
```

```text
**Input:** s = "dddd"
**Output:** "d"
**Explanation:
**In 1st operation the first repeating character is 'd'. After Removing the first character, s = "ddd". After Reversing the string, s = "ddd". 
In 2nd operation, Similarly, s = "dd".
In 3rd operation, Similarly, s = "d".
Now the string s does not contain any repeating character.

```

---

## Solution & Approach

### Approach Explanation

Bidirectional Traversal with Frequency Tracking:
1. Calculate the initial frequency of each character in string s using an array freq[26].
2. Store characters in a LinkedList to support bidirectional iteration and in-place removals.
3. Maintain a boolean flag reversed to track logical traversal direction (forward or backward).
4. In each step, scan in the current direction until the first character with freq[ch] > 1 is encountered.
5. Remove that character occurrence, decrement its frequency, and toggle reversed.
6. Repeat until no character has frequency > 1. Build and return the final string according to the final reversed orientation.

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {
    String removeReverse(String s) {

        LinkedList<Character> list = new LinkedList<>();
        int[] freq = new int[26];

        // Store characters and calculate frequencies
        for (char ch : s.toCharArray()) {
            list.add(ch);
            freq[ch - 'a']++;
        }

        boolean reversed = false;

        while (true) {

            // Traverse according to the current direction
            Iterator<Character> it;

            if (reversed) {
                it = list.descendingIterator();
            } else {
                it = list.iterator();
            }

            boolean found = false;

            while (it.hasNext()) {
                char ch = it.next();

                // Find the first repeating character
                if (freq[ch - 'a'] > 1) {

                    // Remove its first occurrence
                    it.remove();

                    // Update frequency
                    freq[ch - 'a']--;

                    found = true;
                    break;
                }
            }

            // Stop if no repeating character exists
            if (!found) {
                break;
            }

            // Reverse the logical direction
            reversed = !reversed;
        }

        // Construct the final string
        StringBuilder result = new StringBuilder();

        if (reversed) {
            Iterator<Character> it = list.descendingIterator();

            while (it.hasNext()) {
                result.append(it.next());
            }
        } else {
            for (char ch : list) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
```
