package KSY.personal.Practice;

import java.util.*;
import java.io.*;

public class S1956_운동re {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int answer = Integer.MAX_VALUE;
		
		int[][] ms = new int[V+1][V+1];
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				ms[i][j] = 10000000;
			}
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			ms[a][b] = c;
		}
		
		for(int k=1; k<=V; k++) {
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					ms[i][j] = Math.min(ms[i][j], ms[i][k] + ms[k][j]);
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(ms[i][j] != 10000000 && ms[j][i] != 10000000) {
					answer = Math.min(answer, ms[i][j] + ms[j][i]);
				}
			}
		}
		
		System.out.print(answer != Integer.MAX_VALUE ? answer : -1);

	}

}
