class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0 or len(prices) == 1:
            return 0
        profit = 0
        min_value = prices[0]
        for price in prices[1:]:
            
            if price - min_value > profit:
                profit = price - min_value
            if price < min_value:
                min_value = price

        return profit
