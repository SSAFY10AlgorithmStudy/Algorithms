package KSY.personal.BeforeLunch;

import java.io.*;
import java.util.*;

public class BJ2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter sw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] oneLine = br.readLine().split(" ");
		 
		int N = Integer.parseInt(oneLine[0]);
		int M = Integer.parseInt(oneLine[1]);
		
		ArrayList<Integer>[] g = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			g[i] = new ArrayList<Integer>();
		}
		
		int indegree[] = new int[N+1];  // 1~N
		for (int i = 0; i < M; i++) {
			String[] M_input = br.readLine().split(" ");
			int front = Integer.parseInt(M_input[0]);
			int back = Integer.parseInt(M_input[1]);
			g[front].add(back);
			indegree[back]++;
		}
		
		
		//처리
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <=N; i++) {
			if(indegree[i] == 0) {  // 진입차수가 0인 노드(시작점)를 큐에 삽입
				que.offer(i);
			}
		}
		
		while (!que.isEmpty()) {
			int curr = que.poll();
			sb.append(curr).append(" ");
			
			for (int v: g[curr]) {  // 꺼낸 노드와 연결된 모든 노드 방문하며 개수 차감 
				if(--indegree[v] == 0) {
					que.offer(v);
				}
			}
		}
		
		sw.write(sb.toString());
		sw.flush();
		sw.close();
		

	}  // main end

}
