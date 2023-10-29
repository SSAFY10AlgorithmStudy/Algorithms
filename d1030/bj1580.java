package d1030;

import java.io.*;
import java.util.*;

public class bj1580 {
    static int n, m;
    static int[][] map;
    static boolean[][][][] visited;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][n][m];
        int[] startA = new int[2];
        int[] startB = new int[2];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                char c = s.charAt(j);
                if (c == 'A'){
                    startA[0] = i;
                    startA[1] = j;
                } else if (c == 'B') {
                    startB[0] = i;
                    startB[1] = j;
                } else if (c == 'X') {
                    map[i][j] = 1;
                }
            }
        }

        visited[startA[0]][startA[1]][startB[0]][startB[1]] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {startA[0],startA[1], startB[0], startB[1], 0});
        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int ans = -1;

        while (!q.isEmpty()) {
            int ra = q.peek()[0];
            int ca = q.peek()[1];
            int rb = q.peek()[2];
            int cb = q.peek()[3];
            int cnt = q.peek()[4];
            q.poll();

            if (ra == startB[0] && ca == startB[1] && rb == startA[0] && cb == startA[1]) {
                ans = cnt;
                break;
            }

            for (int i=0; i<9; i++) {
                int nra = ra + dr[i];
                int nca = ca + dc[i];
                for (int j=0; j<9; j++) {
                    int nrb = rb + dr[j];
                    int ncb = cb + dc[j];

//                    System.out.println(nra + " " + nca + " " + nrb + " " + ncb);
                    if (!inRange(nra, nca, nrb, ncb)) continue;
                    if (nra == nrb && nca == ncb) continue; // 서로 겹칠때
                    if (nra == rb && nca == cb && nrb == ra && ncb == ca) continue;
                    visited[nra][nca][nrb][ncb] = true;
                    q.offer(new int[] {nra, nca, nrb, ncb, cnt+1});
                }
            }

        }

        System.out.println(ans);
    }

    static boolean inRange(int r1, int c1, int r2, int c2) {
        if (r1 >= 0 && c1 >= 0 && r2 >= 0 && c2 >= 0
                && r1 < n && r2 < n && c1 < m && c2 < m
                && map[r1][c1] == 0 && map[r2][c2] == 0
                && !visited[r1][c1][r2][c2]) return true;
        return false;
    }

}