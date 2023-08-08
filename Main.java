import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] graph;
    private static boolean[] visited;
    private static int answer;
    
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\user\\Documents\\CAREER\\SSAFY\\Algorithms\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[n1][n2] = w;
            graph[n2][n1] = w;
        }

        // for (int i=1; i<=n; i++) {
        //     System.out.println(Arrays.toString(graph[i]));
        // }
        // System.out.println("graphend");

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            visited = new boolean[n+1];
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            // int distance = 0;
            answer = 0;

            dfs(0, start, end);
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int distance, int cur, int end) {
        if (cur == end){
            answer = distance;
            return;
        }
        visited[cur] = true;
        for (int i=1; i<=n; i++) {
            int weight = graph[cur][i];
            if (weight > 0 && !visited[i]) {
                dfs(distance+weight, i, end);
            }
        }
    }

}
