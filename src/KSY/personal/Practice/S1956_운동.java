package KSY.personal.Practice;

import java.util.*;
import java.io.*;

public class S1956_운동 {
	
	static int answer = 0;
	static Map<Integer, List<int[]>> nodes = new HashMap<>();
	static boolean[] visited;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		visited = new boolean[V+1];
		parents = new int[V+1];
		Map<Integer, int[]> edges = new HashMap<>();
		
		for(int i=1; i<=V; i++) {
			nodes.put(i, new ArrayList<>());
			parents[i] = i;
		}
		
		PriorityQueue<Node1> pq = new PriorityQueue<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			nodes.get(a).add(new int[]{b, c});
//			edges.put(c, new int[] {a, b});
			pq.offer(new Node1(a, b, c));
		}
		 
		
		while(!pq.isEmpty()) {
			Node1 curr = pq.poll();
			visited[curr.a] = true;
			
			for(int[] temp: nodes.get(curr.a)) {
				if(!visited[temp[0]]) {
					pq.offer(new Node1(1,1,1));
				}
			}
			
		}
		

	}
	
	public static int find(int x) {
		if(parents[x] != x) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}
	
	public static boolean union(int x, int y) {
		int xroot = find(x);
		int yroot = find(y);
		if(xroot == yroot) return false;
		
		parents[xroot] = parents[yroot];
		return true;
	}
	


}

class Node1 implements Comparable<Node1>{
	int a, b, c;
	Node1(int a, int b, int c){
		this.a = a; this.b = b; this.c = c;
	}
	@Override
	public int compareTo(Node1 o) {
		return this.c - o.c;
	}
}