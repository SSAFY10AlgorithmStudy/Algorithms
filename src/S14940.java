
import java.util.*;
import java.io.*;

public class S14940 {
	static int[] dr = new int[]{1, 0, -1, 0};
	static int[] dc = new int[]{0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] answer = new int[N][M];
		
		int r=0, c=0;
		//입력받기 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(answer[i], -1); // -1 초기화 
			for(int j=0; j<M; j++) { // ,,
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					answer[i][j] = 0;
					r = i;
					c = j;
				}
			}
		}
		
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {r, c, 0});
		
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			for(int d=0; d<4; d++) {
				int row = curr[0] + dr[d];
				int col = curr[1] + dc[d];
				if(-1 < row && row < N && -1 < col && col < M && answer[row][col] == -1) {
					if(map[row][col] == 1) {
						que.offer(new int[] {row, col, curr[2]+1});
						answer[row][col] = curr[2]+1;
					}
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0)
					answer[i][j] = 0;
				sb.append(answer[i][j]).append(" ");				
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
