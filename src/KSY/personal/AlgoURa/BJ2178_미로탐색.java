package KSY.personal.AlgoURa;

import java.util.*;
import java.io.*;

//12360KB/	92ms

public class BJ2178_미로탐색 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dr = new int[] {0, 1, 0, -1};  // right, down, left, up
		int[] dc = new int[] {1, 0, -1, 0};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][]map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			char[] aline = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = (int)(aline[j] - '0');
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {1, 0, 0});
		
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			
			for(int d=0; d<4; d++) {
			int row = curr[1] + dr[d];
			int col = curr[2] + dc[d];
			if(-1 < row && row < N && -1 < col && col < M && map[row][col] == 1) {
				//갈 수 있는 길이고 한 번만 방문한 곳이라면
				map[row][col] = curr[0]+1;  // 큐에 들어간 순간 이미 방문이 보장 됨. (중복 제거!!!)
				que.offer(new int[] {curr[0]+1, row, col});
			}
		}
		}
		System.out.println(map[N-1][M-1]);
	}
}
//	private static void BFS(int r, int c, int sum) {
//		answer[r][c] = sum;
//		if(r == N-1 && c == M-1) {  // 위치 찾음 
//			return;
//		}
//		for(int d=0; d<4; d++) {
//			int row = r + dr[d];
//			int col = c + dc[d];
//			if(-1 < row && row < N && -1 < col && col < M && map[row][col] == 1 && answer[row][col] != 0) {
//				//한 번도 가지 않은 곳이 아닌 현재 값보다 작은 값이면 업데이트 
//				BFS(row, col, sum+1);
//			}
//		}
//		
//	}

class Point implements Comparable<Point>{
	int r, c, value;
	Point(int r, int c, int value){
		this.r = r; this.c = c; this.value = value;
	}
	
	public int compareTo(Point p) {
		if(this.value > p.value) return 1;
		else {
			if(value < p.value) return -1;
			else return 0;
		}
	}
}