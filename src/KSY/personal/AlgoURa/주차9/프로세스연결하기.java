package KSY.personal.AlgoURa.주차9;

import java.io.*;
import java.util.*;

public class 프로세스연결하기 {

	static int N, max, totalCnt, min, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TC; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			list = new ArrayList<int[]>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리 코어 제외
					if (i == 0 || i == N - 1 || j == 0 || j == N - 1)
						continue;
					if (map[i][j] == 1) {
						list.add(new int[] { i, j });
						totalCnt++;
					}
				}
			}

			go(0, 0);
			System.out.println("#" + test + " " + min);

		}
	}

	// 코어를 선택(4방향 시도) / 비선택
	private static void go(int index, int coreCnt) { // index : 고려 할 코어 번호, coreCnt : 연결된 코어 개수
		// 가지 치기 : 현재까지 연결된 코어 수 + 남은 코어 수 < 임시 최대 코어 연결 수
		if (coreCnt + (totalCnt - index) < max)
			return;
		// 기저 조건 처리
		if (index == totalCnt) {
			int res = getLength(); // 놓아진 전선의 길이의 합
			if (max < coreCnt) {
				max = coreCnt;
				min = res;
			} else if (max == coreCnt) {
				if (min > res) {
					min = res;
				}
			}
			return;
		}

		int[] cur = list.get(index);
		int row = cur[0];
		int col = cur[1];

		// 현재 코어를 선택
		for (int d = 0; d < 4; d++) {
			if (!isAvailable(row, col, d))
				continue;
			setStatus(row, col, d, 2);
			go(index + 1, coreCnt + 1);
			setStatus(row, col, d, 0);
		}
		go(index + 1, coreCnt);

		// 현재 코어를 비선택
	}

	private static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					lCnt++;
				}
			}
		}
		return lCnt;
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr = r;
		int nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1)
				break;
			if (map[nr][nc] != 0)
				return false;
		}
		return true;
	}

	private static boolean setStatus(int r, int c, int d, int status) {
		int nr = r;
		int nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1)
				break;
			map[nr][nc] = status;

		}
		return true;
	}

}
