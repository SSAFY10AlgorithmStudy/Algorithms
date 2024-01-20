package KSY;

import java.io.*;
import java.util.*;

public class S9375_패션왕신해빈 {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			answer = 1;
			Map<String, Integer> map = new HashMap<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String kind = st.nextToken();
				if(!map.containsKey(kind)) {
					map.put(kind, 0);
				}
				map.put(kind, map.get(kind)+1);
			}
			
			for(int m:map.values()) {  // kind 종류 중 하나 선택
				answer *= m + 1;
			}
			
			sb.append(answer-1).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
}
