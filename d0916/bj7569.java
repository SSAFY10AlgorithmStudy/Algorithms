package d0916;

import java.io.*;
import java.util.*;

public class bj7569 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[h][n][m];
        Queue<int[]> q = new ArrayDeque<>();
        boolean allripe = true;
        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        q.offer(new int[] {k, j, i});
                    } else if (tomato[i][j][k] == 0) {
                        allripe = false;
                    }
                }
            }
        }

        if (allripe) {
            System.out.println(0);
            return;
        }

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int z = q.peek()[2];
            q.poll();

            for (int i=0; i<6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h || tomato[nz][ny][nx] != 0) continue;
                tomato[nz][ny][nx] = tomato[z][y][x] + 1;
                q.offer(new int[] {nx, ny, nz});
            }
        }

        int days = 0;
        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<m; k++) {
                    if (tomato[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (tomato[i][j][k] > days) days = tomato[i][j][k];
                }
            }
        }
        System.out.println(days-1);
    }

}