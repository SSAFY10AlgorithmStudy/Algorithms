package KSY;

import java.util.*;
import java.io.*;

public class S11725 {
	static int[] answer;
	static Map<Integer, List<Integer>> graph;
	static boolean[] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		answer = new int[N+1];
		checked = new boolean[N+1];
		
		//node 설정(인접 리스트)
		graph = new HashMap<>();
		for(int i=1; i<=N; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		DFS(1);
		
		for(int i=2; i <= N; i++)
			sb.append(answer[i]).append("\n");
		System.out.println(sb);

	}
	
	public static void DFS(int vertex) {
		if(!checked[vertex]) {
			checked[vertex] = true;
			for(int v:graph.get(vertex)) {
				if(!checked[v]) {
					answer[v] = vertex;
					DFS(v);
				}
			}
		}
	}

}
