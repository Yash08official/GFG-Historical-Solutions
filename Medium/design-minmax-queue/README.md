# Design MinMax Queue

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/design-minmax-queue/1](https://www.geeksforgeeks.org/problems/design-minmax-queue/1)  
**Problem ID:** `912110`  
**Slug:** `design-minmax-queue`  
**Accepted Submission Date:** `2026-11-24 11:16:30`  

---

## Problem Statement

Design a **SpecialQueue **data structure that functions like a normal queue but with additional support for retrieving the minimum and maximum element efficiently.
The SpecialQueue must support the following operations:
- **enqueue(x): **Insert an element x at the rear of the queue.
- **dequeue(): **Remove the element from the front of the queue.
- **getFront(): **Return the front element without removing.
- **getMin(): **Return the minimum element in the queue in O(1) time.
- **getMax(): **Return the maximum element in the queue in O(1) time.

There will be a sequence of queries **queries****[][]**. The queries are represented in numeric form:
- **1 x : **Call enqueue(x)
- **2:  **Call dequeue()
- **3: **Call getFront()
- **4: **Call getMin()
- **5: **Call getMax()

The driver code will process the queries, call the corresponding functions, and print the outputs of getFront(), getMin(), getMax() operations.
You only need to implement the above five functions.

**Note: **It is guaranteed that all the queries are valid.

**Examples:**
```text
**Input: **queries[][] = [[1, 4], [1, 2], [3], [4], [2], [5]]**
Output: **[4, 2, 2]**
Explanation: **Queries on queue are as follows:
enqueue(4): Insert 4 at the rear of the queue.
enqueue(2): Insert 2 at the rear of the queue.
return the front element i.e 4
return minimum element from the queue i.e 2
dequeue(): Remove the front element 4 from the queue
return maximum element from the queue i.e 2
```

```text
**Input:** queries[][] = [[1, 3], [4], [1, 5], [5]]**
Output: **[3, 5]**
Explanation: **Queries on queue are as follows:**
**enqueue(3): Insert 3 at the rear of the queue.
return minimum element from the queue i.e 3
enqueue(5): Insert 5 at the rear of the queue.
return maximum element from the queue i.e 5
```

**Constraints:
**1 ≤ queries.size() ≤ 105
0 ≤ values in the queue ≤ 109

---

## Solution & Approach

### Approach Explanation

Monotonic Double-Ended Queues for O(1) Amortized Min & Max:
1. Standard FIFO `queue` preserves insertion order for `getFront()` and `dequeue()`.
2. Monotonic `minDeque` maintains elements in non-decreasing order by popping larger elements from the rear before enqueuing.
3. Monotonic `maxDeque` maintains elements in non-increasing order by popping smaller elements from the rear before enqueuing.
4. On `dequeue()`, if the removed element equals the front of `minDeque` or `maxDeque`, pop from the corresponding deque.
5. `getMin()` and `getMax()` access the front elements in O(1) time.

### Complexity Analysis
- **Time Complexity:** O(1) amortized for enqueue/dequeue, O(1) worst-case for getFront/getMin/getMax
- **Auxiliary Space:** O(n) for queue and monotonic deques

---

## Source Code

```java
import java.util.*;

class SpecialQueue {

    Queue<Integer> queue;
    Deque<Integer> minDeque;
    Deque<Integer> maxDeque;

    public SpecialQueue() {
        queue = new LinkedList<>();
        minDeque = new ArrayDeque<>();
        maxDeque = new ArrayDeque<>();
    }

    public void enqueue(int x) {

        queue.offer(x);

        // Maintain increasing order in minDeque
        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.offerLast(x);

        // Maintain decreasing order in maxDeque
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(x);
    }

    public void dequeue() {

        int removed = queue.poll();

        if (removed == minDeque.peekFirst()) {
            minDeque.pollFirst();
        }

        if (removed == maxDeque.peekFirst()) {
            maxDeque.pollFirst();
        }
    }

    public int getFront() {
        return queue.peek();
    }

    public int getMin() {
        return minDeque.peekFirst();
    }

    public int getMax() {
        return maxDeque.peekFirst();
    }
}
```
