# Implement Deque using DLL

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/implementation-of-deque-using-doubly-linked-list/1](https://www.geeksforgeeks.org/problems/implementation-of-deque-using-doubly-linked-list/1)  
**Problem ID:** `912366`  
**Slug:** `implementation-of-deque-using-doubly-linked-list`  
**Accepted Submission Date:** `2026-11-24 11:19:50`  

---

## Problem Statement

Implement a Deque (Double Ended Queue)** **using a doubly linked list. The Deque must support the following operations:

**(i)**** ****insertFront****(x):** Adds an element x at the front of Deque.
**(ii)** **insertRear****(x):** Adds an element x at the rear of Deque.
**(iii)** **deleteFront****():** Deletes an element from front of Deque. 
**(iv)** **deleteRear****():** Deletes an element from rear of Deque.
**(v)** **getFront****():** Gets the front element from queue. Return -1 if it is empty.
**(vi)** **getRear****():** Gets the last element from queue. Return -1 if it is empty.

There will be a sequence of queries **queries[][]**. The queries are represented in numeric form:

- 1 x : Call insertFront(x)
- 2 x : Call insertRear(x)
- 3 : Call deleteFront()
- 4 : Call deleteRear()
- 5 : Call getFront()
- 6 : Call getRear()

You just have to implement the functions insertFront, insertRear, deleteFront, deleteRear, getFront and getRear and the driver code will handle the input & output.

**Note: **It is guaranteed that all the queries are valid.

**Examples:**
```text
**Input: **queries[][] = [[1, 3], [2, 5], [1, 6], [6], [3], [5]]
**Output: **[5, 3]**
Explanation: **Queries on Deque are as follows:
insertFront(3): Insert 3 at the front of the Deque.
insertRear(5): Insert 5 at the rear of the Deque.
insertFront(6): Insert 6 at the front of the Deque.
getRear(): Return the rear element i.e 5.
deleteFront(): Remove the front element 6 from the Deque.
getFront(): Return the front element i.e 3.
```

```text
**Input: **queries[][] = [[2, 4], [3], [6], [5]]
**Output: **[-1, -1]**
Explanation: **Queries on Deque are as follows:
insertRear(4): Insert 4 at the rear of the Deque.
deleteFront(): Remove the front element 4 from the Deque.
getRear(): As the Deque is empty return -1.
getFront(): As the Deque is empty return -1.
```

**Constraints:**
1 ≤ number of query ≤ 103
0 ≤ x** **≤ 105

---

## Solution & Approach

### Approach Explanation

Doubly Linked List Deque Implementation:
1. Maintain `head` and `tail` pointers to the doubly linked list.
2. `insertFront(data)`: Prepend new node before `head` and update `head`.
3. `insertRear(data)`: Append new node after `tail` and update `tail`.
4. `deleteFront()`: Move `head` forward; if list becomes empty, set `tail = null`.
5. `deleteRear()`: Move `tail` backward; if list becomes empty, set `head = null`.
6. `getFront()` and `getRear()`: Return element data or `-1` if empty in O(1) time.

### Complexity Analysis
- **Time Complexity:** O(1) for all operations (insertFront, insertRear, deleteFront, deleteRear, getFront, getRear)
- **Auxiliary Space:** O(n) total space where n is number of stored elements

---

## Source Code

```java
class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

class myDeque {

    Node head;
    Node tail;

    myDeque() {
        head = null;
        tail = null;
    }

    void insertFront(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertRear(int data) {

        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void deleteFront() {

        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    void deleteRear() {

        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    int getFront() {

        if (head == null) {
            return -1;
        }

        return head.data;
    }

    int getRear() {

        if (tail == null) {
            return -1;
        }

        return tail.data;
    }
}
```
