package KSY;

import java.util.*;
import java.io.*;

//447296KB/	2952ms

public class S7662_이중우선순위큐 {
	
	static Map<Integer, Integer> live;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pqMin = new PriorityQueue<>();
			PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
			live = new HashMap<>();  //큐 안에 존재하는 수 & 개수
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				
				switch(op) {
				case "I":
					live.put(value, live.getOrDefault(value, 0) + 1);  // 큐에 존재하는 값으로 인식하기
					pqMin.offer(value);
					pqMax.offer(value);
					
					break;
				case "D":
					if(value == 1) {  // 최대값 삭제 
						if(!pqMax.isEmpty()) {
							removeMap(pqMax);
						}
					} else {  // 최소값 삭제
						if(!pqMin.isEmpty()) {
							removeMap(pqMin);
						}
					}
					break;
				}
			}
			
			if(live.size() == 0)
				sb.append("EMPTY");
			else {
				int n = removeMap(pqMax);
				sb.append(n).append(" ").append(live.size() == 0 ? n : removeMap(pqMin));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int removeMap(PriorityQueue<Integer> que) {
		int curr=-1;
		while(!que.isEmpty()) {
			curr = que.poll();
			if(live.getOrDefault(curr, 0) == 0)  // 지울 값이 없다면
				continue;
			
			if(live.get(curr) == 1) { // 지울 값이 한 개 있다면
				live.remove(curr);
			}
			else   // 지울 수 있는 값 한개 이상
				live.put(curr, live.get(curr)-1);  // 존재하는 curr 중 1개 삭제
			break;
			
		}
		return curr;
	}

}
