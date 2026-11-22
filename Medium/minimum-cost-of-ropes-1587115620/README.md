# Min Cost to Connect Ropes

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1](https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1)  
**Problem ID:** `701357`  
**Slug:** `minimum-cost-of-ropes-1587115620`  
**Accepted Submission Date:** `2026-11-22 19:27:16`  

---

## Problem Statement

Given an array, **arr[]** of rope lengths, connect all ropes into a single rope with the minimum total cost. The cost to connect two ropes is the sum of their lengths. Return the minimum possible cost.

**Examples:**

```text
**Input: **arr[] = [4, 3, 2, 6]
**Output: **29**
Explanation:** First connect 2 and 3 to get [4, 5, 6] with a cost of 5, then connect 4 and 5 to get [9, 6] with a cost of 9, and finally connect 9 and 6 to get one rope with a cost of 15, giving a total minimum cost of 29. Any other order, such as connecting 4 and 6 first, results in a higher total cost of 38.
```

```text
**Input: **arr[] = [4, 2, 7, 6, 9]
**Output: **62 
**Explanation: **First, connect ropes 4 and 2, which makes the array [6, 7, 6, 9]. Cost of this operation 4 + 2 = 6. Next, add ropes 6 and 6, which results in [12, 7, 9]. Cost of this operation 6 + 6 = 12. Then, add 7 and 9, which makes the array [12,16]. Cost of this operation 7 + 9 = 16. And finally, add these two which gives [28]. Hence, the total cost is 6 + 12 + 16 + 28 = 62.

```

```text
**Input: **arr[] = [10]
**Output: **0
**Explanation**: Since there is only one rope, no connections are needed, so the cost is 0.
```

---

## Solution & Approach

### Approach Explanation

Greedy Approach using Min Heap (PriorityQueue):
1. Insert all rope lengths into a min-priority queue.
2. While more than one rope remains in the queue, extract the two smallest ropes.
3. Connect them, accumulate their sum into total cost, and insert the connected rope length back into the heap.
4. Return total accumulated connection cost.

### Complexity Analysis
- **Time Complexity:** O(n log n) where n is the number of ropes
- **Auxiliary Space:** O(n) for the min-heap

---

## Source Code

```java
import java.util.*;

class Solution {
    public int minCost(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all rope lengths into Min Heap
        for (int rope : arr) {
            pq.add(rope);
        }

        int totalCost = 0;

        // Connect ropes until only one remains
        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            int cost = first + second;

            totalCost += cost;

            // Add the newly connected rope
            pq.add(cost);
        }

        return totalCost;
    }
}
```
