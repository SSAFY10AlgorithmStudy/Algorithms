package KSY.personal.Practice;

import java.util.*;
import java.io.*;

//60036KB/	512ms

public class S1600_말이되고픈원숭이 {

	static int[] kdr = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] kdc = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] dr = new int[] { 1, -1, 0, 0 };
	static int[] dc = new int[] { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][][] visited = new boolean[H][W][K + 1];
		Queue<Point> que = new ArrayDeque<>();
		que.offer(new Point(0, 0, 0, 0));
		while (!que.isEmpty()) {
			Point curr = que.poll();
			if (curr.r == H - 1 && curr.c == W - 1) {
				sb.append(curr.cnt);
				bw.write(sb.toString());
				bw.flush();
				bw.close();
				return;
			}

			if (curr.k < K) { // 말처럼 움직일 수 있음
				for (int d = 0; d < 8; d++) {
					int row = curr.r + kdr[d];
					int col = curr.c + kdc[d];
					if (-1 < row && row < H && -1 < col && col < W && map[row][col] != 1
							&& !visited[row][col][curr.k+1]) {
						visited[row][col][curr.k+1] = true;
						que.offer(new Point(row, col, curr.cnt+1, curr.k + 1));
					}
				}
			}

			// 그냥 이동
			for (int d = 0; d < 4; d++) {
				int row = curr.r + dr[d];
				int col = curr.c + dc[d];
				if (-1 < row && row < H && -1 < col && col < W && map[row][col] != 1 && !visited[row][col][curr.k]) {
					visited[row][col][curr.k] = true;
					que.offer(new Point(row, col, curr.cnt + 1, curr.k));
				}
			}

		}
		sb.append(-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

class Point {
	int r, c, cnt, k;

	Point(int r, int c, int cnt, int k) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.k = k;
	}
}