package d1007;

import java.io.*;
import java.util.*;

public class bj16928 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ladder = new HashMap<>();
        HashMap<Integer, Integer> snake = new HashMap<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        int[] dp = new int[101];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i=1; i<=6; i++) {
                int next = cur + i;
                if (next == 100) {
                    System.out.println(dp[cur] + 1);
                    return;
                }
                if (ladder.containsKey(next)) {
                    next = ladder.get(next);
                } else if (snake.containsKey(next)) {
                    next = snake.get(next);
                }
                if (dp[next] == 0) { // 안가본데 확인
                    dp[next] = dp[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }

}