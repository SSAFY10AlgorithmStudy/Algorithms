import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;


public class S_11725 {
    static int n;
    static ArrayList<Integer>[] list;
    static boolean visited[];
    static int[] answer;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        list = new ArrayList[n+1];
        visited = new boolean[n + 1];
        answer = new int[n + 1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n-1; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            list[a].add(b);
            list[b].add(a);
        }
        //트리 루트 1로 정했음
//        System.out.println(Arrays.toString(list));
        LinkedList<Integer> q = new LinkedList<Integer>();
//        q.add(1);
//        bfs(q);
//        for (int i = 2; i < n+1; i++) {
//            System.out.println(answer[i]);
//        }
        dfs(1);
        for (int i = 2; i < n+1; i++) {
            sb.append(answer[i]).append("\n");
        }
        bw.append(sb);
        bw.close();
    }

//    private static void bfs(LinkedList<Integer> queue) {
//        while (!queue.isEmpty()) {
//            int cur = queue.poll();
//            visited[cur] = true;
//            for (int a : list[cur]) {
//                if(answer[a] == 0) answer[a] = cur;
//                if (!visited[a]) {
//                    queue.add(a);
//                }
//            }
//        }
//    }
    private static void dfs(int vertex){
        if (!visited[vertex]) {
            visited[vertex] = true;
            for (int v : list[vertex]) {
                if(answer[v] == 0) answer[v] =vertex;
                if (!visited[v]) {
                    dfs(v);
                }
            }
        }

    }

}
