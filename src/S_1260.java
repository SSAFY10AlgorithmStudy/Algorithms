import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S_1260 {
    static int n,m,v;
    static List<Integer>[] map;
    static boolean []visited;
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        v = Integer.parseInt(s[2]);

        visited = new boolean[n+1];
        map = new ArrayList[n + 1];
        for (int i = 0; i <map.length ; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            map[a].add(b);
            map[b].add(a);
        }
        for (int i = 0; i < map.length; i++) {
            Collections.sort(map[i]);
        }
        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);

    }

    private static void bfs(int v) {
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(v);
        System.out.print(v+" ");
        visited[v] = true;
        while(!q.isEmpty()){
            int temp = q.pollFirst();
            for (int s :map[temp]) {
                if(!visited[s]){
                    System.out.print(s+" ");
                    visited[s] = true;
                    q.addLast(s);
                }
            }
        }

    }

    private static void dfs(int v) {
        System.out.print(v+" ");
        visited[v] = true;
        for (int i = 0; i < map[v].size(); i++) {
            if (!visited[map[v].get(i)]) {
                visited[map[v].get(i)] = true;
                dfs(map[v].get(i));
            }
        }
    }

}
