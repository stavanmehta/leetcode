#
# @lc app=leetcode id=347 lang=python
#
# [347] Top K Frequent Elements
#
# https://leetcode.com/problems/top-k-frequent-elements/description/
#
# algorithms
# Medium (56.01%)
# Total Accepted:    228.8K
# Total Submissions: 408.5K
# Testcase Example:  '[1,1,1,2,2,3]\n2'
#
# Given a non-empty array of integers, return the k most frequent elements.
# 
# Example 1:
# 
# 
# Input: nums = [1,1,1,2,2,3], k = 2
# Output: [1,2]
# 
# 
# 
# Example 2:
# 
# 
# Input: nums = [1], k = 1
# Output: [1]
# 
# 
# Note: 
# 
# 
# You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
# Your algorithm's time complexity must be better than O(n log n), where n is
# the array's size.
# 
# 
#
from collections import Counter
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        return [k for k, v in Counter(nums).most_common(k)]
        
