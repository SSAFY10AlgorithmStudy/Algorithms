package KSY.personal.B형특강.회차3;

import java.util.*;
import java.io.*;

public class S2930_힙 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src/KSY/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			int answer=0;
			
			PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());
			
			sb.append("#").append(test).append(" ");
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				switch(op) {
				case "1":
					int node = Integer.parseInt(st.nextToken());
					pQue.offer(node);
					
					break;
				case "2":
					if(pQue.isEmpty())
						sb.append(-1);
					else
						sb.append(pQue.poll());
					sb.append(" ");
					break;
				}
			}
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
