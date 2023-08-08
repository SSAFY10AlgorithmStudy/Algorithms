package d0808;

import java.util.*;
import java.io.*;

public class 트리의부모찾기 {
    
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\user\\Documents\\CAREER\\SSAFY\\Algorithms\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        boolean[] visited = new boolean[n+1];
        int[] ans = new int[n+1];

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }



        // bfs 시작
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            for(int i: graph.get(cur)) {
                if (!visited[i]){
                    q.add(i);
                    ans[i] = cur;
                }
            }
        }
        //끝

        for(int i=2; i<=n; i++) {
            sb.append(ans[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
