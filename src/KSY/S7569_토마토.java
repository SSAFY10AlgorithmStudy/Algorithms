package KSY;

import java.util.*;
import java.io.*;

//115016KB /	736ms

public class S7569_토마토 {
	static int[] dr = new int[] { 1, 0, -1, 0, 0, 0 };
	static int[] dc = new int[] { 0, 1, 0, -1, 0, 0 };
	static int[] dh = new int[] { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] tomato = new int[N][M][H];
		boolean[][][] visited = new boolean[N][M][H];
		int answer=0;

		Queue<Tomato> que = new ArrayDeque<>();
//		que.offer(new Tomato());

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomato[i][j][k] == 1) {
						que.offer(new Tomato(i, j, k, 0));
						visited[i][j][k] = true;
					}
				}
			}
		}

		while (!que.isEmpty()) {
			Tomato curr = que.poll();
			if(que.isEmpty())
				answer = curr.cnt;

			for (int d = 0; d < 6; d++) {
				int row = curr.r + dr[d];
				int col = curr.c + dc[d];
				int hei = curr.h + dh[d];

				if (-1 < row && row < N && -1 < col && col < M && -1 < hei && hei < H && !visited[row][col][hei]
						&& tomato[row][col][hei] == 0) {
					visited[row][col][hei] = true;
					que.offer(new Tomato(row, col, hei, curr.cnt+1));
				}

			}

		}

		boolean flag =false;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[j][k][i] == 0 && !visited[j][k][i]) { // 안 익은 토마토 인데 방문하지 않았다면
						flag = true;
						break;
					}
				}
				if(flag)
					break;
			}
			if(flag)
				break;
		}
		
		if(flag) {
			sb.append(-1);
		} else {
			sb.append(answer);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}

class Tomato {
	int r, c, h, cnt;

	Tomato(int r, int c, int h, int cnt) {
		this.r = r;
		this.c = c;
		this.h = h;
		this.cnt = cnt;
	}
}