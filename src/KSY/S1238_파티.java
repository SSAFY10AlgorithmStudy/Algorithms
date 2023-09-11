package KSY;

import java.util.*;
import java.io.*;

//18568KB/	2288ms

public class S1238_파티 {
	
	static int[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		int INF = 1000000;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) continue;
				adjMatrix[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = w;
		}
		
		//플로이드 워샬
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(adjMatrix[i][k] + adjMatrix[k][j] < adjMatrix[i][j])
							adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];						
				}
			}
		}
		
		int max=0;
		for(int i=1; i<=N; i++) {
			int temp = adjMatrix[i][X] + adjMatrix[X][i];
			if(temp > max)
				max = temp;	
		}
		
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
