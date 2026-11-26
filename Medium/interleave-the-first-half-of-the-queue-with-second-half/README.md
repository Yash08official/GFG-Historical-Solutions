# Interleave the First Half of the Queue with Second Half

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/interleave-the-first-half-of-the-queue-with-second-half/1](https://www.geeksforgeeks.org/problems/interleave-the-first-half-of-the-queue-with-second-half/1)  
**Problem ID:** `710024`  
**Slug:** `interleave-the-first-half-of-the-queue-with-second-half`  
**Accepted Submission Date:** `2026-11-27 00:18:13`  

---

## Problem Statement

Given a queue **q** of **even **size, rearrange the queue by interleaving its **first half **with the** second half**.

**Interleaving** is the process of mixing two sequences by alternating their elements while preserving their relative order.
In other words, Interleaving means place the first element from the first half and then first element from the 2nd half and again second element from the first half and then second element from the 2nd half and so on.

**Examples:**
```text
**Input: **q = [2, 4, 3, 1]**
Output: **[2, 3, 4, 1]**
Explanation: **We place the first element of the first half 2 and after that place the first element of second half 3 and after that repeat the same process one more time so the resulting queue will be [2, 3, 4, 1]
```

```text
**Input: **q = [3, 5]**
Output: **[3, 5]**
Explanation: **We place the first element of the first half 3 and first element of the second half 5 so the resulting queue is [3, 5]
```

---

## Solution & Approach

### Approach Explanation

Queue Splitting and Alternating Interleave:
1. Dequeue the first half of the elements (n / 2) into an auxiliary queue firstHalf.
2. While firstHalf is not empty, alternate taking one element from firstHalf and adding it to q, followed by dequeuing one element from q (which belongs to the second half) and re-enqueuing it at the back.
3. The queue is now interleaved in-place.

### Complexity Analysis
- **Time Complexity:** O(n)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    public void rearrangeQueue(Queue<Integer> q) {

        int half = q.size() / 2;

        Queue<Integer> firstHalf = new LinkedList<>();

        // Step 1: Store the first half in another queue
        for (int i = 0; i < half; i++) {
            firstHalf.add(q.poll());
        }

        // Step 2: Interleave both halves
        while (!firstHalf.isEmpty()) {

            // Take one element from the first half
            q.add(firstHalf.poll());

            // Take one element from the second half
            q.add(q.poll());
        }
    }
}
```
