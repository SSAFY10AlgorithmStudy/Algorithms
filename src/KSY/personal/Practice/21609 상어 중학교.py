import sys
from collections import deque
import copy
input = sys.stdin.readline

dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]

n, m = map(int, input().split())
board = [[] for _ in range(n)]
visited = [[False] * n for _ in range(n)]

# input
for i in range(n):
    board[i] = list(map(str, input().split()))


def BFS(row, col):
    if visited[row][col]:
        return []
    visited[row][col] = True
    que = deque([(row, col)])
    blocks = [(row, col)]

    while que:
        point = que.popleft()
        for i in range(4):
            r = point[0] + dr[i]
            c = point[1] + dc[i]
            if (-1 < r < n and -1 < c < n and not visited[r][c]
                    and (board[r][c] == board[row][col] or board[r][c] == '0')):
                visited[r][c] = True
                blocks.append((r, c))
                que.append((r, c))
    return blocks


# find block group
def findBlockGroup():
    maxBlock = []
    for i in range(n):
        visited[i] = [False]*n

    for i in range(n):
        for j in range(n):
            if board[i][j] != '-1' and board[i][j] != '':
                blocks = BFS(i, j)
                lenBlocks = len(blocks)
                if lenBlocks > 1 and lenBlocks >= len(maxBlock):
                    maxBlock = blocks
    # print("maxBlock", maxBlock)
    return maxBlock

# remove blocks
def removeBlocks(blocks):
    for r, c in blocks:
        board[r][c] = ''
    # print("== remove blocsk ==")
    # printBoard(board)

# gravity
def gravity():
    # print("== before gravity ==")
    # printBoard(board)

    que = deque([])
    for col in range(n):
        row = n-1
        start = n-1
        flag = True
        while row > -1:
            while row > -1 and board[row][col] == '':
                if flag:
                    start = row
                    flag = False
                row -= 1
            while row > -1 and board[row][col] != '' and board[row][col] != '-1':
                que.append(board[row][col])
                board[row][col] = ''
                row -= 1
            while que:
                board[start][col] = que.popleft()
                start -= 1
            flag = True
            row -= 1

    # print("== after gravity ==")
    # printBoard(board)

# 반시계 방향 회전
def rotation():
    tempBoard = [['']*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            tempBoard[n-1-j][i] = board[i][j]
    # print("== rotation ==")
    # printBoard(tempBoard)
    return tempBoard

def printBoard(board):
    for i in range(n):
        print(board[i])

score = 0
index = 1
while True:
    print("index :", index)
    index += 1
    blocks = findBlockGroup()
    if not blocks:
        break
    score += len(blocks)*len(blocks)
    removeBlocks(blocks)
    print("remove blocks")
    printBoard(board)
    gravity()
    print("gravity1")
    printBoard(board)
    board = rotation()
    print("rotation")
    printBoard(board)
    gravity()
    print("gravity2")
    printBoard(board)

    print(score)
    print("----------------------------")
