package KSY.personal.Practice;

import java.util.*;
import java.io.*;

public class S15655_N과M6 {
	
	static List<Integer> numbers;
	static boolean[] visited;
	static List<Integer> answer = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		numbers = new ArrayList<>();
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(numbers);
		
		DFS(0, 0, N, M);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	
	public static void DFS(int depth, int start, int N, int M) {
		if(depth == M) {
			answer.stream().forEach(i -> {sb.append(i).append(" ");});
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				answer.add(numbers.get(i));
				DFS(depth+1, i+1, N, M);
				answer.remove(answer.size()-1);
			}
		}
	}

}
