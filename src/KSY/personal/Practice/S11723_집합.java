package KSY.personal.Practice;

import java.io.*;
import java.util.*;

public class S11723_집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int num;
			
			switch(op) {
				case "add":
					num = Integer.parseInt(st.nextToken());
					set.add(num);
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					if(set.contains(num)) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "remove":
					num = Integer.parseInt(st.nextToken());
					set.remove(num);
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					if(set.contains(num)) {
						set.remove(num);
					} else {
						set.add(num);
					}
					break;
				case "all":
					for(int n=1; n<=20; n++) {
						set.add(n);
					}
					break;
				case "empty":
					set.clear();
					break;
			}
			
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
