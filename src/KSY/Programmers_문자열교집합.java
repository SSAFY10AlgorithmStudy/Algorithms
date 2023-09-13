package KSY;

import java.util.*;
import java.io.*;

//128,388 kb / 707 ms

public class Programmers_문자열교집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt=0;
			
			Map<String, Integer> map = new HashMap<>();
			
			// 그룹1
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				String s = st.nextToken();
				map.put(s, 1);
			}
			
			// 그룹2
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				String s = st.nextToken();
				if(map.containsKey(s)) {
					cnt++;
				}
			}
			
			sb.append("#").append(test).append(" ").append(cnt).append("\n");
			
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
