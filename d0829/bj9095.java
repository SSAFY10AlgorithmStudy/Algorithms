// https://www.acmicpc.net/problem/9095

package d0829;

import java.io.*;
import java.util.*;

public class bj9095 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n];

        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i=4; i<12; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i=0; i<n; i++) {
            System.out.println(dp[nums[i]]);
        }
    }


}