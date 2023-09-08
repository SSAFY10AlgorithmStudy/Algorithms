import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//파티
public class G_1238 {

    static int N,M,X; //N 개의 숫자, M개 단방향도로 개수 , X 돌아오고 다시 갈 수 있는 곳
    static ArrayList<int[]> graph[];
    static int answer ;
    static int dis[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        
        graph = new ArrayList[N+1];
        for (int i = 1; i <=N ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int wei = Integer.parseInt(s[2]);
            graph[a].add(new int[]{b,wei}); //그래프만들기
        }
        answer = Integer.MIN_VALUE; //정답 최솟값으로

        dis= new int[N+1];
        for (int i = 1; i <=N ; i++) { //1부터 N까지 
            int go = dj(i,X); //가보고
            int back = dj(X,i); //돌아오기
            answer = Math.max(answer,go+back); //정답 갱신
        }
//        System.out.println(Arrays.toString(dis));
        System.out.println(answer);
    }

    private static int dj(int start, int end) {
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[start] = 0; //시작점 0
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        q.add(new int[]{start,0});

        while(!q.isEmpty()){ //다익스트라
            int[] cur = q.poll();
            int node = cur[0];
            int wei = cur[1];
            if(wei > dis[node]) continue;

            for (int[] next: graph[node]) {
                int nxtN = next[0];
                int nxtW = next[1];

                if (wei + nxtW < dis[nxtN]) {
                    dis[nxtN] = wei + nxtW;
                    q.add(new int[]{nxtN, dis[nxtN]});

                }
            }
        }
        return dis[end]; //X 까지 거리 계산
    }


}