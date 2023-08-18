package KSY;

import java.util.*;
import java.io.*;

public class S16401 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] candies = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			candies[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(candies);
		
		int[] values = new int[] {1, candies[N-1]};  // start, end
		int mid, cnt=0, answer=0;
		while(values[0]<=values[1]) {
			cnt = 0;
			mid = (values[0]+values[1])/2; // 캔디 중간 크기
			for(int i=0; i<N; i++) {
				if(candies[i] >= mid) {
					cnt += candies[i]/mid;  //해당 캔디로 만들 수 있는 모든 개수
				}
			}
				
			if(cnt >= M) { // 캔디 크기 늘리기 
				values[0] = mid+1;
				answer = mid;
			} else {  // 크기 줄이기 
				values[1] = mid-1;
			}
			
		}
		System.out.println(answer);
	}

}
