# Second Highest Salary

**Difficulty:** `Medium`  
**Official GFG Problem URL:** [https://www.geeksforgeeks.org/problems/second-highest-salary--162253/1](https://www.geeksforgeeks.org/problems/second-highest-salary--162253/1)  
**Problem ID:** `930926`  
**Slug:** `second-highest-salary--162253`  
**Accepted Submission Date:** `2026-11-22 19:21:35`  

---

## Problem Statement

Given a Pandas DataFrame **employee** containing employee salary information, find the second highest distinct salary. Return the result as a DataFrame with a single column named SecondHighestSalary. If there is no second highest distinct salary, return None in that column.

**Pandas Schema:**

**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid2_1784371590.png" />

**

- **id: **Unique ID for each employee (Primary key).

- **salary: **The salary of the employee.

**Example:**

**Input table:**

**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid3_1784371606.png" />

**

**Output table:**

**

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid4_1784371620.png" />

**

**Explanation:** The distinct salaries are 1200, 3500, 4800, 2900, 5000 and 4300. The second highest distinct salary is 4800.

---

## Solution & Approach

### Approach Explanation

Pandas Deduplication & Positional Indexing:
1. Extract the `salary` column, remove duplicate salaries via `.drop_duplicates()`, and sort descending.
2. If distinct salaries count is less than 2, return a DataFrame with `SecondHighestSalary: [None]`.
3. Otherwise, select the element at index 1 (`.iloc[1]`) and construct the result DataFrame.

### Complexity Analysis
- **Time Complexity:** O(N log N) for deduplication and sorting
- **Auxiliary Space:** O(N) for distinct salary Series

---

## Source Code

```python
class Solution:
    def secondHighestSalary(self, employee):

        salaries = employee['salary'].drop_duplicates().sort_values(ascending=False)

        if len(salaries) < 2:
            return pd.DataFrame({'SecondHighestSalary': [None]})

        second_highest = salaries.iloc[1]

        return pd.DataFrame({
            'SecondHighestSalary': [second_highest]
        })
```
