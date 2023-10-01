package KSY.personal.Practice;

import java.util.*;
import java.io.*;

//179320KB/	784ms

public class S2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  // 나무의 개수
		long M = Integer.parseInt(st.nextToken());  // 가져야할 나무의 높이
		st = new StringTokenizer(br.readLine());
		
		long[] trees = new long[N];
		long end=0, mid=0, start=0;
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);  // 정렬
		end = trees[N-1];
		mid = end/2;  // 중간 값
		while(start < end) {
			long sum=0;
			for(int i=N-1; i >= 0; i--) {
				if(trees[i] <= mid) {
					break;
				}
				sum += trees[i] - mid;
			}
			if(sum >= M) {  // 주의
				start = mid + 1;
			} else {
				end = mid;
			}
			mid = (end + start)/2;
		}
		if(mid-1 < 0)
			sb.append(0);
		else
			sb.append(mid-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
