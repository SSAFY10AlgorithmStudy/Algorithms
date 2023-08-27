package KSY.personal.AlgoURa.주차8;

import java.util.*;
import java.io.*;

public class DijkstraTest {
	
	//TODO : 다익스트라 샘플문제 풀어보기 
	
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("dijkstra_input_dege"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
			
		}
		
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		
		distance[start] = 0;
		int min=0, stopOver=0;
		for (int i = 0; i < V; i++) {  //모든 정점을 다 처리할 때까지 반복 
			//step1. 미방문 정점중에 출발지에서 가장 가까운 정점 찾기 
			stopOver = -1;
			min = INF;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					stopOver = j;
				}
			}
			if(stopOver == -1) break;
			
			//step2. 방문처리 
			visited[stopOver] = true;
			// 상황에 따라서 처리 : 경우지가 곧 도착디면 끝내기 (출발지에서 모든 정점으로의 최단거리를 구할 때는 break 하지 말기)
			if(stopOver == end) break;
			
			//step3. 경유지를 이용하여 미방문 정점들의 출발지에서 자신으로의 최소비용 고려 
			for(Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				// 해당 정점이 방문 정점이 아니고 현재 정점에서 갈 수 있는 정점의 경우
				// 경유지 정점을 거쳐서 해당 점점을 갈 경우의 최단거리와 기존까지 계산된 해당정점까지의 최단거리를 비교하여 최소값을 만족하면 갱신 
				if(!visited[temp.vertex] && distance[temp.vertex] > min+temp.weight) {
					distance[temp.vertex] = min+temp.weight;
				}
			}
			
		}
		System.out.println(distance[end] != INF ? distance[end] : -1);
		
	}

}
