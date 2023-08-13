package KSY;

import java.io.*;
import java.util.*;

public class S1068 { // 트리 
	static Map<Integer, List<Integer>> graph;
	static int answer=0;
	static int removeNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		graph = new HashMap<>();
		for(int v=0; v<N;v++) {
			graph.put(v, new ArrayList<>());
		}
		
		int rootNode=0;
		for(int v=0; v<N; v++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent != -1)
				graph.get(parent).add(v);
			else
				rootNode = v;
		}
		
		removeNode = Integer.parseInt(br.readLine());  //지울 노드 
		DFS(rootNode);
		
		System.out.println(answer);

	}
	
	private static void DFS(int vertex) {
		if(vertex == removeNode)
			return;
		
		if(graph.get(vertex).isEmpty() | (graph.containsKey(removeNode) && graph.get(vertex).size()-1 == 0)) { // 리프노드 
				answer++;
		} else {
			for(int v: graph.get(vertex)) {
				if(v != removeNode) {  //지운 노드가 아니라
					DFS(v);
				}
			}
		}
	}

}
