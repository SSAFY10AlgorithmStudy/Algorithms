package d1109;

import java.io.*;
import java.util.*;

public class bj2573 {

    static class Node {
        Node(){}
        Node(int ice, int r, int c) {
            this.ice = ice;
            this.r = r;
            this.c = c;
        }
        int ice, r, c;
        Node next;
    }

    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        Node head = new Node();
        Node iter = head;

        int blocks = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    iter.next = new Node(map[i][j], i, j);
                    iter = iter.next;
                    blocks++;
                }
            }
        }

        if (blocks == 0) {
            System.out.println(0);
            return;
        }

        // update
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int years = 0;
        while (true) {
            years++;
            Node prev = head;
            boolean[][] melted = new boolean[n][m];
            while (prev != null && prev.next != null) {
                Node cur = prev.next;
                int melt = 0;

                for (int i=0; i<4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                    if (map[nr][nc] == 0 && !melted[nr][nc]) melt++;
                }
                cur.ice = Math.max(0, cur.ice-melt);
                map[cur.r][cur.c] = cur.ice;
                // ll 연결 끊기
                if (cur.ice == 0) {
                    prev.next = cur.next;
                    cur.next = null;
                    melted[cur.r][cur.c] = true;
                    blocks--;
                } else {
                    prev = prev.next;
                }
            }
            if (blocks == 0) {
                System.out.println(0);
                return;
            }
            // check if one island -> bfs from head and see if matching block
            int[] start = new int[] {head.next.r, head.next.c};
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(start);
            boolean[][] visited = new boolean[n][m];
            visited[start[0]][start[1]] = true;
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                cnt++;
                for (int i=0; i<4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                    if (!visited[nr][nc] && map[nr][nc] > 0) {
                        q.offer(new int[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

            if (cnt != blocks) break;

        }
        System.out.println(years);
    }

}