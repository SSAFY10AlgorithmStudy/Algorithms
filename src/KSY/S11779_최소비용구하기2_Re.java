package KSY;

import java.io.*;
import java.util.*;

public class S11779_최소비용구하기2_Re {
	
//	static Map<Integer, List<Point8>> graph = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());  // 도시 
		int M = Integer.parseInt(br.readLine());  // 버스
		int totalCost = 0;
		
		int[][] adjMatrix = new int[N+1][N+1];
		int INF = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++)
			Arrays.fill(adjMatrix[i], INF);
		
//		boolean[] visited = new boolean[N+1];
//		for(int i=1; i<=N; i++)
//			graph.put(i, new ArrayList<>());
		
		for(int i=0; i<M; i++) {  // 버스 노선
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());  // 시작
			int to = Integer.parseInt(st.nextToken());  // 도착
			int cost = Integer.parseInt(st.nextToken());  // 비용
			adjMatrix[from][to] = cost;
//			graph.get(from).add(new Point8(idx, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());  // 출발지 
		int end = Integer.parseInt(st.nextToken());  // 도착지
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(adjMatrix[i][k] != INF && adjMatrix[k][j] != INF)
						adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
				}
			}
		}
		
		sb.append(adjMatrix[start][end]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();


	}

}
