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
