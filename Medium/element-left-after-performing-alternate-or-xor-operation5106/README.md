# Array Queries with OR and XOR

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/element-left-after-performing-alternate-or-xor-operation5106/1](https://www.geeksforgeeks.org/problems/element-left-after-performing-alternate-or-xor-operation5106/1)  
**Problem ID:** `705171`  
**Slug:** `element-left-after-performing-alternate-or-xor-operation5106`  
**Accepted Submission Date:** `2026-11-26 11:00:52`  

---

## Problem Statement

Given **arr[] **of **n** integers and **q** queries. Each query consists of an index and a value, assign the value to arr[index] (this update persists for all subsequent queries too), then compute a single value using the following recursive rule.

For a segment arr[l..r]:
- If l == r, its value is just arr[l].
- Otherwise, split it at mid = (l + r) / 2 into arr[l..mid] and arr[mid+1..r], and recursively compute each half's value.
- Combine the two values using bitwise OR if ceil(log2(r - l + 1)) is odd, or bitwise XOR if it's even.

The value obtained for the whole array arr[0..n-1] is the answer for that query.

If the given index is outside the valid range of the array (index >= n), return -1 for that query and do not modify the array.

**Examples:**
```text
**Input: **arr[] = [1, 4, 5, 6], q = 2, queries[][] = [[0, 2], [3, 5]]**
Output: **[1, 3]**
Explanation:
**For query [0, 2], update arr[0] = 2. Array becomes [2, 4, 5, 6].
Step 1: Split [0..3] at mid = (0 + 3)/2 = 1 into [0..1] and [2..3].
Step 2: Compute [0..1]: split into [0..0] = 2 and [1..1] = 4. Size 2, ceil(log2(2)) = 1 (odd) -> OR: 2|4 = 6.
Step 3: Compute [2..3]: split into [2..2] = 5 and [3..3] = 6. Size 2, OR: 5|6=7.
Step 4: Combine [0..1] = 6 and [2..3] = 7: size of [0..3] is 4, ceil(log2(4)) = 2 (even) -> XOR: 6^7 = 1.
Result = 1.

For query [3, 5], update arr[3] = 5. Array becomes [2, 4, 5, 5] (the earlier update to index 0 is still in effect).
Step 1: Split [0..3] into [0..1] and [2..3].
Step 2: Compute [0..1]: 2|4 = 6 (same as before).
Step 3: Compute [2..3]: split into [2..2] = 5 and [3..3]=5. OR: 5|5 = 5.
Step 4: Combine [0..1] = 6 and [2..3] = 5: size 4, XOR: 6^5 = 3.
Result = 3.
```

```text
**Input:** arr[] = [2, 3, 5, 7, 1], q = 1, queries[][] = [[0, 2]]
**Output:** [7]
**Explanation:**
Array size is odd (n = 5). Update arr[0] = 2 (no change here, since it was already 2).
Step 1: Split [0..4] at mid = (0+4)/2 = 2 into [0..2] and [3..4].
Step 2: Compute [0..2]:
  - Split [0..2] at mid = (0+2)/2=1 into [0..1] and [2..2].
  - Compute [0..1]: split into [0..0] = 2 and [1..1] = 3. Size 2, ceil(log2(2)) = 1 (odd) -> OR: 2|3 = 3.
  - Compute [2..2]: single element, value = 5.
  - Combine [0..1] = 3 and [2..2] = 5: size of [0..2] is 3, ceil(log2(3)) = 2 (even) -> XOR: 3^5 = 6.
Step 3: Compute [3..4]:
  - Split into [3..3] = 7 and [4..4] = 1.
  - Combine them: size of [3..4] is 2, ceil(log2(2)) = 1 (odd) -> OR: 7|1 = 7.
Step 4: Combine [0..2] = 6 and [3..4] = 7: size of [0..4] is 5, ceil(log2(5)) = 3 (odd) -> OR: 6|7 = 7.
Result = 7.
```

---

## Solution & Approach

### Approach Explanation

Segment Tree with Alternating Operations:
1. The problem involves updating array elements and finding the reduced value after alternating OR and XOR levels (similar to a tournament tree).
2. Build a Segment Tree where the operation at each tree level alternates between bitwise OR (`|`) and bitwise XOR (`^`) depending on tree depth / height.
3. For point updates `query[i] = [index, val]`, update the leaf node in O(log n) and pull values up while alternating OR and XOR operations at each level.
4. The root node `tree[1]` holds the reduced value after all operations. Collect results for each query.

### Complexity Analysis
- **Time Complexity:** O(n + q * log n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    int[] tree;

    // Calculate ceil(log2(length))
    private int ceilLog2(int length) {

        if (length <= 1) {
            return 0;
        }

        return 32 - Integer.numberOfLeadingZeros(length - 1);
    }

    // Combine two child values
    private int combine(int left, int right, int length) {

        int k = ceilLog2(length);

        if (k % 2 == 1) {
            return left | right;
        } else {
            return left ^ right;
        }
    }

    // Build segment tree
    private void build(int[] arr, int node, int l, int r) {

        if (l == r) {
            tree[node] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(arr, 2 * node, l, mid);
        build(arr, 2 * node + 1, mid + 1, r);

        tree[node] = combine(
            tree[2 * node],
            tree[2 * node + 1],
            r - l + 1
        );
    }

    // Update one array element
    private void update(int node, int l, int r,
                        int index, int value) {

        if (l == r) {
            tree[node] = value;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {

            update(2 * node, l, mid, index, value);

        } else {

            update(2 * node + 1, mid + 1, r, index, value);
        }

        // Recalculate the current node
        tree[node] = combine(
            tree[2 * node],
            tree[2 * node + 1],
            r - l + 1
        );
    }

    public ArrayList<Integer> left(int[] arr, int[][] query) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;

        tree = new int[4 * n];

        // Build the initial segment tree
        build(arr, 1, 0, n - 1);

        // Process queries in order
        for (int[] q : query) {

            int index = q[0];
            int value = q[1];

            // Invalid index: do not update
            if (index >= n) {
                result.add(-1);
                continue;
            }

            // Update the original array
            arr[index] = value;

            // Update segment tree
            update(1, 0, n - 1, index, value);

            // Root stores the complete array's value
            result.add(tree[1]);
        }

        return result;
    }
}
```
