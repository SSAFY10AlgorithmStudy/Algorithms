package KSY;

import java.io.*;
import java.util.*;

// 12704KB/	104ms

public class S9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[][] adjMatrix = new boolean[N+2][N+2];  // 집, 편의점(N), 페스티벌 
//			int INF = Integer.MAX_VALUE;
//			Arrays.fill(adjMatrix, INF);

			// home
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			
			// combini
			int[][] combinies = new int[N+1][2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				combinies[i][0] = Integer.parseInt(st.nextToken());
				combinies[i][1] = Integer.parseInt(st.nextToken());
				if(Math.abs(home[0] - combinies[i][0]) + Math.abs(home[1] - combinies[i][1]) <= 1000) {
					adjMatrix[0][i] = true;
				}
			}
			System.out.println(Arrays.toString(adjMatrix[0]));
			
			for(int i=1; i<=N; i++) {
				for(int j=i+1; j<=N; j++) {
					if( Math.abs(combinies[i][0] - combinies[j][0]) + Math.abs(combinies[i][1] - combinies[j][1]) <= 1000) {
						adjMatrix[i][j] = true;
						adjMatrix[j][i] = true;
					}
				}
				System.out.println(Arrays.toString(adjMatrix[i])); ;
			}
			
			//festival
			st = new StringTokenizer(br.readLine());
			int[] festival = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};			
			
			//집에서 바로 festival가능함 
			if(Math.abs(festival[0] - home[0]) + Math.abs(festival[1] - home[1]) <= 1000) {
				sb.append("happy").append("\n");
				continue;
			}
				
			// festival과 편의점 가능 판단
			for(int i=1; i<=N; i++) {
				if(Math.abs(festival[0] - combinies[i][0]) + Math.abs(festival[1] - combinies[i][1]) <= 1000) {
					adjMatrix[N+1][i] = true;
					adjMatrix[i][N+1] = true;
				}
			}
			System.out.println(Arrays.toString(adjMatrix[N+1]));
			
			boolean flag = false;
			boolean[] visited = new boolean[N+2];
			Queue<Integer> que = new ArrayDeque<>();
			que.offer(0);
			while(!que.isEmpty()) {
				int curr = que.poll();
				if(visited[curr])
					continue;
				visited[curr] = true;
				
				if(curr == N+1) {
					flag = true;
					break;
				}
				
				for(int i=1; i<=N+1; i++) {
					if(adjMatrix[curr][i]) {
						que.offer(i);
					}
				}
				
			}
			if(flag)
				sb.append("happy");
			else
				sb.append("sad");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
