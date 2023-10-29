package d0930;

import java.io.*;
import java.util.*;


public class bj16928 { // 80ms
    public static void main(String[] args) throws Exception {
        // 참고 솔루션
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> slide = new HashMap<>();

        for (int i=0; i<n+m; i++) {
            st = new StringTokenizer(br.readLine());
            slide.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        boolean[] visited = new boolean[101];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1, 0});

        while(!q.isEmpty()) {
            int cur = q.peek()[0];
            int cnt  = q.peek()[1];
            q.poll();
            for (int i=1; i<=6; i++) {
                int nx = cur + i;
                if (nx == 100) {
                    System.out.println(cnt+1);
                    return;
                } else if (nx < 100) {
                    while (slide.containsKey(nx)) {
                        nx = slide.get(nx);
                    }
                    if (!visited[nx]) { // 안가봤으면
                        visited[nx] = true;
                        q.offer(new int[] {nx, cnt+1});
                    }
                }
            }
        }


    }

    // 내 솔루션 수정
//    public class Main{
//        public static void main(String[] args) throws Exception {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            int n = Integer.parseInt(st.nextToken());
//            int m = Integer.parseInt(st.nextToken());
//
//            HashMap<Integer, Integer> ladder = new HashMap<>();
//            HashMap<Integer, Integer> snake = new HashMap<>();
//
//            for (int i=0; i<n; i++) {
//                st = new StringTokenizer(br.readLine());
//                ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//            }
//
//            for (int i=0; i<m; i++) {
//                st = new StringTokenizer(br.readLine());
//                snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//            }
//
//
//            int[] dp = new int[101];
//
//            Queue<Integer> q = new ArrayDeque<>();
//            q.offer(1);
//
//            while(!q.isEmpty()) {
//                int cur = q.poll();
//                for (int i=1; i<=6; i++) {
//                    int next = cur + i;
//                    if (next == 100) {
//                        System.out.println(dp[cur] + 1);
//                        return;
//                    }
//                    if (ladder.containsKey(next)) {
//                        next = ladder.get(next);
//                    } else if (snake.containsKey(next)) {
//                        next = snake.get(next);
//                    }
//                    if (dp[next] == 0) { // 안가본데 확인
//                        dp[next] = dp[cur] + 1;
//                        q.offer(next);
//                    }
//                }
//            }
//        }
//
//    }

}
