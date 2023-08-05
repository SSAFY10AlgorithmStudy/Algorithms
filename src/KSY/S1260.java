package KSY;

import java.util.*;

public class S1260 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= V; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N+1];
        dfs(graph, visited, V);
        System.out.println();

        visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        bfs(graph, visited, queue);
    }

    static void dfs(List<List<Integer>> graph, boolean[] visited, int vertex) {
        if (!visited[vertex]) {
            visited[vertex] = true;
            System.out.print(vertex + " ");
            for (int v : graph.get(vertex)) {
                if (!visited[v]) {
                    dfs(graph, visited, v);
                }
            }
        }
    }

    static void bfs(List<List<Integer>> graph, boolean[] visited, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int q = queue.poll();
            if (!visited[q]) {
                visited[q] = true;
                System.out.print(q + " ");
                for (int v : graph.get(q)) {
                    if (!visited[v]) {
                        queue.add(v);
                    }
                }
            }
        }
    }
}
