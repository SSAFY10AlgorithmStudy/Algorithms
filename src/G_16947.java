
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class G_16947 {
    static int N;
    static ArrayList<Integer>[] route;
    static boolean visited[],cycle[];
    static int distance[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        route = new ArrayList[N+1];
        cycle = new boolean[N+1];
        distance = new int[N+1];

        for (int i = 1; i <= N; i++) {
            route[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            String s[] = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            route[a].add(b);
            route[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if(find(i,-1,i)){
                break;
            }
            Arrays.fill(cycle,false);
        }

        bfs();

        for (int i = 1; i <= N; i++) {
            System.out.print(distance[i] + " ");
        }

    }

    private static void bfs() {
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        visited = new boolean[N+1];

        for (int i = 1; i <=N ; i++) {
            if(cycle[i]){
                dq.add(i);
                visited[i] = true;
            }
        }
        while(!dq.isEmpty()){
            int p = dq.poll();
            for (int ro:route[p]) {
                if(!visited[ro]){
                    visited[ro] = true;
                    dq.add(ro);
                    distance[ro] = distance[p]+1;
                }
            }
        }


    }

    private static boolean find(int now,int par,int start) {
        cycle[now] = true;
        for (int next : route[now]) {
            if(!cycle[next]){
                if(find(next, now,start)) return true;

            }
            else if(next == start && par != next) return true;
        }
        cycle[now] = false;
        return false;
    }


}
