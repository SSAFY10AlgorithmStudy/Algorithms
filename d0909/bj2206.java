package d0909;
import java.io.*;
import java.util.*;

public class bj2206 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 줄로 읽어 빠르게 토큰으로 나누기

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int map[][] = new int[n][m];
        int dp1[][] = new int[n][m];
        int dp2[][] = new int[n][m];
        dp1[0][0] = 1;

        for (int i=0; i<n; i++) {
            String row = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = row.charAt(j)-'0';
            }
        }


        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0,0}); // [x,y,벽(0=안부숨, 1=부숨)]

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        boolean[][] visited1 = new boolean[n][m];
        boolean[][] visited2 = new boolean[n][m];
        visited1[0][0] = true;

        while (!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.peek()[1];
            int broken = q.peek()[2];
            q.poll();

            // 4방향 확인
            for (int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위 안에 없으거나 방문했으면 다음
                if (!(nr >= 0 && nc >= 0 && nr < n && nc < m)) continue;
                // 벽 없으면 다음 위치 dp 값 업데이트, 큐에 추가
                if (map[nr][nc] == 0) {
                    // 벽 아직 안부쉈으면
                    if (broken == 0 && !visited1[nr][nc]) {
                        visited1[nr][nc] = true;
                        dp1[nr][nc] = dp1[r][c] + 1;
                        q.offer(new int[] {nr, nc, 0});
                    } else if (broken == 1 && !visited2[nr][nc]) { // 벽 이미 부순 상태면
                        visited2[nr][nc] = true;
                        dp2[nr][nc] = dp2[r][c] + 1;
                        q.offer(new int[] {nr, nc, 1});
                    }
                    // 벽 있고 아직 벽을 안부숴봤으면
                } else if (broken == 0 && !visited1[nr][nc]) {
                    visited1[nr][nc] = true;
                    dp2[nr][nc] = dp1[r][c] + 1;
                    q.offer(new int[] {nr, nc, 1});
                }
            }
        }

        if (dp1[n-1][m-1] == 0 && dp2[n-1][m-1] == 0) {
            System.out.println(-1);
        } else if (dp1[n-1][m-1] == 0) {
            System.out.println(dp2[n-1][m-1]);
        } else if (dp2[n-1][m-1] == 0) {
            System.out.println(dp1[n-1][m-1]);
        } else {
            System.out.println(Math.min(dp1[n-1][m-1], dp2[n-1][m-1]));
        }

    }

}