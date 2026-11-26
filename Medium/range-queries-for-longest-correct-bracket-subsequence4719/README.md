# Longest Correct Bracket Subsequence

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/range-queries-for-longest-correct-bracket-subsequence4719/1](https://www.geeksforgeeks.org/problems/range-queries-for-longest-correct-bracket-subsequence4719/1)  
**Problem ID:** `701700`  
**Slug:** `range-queries-for-longest-correct-bracket-subsequence4719`  
**Accepted Submission Date:** `2026-11-26 13:33:41`  

---

## Problem Statement

Given a bracket sequence **s** consisting only of the characters '(' and ')', and a 2D array **queries[][]**, where each query is represented as [l, r] (0 based indexing), find the length of the longest correct bracket subsequence that can be formed from the substring s[l...r] (both indices inclusive).

Return an array where each element represents the answer for the corresponding query.

**Note:** Use 0-based indexing. A correct bracket sequence is a sequence in which every opening bracket '(' has a corresponding closing bracket ')' in the correct order.

**Examples:**
```text
**Input: **s = "())(())(())(", queries[][] = [[3, 6], [0, 11]]
**Output: **[4, 10]**
Explanation: 
**Query [3, 6]: The substring is "(())", which is already a correct bracket sequence. Hence the maximum correct bracket subsequence has length 4.
Query [0, 11]: The longest correct bracket subsequence is "()(())(())", whose length is 10.

```

```text
**Input: **s = "(()())())(", queries[][] = [[0, 5], [2, 9]]
**Output: **[6, 4]**
Explanation: **
Query [0, 5]: The substring is "(()())". It contains 3 matched pairs, so the answer is 6.
Query [2, 9]: The substring is ")()))()(". It contains 2 matched pairs, so the answer is 4.
```

**Constraints:**
1 ≤ arr.size(), q ≤ 104
0 ≤ l ≤ r ≤ arr.size()-1

---

## Solution & Approach

### Approach Explanation

Segment Tree for Balanced Parentheses Merging:
1. Each node in the segment tree tracks two values: `open` (number of unmatched opening brackets '(') and `close` (number of unmatched closing brackets ')').
2. Merging two segments `left` and `right`:
   - Number of newly matched pairs: `matched = Math.min(left.open, right.close)`
   - Unmatched open brackets: `parent.open = left.open + right.open - matched`
   - Unmatched close brackets: `parent.close = left.close + right.close - matched`
3. For range query `[l, r]`, query the segment tree for the merged state in O(log n).
4. Total matched characters in `[l, r]` is: `length = (r - l + 1) - ans.open - ans.close`.

### Complexity Analysis
- **Time Complexity:** O(n + q * log n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    static class Node {
        int open;
        int close;

        Node(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    Node[] tree;

    // Merge two segment tree nodes
    private Node merge(Node left, Node right) {

        int matched = Math.min(left.open, right.close);

        int open = left.open + right.open - matched;

        int close = left.close + right.close - matched;

        return new Node(open, close);
    }

    // Build segment tree
    private void build(String str, int node, int start, int end) {

        if (start == end) {

            if (str.charAt(start) == '(') {
                tree[node] = new Node(1, 0);
            } else {
                tree[node] = new Node(0, 1);
            }

            return;
        }

        int mid = start + (end - start) / 2;

        build(str, 2 * node, start, mid);

        build(str, 2 * node + 1, mid + 1, end);

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Range query
    private Node query(int node, int start, int end,
                       int l, int r) {

        // No overlap
        if (end < l || start > r) {
            return new Node(0, 0);
        }

        // Complete overlap
        if (start >= l && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        Node left = query(
            2 * node, start, mid, l, r
        );

        Node right = query(
            2 * node + 1, mid + 1, end, l, r
        );

        return merge(left, right);
    }

    ArrayList<Integer> longestSeq(String str, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = str.length();

        tree = new Node[4 * n];

        // Build the segment tree
        build(str, 1, 0, n - 1);

        // Process each query
        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            Node ans = query(1, 0, n - 1, l, r);

            int length = (r - l + 1) - ans.open - ans.close;

            result.add(length);
        }

        return result;
    }
}
```
