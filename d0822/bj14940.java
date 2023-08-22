// package d0822;

import java.io.*;
import java.util.*;

public class bj14940 {
    
    static int[][] map, answer;
    static boolean[][] visited;
    static int n, m;
    static int[] start = new int[3];
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("../input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // System.out.println("test");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];

        // input
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    start[2] = 0; 
                }
            }
        }

        // bfs
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            answer[cur[0]][cur[1]] = cur[2]; //count 저장
            for (int i=0; i<4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (inRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc, cur[2]+1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 1 && answer[i][j] == 0) answer[i][j] = -1;
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();

    }

    static boolean inRange(int row, int col) {
        if (row >= 0 && col >= 0 && row < n && col < m) {
            return true;
        }
        return false;
    }

}
