package KSY;

import java.io.*;
import java.util.*;

// 125,224kb/  908ms

public class S3000_swea_중간값구하기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			long answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 자연수 2개 개수
			int A = Integer.parseInt(st.nextToken()); // 초기값

			// 중간값을 기준으로 트리를 min heap, max heap으로 구성
			PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> right = new PriorityQueue<>();
			left.offer(A);
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				if(X > left.peek() && Y > left.peek()) {  // 둘 다 중간값보다 크다면 
					right.offer(X);
					right.offer(Y);
					left.offer(right.poll());
				} else if(X < left.peek() && Y < left.peek()) {  // 둘 다 중간값보다 작다면
					left.offer(X);
					left.offer(Y);
					right.offer(left.poll());
				} else {
					if(X > Y) {
						right.offer(X);
						left.offer(Y);
					} else {
						left.offer(X);
						right.offer(Y);
					}
				}
//				System.out.println(left.peek());
				answer = (left.peek() + answer) % 20171109;

			}

			sb.append("#").append(test).append(" ").append(answer);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
