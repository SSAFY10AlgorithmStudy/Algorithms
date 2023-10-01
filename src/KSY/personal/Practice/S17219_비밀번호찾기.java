package KSY.personal.Practice;

import java.util.*;
import java.io.*;

//	70012KB/	560ms

public class S17219_비밀번호찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> dir = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			dir.put(site, pw);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			sb.append(dir.get(site)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
