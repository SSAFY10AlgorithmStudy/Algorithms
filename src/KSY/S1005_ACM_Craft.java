package KSY;

import java.io.*;
import java.util.*;

public class S1005_ACM_Craft {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());  // 건물 개수
			int K = Integer.parseInt(st.nextToken());  // 순서 규칙 개수
			
			Map<Integer, List<Integer>> graph = new HashMap<>();
			int[] before = new int[N+1];
			Map<Integer, List<Building>> child = new HashMap<>();
			for(int i=1; i<=N; i++) {
				graph.put(i, new ArrayList<>());
				child.put(i, new ArrayList<>());
			}
			
			// 건물 짓는 비용
			int[] costs = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			
			// 건설 순서
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph.get(start).add(end);
				before[end] = start;
			}
			
			Queue<Integer> que = new ArrayDeque<Integer>();
			for(int i=1; i<=N; i++) {
				if(before[i] == 0) {
					que.offer(i);
				}
			}
			
			while(!que.isEmpty()) {
				int curr = que.poll();
				after[]
				
			}
			
			int W = Integer.parseInt(br.readLine()); // 승리를 위해 지어야 할 건물
			
			
		}

	}

}
class Building{
	int time, totalTime;
	Building(int time, int totalTime){
		this.time = time, this.totalTime = totalTime;
	}
}