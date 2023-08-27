package KSY.personal.B형특강.회차2;

import java.io.*;
import java.util.*;

public class 영준이의진짜BFS {
	
	static Map<Integer, List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/personal/B형특강/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			
			int N = Integer.parseInt(br.readLine());
			graph = new HashMap<>();
			visited = new boolean[N+1];
			
			for(int i=1; i<=N; i++) {
				graph.put(i, new ArrayList<>());
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=2; i<=N; i++) {
				int parent = Integer.parseInt(st.nextToken());
				graph.get(parent).add(i);
			}
			
			Queue<Integer> que = new ArrayDeque<>();
			que.offer(1);
			visited[1] = true;
			int answer = 0;
			while(!que.isEmpty()) {
				int curr = que.poll();
				System.out.print(curr+ " ");
				answer++;
				for(int v: graph.get(curr)) {
					if(!visited[v]) {
						que.offer(v);
					}
				}
			}
			System.out.println();
			sb.append("#").append(test).append(" ").append(answer).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
