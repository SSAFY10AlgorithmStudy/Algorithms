package KSY.personal.Practice;

import java.util.*;
import java.io.*;

public class S15665_N과M11 {
	
	static int N, M;
	static int[] numbers, answer;
	static Set<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		answer = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		
		DFS(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	
	public static void DFS(int depth) {
		if(M == depth) {
			String temp = "";
			for(int i=0; i<M; i++) {
				temp += answer[i] + " ";
			}
			if(!set.contains(temp)) {
				set.add(temp);
				sb.append(temp).append("\n");
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			answer[depth] = numbers[i];
			DFS(depth+1);
		}
	}

}
