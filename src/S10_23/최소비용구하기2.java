package S10_23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기2 {
    static final int MAX_VAL = 987654321;
    static int n,m;

    static int start, end;
    static ArrayList<Node> graph[];
    static ArrayList<Integer> data;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        data = new ArrayList<Integer>();
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            graph[a].add(new Node(b,c));
        }
        String []s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);

        dij(sb);
    }

    private static void dij(StringBuilder sb) {
        PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.weight,o2.weight);
            }
        });
        pq.add(new Node(start,0));
        int dist[]  = new int[n+1];
        Arrays.fill(dist,MAX_VAL);
        dist[start] = 0;
        int route[] = new int[n+1];
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int no = cur.no;
            int weight = cur.weight;

            if(dist[no] < weight) continue;
            for (Node next :graph[no]) {

                if( next.weight + dist[no] < dist[next.no]){
                    dist[next.no] =  next.weight + dist[no];
                    route[next.no] = no;
                    pq.add(new Node(next.no,dist[next.no]));
                }
            }

        }

        sb.append(dist[end]).append("\n");
        System.out.println(Arrays.toString(route));

        Stack<Integer> st = new Stack<Integer>();
        for (int i = end; i!=start  ; i=route[i]) {

            st.push(i);
        }
        st.push(start);
        sb.append(st.size()).append("\n");
        while(!st.isEmpty()){
            sb.append(st.pop()).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);

    }

    private static class Node {
        int no, weight;

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", weight=" + weight +
                    '}';
        }

        public Node(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }
}
