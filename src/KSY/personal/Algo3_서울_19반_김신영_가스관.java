package KSY.personal;


import java.util.*;
import java.io.*;

public class Algo3_서울_19반_김신영_가스관 {

	static Point M, Z, A = new Point(-1, -1); // 집, 유치원, 결과
	static int R, C; // 행, 열 크기
	static boolean[][] visited; // 방문 표시 배열
	static char[][] map; // map
	static int[] dr = new int[] { 1, 0, -1, 0, 1, 1, -1, -1}; // down, right, up, left
	static int[] dc = new int[] { 0, 1, 0, -1, 1, -1, 1, -1}; // down right, down left, up right, up left
	static boolean flag = false, realFlag = false;

	static char[] blocks = new char[] { '-', '+', '1', '2', '3', '4' }; // 모든 블록 형태

	public static void main(String[] args) throws IOException { // main start
		System.setIn(new FileInputStream("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // Test case 개수

		for (int test = 0; test <= T; test++) { // test case
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken()); // map 행 크기
			C = Integer.parseInt(st.nextToken()); // map 열 크기
			map = new char[R + 1][C + 1]; // map 배열 초기화
			visited = new boolean[R + 1][C + 1]; // 방문한 위치인지 판별

			// map 입력 받기
			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i+1][j+1] = line.charAt(j);
					if (map[i+1][j+1] == 'M') // 집이라면
						M = new Point(i+1, j+1); // 집 위치 업데이트
					else if (map[i+1][j+1] == 'Z') // 유지원이라면
						Z = new Point(i+1, j+1); // 유치원 위치 업데이트
				}
			}
			
			//첫 방향 찾기
			int r, c, dir;
			for(int d=0; d<8; d++) {
				int row = M.r + dr[d];
				int col = M.c + dc[d];
				if(-1 < row && row < R && -1 < col && col < C && map[row][col] != '.') {
					r = row; c = col; dir = d;
					break;
				}
			}
			
			// todo : 첫 방향을 찾지 못 했을 때 

			visited[M.r][M.c] = true; // 집 위치 방문 표시
			findRoad(M.r, M.c, 1);  // M부터 Z까지 DFS로 길 찾기

			sb.append("#").append(test).append(" ").append(A.r).append(A.c).append(map[A.r][A.c]).append("\n");

		} // test case end

		bw.write(sb.toString()); // 출력
		bw.flush(); // bw 비우기
		bw.close(); // bw 닫기

	} // main end

	private static void findRoad(int r, int c, int dir) { // 현재 위치, 방향 매서드/DFS로 가능한 경우 찾기
		if (r == Z.r && c == Z.c) { // 유치원에 도착 함
			realFlag = true;
			return;
		}
		
		for (int d = 0; d < 8; d++) { // 방문하지 않은 주변 경우 확인
			int row = r + dr[d]; // 행 방향 전환
			int col = c + dc[d]; // 열 방향 전환
			if (-1 < row && row < R && -1 < col && col < C && !visited[row][col]) {
				visited[row][col] = true; // 방문 표시

				switch (map[row][col]) {
				case '-':
					if (dir == 1) // 오른 방향 이었다면
						findRoad(r, c + 1, d);
					else if (dir == 3) // 왼 방향 이었다면
						findRoad(r, c - 1, d);
					break;
				case '+':
					if (dir == 1) // 오른 방향 이었다면
						findRoad(r, c + 1, d);
					else if (dir == 3) // 왼 방향 이었다면
						findRoad(r, c - 1, d);
					else if (dir == 0) // 아래 방향 이었다면
						findRoad(r + 1, c, d);
					else if (dir == 2) // 위 방향 이었다면
						findRoad(r - 1, c, d);
					break;
				case '1': // up right
					if (dir == 2) // 위 방향 이었다면
						findRoad(r, c + 1, d);
					else if (dir == 3) // 왼 방향 이었다면
						findRoad(r - 1, c , d);
					break;
				case '2': // ㄴ
					if (dir == 0) //아래 방향 이었다면
						findRoad(r, c + 1, d);
					else if (dir == 4) // 왼 방향 이었다면
						findRoad(r - 1, c , d);
					break;
				case '3': // down, left
					if (dir == 2) //아래 방향 이었다면
						findRoad(r, c - 1, d);
					else if (dir == 3) // 오른 방향 이었다면
						findRoad(r - 1, c , d);
					break;
				case '4': // ㄱ
					if (dir == 2) //위 방향 이었다면
						findRoad(r, c - 1, d);
					else if (dir == 1) // 오른 방향 이었다면
						findRoad(r + 1, c , d);
					break;
				case '.': // 빈 공간(새로운 값을 넣어 본다)
					A.r = row;
					A.c = col; // 찾았다고 표시
					if(!flag) {
						for (int setChar = 0; setChar < 6; setChar++) {
							flag = true;
							map[row][col] = blocks[setChar];
							if(!realFlag) {
								findRoad(row, col, d);
							}
								flag = false;
						}
					}
					break;
				}

				visited[row][col] = true; // 방문 표시 해제
			}
		}
	}

} // class end

//Point
class Point {
	int r, c;  // 위치
	char block;  // 블록

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
