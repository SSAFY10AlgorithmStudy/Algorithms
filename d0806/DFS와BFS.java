// https://www.acmicpc.net/problem/1260
// DFS와 BFS
// 21632kb, 368ms

import java.io.*;
import java.util.*;

public class DFS와BFS {
	
	private static boolean bfsVisited[];
	private static boolean dfsVisited[];
	private static Map<Integer, List<Integer>> graph;
	private static int[] graph2 = new int[1000];
	private static int start;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\user\\Documents\\CAREER\\SSAFY\\Algorithms\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		bfsVisited = new boolean[N+1];
		dfsVisited = new boolean[N+1];
		
		graph = new HashMap<>();

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if (!graph.containsKey(n1)) {
				graph.put(n1, new ArrayList<Integer>());
			}
			if (!graph.containsKey(n2)) {
				graph.put(n2,  new ArrayList<Integer>());
			}
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}

		for (int gk: graph.keySet()) {
			Collections.sort(graph.get(gk));
		}
		
		dfs(start);
		System.out.println();
		bfs(start);
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	private static void dfs(int cur) {
		dfsVisited[cur] = true;
		System.out.printf(cur + " ");
		List<Integer> neighbor = graph.get(cur);
		if (neighbor != null) {			
			for(int n: neighbor) {
				if (!dfsVisited[n]) {
					dfs(n);
				}
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		bfsVisited[start] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.printf(cur + " ");
			List<Integer> neighbors = graph.get(cur);
			if (neighbors != null) {				
				for(int n: neighbors) {
					if (!bfsVisited[n]) {
						bfsVisited[n] = true;
						queue.offer(n);
					}
				}
			}
		}
		
		
	}

}