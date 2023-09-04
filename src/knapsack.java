

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class knapsack {

    static class Thing implements Comparable<Thing>{
        int vol, val;
        public Thing(int vol, int val) {
            this.vol = vol;
            this.val = val;
        }

        @Override
        public int compareTo(Thing o) {
            return Integer.compare(this.vol, o.vol);
        }

        @Override
        public String toString() {
            return vol + " " + val;
        }
    }


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n][k+1];
            List<Thing> things = new ArrayList<>();

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int vol = Integer.parseInt(st.nextToken()); // 부피
                int val = Integer.parseInt(st.nextToken()); // 가치
                things.add(new Thing(vol, val));
            }

            for (int i=1; i<=k; i++) {
                if (k >= things.get(0).vol) dp[0][i] = things.get(0).val;
            }

            for (int i=1; i<n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (j >= things.get(i).vol) {
                        dp[i][j] = Math.max(things.get(i).val + dp[i - 1][j - things.get(i).vol], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(dp[n-1][k]).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
    }

}

