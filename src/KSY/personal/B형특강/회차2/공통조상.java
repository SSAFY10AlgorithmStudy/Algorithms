package KSY.personal.B형특강.회차2;

import java.io.*;
import java.util.*;

public class 공통조상 {
	
	static Map<Integer, List<Integer>> graph;
	static Map<Integer, List<Integer>> parents;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/personal/B형특강/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());  // V, E, v1, v2
			graph = new HashMap<>();
			parents = new HashMap<>();
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			int[] nodes = new int[V+1];
			
			for(int i=1; i<=V; i++) {
				graph.put(i, new ArrayList<>());
				parents.put(i, new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {  // edges
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
			}
			
			DFS(1);
			
			int[]
			
			System.out.println(parents.get(v1).toString() + " " + parents.get(v2).toString());
			
		}

	}
	
	private static void DFS(int vertex) {
		if(graph.get(vertex).isEmpty()) { // 리프 노드 
			return;
		}
		for(int v:graph.get(vertex)) {
			parents.get(v).add(vertex);
			DFS(v);
		}
	}

}
