package KSY;

import java.io.*;
import java.util.*;

//12272KB/	80ms

public class S2629_양팔저울 {
	
	static int N, M;
	static int[] weights;
	static StringBuilder sb;
	static boolean dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());  // 수의 개수
		
		weights = new int[N];
		dp = new boolean[31][15001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		
		M = Integer.parseInt(br.readLine());  // 구슬의 개수(7이하)
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int marble = Integer.parseInt(st.nextToken());
			if(marble > 15000) {
				sb.append("N ");
			} else
				sb.append(dp[N][marble]? "Y " : "N ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void DFS(int depth, int weight) {
		if(dp[depth][weight]) return;  // 이미 만들었다면
		dp[depth][weight] = true;  // 만들 수 있음
		if(depth == N) return; // 추 개수 넘너가면 
		
		// 추가
		DFS(depth+1, weight + weights[depth]);
		// 빼기
		DFS(depth+1, Math.abs(weight - weights[depth]));
		// 미추가
		DFS(depth+1, weight);
		
		
	}

}
