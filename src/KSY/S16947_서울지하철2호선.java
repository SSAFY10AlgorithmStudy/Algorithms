package KSY;

import java.io.*;
import java.util.*;

//302012KB/	1156ms

public class S16947_서울지하철2호선 {

	static Map<Integer, List<Integer>> graph = new HashMap<>();
	static boolean[] cycle;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int v = 1; v <= N; v++) {
			graph.put(v, new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 각 역이 순환선에 포함되는지 판별
		cycle = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (checkCycle(i, i, i))  // 순환선을 찾았다면 
				break;
			cycle = new boolean[N + 1];
		}
		System.out.println(Arrays.toString(cycle));
		
		for(int v=1; v<=N; v++) {  // 각 역에 대해서 순환선과의 거리 BFS
			Queue<int[]> que = new ArrayDeque<>(); 
			que.offer(new int[] {v, 0});  // 
			boolean[] visited = new boolean[N+1];
			while(!que.isEmpty()) {
				int[] curr = que.poll();
				if(cycle[curr[0]]){  // cycle 찾음 
					sb.append(curr[1]).append(" ");
					break;
				}
				for(int ver: graph.get(curr[0])) {
					if(!visited[ver]) {
						visited[ver] = true;
						que.offer(new int[] {ver, curr[1]+1});
					}
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

//		for(int v=1; v<=N; v++)
//			System.out.println(v + " " + graph.get(v).toString());
	}

	private static boolean checkCycle(int prev, int now, int start) { // DFS로 순환 확인
		cycle[now] = true;
		for (int v : graph.get(now)) {
			if (!cycle[v]) {
				if (checkCycle(now, v, start))
					return true;
			} else if (v != prev && v == start)  // cycle 찾음!
				return true;
		}
		cycle[now] = false;
		return false;
	}

}
