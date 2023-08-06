package KSY;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //보드 입력 받기
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = row.charAt(j) - '0';
            }
        }

        int[][] dist = new int[N][M];  // 각 위치 별 거리 저장
        Queue<int[]> queue = new ArrayDeque<>();  // 배열형태의 deque
        queue.offer(new int[]{0, 0, 1});  // row, col, distance
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int distance = curr[2];

            if (r == N - 1 && c == M - 1) {  // 찾는 위치 값 발견했다면 출력 후 종료
                System.out.println(distance);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int newRow = r + dr[d];
                int newCol = c + dc[d];
                
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M &&  // 범위를 벗어나지 않앗다면
                    maze[newRow][newCol] == 1 && dist[newRow][newCol] == 0) {  // 아직 방문하지 않은 위치이고 0이 아닌 1이라면
                    dist[newRow][newCol] = distance + 1;  // 거리 업데이트
                    queue.offer(new int[]{newRow, newCol, distance + 1});  // 큐 삽입
                }
            }
        }

        br.close();
    }
}
