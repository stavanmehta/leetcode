
class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        str_list = list()
        for i in range(1, n+1):
            print(i)
            if i%3 == 0 and i%5 == 0:
                str_list.append("FizzBuzz")
            elif i%3 == 0:
                str_list.append("Fizz")
            elif i % 5 == 0:
                str_list.append("Buzz")
            else:
                str_list.append("{}".format(i))
        return str_list
