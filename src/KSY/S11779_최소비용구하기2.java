package KSY;

import java.util.*;
import java.io.*;

import java.util.*;

//51104KB/	508ms

public class S11779_최소비용구하기2 {
    
    static ArrayList<Node>[] list;  // 각 마을에 연결 된 다른 마을 연결
    static int n, m, start, end; 
    static int[] dist;
    static int[] route; // 직전 노드 저장
    static boolean[] visited; 
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());  // 마을 수 
        m = Integer.parseInt(br.readLine());  // 노선 수
        
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, c));  // s에서 e로 가는 c 비용 연결
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());  // 시작 노드
        end = Integer.parseInt(st.nextToken());  // 끝 노드
        
        dist = new int[n + 1];  // start부터 각 i까지 최소 비용
        route = new int[n + 1];  // i에 도착하기 직전 마을
        Arrays.fill(dist, 1000000001);  // 무한수로 모든 배열 업데이
        visited = new boolean[n + 1];  // 방문 표시
        dijkstra();  // 다익스트라(특정 위치에서 각 노드로의 최소 거리) vs  플로이드-워샬 
        
        sb.append(dist[end]).append("\n");
        
        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0) {
            routes.add(current);
            current = route[current];
        }
        sb.append(routes.size()).append("\n");
        for(int i = routes.size() - 1; i >= 0; i--) {
            sb.append(routes.get(i) + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();  // 쁘리아라리큐 
        q.add(new Node(start, 0));  // 시작 노드
        dist[start] = 0;  // 시작 노드 거리 초기화 
        route[start] = 0;  // 시작 노드 이전 초기화
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            if(!visited[current.e]) visited[current.e] = true;  // 방문하지 않았다면 방문 표시 후 탐색
            else continue;
            
            for(int i = 0; i < list[current.e].size(); i++) {  // 연결된 마을 탐색 
                Node next = list[current.e].get(i);  // 연결 된 마을
                if(dist[next.e] > dist[current.e] + next.cost) {  // 업데이트 할 위치 비용 < '비용이 현재 위치 + 다음 비용'
                    dist[next.e] = dist[current.e] + next.cost; // 값 업데이트 
                    q.offer(new Node(next.e, dist[next.e]));  // 큐 삽입
                    route[next.e] = current.e;  // 부모 업데이트
                }
            }
        }
    }
    
    public static class Node implements Comparable<Node> {
        int e;  // 도착 노드
        int cost;
        
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {  // 비용 기준으로 쁘리아라리큐 정렬
            return this.cost - n.cost;
        }
    }
}
