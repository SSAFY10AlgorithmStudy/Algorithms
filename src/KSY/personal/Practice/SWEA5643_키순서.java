package KSY.personal.Practice;

import java.util.*;
import java.io.*;

//92,888 kb/ 1,901 ms

public class SWEA5643_키순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int ans =0;
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			boolean[][] adjMatrix = new boolean[N+1][N+1];
			
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = true;
			}
			
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(adjMatrix[i][k] && adjMatrix[k][j] && !adjMatrix[i][j])
							adjMatrix[i][j] = true;
					}
				}
			}
			
			for(int i=1; i<=N; i++) {
				boolean flag = false;
				for(int j=1; j<=N; j++) {
					if(i!=j && !adjMatrix[i][j] && !adjMatrix[j][i]) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					ans++;
				}
			}
			
			
			sb.append("#").append(test).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
