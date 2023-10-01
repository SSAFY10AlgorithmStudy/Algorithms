package KSY;

import java.util.*;
import java.io.*;

// 35140KB/	392ms

public class S1655_가운데를말해요 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		int N = Integer.parseInt(br.readLine());
		maxHeap.offer(Integer.parseInt(br.readLine()));  // 첫 숫자
		sb.append(maxHeap.peek()).append("\n");
		
		for(int i=0; i<N-1; i++) {
			int number = Integer.parseInt(br.readLine());  // 확인 할 값
			
			if(number > maxHeap.peek()) {
				minHeap.offer(number);
				if(maxHeap.size() < minHeap.size()) {
					maxHeap.offer(minHeap.poll());
				}
			} else {
				maxHeap.offer(number);
				if(maxHeap.size() - minHeap.size() > 1) {
					minHeap.offer(maxHeap.poll());
				}
			}
			
			
			sb.append(maxHeap.peek()).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
