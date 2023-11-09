package d1109;

import java.io.*;
import java.util.*;

public class BJ1135 {

    static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();
        graph.add(new ArrayList<>()); // 민식이
        st.nextToken();
        for (int i=1; i<n; i++) {
            graph.add(new ArrayList<>());
            int parent = Integer.parseInt(st.nextToken());
            graph.get(parent).add(i);
        }

        int ans = dfs(0);
        System.out.println(ans);
    }

    static int dfs(int emp) {
        int time = 0;
        int call = 0;

        List<Integer> children = graph.get(emp);
        if (children.isEmpty()) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((t1, t2) -> t2 - t1);

        for (int child : children) {
            int dur = dfs(child);
            pq.offer(dur);
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            call++;
            time = Math.max(time, cur + call);
        }

        return time;
    }

}