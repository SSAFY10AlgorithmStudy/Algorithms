package d1109;

import java.io.*;

public class bj9663 {

    static int n;
    static boolean[][] chessboard;
    static boolean[] selectedCol;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기

        n = Integer.parseInt(br.readLine());
        chessboard = new boolean[n][n];
        selectedCol = new boolean[n];

        dfs(0);

        System.out.println(ans);

    }

    static void dfs(int cnt) {
//		System.out.println("debug");
        if (cnt == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selectedCol[i]) // 세로 확인
                continue;
            if (diagonal(cnt, i)) // 대각선 확인
                continue;
            selectedCol[i] = true;
            chessboard[cnt][i] = true;
            dfs(cnt + 1);
            selectedCol[i] = false;
            chessboard[cnt][i] = false;
        }
    }

    static boolean diagonal(int r, int c) {
        int nr = r - 1;
        int nc = c - 1;
        while (nr >= 0 && nc >= 0) {
            if (chessboard[nr][nc])
                return true;
            nr--;
            nc--;
        }
        nr = r - 1;
        nc = c + 1;
        while (nr >= 0 && nc < n) {
            if (chessboard[nr][nc]) return true;
            nr--;
            nc++;
        }

        return false;
    }

}
