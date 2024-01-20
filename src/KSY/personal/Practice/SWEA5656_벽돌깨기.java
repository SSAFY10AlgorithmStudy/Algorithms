package KSY.personal.Practice;

import java.io.*;
import java.util.*;

public class SWEA5656_벽돌깨기 {

	static int N, W, H, min;
	static int dr[] = new int[] { 1, -1, 0, 0 };
	static int dc[] = new int[] { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 2차원 map입력
			min = Integer.MAX_VALUE;
			drop(0, map);
			System.out.println("#"+test+" "+min);
		}

	}

	// 구슬 던지기 : 중복 순열
	private static boolean drop(int cnt, int[][] map) { // 구슬 떨어뜨리기 cnt : 직전까지 떨어뜨린 구슬 수,
														// map : 직전 상태까지의 map
														// 리턴값 : 모든 벽돌이 제거되었는지 여부

		int result = getRemain(map);
		if (result == 0) {
			min = 0;
			return true;
		}

		if (cnt == N) {
			if (min < result)
				min = result;
			return false;
		}

		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) { // 모든 열에 대해 시도

			// 해당 열에 떨어뜨릴 경우 제거되는 맨 윗벽돌 찾기

			// 벽돌이 존재하지 않는다면 (해당열은 모두 빈칸)

			// 벽돌이 존재한다면
			copy(map, newMap);
			// 함께 제거될 인접벽돌 연쇄 찾기
			// 디버깅 출력
			boom(newMap, r, c);
			// 제거처리(벽돌 내리기)
			// 디버깅 출력
			down(newMap);
			// 다음 구슬 던지러 가기
			// 디버깅 출력

			if (drop(cnt + 1, newMap))
				return true;
		}
	}

	// 인접한 제거 벽돌 찾기 : Flood Fill(4방 BFS)
	private static void boom(int[][] map, int r, int c) {
		Queue<Point4> que = new ArrayDeque<Point4>();

		que.offer(new Point4(r, c, map[r][c]));
		map[r][c] = 0; // 방문 처리

		while (!que.isEmpty()) {
			Point4 cur = que.poll();

			for (int d = 0; d < 4; d++) {
				int row = cur.r;
				int col = cur.c;
				for (int i = 0; i < cur.cnt - 1; i++) { // cnt-1 만큼 주변 벽돌 찾기
					row += dr[d];
					col += dc[d];
					if (-1 < row && row < N && -1 < col && col < N && map[row][col] > 0) {
						if (map[row][col] > 1) {
							que.offer(new Point4(row, col, map[row][col]));
							map[row][col] = 0; // 방문 처리
						}
					}
				}

			}

		}
	}

	// 벽돌 내리기1 : 빈자리 위쪽 벽돌 찾아 내리기
	// 벽돌 내리기2 : 매 열마다 맨 윗행부터 벽돌칸 모두 스택에 넣고 빈칸 만들기 (more easy)
	private static void down(int[][] map) {
		// 매 열 기준으로 내리기
		for (int c = 0; c < W; c++) {
			int r = H - 1, row = -1;
			while (r > 0) {
				if (map[r][c] == 0) { // 빈칸이면 내일 벽돌 찾기
					row = r - 1; // 바로 윗행부터 찾기

					while (row > 0 && map[row][c] == 0)
						--row;

					map[r][c] = map[row][c];
					map[row][c] = 0; // 빈칸 처리
				}

				if (row == 0)
					break; // row 가 map의 끝까지 탐색했으므로 빠져나감으로 더이상 탐색하지 않는다
				--r;
			}
		}

	}

	// 배열 복사하기
	private static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}

	// 남은 벽돌 개수 구하기 :매번 구슬 던지기 전에 사용할 목적
	private static int getRemain(int[][] map) {
		int cnt = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (map[r][c] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	// 디버깅용 : 상태 출력

}

class Point4 {
	int r, c, cnt;

	Point4(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}
