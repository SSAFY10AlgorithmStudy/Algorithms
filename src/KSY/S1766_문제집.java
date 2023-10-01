package KSY;

import java.io.*;
import java.util.*;

// 52556KB/	516ms

public class S1766_문제집 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, List<Integer>> graph = new HashMap<>();  // 가야하는 애들
		for(int i=1; i<=N; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		int[] costs = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			costs[b]++;
		}
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			if(costs[i] == 0) {
				que.offer(i);
			}
		}
		
		while(!que.isEmpty()) {
			int curr = que.poll();
			sb.append(curr).append(" ");
			for(int c : graph.get(curr)) {
				costs[c]--;
				if(costs[c] == 0) {
					que.offer(c);
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}