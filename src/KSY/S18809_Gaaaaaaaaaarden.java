package KSY;

import java.io.*;
import java.util.*;

//295056KB/	876ms

public class S18809_Gaaaaaaaaaarden {

	static List<Cell> able = new ArrayList<>();
	static int[] dr = new int[] { 0, 1, 0, -1 };
	static int[] dc = new int[] { 1, 0, -1, 0 };
	static int N, M, map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken()); // 초록 배양액
		int R = Integer.parseInt(st.nextToken()); // 빨간 배양액
		int answer = 0;

		// 0: 호수, 1: 배양액 뿌릴 수 없는 땅, 2: 배양액 뿌릴 수 있는 땅
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					able.add(new Cell(i, j, 0));
				}
			}
		}

		int p[] = new int[able.size()];
		int cnt = able.size() - 1;
		while (cnt >= able.size() - (G + R))
			p[cnt--] = 1;
		do { // 배양액 놓을 위치 선정

			int[] selected = new int[G + R]; // 선택된 위치의 able 인덱스 번호들
			int idx = 0;
			for (int i = 0; i < able.size(); i++) {
				if (p[i] == 1) {
					selected[idx++] = i;
				}
			}

			int p2[] = new int[G + R]; // Green vs Red
			int cnt2 = p2.length - 1;
			while (cnt2 >= p2.length - G)
				p2[cnt2--] = 1;

			do { // 선정된 위치 기반 초록색(1), 빨간색(0) 분리

				// map 분리
				int[][] greenmap = new int[N][M];
				int[][] redmap = new int[N][M];

				Queue<Cell> que = new ArrayDeque<>();

				for (int i = 0; i < p2.length; i++) {
					Cell c = able.get(selected[i]);
					Cell newCell = null;  // 다음 상황을 위해서 객체 새로 생성
					if (p2[i] == 1) { // 초록색이라면
						greenmap[c.r][c.c] = -1;
						newCell = new Cell(c.r, c.c, c.cnt, 'g');
					} else { // 빨강색이라면
						redmap[c.r][c.c] = -1;
						newCell = new Cell(c.r, c.c, c.cnt, 'r');
					}
					que.offer(newCell);
				}
//				//tempmap 출력
//				System.out.println("before");
//				for(int i=0; i<N; i++) {
//					System.out.println(Arrays.toString(greenmap[i]));
//				}
//				System.out.println();
//				for(int i=0; i<N; i++) {
//					System.out.println(Arrays.toString(redmap[i]));
//				}
//				System.out.println("------");

				int answertemp = BFS(greenmap, redmap, que);

				if (answertemp > answer) {
					answer = answertemp;
				}

			} while (NP(p2));

		} while (NP(p));
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static int BFS(int[][] greenmap, int[][] redmap, Queue<Cell> que) {
		int[][] tempmap = new int[N][M];  // 꽃이 피는 영역 확인용
		while (!que.isEmpty()) { // que에 값이 있을 때까지
			Cell curr = que.poll();
			// 해당 cell이 이미 꽃을 피운 곳이라면 탐색 중지
			if (tempmap[curr.r][curr.c] == 1)
				continue;

			for (int d = 0; d < 4; d++) {
				int row = curr.r + dr[d];
				int col = curr.c + dc[d];
				if (-1 < row && row < N && -1 < col && col < M && map[row][col] != 0) { // 범위를 벗어나지 않고 호수가 아님
					if (curr.color == 'g') { // 초록색일 때
						if (redmap[row][col] == curr.cnt + 1) { // 배양
							tempmap[row][col] = 1;
						} else if (greenmap[row][col] == 0 && redmap[row][col] == 0) {  // 방문하지 않은곳이라면 ( 3% ->
							greenmap[row][col] = curr.cnt + 1;
							Cell c = new Cell(row, col, curr.cnt + 1);
							c.color = 'g';
							que.offer(c);
						}
					} else if (curr.color == 'r') { // 빨간색일 때
						if (greenmap[row][col] == curr.cnt + 1) { // 배양
							tempmap[row][col] = 1;
						} else if (redmap[row][col] == 0 && greenmap[row][col] == 0) {  // 방문하지 않은곳이라면
							redmap[row][col] = curr.cnt + 1;
							Cell c = new Cell(row, col, curr.cnt + 1);
							c.color = 'r';
							que.offer(c);
						}
					}
				}
			}
		}
//		System.out.println("tempmap");
//		for(int i=0;i<N; i++) {
//			System.out.println(Arrays.toString(tempmap[i]));
//		}

		return flowerCnt(tempmap);  // 피워진 꽃 개수 확인
	}

	public static int flowerCnt(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static boolean NP(int[] p) {
		int i = p.length - 1;
		while (i > 0 && p[i - 1] >= p[i])
			i--;
		if (i == 0)
			return false;

		int j = p.length - 1;
		while (p[i - 1] >= p[j])
			j--;
		swap(p, i - 1, j);

		int k = p.length - 1;
		while (k > i)
			swap(p, k--, i++);

		return true;
	}

	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}

class Cell {
	int r, c, cnt;
	char color;

	Cell(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
	Cell(int r, int c, int cnt, char color) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.color = color;
	}
}