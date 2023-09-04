package KSY;

import java.io.*;
import java.util.*;

// 11600KB/	76ms

public class S9095_123더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test=0; test<T; test++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N+1];
			
			if(N == 1  || N == 2) {
				sb.append(N).append("\n");
				continue;
			}
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = dp[1] + dp[2] + 1;
			
			for(int i=4; i<=N; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			sb.append(dp[N]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
