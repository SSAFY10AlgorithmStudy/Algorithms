package d0909;

import java.io.*;
import java.util.*;

public class bj1238 {

    static class Edge implements Comparable<Edge>{
        int to, weight;
        public Edge (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return to + " " + weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 줄로 읽어 빠르게 토큰으로 나누기

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> graph2 = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Edge(v2, w));
            graph2.get(v2).add(new Edge(v1, w));
        }

        // 파티에서 집가는 길
        int[] toHome = new int[n+1];
        int[] toParty = new int[n+1];
        Arrays.fill(toHome, Integer.MAX_VALUE);
        Arrays.fill(toParty, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n+1];
        boolean[] visited2 = new boolean[n+1];
        toHome[x] = 0;
        toParty[x] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(x, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue; // 이미 방문했으면 다음 작은 엣지
            visited[cur.to] = true;
            for(Edge e: graph.get(cur.to)) {
                if (!visited[e.to] && toHome[e.to] > toHome[cur.to] + e.weight ) {
                    toHome[e.to] = toHome[cur.to] + e.weight;
                    pq.offer(new Edge(e.to, toHome[e.to]));
                }
            }
        }

        // 각 집에서 파티가는길
        pq = new PriorityQueue<>();
        pq.offer(new Edge(x, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited2[cur.to]) continue; // 이미 방문했으면 다음 작은 엣지
            visited2[cur.to] = true;
//                System.out.println(graph.get(cur.to));
            for(Edge e: graph2.get(cur.to)) {
                if (!visited2[e.to] && toParty[e.to] > toParty[cur.to] + e.weight ) {
                    toParty[e.to] = toParty[cur.to] + e.weight;
                    pq.offer(new Edge(e.to, toParty[e.to]));
                }
            }
        }

        int taxiB = 0;
        for (int i=1; i<=n; i++) {
            int poten = toHome[i] + toParty[i];
            if (poten > taxiB) taxiB = poten;
        }

        System.out.println(taxiB);
    }

}