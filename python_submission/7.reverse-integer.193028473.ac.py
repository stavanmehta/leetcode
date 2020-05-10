class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        # if x > 0:
        #     return int(str(x)[::-1]) if int(str(x)[::-1]) <= 2**31 else 0
        # else:
        #     return int(str(x*-1)[::-1]) * -1 if int(str(x*-1)[::-1]) * -1 >= -2**31 else 0

        from collections import deque
        if x == 0:
            return x
        
        reverse = deque()
        n = x if x > 0 else x*-1

        while n > 0:
            digit = n%10
            reverse.append(str(digit))
            n = int(n/10)

        result = int("".join(reverse))
        return result if x > 0 else result * -1


if __name__ == '__main__':
    print(Solution().reverse(98765))
    print(Solution().reverse(-98765))
    print(Solution().reverse(0))
    print(Solution().reverse(-1))
    print(Solution().reverse(9))
    print(Solution().reverse(-10))