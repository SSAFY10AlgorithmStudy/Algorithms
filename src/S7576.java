import java.io.*;
import java.util.*;

//108596KB/	588ms

public class S7576 {
	
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M]; // 원본
		Queue<int[]> que = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) { //익은 토마토 
					que.offer(new int[] {i, j, 1});  //위치, 카운트 
				}
			}
		}
		int cnt=0;
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			for(int d=0; d<4; d++) {
				int row = curr[0] + dr[d];
				int col = curr[1] + dc[d];
				if(-1 < row && row < N && -1 < col && col < M && map[row][col] == 0) {
					map[row][col] = curr[2]+1;
					cnt = curr[2];
					que.offer(new int[] {row, col, curr[2]+1});
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(cnt);

	}

}
