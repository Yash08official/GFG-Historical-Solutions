# Maximum Area Between Bars

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/maximum-area-between-bars/1](https://www.geeksforgeeks.org/problems/maximum-area-between-bars/1)  
**Problem ID:** `706064`  
**Slug:** `maximum-area-between-bars`  
**Accepted Submission Date:** `2026-11-27 00:26:20`  

---

## Problem Statement

Given an integer array **height[]**, where height[i] represents the height of the** **ith** **bar arranged in a row, find the **maximum** rectangular** area** that can be formed by selecting any two bars. The area is calculated based on the original positions of the selected bars.

**Examples :**

```text
**Input: **height[] = [2, 5, 4, 3, 7]**
Output: **10**
Explanation:

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929227/Web/Other/blobid0_1780468637.webp" />

**The maximum rectangular area is formed by selecting the bars of heights 5 and 7.
There are 2 bars between them, so the area is: min(5, 7) × 2 = 10

```

```text
**Input:** height[] = [1, 3, 4]
**Output: **1**
Explanation: **Selecting bars 1 and 4 gives one bar between them, so the area is: min(1, 4) × 1 = 1
```

**Constraints:**
1 ≤ height.size() ≤ 105
1 ≤ height[i] ≤ 104

---

## Solution & Approach

### Approach Explanation

Two-Pointer Area Maximization:
1. Initialize left = 0 and right = height.size() - 1.
2. The area between two bars is Math.min(height[left], height[right]) * (right - left - 1).
3. Update the maximum area observed so far.
4. Move the pointer pointing to the smaller bar inward (if height[left] < height[right], left++; otherwise right--) because a smaller bar limits the maximum possible area for all inward pairs with the other bar.

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(1)

---

## Source Code

```java
class Solution {
    public int maxArea(List<Integer> height) {

        int left = 0;
        int right = height.size() - 1;

        int maxArea = 0;

        while (left < right) {

            // Find the smaller height
            int minHeight = Math.min(
                height.get(left),
                height.get(right)
            );

            // Number of bars between the selected bars
            int width = right - left - 1;

            // Calculate area
            int area = minHeight * width;

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
```
