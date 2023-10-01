package KSY.personal.Practice;

import java.util.*;
import java.io.*;

//13484KB/	116ms

public class S1012_유기농배추 {
	
	static int[] dr = new int[] {1, -1, 0, 0};
	static int[] dc = new int[] {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=0; test<T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());  // 가로
			int N = Integer.parseInt(st.nextToken());  // 세로
			int K = Integer.parseInt(st.nextToken());  // 배추 개수
			int answer=0;
			
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			Queue<Position> que = new ArrayDeque<>();
			
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				map[r][c] = 1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						que.offer(new Position(i, j));
						visited[i][j] = true;
						while(!que.isEmpty()) {
							Position curr = que.poll();
							
							for(int d=0; d<4; d++) {
								int row = curr.r + dr[d];
								int col = curr.c + dc[d];
								if(-1 < row && row < N && -1 < col && col < M && !visited[row][col] && map[row][col] == 1) {
									visited[row][col] = true;
									que.offer(new Position(row, col));
								}
							}
							
						}
						answer++;
					}
				}
				
			}
			
			sb.append(answer).append("\n");
			
			
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}

class Position{
	int r, c;
	Position(int r, int c){
		this.r = r; this.c = c;
	}
}