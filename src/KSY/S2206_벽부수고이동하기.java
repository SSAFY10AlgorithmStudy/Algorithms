package KSY;

import java.io.*;
import java.util.*;

// 109200KB/	704ms

public class S2206_벽부수고이동하기 {

	static int[] dr = new int[] { 0, 1, 0, -1 };
	static int[] dc = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (int) (str.charAt(j) - '0');
			}
		}

		Queue<Point2> que = new ArrayDeque<>();
		que.offer(new Point2(0, 0, 1, 1));
		visited[0][0][0] = true;
		while (!que.isEmpty()) {
			Point2 curr = que.poll();
			if (curr.r == N - 1 && curr.c == M - 1) {
				sb.append(curr.value);
				bw.write(sb.toString());
				bw.flush();
				bw.close();
				return;
			}

			for (int d = 0; d < 4; d++) {
				int row = curr.r + dr[d];
				int col = curr.c + dc[d];
				if (-1 < row && row < N && -1 < col && col < M) {
					if (curr.flag == 0) { // 기회 없음
						if (map[row][col] == 0 && !visited[row][col][1]) { // 방문하지 않았고 벽이 아니라면
							visited[row][col][1] = true;
							que.offer(new Point2(row, col, curr.value + 1, 0));
						}
					} else { // 기회 있음
						 // 부신다
						if (map[row][col] == 1 && !visited[row][col][1]) {
							visited[row][col][1] = true;
							que.offer(new Point2(row, col, curr.value + 1, 0));
						} 
						// 안 부신다
						if (!visited[row][col][0] && map[row][col] == 0) {
							visited[row][col][0] = true;
							que.offer(new Point2(row, col, curr.value + 1, 1));
						}
					}
				}

			}

		}
		sb.append(-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}

class Point2 {
	int r, c, value;
	int flag;

	Point2(int r, int c, int value, int flag) {
		this.r = r;
		this.c = c;
		this.value = value;
		this.flag = flag;
	}
}