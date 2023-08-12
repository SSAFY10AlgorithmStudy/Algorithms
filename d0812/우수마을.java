// https://www.acmicpc.net/problem/1949

package d0812;

import java.io.*;
import java.util.*;


// memory 22192, time 208ms
public class 우수마을 {

    private static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    private static int[][] memo;
    private static int[] people;
    private static boolean[] visited;
    private static int n;
	
	public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        people = new int[n+1];
        visited = new boolean[n+1];
        memo = new int[n+1][2];

        // 도시 인구수 저장
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            graph.put(i, new ArrayList<Integer>());
        }

        // 트리 저장
        for (int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        dfs(1);
        System.out.println(Arrays.deepToString(memo));
        System.out.println(Math.max(memo[1][0], memo[1][1]));
        
    }

    private static void dfs(int cur) {
        List<Integer> next = graph.get(cur);
        visited[cur] = true;

        for (int city: next) {
            if (!visited[city]) {
                dfs(city);

                memo[cur][0] += memo[city][1]; // 선택
                memo[cur][1] += Math.max(memo[city][0], memo[city][1]); // 미선택
            }
        }
        memo[cur][0] += people[cur];
    }
	
}