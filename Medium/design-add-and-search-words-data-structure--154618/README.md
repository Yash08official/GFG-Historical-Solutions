# Search Patterns with Dot in Dictionary

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/design-add-and-search-words-data-structure--154618/1](https://www.geeksforgeeks.org/problems/design-add-and-search-words-data-structure--154618/1)  
**Problem ID:** `876601`  
**Slug:** `design-add-and-search-words-data-structure--154618`  
**Accepted Submission Date:** `2026-11-28 11:09:36`  

---

## Problem Statement

Given two arrays of strings ****d[]**** and ****words[]****, where d[] contains a set of dictionary words and words[] contains search patterns. For each pattern in words[], determine whether it matches any word in d[].

A pattern matches a dictionary word if:
-  Both strings have the same length. 
-  Every character matches at the same position. 
-  A (.) dot in the pattern can match any single lowercase alphabet. 

Return the number of patterns in words[] that match at least one word in d[].

**Examples:**
```text
****Input:**** d[] = ["bad", "dad", "mad"], words[] = ["pad", "bad", ".ad", "b.."]  
****Output:**** 3  
****Explanation:**** 
"pad" → No match 
"bad" → Matches "bad" 
".ad" → Matches "bad", "dad", and "mad" 
"b.." → Matches "bad"  
Therefore, 3 patterns have at least one matching word.
```

```text
****Input: ****d[] = ["cat", "car", "dog", "door"], words[] = ["c.t", "ca.", "d..", "do.", "....."]  
****Output: ****4  
****Explanation: ****
"c.t"  → Matches "cat"
"ca."  → Matches "cat" or "car" 
"d.."  → Matches "dog" 
"do."  → Matches "dog" 
"....." → No match because there is no 5-letter dictionary word. 
Therefore, 4 patterns have at least one matching word.

```

**Constraints:**

1 ≤ m ≤ 10^4, m = size of d[]
1 ≤ n ≤ 10^4, n = size of words[]
1 ≤ |d[i]|, |words[i]| ≤ 10
d[i] contains only lowercase English letters. 
words[i] contains lowercase English letters and dot(.)

---

## Solution & Approach

### Approach Explanation

Trie with Wildcard DFS Search:
1. Build a Trie by inserting all words from dictionary `d`.
2. For each query pattern in `words`, perform a recursive depth-first search on the Trie starting from the root at character index 0.
3. When a standard character is encountered, follow the single corresponding Trie child.
4. When a dot `.` wildcard is encountered, branch into all 26 non-null child nodes and return true if any branch leads to a valid word match.
5. Increment match count if the pattern search succeeds.

### Complexity Analysis
- **Time Complexity:** O(sum |d_i| + sum 26^k)
- **Auxiliary Space:** O(sum |d_i|)

---

## Source Code

```java
class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    public int countMatches(String[] d, String[] words) {

        TrieNode root = new TrieNode();

        // Insert dictionary words into Trie
        for (String word : d) {

            TrieNode current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.isEndOfWord = true;
        }

        int answer = 0;

        // Check every search pattern
        for (String pattern : words) {

            if (search(root, pattern, 0)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean search(TrieNode current, String pattern, int index) {

        // All pattern characters have been processed
        if (index == pattern.length()) {
            return current.isEndOfWord;
        }

        char ch = pattern.charAt(index);

        // Dot can match any one character
        if (ch == '.') {

            for (int i = 0; i < 26; i++) {

                if (current.children[i] != null) {

                    if (search(current.children[i], pattern, index + 1)) {
                        return true;
                    }
                }
            }

            return false;
        }

        // Normal character: follow only the matching child
        int position = ch - 'a';

        if (current.children[position] == null) {
            return false;
        }

        return search(current.children[position], pattern, index + 1);
    }
}
```
