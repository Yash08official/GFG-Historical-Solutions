# Deque using Circular Array

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/implementation-of-deque-using-circular-array--174925/1](https://www.geeksforgeeks.org/problems/implementation-of-deque-using-circular-array--174925/1)  
**Problem ID:** `912156`  
**Slug:** `implementation-of-deque-using-circular-array--174925`  
**Accepted Submission Date:** `2026-11-24 11:17:52`  

---

## Problem Statement

Implement a **Deque **(Double Ended Queue)** **using a circular array, where the size of the array, **n** is given.
The Deque must support the following operations:

**(i)**** ****insertFront****(x):** Adds an element x at the front of Deque.
**(ii)** **insertRear****(x):** Adds an element x at the rear of Deque.
**(iii)** **deleteFront****():** Deletes an element from front of Deque. 
**(iv)** **deleteRear****():** Deletes an element from rear of Deque.
**(v)** **frontEle****():** Gets the front element from queue. Return -1 if it is empty.
**(vi)** **rearEle****():** Gets the last element from queue. Return -1 if it is empty.

There will be a sequence of queries **queries[][]**. The queries are represented in numeric form:

- 1 x : Call insertFront(x)
- 2 x : Call insertRear(x)
- 3 : Call deleteFront()
- 4 : Call deleteRear()
- 5 : Call frontEle()
- 6 : Call rearEle()

You just have to implement the functions **insertFront****, ****insertRear****, ****deleteFront****, ****deleteRear****, ****frontEle **and **rearEle**** **and the driver code will handle the input & output.

**Note: **It is guaranteed that all the queries are valid.

**Examples:**
```text
**Input: **n = 3, queries[][] = [[1, 3], [2, 5], [1, 6], [6], [3], [5]]
**Output: **[5, 3]**
Explanation: **Queries on Deque are as follows:
insertFront(3): Insert 3 at the front of the Deque.
insertRear(5): Insert 5 at the rear of the Deque.
insertFront(6): Insert 6 at the front of the Deque.
rearEle(): Return the rear element i.e 5.
deleteFront(): Remove the front element 6 from the Deque.
frontEle(): Return the front element i.e 3.
```

```text
**Input: **n = 2, queries[][] = [[2, 4], [3], [6], [5]]
**Output: **[-1, -1]**
Explanation: **Queries on Deque are as follows:
insertRear(4): Insert 4 at the rear of the Deque.
deleteFront(): Remove the front element 4 from the Deque.
rearEle(): As the Deque is empty return -1.
frontEle(): As the Deque is empty return -1.
```

**Constraints:**
1 ≤ n ≤ 103
1 ≤ number of query ≤ 103
0 ≤ x** **≤ 105

---

## Solution & Approach

### Approach Explanation

Circular Buffer Deque Implementation:
1. Maintain fixed-capacity array `arr`, `front` pointer, current `size`, and maximum `capacity`.
2. `insertFront(x)`: Decrement `front = (front - 1 + capacity) % capacity`, store `x`, increment `size`.
3. `insertRear(x)`: Compute `rear = (front + size) % capacity`, store `x`, increment `size`.
4. `deleteFront()`: Increment `front = (front + 1) % capacity`, decrement `size`.
5. `deleteRear()`: Decrement `size`.
6. `frontEle()` and `rearEle()`: Access front element and `(front + size - 1) % capacity` in O(1) time.

### Complexity Analysis
- **Time Complexity:** O(1) for all operations
- **Auxiliary Space:** O(capacity) for circular array storage

---

## Source Code

```java
class myDeque {

    int[] arr;
    int front;
    int size;
    int capacity;

    public myDeque(int n) {
        arr = new int[n];
        capacity = n;
        front = 0;
        size = 0;
    }

    public void insertFront(int x) {

        if (size == capacity) {
            return;
        }

        front = (front - 1 + capacity) % capacity;
        arr[front] = x;
        size++;
    }

    public void insertRear(int x) {

        if (size == capacity) {
            return;
        }

        int rear = (front + size) % capacity;

        arr[rear] = x;
        size++;
    }

    public void deleteFront() {

        if (size == 0) {
            return;
        }

        front = (front + 1) % capacity;
        size--;

        if (size == 0) {
            front = 0;
        }
    }

    public void deleteRear() {

        if (size == 0) {
            return;
        }

        size--;

        if (size == 0) {
            front = 0;
        }
    }

    public int frontEle() {

        if (size == 0) {
            return -1;
        }

        return arr[front];
    }

    public int rearEle() {

        if (size == 0) {
            return -1;
        }

        int rear = (front + size - 1) % capacity;

        return arr[rear];
    }
}
```
