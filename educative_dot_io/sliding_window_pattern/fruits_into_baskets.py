"""
Problem Statement
    Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal
    is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

    You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree
    until you cannot, i.e., you will stop when you have to pick from a third fruit type.

    Write a function to return the maximum number of fruits in both the baskets.

Example 1:
    Input: Fruit=['A', 'B', 'C', 'A', 'C']
    Output: 3
    Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Example 2:
    Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
    Output: 5
    Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
    This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

Solution
    This problem follows the Sliding Window pattern and is quite similar to Longest Substring with K Distinct Characters.
    In this problem, we need to find the length of the longest subarray with no more than two distinct characters (or fruit types!).
    This transforms the current problem into Longest Substring with K Distinct Characters where K=2.


"""
from collections import Counter


def fruits_into_baskets(fruits):
    window_length = 0
    window_start = 0
    for window_end in range(len(fruits)):
        fruit_dict = Counter(fruits[window_start:window_end])
        while len(fruit_dict) > 2:
            left_fruit = fruits[window_start]
            fruit_dict[left_fruit] -= 1
            if fruit_dict[left_fruit] == 0:
                del fruit_dict[left_fruit]
            window_start += 1
        window_length = max(window_length, window_end - window_start + 1)

    return window_length


def main():
    print("Maximum number of fruits: " + str(fruits_into_baskets(['A', 'B', 'C', 'A', 'C'])))
    print("Maximum number of fruits: " + str(fruits_into_baskets(['A', 'B', 'C', 'B', 'B', 'C'])))


main()
