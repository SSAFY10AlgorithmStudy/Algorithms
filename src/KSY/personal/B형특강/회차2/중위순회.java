package KSY.personal.B형특강.회차2;

import java.io.*;
import java.util.*;

public class 중위순회 {
	static Node[] nodes;
	static String[] vertexes;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/personal/B형특강/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			nodes = new Node[N+1];
			vertexes = new String[N+1];
		
			for(int i=1; i<=N; i++) {
//				Node node = new Node();
				StringTokenizer st = new StringTokenizer(br.readLine());  // 정점번호, 문장, 왼쪽 자식, 오른쪽 자식
				int index = Integer.parseInt(st.nextToken());
				String word = st.nextToken();
				
//				if(st.hasMoreTokens()) // 자식이 있음
//					node.right = Integer.parseInt(st.nextToken());
//				st.ne
//				if(st.hasMoreTokens())  // 자식이 있음
//					node.left = Integer.parseInt(st.nextToken());	
//				while(st.hasMoreTokens()) {
//					st.nextToken();
//				}
				
//				nodes[node.index] = node;
				vertexes[i] = word;
				
			}
			
			
			
			sb.append("#").append(test).append(" ").append(false);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	
	private static void DFS(int vertex) {
		if(vertex > )
		DFS(vertex.left);
	}

}

class Node{
	int index;
	Node right, left;
	String word;
}