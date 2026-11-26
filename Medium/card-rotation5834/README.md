# Initial Arrangement of Cards

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/card-rotation5834/1](https://www.geeksforgeeks.org/problems/card-rotation5834/1)  
**Problem ID:** `704864`  
**Slug:** `card-rotation5834`  
**Accepted Submission Date:** `2026-11-27 00:19:53`  

---

## Problem Statement

Given n cards numbered from 1 to n. We need to find an initial arrangement of these cards such that the following process removes the cards in the order 1, 2, 3, …, n.

Do the following for every number k from 1 to n:
- Move the first k cards of the deck to the back of the deck, one by one.
- After these k moves, pick the card at the front.
- This card must be equal to k.  If it is, remove it from the deck and continue. If it is not, then no valid arrangement exists.

If such an arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of n then output -1.

**Examples:**
```text
**Input**: n = 4
**Output: **[2, 1, 4, 3]
**Explanation**:
We initially have [2, 1, 4, 3]
Step1, we move the first card to the end. Deck now is: [1, 4, 3, 2]
Step2, we get 1. Hence we remove it. Deck now is: [4, 3, 2]
Step3, we move the 2 front cards one by one to the end  ([4, 3, 2] -> [3, 2, 4] -> [2, 4, 3]) Deck now is: [2, 4, 3].
Step4, we get 2. Hence we remove it. Deck now is: [4, 3]
Step5, we move the first 3 cards, [4, 3] -> [3, 4] -> [4, 3] -> [3, 4]. Deck now is: [3, 4] 
Step6, we get 3. Hence we remove it. Deck now is: [4] Finally, we're left with a single card and thus, we stop. 
```

```text
**Input : **n = 3**
Output:** [3, 1, 2]**
Explanation:
**We initially have [3, 1, 2]
Step1, we move the first card to the end. Deck now is : [1, 2, 3]
Step2, we get 1. Hence we remove it. Deck now is : [2,3]
Step3, we move the 2 front card on e by one to the end ([2,3] -> [3,2] -> [2,3]) Deck now is : [2, 3].
Step4, we get 2. Hence we remove it. Deck now is : [3] Finally, we're left with single card and thus, we stop.
```

**
Constraints:**
1 ≤ n ≤ 1000

---

## Solution & Approach

### Approach Explanation

Queue Simulation of Card Dealing:
1. Initialize a queue containing indices 0 to n - 1 representing available card positions.
2. For card value k from 1 to n:
   - Simulate moving k cards to the back by polling k elements from the front of the queue and adding them back.
   - The next polled index from the queue is where card k is placed in the output array.
3. Return the populated card arrangement.

### Complexity Analysis
- **Time Complexity:** O(n^2)
- **Auxiliary Space:** O(n)

---

## Source Code

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> rotation(int n) {

        ArrayList<Integer> result = new ArrayList<>(
            Collections.nCopies(n, 0)
        );

        Queue<Integer> q = new LinkedList<>();

        // Store all available positions
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        for (int k = 1; k <= n; k++) {

            // Move first k positions to the back
            for (int j = 0; j < k; j++) {
                q.add(q.poll());
            }

            // Place card k at the next position
            int position = q.poll();
            result.set(position, k);
        }

        return result;
    }
}
```
