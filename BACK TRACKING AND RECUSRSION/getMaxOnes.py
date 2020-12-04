def getValue(array, row, column, length, breath):
    if (row < 0 or row >= length or column < 0 or column >= breath):
        return 0
    else:
        return array[row][column]

def findMaxOnes(array, row, column, length, breath, size):
    global maxSize
    global visitedCell

    if (row >= length or column >= breath):
        return
    visitedCell[row][column] = 1
    size += 1
    if (size > maxSize):
        maxSize = size
    #print("row, column: ", row, column)
    direction = [[-1, -1], [0, -1], [-1, 0], [1,-1], [0, 1], [1, 1], [1, 0], [1, -1]]
    #direction = [[-1, 0], [-1, -1], [0, -1], [1, -1], [1, 0], [1, 1], [0, 1], [-1, 1]]
    for i in range(0, 8):
        newRow = row + direction[i][0]
        newColumn = column + direction[i][1]
        value = getValue(array, newRow, newColumn, length, breath)
        #print("@@@@@@@@@@@@@@@for")
        #print("row, column: i, value", row, column, i, value)
        #print(visitedCell)
        if (value > 0 and (visitedCell[newRow][newColumn] == 0)):
            """
            print("inside iffffffffffffffffff")
            print("size", size)
            print("maxsize", maxSize)
            print("row, column: ", row, column)
            print("dirction row, column", newRow, newColumn)
            print("###################")
            """
            findMaxOnes(array, newRow, newColumn, length, breath, size)
    #print("enddddddddddddddddddddddddddddddddddd")
    visitedCell[row][column] = 0

def getMaxOnes(array, length, breath):
    global size
    global maxSize
    for row in range(0, length):
        for column in range(0, breath):
            if (array[row][column] == 1):
                findMaxOnes(array, row, column, length, breath, 0)
    return maxSize

size = 0
maxSize = 0
length = 5
breath = 5
#orginalMatrix = [[1, 1, 0, 0, 0], [0, 1, 1, 0, 1], [0, 0, 0, 1, 1], [1, 0, 0, 1, 1], [0, 1, 0, 1, 1]]
orginalMatrix = [[1, 1, 0, 0, 0],
                 [0, 1, 1, 0, 0],
                 [0, 0, 1, 0, 1],
                 [1, 0, 0, 1, 1],
                 [0, 1, 0, 1, 1]
                ]
#visitedCell = length * [breath * [0]]
visitedCell =   [[0, 0, 0, 0, 0],
                 [0, 0, 0, 0, 0],
                 [0, 0, 0, 0, 0],
                 [0, 0, 0, 0, 0],
                 [0, 0, 0, 0, 0]
                ]
print(getMaxOnes(orginalMatrix, length, breath))        
