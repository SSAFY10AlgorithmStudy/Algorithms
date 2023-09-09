package d0909;

import java.util.*;

class prog60059 {

    static int m, n;

    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;

        int[][][] rots = new int[4][m][m];

        // key rotations
        rots[0] = key;
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                rots[1][j][m-i-1] = key[i][j];
                rots[2][m-i-1][m-j-1] = key[i][j];
                rots[3][m-j-1][i] = key[i][j];
            }
        }

        for (int i=0; i<n+m-1; i++) {
            for (int j=0; j<n+m-1; j++) {
                for (int k=0; k<4; k++) {
                    if (checkfit(lock, rots[k], i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean checkfit(int[][] lock, int[][] key, int row, int col) {
        int[][] tmpmap = new int[n + (m-1)*2][n + (m-1)*2];

        // 열쇠 끼워넣기
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                tmpmap[i+row][j+col] = key[i][j];
            }
        }


        // 모든 칸 잘 맞는지 확인
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                tmpmap[i+m-1][j+m-1] += lock[i][j];
                if (tmpmap[i+m-1][j+m-1] != 1) return false;
            }
        }

        return true;
    }
}