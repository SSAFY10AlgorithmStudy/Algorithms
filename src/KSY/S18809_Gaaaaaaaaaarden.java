package KSY;

import java.io.*;
import java.util.*;

public class S18809_Gaaaaaaaaaarden {

	static List<Cell> able = new ArrayList<>();
	static int[] dr = new int[] { 0, 1, 0, -1 };
	static int[] dc = new int[] { 1, 0, -1, 0 };
	static int N, M, map[][];
	static Set<Cell> checked = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken()); // 초록 배양액
		int R = Integer.parseInt(st.nextToken()); // 빨간 배양액
		int river = 0, answer = 0;

		// 0: 호수, 1: 배양액 뿌릴 수 없는 땅, 2: 배양액 뿌릴 수 있는 땅
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					able.add(new Cell(i, j, 0));
				} else if (map[i][j] == 0) {
					river++;
				}
			}
		}
//		System.out.println("river: " + river);

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

			do { // 초록색(1), 빨간색(0) 분리

				// map 분리
				int[][] greenmap = new int[N][M];
				int[][] redmap = new int[N][M];
//				Arrays.fill(greenmap, -1);
//				Arrays.fill(redmap, -1);
//				for (int i = 0; i < N; i++) {
//					greenmap[i] = map[i].clone();
//					redmap[i] = map[i].clone();
//				}

//				Queue<Cell> greenque = new ArrayDeque<>();
//				Queue<Cell> redque = new ArrayDeque<>();
				Queue<Cell> que = new ArrayDeque<>();

				for (int i = 0; i < p2.length; i++) {
					Cell c = able.get(selected[i]);
					if (p2[i] == 1) { // 초록색이라면
						greenmap[c.r][c.c] = -1;
						c.color = 'g';
						que.offer(c);
					} else { // 빨강색이라면
						redmap[c.r][c.c] = -1;
						c.color = 'r';
						que.offer(c);
					}
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

//				BFS(greenmap, greenque);
//				BFS(redmap, redque);

				int answertemp = BFS(greenmap, redmap, que);

//				int answertemp = checkSameTime(greenmap, redmap);
				if (answertemp > answer) {
					answer = answertemp;
					// tempmap 재출력
					for (int i = 0; i < N; i++) {
						System.out.println(Arrays.toString(greenmap[i]));
					}
					System.out.println();
					for (int i = 0; i < N; i++) {
						System.out.println(Arrays.toString(redmap[i]));
					}
					System.out.println("=======" + answertemp);

				}
//				sb.append(answer).append("\n");

			} while (NP(p2));

		} while (NP(p));
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

//	public static int checkSameTime(int[][] map1, int[][] map2) { // 둘이 같은 시간에 방문한 위치 확인
//		int cnt = 0;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (map1[i][j] != 0 && map1[i][j] == map2[i][j]) {
//					cnt++;
//				}
//			}
//		}
//		return cnt;
//	}

	public static int BFS(int[][] greenmap, int[][] redmap, Queue<Cell> que) {
//		int tempanswer = 0;
		int[][] tempmap = new int[N][M];
		while (!que.isEmpty()) { // que에 값이 있을 때까지
			Cell curr = que.poll();
			// 해당 cell이 이미 꽃을 피운 곳이라면 탐색 중지
			if (checked.contains(curr))
				continue;

			for (int d = 0; d < 4; d++) {
				int row = curr.r + dr[d];
				int col = curr.c + dc[d];
				if (-1 < row && row < N && -1 < col && col < M && map[row][col] != 0) { // 범위를 벗어나지 않고 호수가 아님
					if (curr.color == 'g') { // 초록색일 때
						if (redmap[row][col] == curr.cnt + 1) { // 배양
//							tempanswer++;
							tempmap[row][col] = 1;
							checked.add(new Cell(row, col, 0));
						} else if (greenmap[row][col] == 0) {
							greenmap[row][col] = curr.cnt + 1;
							Cell c = new Cell(row, col, curr.cnt + 1);
							c.color = 'g';
							que.offer(c);
						}
					} else if (curr.color == 'r') { // 빨간색일 때
						if (greenmap[row][col] == curr.cnt + 1) { // 배양
//							tempanswer++;
							tempmap[row][col] = 1;
							checked.add(new Cell(row, col, 0));
						} else if (redmap[row][col] == 0) {
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

		return flowerCnt(tempmap);
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

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + r;
		result = prime * result + c;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Cell c = (Cell) obj;
		return hashCode() == obj.hashCode();
	}

}