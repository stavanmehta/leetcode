class Solution:
    def validWordAbbreviation(self, word: str, abbr: str):
        if len(word) < len(abbr):
            return False
        index = 0
        digit = ""
        pos = 0
        wordlen = len(word)
        for ch in abbr:
            if ch.isalpha():
                index += pos
                if index > wordlen:
                    return False
                elif index < wordlen and ch != word[index]:
                    return False
                index += 1
                digit = ""
            elif ch.isnumeric():
                if digit == "" and int(ch) == 0:
                    return False
                else:
                    digit += ch
            pos = int(digit) if digit != "" else 0

        return len(word) - index - pos == 0



if __name__ == '__main__':
    s = "abbreviation"
    # abbr = "i5a11o1"
    #
    abbr = "a10n"
    print(Solution().validWordAbbreviation(s, abbr))