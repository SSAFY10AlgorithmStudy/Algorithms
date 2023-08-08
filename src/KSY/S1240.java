package KSY;

import java.util.*;
import java.io.*;

public class S1240 {
	static boolean[] visited;
	static Map<Integer, List<int[]>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new HashMap<>();
		visited = new boolean[N+1];

		for(int i=0; i<N-1; i++) {  //edges
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new int[] {b, dist});
			graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new int[] {a, dist});
		}
		
		for(int test=0; test<M; test++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  // start
			int b = Integer.parseInt(st.nextToken());  // end
			
			DFS(b, a, 0);
			visited = new boolean[N+1];
		}
		
	}
	
	static public void DFS(int end, int now, int sumDist) {
		if(end == now) {
			System.out.println(sumDist);
		} else {
			if(!visited[now]) {
				visited[now] = true;
				for(int[] v: graph.get(now)) {
					if(!visited[v[0]]) {  //방문하지 않은 노드라면
						DFS(end, v[0], sumDist+v[1]);
					}
				}
				
			}
		}
	}

}
