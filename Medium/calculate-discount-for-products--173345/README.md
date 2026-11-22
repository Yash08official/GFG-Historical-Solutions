# Calculate Discount for Products

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/calculate-discount-for-products--173345/1](https://www.geeksforgeeks.org/problems/calculate-discount-for-products--173345/1)  
**Problem ID:** `930960`  
**Slug:** `calculate-discount-for-products--173345`  
**Accepted Submission Date:** `2026-11-22 19:20:18`  

---

## Problem Statement

Given a DataFrame **products **containing information about products, determine the discount for each product. A product receives a discount equal to its price if product_id is even and category starts with 'A'; otherwise, the discount is 0.

Return a DataFrame containing the product_id and corresponding discount for each product, ordered by product_id in ascending order.

**Pandas Schema:**

**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid0_1784548729.png" />

**

- **product_id:** The unique ID for each product (Primary key).

- **category:** The category of the product.

- **price: **The price of the product.

**Example:**

**Input table:**

**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/930960/Web/Other/blobid1_1786519293.png" />

**

**Output table:**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/930960/Web/Other/blobid0_1786519276.png" />

**Explanation: **The result contains product_id and the corresponding discount.

- Product 1: The product_id is odd, so no discount is applied. The discount is 0.

- Product 2: The product_id is even, and the category is Apricot, which starts with 'A'. Therefore, the discount is equal to its price, 200.

- Product 3: The product_id is odd, so no discount is applied. The discount is 0.

- Product 4: The product_id is even, and the category is Avocado, which starts with 'A'. Therefore, the discount is equal to its price, 400.

- Product 5: The product_id is odd, so no discount is applied. The discount is 0.

- Product 6: The product_id is even, and the category is Apple, which starts with 'A'. Therefore, the discount is equal to its price, 600.

---

## Solution & Approach

### Approach Explanation

Vectorized Conditional Computation with NumPy and Pandas:
1. Evaluate compound condition: `(product_id % 2 == 0) & (category.str.startswith('A'))`.
2. Apply `np.where(condition, price, 0)` to assign the discount column.
3. Select `product_id` and `discount` columns, sort by `product_id` in ascending order, and reset index.

### Complexity Analysis
- **Time Complexity:** O(N log N) dominated by sorting by product_id
- **Auxiliary Space:** O(N) for new column and output DataFrame

---

## Source Code

```python
import numpy as np

class Solution:
    def calculateDiscount(self, products):

        # Check both conditions
        condition = (
            (products['product_id'] % 2 == 0) &
            (products['category'].str.startswith('A'))
        )

        # Calculate discount
        products['discount'] = np.where(
            condition,
            products['price'],
            0
        )

        # Return required columns sorted by product_id
        return products[['product_id', 'discount']].sort_values(
            by='product_id'
        ).reset_index(drop=True)
```
