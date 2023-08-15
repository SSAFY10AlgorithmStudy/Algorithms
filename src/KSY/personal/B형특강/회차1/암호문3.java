package KSY.personal.B형특강.회차1;
import java.util.*;
import java.io.*;

public class 암호문3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test=1; test<=10; test++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> list = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			for(int i=0; i<M; i++) {
				String op = st.nextToken(); // I/D/A
				int x, y, s;
				switch(op) {
				case "I":  // insert
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++) {
						
					}
					break;
				case "D": // delete
					break;
				case "A":  // add
					x = Integer.parseInt(st.nextToken());
					for(int j=0; j<x; j++)
					break;
				}
				
			}
			
			sb.append("#").append(test).append("\n");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i));
			}
		}
		System.out.println(sb);

	}

}
