package KSY.personal.AlgoURa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

//무향 그래프 
public class AdjMatrixTest {
	
	//Node
	static class Node{
		int vertext;
		Node next;
		
		public Node(int vertext, Node next) {
			super();
			this.vertext = vertext;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertext=" + vertext + ", next=" + next.toString()+ "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node adjList[] = new Node[V];  // 헤드리스
		
		int[][] adjMatrix = new int[V][V];  // 초기값 0
		// 간선 있으면 1, 없으면 0
		
		for(int i=0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
//			인접행렬 
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
			
			//인접리스트 
			adjList[from] = new Node(to, adjList[from]);  // 연결된 순서는 상관없으므로 가능한 연산(from과 연결된 아이들끼리의 관계는 아무것도 없음)
			adjList[to] = new Node(from, adjList[to]);
		}
		
//		for(int[] is : adjMatrix) {
//			System.out.println(Arrays.toString(is));
//		}
//		for(Node node : adjList) {  // node : 각 정점의 인접리스트의 헤드 
//			System.out.println(node);
//		}
//		bfs(adjMatrix);
		bfs(adjList);
	}
	
	private static void bfs(int[][] adjMatrix) {
		int size = adjMatrix.length;
		Queue<Integer> que = new ArrayDeque<>();  // 큐에 넣는 값은 방문대상을 관리할 값과 그밖의 값들이 될 수 있다.
		boolean[] visited = new boolean[size];
		
		//탐색 시작점 정점0으로 하자
		que.offer(0);
		visited[0] = true;
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			System.out.println((char)(curr+65));
			
			//현 정점의 인접정점들 체크하며 대기열에 넣기
			for (int i = 0; i < size; i++) {
				if(adjMatrix[curr][i] != 0 && !visited[i]) {  // 인접해있고 방문하지 않았다면 
					que.offer(i);
					visited[i] = true;
				}
			}
		}
		
		
	}
	
	private static void bfs(Node adjList[]) {
		int size = adjList.length;
		Queue<Integer> que = new ArrayDeque<>();  // 큐에 넣는 값은 방문대상을 관리할 값과 그밖의 값들이 될 수 있다.
		boolean[] visited = new boolean[size];
		
		//탐색 시작점 정점0으로 하자
		que.offer(0);
		visited[0] = true;
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			System.out.println((char)(curr+65));
			
			//현 정점의 인접정점들 체크하며 대기열에 넣기
			for (Node temp = adjList[curr]; temp!=null; temp=temp.next) {
				if(!visited[temp.vertext]) {  // 인접해있고 방문하지 않았다면 
					que.offer(temp.vertext);
					visited[temp.vertext] = true;
				}
			}
		}
		
		
	}

}
