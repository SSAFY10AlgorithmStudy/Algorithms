package KSY.personal.Prectice;

import java.util.*;
import java.io.*;

//21160KB/	120ms

public class S15642_N과M_4 {
	static int[] answer;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[M];
		
		DFS(0, 1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int depth, int start) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=N; i++) {
			answer[depth] = i;
			DFS(depth+1, i);
		}
	}

}
