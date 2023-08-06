// https://www.acmicpc.net/problem/2178
// 미로탐색
// 12276kb, 96ms

import java.io.*;
import java.util.*;

public class 미로탐색 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] maze = new boolean[N+2][M+2];
		boolean[][] visited = new boolean[N+2][M+2];
		int[][] distance = new int[N+2][M+2];
		
		for (int i=0; i<N; i++) {
			String row = br.readLine();
			for (int j=0; j<M; j++) {
				if (row.charAt(j) == '1') {
					maze[i+1][j+1] = true; 
				}
			}
		}
		
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(1);
		visited[1][1] = true;
		distance[1][1] = 1;
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			
			if (x == M && y == N) {
				System.out.println(distance[y][x]);
				return;
			}
			
			for (int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if (maze[ny][nx] && !visited[ny][nx]) {
					queue.offer(nx);
					queue.offer(ny);
					visited[ny][nx] = true;
					distance[ny][nx] = distance[y][x] + 1;
				}
				
			}
		}

	}

}