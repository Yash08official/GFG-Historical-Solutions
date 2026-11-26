# Binary Array Sorting

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1](https://www.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1)  
**Problem ID:** `701223`  
**Slug:** `binary-array-sorting-1587115620`  
**Accepted Submission Date:** `2026-11-27 00:24:21`  

---

## Problem Statement

Given a binary array **arr[]**, where each element is either **0 **or **1**. Your task is to rearrange the array in increasing order in place (without using extra space). You do not need to return anything; simply modify the input array.

**Examples:**
```text
**Input**: arr[] = [1, 0, 1, 1, 0]
**Output**: [0, 0, 1, 1, 1]
**Explanation**: After arranging the elements in increasing order, elements will be as 0 0 1 1 1.
```

```text
**Input**: arr[] = [1, 0, 1, 1, 1, 1, 1, 0, 0, 0]
**Output**: [0, 0, 0, 0, 1, 1, 1, 1, 1, 1]
**Explanation**: After arranging the elements in increasing order, elements will be 0 0 0 0 1 1 1 1 1 1.
```

```text
**Input**: arr[] = [1, 1, 1, 1]
**Output**: [1, 1, 1, 1]
**Explanation**: Since the array already contains only `1`s, no change is needed.
```

**Constraints:**
1 ≤ arr.size() ≤ 106
**arr[i****]** ∈ {0,1} for all valid indices **i**.

---

## Solution & Approach

### Approach Explanation

Two-Pointer Partitioning:
1. Initialize left = 0 and right = arr.length - 1.
2. Advance left while arr[left] == 0.
3. Decrement right while arr[right] == 1.
4. If left < right, swap arr[left] and arr[right], then advance left and decrement right.
5. Continue until left >= right, partitioning all 0s before 1s in-place.

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {
    public void binSort(int[] arr) {
        
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // Skip zeros from the left
            while (left < right && arr[left] == 0) {
                left++;
            }

            // Skip ones from the right
            while (left < right && arr[right] == 1) {
                right--;
            }

            // Swap misplaced elements
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
}
```
