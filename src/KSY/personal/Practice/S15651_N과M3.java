package KSY.personal.Practice;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class S15651_N과M3 {
	static int[] answer;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		
		DFS(0, N, M);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	
	public static void DFS(int depth, int N,  int M) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i <= N; i++) {
			answer[depth] = i;
			DFS(depth+1, N, M);
		}
	}

}
