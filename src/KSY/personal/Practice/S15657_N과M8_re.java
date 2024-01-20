package KSY.personal.Practice;

import java.util.*;
import java.io.*;

public class S15657_N과M8_re {
	
	static int N, M;
	static int[] answer, numbers;
	static boolean[] visisted;
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
		
		DFS(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static void DFS(int depth, int start) {
		if(depth == M) {
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
		
		for(int i=start; i<N; i++) {
			answer[depth] = numbers[i];
			DFS(depth+1, i);
		}
	}
}
