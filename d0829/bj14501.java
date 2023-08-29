// https://www.acmicpc.net/problem/14501
package d0829;

import java.io.*;
import java.util.*;

public class bj14501 {


	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] session = new int[n+1][2];
        int[][] dp = new int [2][n+1];

        for (int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            session[i][0] = Integer.parseInt(s[0]);
            session[i][1] = Integer.parseInt(s[1]);
        }

        if (session[n-1][0] == 1) dp[1][n-1] = session[n-1][1];

        // 뒤에서 보면서
        for (int i=n-2; i>=0; i--) {
            int time = session[i][0];
            int payment = session[i][1];
            if (i + time <= n) { // 퇴사 전에 끝낼 수 있으면
                // 선택
                dp[0][i] = payment + Math.max(dp[0][i+time], dp[1][i+time]);
            }
            // 미선택
            dp[1][i] = Math.max(dp[0][i+1], dp[1][i+1]);
        }

        System.out.println(Math.max(dp[0][0], dp[1][0]));
    }


}