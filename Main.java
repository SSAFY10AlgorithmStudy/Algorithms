// https://www.acmicpc.net/problem/1949

import java.io.*;
import java.util.*;

public class Main {

    private static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    private static int[][] memo;
    private static boolean[] visited;
    private static int n;
	
	public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        memo = new int[n+1][2];

        for (int i=1; i<=n; i++) {
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
        // System.out.println(Arrays.deepToString(memo));
        System.out.println(Math.min(memo[1][0], memo[1][1]));
        
    }

    private static void dfs(int cur) {
        List<Integer> next = graph.get(cur);
        visited[cur] = true;

        for (int friend: next) {
            if (!visited[friend]) {
                dfs(friend); // cur -> 1, friend -> 2
    
                memo[cur][0] += Math.min(memo[friend][0], memo[friend][1]); // ea
                memo[cur][1] += memo[friend][0]; // nea
            }
        }
        memo[cur][0] += 1; // cur 이 ea 인 경우 한명 추가
    }
	
}