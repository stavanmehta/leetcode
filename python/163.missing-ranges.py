class Solution:
    def findMissingRanges(self, nums, lower, upper):
        i = 1
        result = list()
        nums.insert(0, lower)
        nums.append(upper)
        while i < len(nums):
            low = nums[i-1]
            high = nums[i]
            if high - low == 1:
                result.append("{0}".format(low))
            elif high - low > 1:
                result.append("{0}->{1}".format(low, high))
            i += 1
        return result

if __name__ == '__main__':
    nums = [-1]
    lower = -1
    upper = -1
    res = Solution().findMissingRanges(nums, lower, upper)
    print(res)