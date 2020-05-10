class Solution:
    def isValidSudoku(self, board) -> bool:
        rows = [dict() for _ in range(9)]
        cols = [dict() for _ in range(9)]
        boxes = [dict() for _ in range(9)]

        for row in range(len(board)):
            for col in range(len(board[0])):
                box_index = ((row // 3) * 3) + col // 3
                num = board[row][col]
                if num == ".":
                    continue
                num = int(num)
                rows[row][num] = rows[row].get(num, 0) + 1
                cols[col][num] = cols[col].get(num, 0) + 1
                boxes[box_index][num] = boxes[box_index].get(num, 0) + 1

                print(boxes)
                if rows[row][num] > 1 or cols[col][num] > 1 or boxes[box_index][num] > 1:
                    return False
        return True


if __name__ == '__main__':
    board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
    print(Solution().isValidSudoku(board))