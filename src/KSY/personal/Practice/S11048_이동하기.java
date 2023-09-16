package KSY.personal.Practice;

import java.util.*;
import java.io.*;

// 72496KB/	444ms

public class S11048_이동하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] miro = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				miro[i][j] = miro[i][j] + Math.max(miro[i-1][j-1], Math.max(miro[i-1][j], miro[i][j-1]));
			}
		}
		
		System.out.println(miro[N][M]);

	}

}
