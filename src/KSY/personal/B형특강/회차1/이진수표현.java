package KSY.personal.B형특강.회차1;
import java.util.*;
import java.io.*;

// 끝 k개의 값 가져오기 => '&' 연산자!!

public class 이진수표현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
//			(내풀이)
//			Deque<Integer> que = new ArrayDeque<>();
//			while(M>0) {
//				que.offer(M%2);
//				M /= 2;
//			}
//			
//			boolean flag = false;
//			for(int i=0; i<N; i++) {
//				int temp = que.poll();
//				if(temp != 1) {
//					flag = true;
//					System.out.println("OFF");
//					break;
//				}
//					
//			}
//			if(!flag)
//				System.out.println("ON");
			
			int mask = (1 <<(N)) - 1; // 111....1(길이 N)
			if(mask == (M & mask)) {
				System.out.println("#"+test+" " + "ON");
			} else {
				System.out.println("#"+test+ " " + "OFF");
			}
			
		}

	}

}
