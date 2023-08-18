package KSY.personal.AlgoURa;

import java.util.Arrays;
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
			//인접행렬 
//			adjMatrix[from][to] = 1;
//			adjMatrix[to][from] = 1;
			
			//인접리스트 
			adjList[from] = new Node(to, adjList[from]);  // 연결된 순서는 상관없으므로 가능한 연산(from과 연결된 아이들끼리의 관계는 아무것도 없음)
			adjList[to] = new Node(from, adjList[to]);
		}
		
//		for(int[] is : adjMatrix) {
//			System.out.println(Arrays.toString(is));
//		}
		for(Node node : adjList) {  // node : 각 정점의 인접리스트의 헤드 
			System.out.println(node);
		}

	}

}
