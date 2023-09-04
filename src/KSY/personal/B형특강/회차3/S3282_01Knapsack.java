package KSY.personal.B형특강.회차3;

import java.util.*;
import java.io.*;

public class S3282_01Knapsack {
	static int N, K, answer;
	static int[][] items;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src/KSY/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {  //test case
			StringTokenizer st = new StringTokenizer(br.readLine()); // N, K
			N = Integer.parseInt(st.nextToken());  // 물건 개수
			K = Integer.parseInt(st.nextToken());  // 최대 배낭 무게
			items = new int[N+1][2];  // 각 물건의 무게, 가치 저장할 배열
			int[][] answer = new int[N+1][K+1];  // DP
 			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				items[i][0] = Integer.parseInt(st.nextToken());  // weight
				items[i][1] = Integer.parseInt(st.nextToken());  // value
			}
			
			for(int i=1; i<=N; i++) {  // i개를 선택 
				for(int j=1; j<=K; j++) {  // 배낭의 무게
					int wi = items[i][0];
					if(wi <= j)  // 배낭의 고려할 물건보다 크다면 
						answer[i][j] = Math.max(answer[i-1][j], answer[i-1][j-wi] + items[i][1]);
					else // 배낭의 무게가 고려할 물건보다 작다면 
						answer[i][j] = answer[i-1][j]; // 이전에 계산한 값 그대로 
				}
			}
			
//			Knapsack(0, 0, 0);
			
			
			sb.append("#").append(test).append(" ").append(answer[N][K]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
//	private static void Knapsack(int idx, int value, int weight) {
//		if(idx == N && weight <= K) {
//			answer = Math.max(answer, value);
//			return;
//		}
//		if(weight > K)
//			return;
//		Knapsack(idx+1, value+items[idx][1], weight+items[idx][0]);
//		Knapsack(idx+1, value, weight);
//		
//	}

}
