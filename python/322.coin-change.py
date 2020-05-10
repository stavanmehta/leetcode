class Solution:
    def coinChange(self, coins, amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for j in range(coin, len(dp)):
                dp[j] = min(dp[j], dp[j - coin] + 1)
                print(dp, dp[j - coin])

        return dp[-1] if dp[-1] != amount + 1 else -1

if __name__ == '__main__':
    print(Solution().coinChange([1,2,5], 11))