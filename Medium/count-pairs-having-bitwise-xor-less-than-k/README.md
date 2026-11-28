# XOR Pairs less than K

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/count-pairs-having-bitwise-xor-less-than-k/1](https://www.geeksforgeeks.org/problems/count-pairs-having-bitwise-xor-less-than-k/1)  
**Problem ID:** `916604`  
**Slug:** `count-pairs-having-bitwise-xor-less-than-k`  
**Accepted Submission Date:** `2026-11-28 11:06:14`  

---

## Problem Statement

Given an array **arr[]** and an integer **k,** we need to count the number of pairs from the given array such that the Bitwise XOR of each pair is less than k.

**Examples:**

```text
**Input: **arr = [1, 2, 3, 5], k = 5 **
****Output:** 4**
Explanation: **Bitwise XOR of all possible pairs that satisfy the given conditions are:
arr[0] ^ arr[1] = 1 ^ 2 = 3 
arr[0] ^ arr[2] = 1 ^ 3 = 2 
arr[0] ^ arr[3] = 1 ^ 5 = 4 
arr[1] ^ arr[2] = 2 ^ 3 = 1 
Therefore, the required output is 4.
```

```text
**Input: **arr[] = [3, 5, 6, 8], k = 7 **
****Output: **3
**Explnation: **Bitwise XOR of all possible pairs that satisfy the given conditions are:
arr[0] ^ arr[1] = 6
arr[0] ^ arr[2] = 5
arr[1] ^ arr[2] = 3
Therefore, the required output is 3. 
```

**Constraints:**
1 ≤ arr.size(), k ≤ 5*104
1 ≤ arr[i] ≤ 5*104

---

## Solution & Approach

### Approach Explanation

Binary Bitwise Trie Prefix Counting:
1. Maintain a binary Trie (alphabet size 2 for bits 0 and 1) storing the binary representations of elements inserted so far up to bit 16.
2. Each Trie node maintains a `count` of elements passing through it.
3. For each incoming number `num`:
   - At each bit from 16 down to 0, if the corresponding bit of k is 1: all numbers in the subtree that match the bit of `num` will yield a bit of 0 upon XOR, which is strictly less than k's bit of 1. Add their `count` to the answer and branch into the opposite child.
   - If k's bit is 0: the XOR bit must be 0 to not exceed k, so branch only into the matching child.
4. Insert `num` into the Trie and continue.

### Complexity Analysis
- **Time Complexity:** O(17 * n) = O(n)
- **Auxiliary Space:** O(17 * n) = O(n)

---

## Source Code

```java
class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count = 0;
    }

    private void insert(TrieNode root, int num) {
        TrieNode current = root;

        for (int bit = 16; bit >= 0; bit--) {
            int value = (num >> bit) & 1;

            if (current.children[value] == null) {
                current.children[value] = new TrieNode();
            }

            current = current.children[value];
            current.count++;
        }
    }

    private int countLessThan(TrieNode root, int num, int k) {
        TrieNode current = root;
        int result = 0;

        for (int bit = 16; bit >= 0; bit--) {

            if (current == null) {
                break;
            }

            int numBit = (num >> bit) & 1;
            int kBit = (k >> bit) & 1;

            if (kBit == 1) {

                // XOR bit 0 makes the current XOR prefix smaller
                if (current.children[numBit] != null) {
                    result += current.children[numBit].count;
                }

                // Continue with XOR bit 1
                current = current.children[1 - numBit];

            } else {

                // XOR bit must be 0
                current = current.children[numBit];
            }
        }

        return result;
    }

    public int cntPairs(int[] arr, int k) {

        TrieNode root = new TrieNode();
        int answer = 0;

        for (int num : arr) {

            // Count valid pairs with previously inserted numbers
            answer += countLessThan(root, num, k);

            // Insert current number
            insert(root, num);
        }

        return answer;
    }
}
```
