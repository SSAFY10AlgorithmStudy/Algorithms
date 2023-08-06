package KSY;

import java.io.*;
import java.util.*;

public class S1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> edges = new HashMap<>();  // 각 노드 별 연결된 노드를 List로 저장

        Stack<Integer> stack = new Stack<>();
        stack.push(V); // DFS

        Queue<Integer> queue = new LinkedList<>();
        queue.add(V); // BFS

        // DFS
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges.computeIfAbsent(v1, k -> new ArrayList<>()).add(v2);  // v1의 key값이 있으면 가져오고 없으면 생성하여 삽입
            edges.computeIfAbsent(v2, k -> new ArrayList<>()).add(v1);
        }

        StringBuilder answer = new StringBuilder();
        Set<Integer> visited = new HashSet<>();  // 방문한 노드 표시를 위한 HashSet
        while (!stack.isEmpty()) {
            int s = stack.pop();
            if (!visited.contains(s)) {
                answer.append(s).append(" ");
                visited.add(s);

                List<Integer> neighbors = edges.get(s);  // 방문한 노드와 인접한 노드들 가져오기
                if (neighbors != null) {
                    Collections.sort(neighbors, Collections.reverseOrder());  // 노드가 큰 것부터 삽입하여 작은 값이 먼저 출력 될 수 있게 함
                    for (int _s : neighbors) {
                        if (_s != 0) {
                            stack.push(_s);
                        }
                    }
                }
            }
        }
        System.out.println(answer);

        answer = new StringBuilder();
        visited.clear();  // 방문한 노드 초기화
        while (!queue.isEmpty()) {
            int q = queue.poll();
            if (!visited.contains(q)) {  // 방문하지 않은 노드라면
                answer.append(q).append(" ");
                visited.add(q);

                List<Integer> neighbors = edges.get(q);  // 현재 방문한 노드와 인접한 노드 List
                if (neighbors != null) {
                    Collections.sort(neighbors);
                    for (int _q : neighbors) {
                        queue.add(_q);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
