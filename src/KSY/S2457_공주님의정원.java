package KSY;

import java.util.*;
import java.io.*;

public class S2457_공주님의정원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		List<Flower> flowers = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			Flower flower = new Flower(m1, d1, m2, d2);
			flowers.add(flower);
		}
		Collections.sort(flowers);
		int answer= 0;
		int[] now = new int[] {3, 1, 3, 1};  // 3월 1일
		for(int i=0; i<flowers.size(); i++) {
			Flower flower = flowers.get(i);  // 살펴볼 꽃
			
			// 마지막 꽃
			if(flower.m2 > 11 || (flower.m2 == 11 && flower.d2 >= 30)) {
				answer++;
				break;
			}
			
			if(flower.m1 < now[2] || (flower.m1 == now[2] && flower.d1 <= now[])) {
				answer++;
				now[0] = flower.m2;
				now[1] = flower.d2;
			} else if(flower.m1 == now[0] && flower.d1 < now[1]) {
				
			}
		}
		
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}

class Flower implements Comparable<Flower>{
	int m1, d1, m2, d2;
	Flower(int m1, int d1, int m2, int d2){
		this.m1 = m1; this.d1 = d1; this.m2 = m2; this.d2 = d2;
	}
	public int compareTo(Flower o) {
		if(m1 > o.m1) return 1;
		if(m1 < o.m1) return -1;
		else {
			if(d1 > o.d1) return 1;
			if(d1 < o.d1) return -1;
			else {
				if(m2 < o.m2) return 1;
				if(m2 > o.m2) return -1;
				else {
					if(d2 < o.d2) return 1;
					if(d2 > o.d2) return -1;
					return 0;
				}
			}
		}
	}
}