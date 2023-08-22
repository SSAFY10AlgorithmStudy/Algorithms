// https://www.acmicpc.net/problem/7576

import java.io.*;
import java.util.*;

public class 토마토 {

    static int m, n;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> start;
	
	public static void main(String[] args) throws Exception {
        // 시작부터 모두 익은 경우
        // 마지막까지 모두 악지 못하는 경우
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        start = new ArrayList<int[]>();

        //배열 입력
        boolean seenEmpty = false;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) seenEmpty = true;
                else if (map[i][j] == 1) {
                    start.add(new int[] {i, j, 0});
                }
            }
        }

        // 시작부터 0 없으면 출력하고 끝
        if (!seenEmpty) {
            System.out.println(0);
            return;
        }

        //bfs
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] s: start) {
            q.offer(s);
            visited[s[0]][s[1]] = true;
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int days = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[2] > days) days = cur[2];
            for (int i=0; i<4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, cur[2]+1});
                } 
            }
        }
        
        // 앞뒤로 확인
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && map[i][j] ==0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days);
    }

}