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
