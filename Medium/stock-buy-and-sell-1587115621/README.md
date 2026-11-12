# Stock Buy and Sell

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1](https://www.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1)  
**Problem ID:** `701212`  
**Slug:** `stock-buy-and-sell-1587115621`  
**Accepted Submission Date:** `2026-11-12 09:42:57`  

---

## Problem Statement

Given an array `arr[]` denoting the cost of stock on each day, find the maximum total profit if we can buy and sell the stocks any number of times.

**Note:** We can only sell a stock which we have bought earlier and only one instance of stock can be traded at a time.

**Examples:**
```text
Input: arr[] = [100, 180, 260, 310, 40, 535, 695]
Output: 865
Explanation: Buy on day 0 and sell on day 3 (profit: 310 - 100 = 210), buy on day 4 and sell on day 6 (profit: 695 - 40 = 655). Total = 865.
```
```text
Input: arr[] = [4, 2, 2, 2, 4]
Output: 2
Explanation: Buy on day 3 and sell on day 4 (profit: 4 - 2 = 2).
```

**Constraints:**
- $1 \le 	ext{arr.size()} \le 10^5$
- $0 \le 	ext{arr}[i] \le 10^4$

---

## Solution & Approach

### Approach Explanation

Greedy approach (Peak Valley / Daily Profit Harvesting):
1. Whenever the stock price of day $i$ is strictly greater than day $i - 1$, capture the difference `arr[i] - arr[i - 1]` as profit.
2. Accumulating all positive day-to-day differences is mathematically equivalent to buying at every local minimum and selling at every subsequent local maximum.
3. Return the accumulated total profit.

### Complexity Analysis
- **Time Complexity:** O(n) where n is the length of array arr
- **Auxiliary Space:** O(1) auxiliary space

---

## Source Code

```java
class Solution {

    int maxProfit(int arr[]) {

        int n = arr.length;

        int profit = 0;

        for (int i = 1; i < n; i++) {

            // If today's price is greater than yesterday's
            if (arr[i] > arr[i - 1]) {

                profit += arr[i] - arr[i - 1];
            }
        }

        return profit;
    }
}
```

- **Original Solution File:** [`Solution.java`](./Solution.java) (`SHA-256: 690a6637b9d28fe2514fb05e6ba924e104172c45d4203b6e91912faf738885d6`)
