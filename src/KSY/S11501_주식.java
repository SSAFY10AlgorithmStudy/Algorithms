package KSY;
import java.util.*;
import java.io.*;

public class S11501_주식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=0; test<T; test++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			long[] nums = new long[N];
			
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int purchased = 0;
			long answer = 0;
			long[] purchasedNums = new long[N];
			for(int i=0; i<N; i++) {
				long checkNum = nums[i];
				boolean isPurchased = false;
				for(int j=i+1; j<N; j++) {
					if(checkNum <= nums[j]) {
						purchasedNums[purchased++] = checkNum;
						isPurchased = true;
						break;
					}
				}
				if(isPurchased)
					continue;
				for(int j=0; j<purchased; j++) {
					answer += checkNum - purchasedNums[j];
				}
				purchased = 0;
			}
			
			sb.append(answer).append("\n");
			
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
