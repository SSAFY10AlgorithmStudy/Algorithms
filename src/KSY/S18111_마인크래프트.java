package KSY;

import java.io.*;
import java.util.*;

//35692KB/	624ms

public class S18111_마인크래프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int answer[] = new int[] {Integer.MAX_VALUE, 0};  // 시간
		int max=0, min=Integer.MAX_VALUE;
		
		// map
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j])
					max = map[i][j];
				if(min > map[i][j])
					min = map[i][j];
			}
		}
		//최대값으로부터 차이값의 합이 가지고 있는 
		
		for(int ans=min; ans<=max; ans++) {  // 최대값부터 하나씩 내려오며 확인
			int block = B, time=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					int gap = ans - map[i][j];
					if(gap < 0) {
						time += 2*(-gap);
						block += (-gap);
					} else if(gap > 0) {
						block -= gap;
						time += gap;
					}
				}
			}
			if(block < 0)  // 가진 블록보다 많이 사용 함
				continue;
			
			if(answer[0] >= time) {
				answer[0] = time;
				answer[1] = ans;
			}
		}
		sb.append(answer[0]).append(" ").append(answer[1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		

	}

}
