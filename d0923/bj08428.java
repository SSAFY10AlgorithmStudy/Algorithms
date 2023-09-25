package d0923;

import java.io.*;
import java.util.*;

public class bj08428 {

    static int n;
    static int[][] map;
    static List<int[]> students = new ArrayList<>();
    static List<int[]> teachers = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i=0;i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                String s = st.nextToken();
                switch (s) {
                    case "S":
                        map[i][j] = 1;
                        students.add(new int[] {i,j});
                        break;
                    case "T":
                        map[i][j] = 2;
                        teachers.add(new int[] {i,j});
                        break;
                }
            }
        }

        List<int[]> startPoint = null;
        int find = -1;
        if (students.size() <= teachers.size()) {
            startPoint = students;
            find = 2;
        } else {
            startPoint = teachers;
            find = 1;
        }

        // 3중 루프해서 빈칸의 모든 조합에 벽을 세워서 확인
        for (int i=0; i<n*n-2; i++) {
            if (map[i/n][i%n] == 0) map[i/n][i%n] = -1;
            for (int j=i+1; j<n*n-1; j++) {
                if (map[j/n][j%n] == 0) map[j/n][j%n] = -1;
                for(int k=j+1; k<n*n; k++) {
                    if (map[k/n][k%n] == 0) map[k/n][k%n] = -1;
                    if (simulate(startPoint, find)) {
                        System.out.println("YES");
                        return;
                    }
                    if (map[k/n][k%n] == -1) map[k/n][k%n] = 0;
                }
                if (map[j/n][j%n] == -1) map[j/n][j%n] = 0;
            }
            if (map[i/n][i%n] == -1) map[i/n][i%n] = 0;
        }

        System.out.println("NO");
    }

    static boolean simulate(List<int[]> startPoint, int find) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int[] p: startPoint) {
            int r = p[0];
            int c = p[1];
            for (int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                while (nr >= 0 && nc >= 0 && nr < n && nc < n && map[nr][nc] != -1) { // 범위 안에 있으면
                    if (map[nr][nc] == find) return false;
                    nr += dr[i];
                    nc += dc[i];
                }
            }
        }

        return true;
    }

}