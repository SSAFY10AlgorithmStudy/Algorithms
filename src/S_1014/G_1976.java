package S_1014;


import java.io.BufferedReader;
import java.io.InputStreamReader;
//17464kb	152ms
public class G_1976 {
    static int n, m;
    static int map[][];
    static int tPlan[]; //여행계획
    static boolean visited[]; //해당도시 방문처리
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n+1];
        visited = new boolean[n + 1];
        //인접행렬 입력받기
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <=n ; j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        String[] s= br.readLine().split(" ");
        tPlan = new int[s.length];
        //여행 계획 입력받기
        for (int i = 0; i < m; i++) {
            tPlan[i] = Integer.parseInt(s[i]);
        }
        //처음껄로 dfs
        find(tPlan[0]);
        boolean flag = true;
        //여행계획중에 방문 안한게 있으면 FALSE
        for (int t : tPlan) {
            if (!visited[t]) {
                flag = false;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }

    private static void find(int idx) {
        visited[idx] = true;

        for (int i = 1; i <=n ; i++) {
            //idx에서 i로 갈수 있는 도시가 있고 방문하지 않았다면
            if(map[idx][i] == 1 && !visited[i]){
                find(i);
            }
        }
    }

}
