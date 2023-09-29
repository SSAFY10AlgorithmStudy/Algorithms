package S_0923;

import java.util.*;
//62360kb	540ms
import java.io.*;
public class G_1766 {
	
    static ArrayList<Integer>[] graph;
    static int N,M;
    static int arr[];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s [] = br.readLine().split(" ");
        
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <=N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        //위상정렬 맵 입력받고 진입차수 세기
        arr = new int[N+1];
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph[a].add(b);
            graph[b].add(a);
            arr[b]++;
        }
        StringBuilder sb = new StringBuilder();
        //우선순위 큐로 만듬 3번 조건 -쉬운 문제먼저 풀기
        PriorityQueue<Integer> dq = new PriorityQueue<>();
        for (int i = 1; i <=N ; i++) {
            if(arr[i] ==0){
                dq.add(i);

            }
        }

        //하나씩 꺼내서 진입차수 0 되는거 추가시켜주기
        while (!dq.isEmpty()){
            int idx = dq.poll();
            sb.append(idx).append(" ");
            for (int next :graph[idx]) {

                if(--arr[next] == 0){
                    dq.add(next);
                }

            }
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
