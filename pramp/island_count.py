def get_number_of_islands(binaryMatrix):
    islands = 0
    rows = len(binaryMatrix)
    cols = len(binaryMatrix[0])
    for i in range(rows):
        for j in range(cols):
            if binaryMatrix[i][j] == 1:
                markIsland(binaryMatrix, rows, cols, i, j)
                islands += 1
    return islands


def markIsland(grid, rows, cols, sr, sc):
    island = list()
    island.insert(0, (sr, sc))
    while island:
        item = island.pop()
        x = item[0]
        y = item[1]
        if grid[x][y] == 1:
            grid[x][y] = -1
            pushIfValid(island, rows, cols, x - 1, y)
            pushIfValid(island, rows, cols, x, y - 1)
            pushIfValid(island, rows, cols, x + 1, y)
            pushIfValid(island, rows, cols, x, y + 1)


def pushIfValid(island, rows, cols, x, y):
    if x >= 0 and x < rows and y >= 0 and y < cols:
        island.insert(0, (x, y))


if __name__ == '__main__':
    binaryMatrix = [[0, 1, 0, 1, 0],
                    [0, 0, 1, 1, 1],
                    [1, 0, 0, 1, 0],
                    [0, 1, 1, 0, 0],
                    [1, 0, 1, 0, 1]]
    result = get_number_of_islands(binaryMatrix)
    print(result)

# 0,1 -> 00, 02, 11
# 1,2 -> 02, 11, 22, 13
# (-1,0) (0, -1), (+1, 0) (0, +1)
"""
[ [0,    1,    0,    1,    0],
  [0,    0,    1,    1,    1],
  [1,    0,    0,    1,    0],
  [0,    1,    1,    0,    0],
  [1,    0,    1,    0,    1] ]
"""