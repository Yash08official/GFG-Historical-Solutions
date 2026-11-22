# High-Rated and Expensive Products

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/high-rated-and-expensive-products--160106/1](https://www.geeksforgeeks.org/problems/high-rated-and-expensive-products--160106/1)  
**Problem ID:** `930921`  
**Slug:** `high-rated-and-expensive-products--160106`  
**Accepted Submission Date:** `2026-11-22 19:22:41`  

---

## Problem Statement

Given a Pandas DataFrame **products** containing information about products, return the product_id, product_name, rating, quantity_in_stock, and price of all products that are high-rated, in stock, and expensive. A product is considered high-rated and expensive if:

- The product has a rating of at least 4.5.

- The product is available in stock (quantity_in_stock > 0).

- The product price is at least 300.

Return the resulting DataFrame in any order.

**Pandas Schema:**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid0_1784370073.png" />

- **product_id: **Unique ID for each product (Primary key).

- **product_name: **The name of the product.

- **rating: **The rating of the product (float, ranging from 1 to 5).

- **quantity_in_stock: **The number of units available in stock.

- **price: **The price of the product.

**Example :**

**Input table:**

**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid1_1784370174.png" />

**

**Output table:**

**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid2_1784370231.png" />

**

---

## Solution & Approach

### Approach Explanation

Pandas Boolean Indexing & Column Filtering:
1. Define a vectorized compound boolean mask: `(rating >= 4.5) & (quantity_in_stock > 0) & (price >= 300)`.
2. Use `.loc` to filter rows matching the condition and project the requested columns (`product_id`, `product_name`, `rating`, `quantity_in_stock`, `price`).

### Complexity Analysis
- **Time Complexity:** O(N) vectorized filtering across N rows
- **Auxiliary Space:** O(N) for output DataFrame subset

---

## Source Code

```python
class Solution:
    def highRatedProducts(self, products):

        condition = (
            (products['rating'] >= 4.5) &
            (products['quantity_in_stock'] > 0) &
            (products['price'] >= 300)
        )

        return products.loc[
            condition,
            ['product_id', 'product_name', 'rating',
             'quantity_in_stock', 'price']
        ]
```
