# Stack using Queue

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/stack-using-queue/1](https://www.geeksforgeeks.org/problems/stack-using-queue/1)  
**Problem ID:** `700198`  
**Slug:** `stack-using-queue`  
**Accepted Submission Date:** `2026-11-27 00:17:13`  

---

## Problem Statement

Implement a **Stack **using Queue data structure, this stack has no fixed capacity and can grow dynamically until memory is available.
The Stack must support the following operations:

**(i)**** push(x):** Insert an element x at the top of the stack.
**(ii)** **pop():** Remove the element from the top of the stack, if stack is empty do nothing.
**(iii)** **top():** Return top element if not empty, else -1.
**(iv)** **size()****:** Return the number of elements currently in the stack.

There will be a sequence of queries **queries[][]**. The queries are represented in numeric form:

- 1 x: Call push(x)
- 2: Call pop()
- 3: Call top()
- 4: Call size()

You just have to implement the functions push, pop, top and size. The driver code will handle the input and output.

**Examples:**
```text
**Input: **queries[][] = [[1, 5], [1, 3], [1, 4], [3], [2], [4]]
**Output: **[4, 2]**
Explanation: **Queries on queue are as follows:
push(5): Insert 5 at the top of the stack.
push(3): Insert 3 at the top of the stack.
push(4): Insert 4 at the top of the stack.
top(): Return the top element i.e 4.
pop(): Remove the top element 4 from the stack.
size(): Stack contains 2 elements return 2.
```

```text
**Input: **queries[][] = [[4], [3], [1, 10], [3]]
**Output: **[0, -1, 10]**
Explanation: **Queries on queue are as follows:
size(): Stack contains 0 elements return 0.
top(): Stack is empty return -1.
push(10): Insert 10 at the top of the stack.
top(): Return the top element i.e 10.
```

**Constraints:**
1 ≤ queries.size ≤ 100
0 ≤ x** **≤ 104

---

## Solution & Approach

### Approach Explanation

Single Queue Stack Implementation:
1. For push(x): Add x to the queue. For all previous elements (current queue size - 1), remove each from the front and re-insert at the back. This places the newly added element at the front of the queue.
2. For pop(): Dequeue the front element in O(1).
3. For top(): Return the front element in O(1) without removal.
4. For size(): Return queue size in O(1).

### Complexity Analysis
- **Time Complexity:** O(n) push, O(1) pop/top
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class myStack {

    Queue<Integer> q = new LinkedList<>();

    // Inserts an element at the top
    void push(int x) {

        q.add(x);

        int size = q.size();

        // Move previous elements behind the new element
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
    }

    // Removes the top element
    void pop() {

        if (!q.isEmpty()) {
            q.poll();
        }
    }

    // Returns the top element
    int top() {

        if (q.isEmpty()) {
            return -1;
        }

        return q.peek();
    }

    // Returns the current stack size
    int size() {

        return q.size();
    }
}
```
